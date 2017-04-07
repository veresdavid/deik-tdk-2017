// width and height of the svg image
var width = +d3.select("svg").attr("width"),
	height = +d3.select("svg").attr("height");

// zoom behavior
var zoom = d3.zoom()
	.scaleExtent([1/5, 10])
	.on("zoom", zoomed);

// zoom function
function zoomed() {
	svg.attr("transform", d3.event.transform);
}

// the group of the graph components
var svg = d3.select("svg")
	.call(zoom)
	.append("g")
	.attr("id", "graph");

// force simulation
var simulation = d3.forceSimulation()
	.force("link", d3.forceLink().distance(75).id(function(d){return d.id;}))
	.force("charge", d3.forceManyBody())
	.force("center", d3.forceCenter(width / 2, height / 2));

var steps;
var nodes;
var operators;
var solutions;

var stepIndex;
var drag;
var solutionVisible;
var changeHistory;
var statuses;

function initGraph(jsonUrl){

	d3.json(jsonUrl, function(error, graph) {
		
		// if error occurs, throw exception
		if (error) throw error;
		
		// set nodes for graph
		simulation
			.nodes(graph.nodes)
			.on("tick", ticked);
		
		// set links for graph
		simulation.force("link")
			.links(graph.connections);
		
		// generate markers for the end of the connections
		svg.append("defs").selectAll("marker")
			.data(graph.connections)
			.enter().append("marker")
			.attr("id", function(d) { return "m" + d.source.id + "-" + d.operatorId + "-" + d.target.id; })
			.attr("viewBox", "0 -5 10 10")
			.attr("refX", 15)
			.attr("refY", -1.5)
			.attr("markerWidth", 6)
			.attr("markerHeight", 6)
			.attr("orient", "auto")
			.style("fill", "lightgray")
			.append("path")
			.attr("d", "M0,-5L10,0L0,5");
		
		// generate connections
		var path = svg.append("g")
			.attr("id", "connections")
			.selectAll("path")
			.data(graph.connections)
			.enter().append("path")
			.attr("id", function(d){ return "c" + d.source.id + "-" + d.operatorId + "-" + d.target.id; })
			.style("fill", "none")
			.style("stroke", "lightgray")
			.style("stroke-width", "1")
			.attr("marker-end", function(d) { return "url(#m" + d.source.id + "-" + d.operatorId + "-" + d.target.id + ")"; });
			
		// generate solution path
		var solutionPathsGroup = svg.append("g")
			.attr("id", "solution")
			.style("opacity", "0");
		
		for(i=0; i<graph.solutions.length; i++){
			
			for(j=0; j<graph.solutions[i].length; j++){
				
				var solutionPathId = "s" + graph.solutions[i][j];
				solutionPathsGroup.append("path")
					.attr("id", solutionPathId)
					.style("fill", "none")
					.style("stroke", "red")
					.style("stroke-width", "2");
				
			}

		}
		
		// generate nodes
		var node = svg.append("g")
			.attr("id", "nodes")
			.selectAll("circle")
			.data(graph.nodes)
			.enter().append("circle")
			.attr("id", function(d){ return "n" + d.id; })
			.attr("r", 5)
			.style("stroke", "lightgray")
			.style("fill", "white")
			.on("mouseover", enterNode)
			.on("mouseout", exitNode)
			.call(d3.drag()
				.on("start", dragStarted)
				.on("drag", dragged)
				.on("end", dragEnded));
		
		// generate operator circles
		var op = svg.append("g")
			.attr("id", "operators")
			.selectAll("circle")
			.data(graph.connections)
			.enter().append("circle")
			.attr("id", function(d){ return "o" + d.source.id + "-" + d.operatorId + "-" + d.target.id; })
			.attr("r", 3)
			.style("fill", "lightgray")
			.on("mouseover", enterOperatorCircle)
			.on("mouseout", exitOperatorCircle);
		
		// this function is responsible for updating the position of the svg elements
		function ticked() {
			
			node
				.attr("cx", function(d) { return d.x; })
				.attr("cy", function(d) { return d.y; });
			
			path.attr("d", linkArc);
			
			op
				.attr("cx", function(d){
					// distance of the two endpoints of the actual connection
					var dist;
					if(d.target.id==d.source.id){
						dist = 57;
					}else{
						dist = Math.hypot(d.source.x - d.target.x, d.source.y - d.target.y);
					}
					// return the midpoint's x coordinate
					return document.getElementById("c" + d.source.id + "-" + d.operatorId + "-" + d.target.id).getPointAtLength(dist / 2).x;
				})
				.attr("cy", function(d){
					// distance of the two endpoints of the actual connection
					var dist;
					if(d.target.id==d.source.id){
						dist = 57;
					}else{
						dist = Math.hypot(d.source.x - d.target.x, d.source.y - d.target.y);
					}
					// return the midpoint's y coordinate
					return document.getElementById("c" + d.source.id + "-" + d.operatorId + "-" + d.target.id).getPointAtLength(dist / 2).y;
				});
			
			// update solution path
			for(i=0; i<solutions.length; i++){
				
				for(j=0; j<solutions[i].length; j++){
				
				var solutionPathId = "s" + solutions[i][j];
				var graphPathId = "c" + solutions[i][j];
				
				document.getElementById(solutionPathId).setAttribute("d", document.getElementById(graphPathId).getAttribute("d"));
				
				}
				
			}
			
		}
		
		// initialize variables
		steps = graph.steps;
		nodes = graph.nodes;
		operators = graph.operators;
		solutions = graph.solutions;
		
		stepIndex = 0;
		drag = false;
		solutionVisible = false;
		changeHistory = [];
		statuses = [];
		
		// set default statuses for nodes and connections
		var tmpNodes = simulation.nodes();
		for(i in tmpNodes){
			statuses[tmpNodes[i].id] = "inactivated";
		}
		
		var tmpConnections = simulation.force("link").links();
		for(i in tmpConnections){
			var tmpConnectionId = tmpConnections[i].source.id + "-" + tmpConnections[i].operatorId + "-" + tmpConnections[i].target.id;
			statuses[tmpConnectionId] = "inactivated";
		}
		
		// apply functions to buttons
		d3.select("#stepButton")
			.on("click", step);
			
		d3.select("#backButton")
			.on("click", back);
		
		d3.select("#solutionButton")
			.on("click", showSolution);
		
	});

}

function dragStarted(d) {
	drag = true;
	hideNodeDescriptionBox(this);
	
	if (!d3.event.active) simulation.alphaTarget(0.3).restart();
	d.fx = d.x;
	d.fy = d.y;
}

function dragged(d) {
	d.fx = d3.event.x;
	d.fy = d3.event.y;
}

function dragEnded(d) {
	drag = false;
	
	if (!d3.event.active) simulation.alphaTarget(0);
	d.fx = null;
	d.fy = null;
}

function linkArc(d) {
	
	if(d.target.id==d.source.id){
		
		// loop edge
		
		var drx = 10;
		var dry = 10;
		var xRotation = -45;
		var largeArc = 1;
		var sweep = 0;
		var targetX = d.target.x + 1;
		var targetY = d.target.y + 1;
		
		return "M" + d.source.x + "," + d.source.y + "A" + drx + "," + dry + " " + xRotation + "," + largeArc + "," + sweep + " " + targetX + "," + targetY;
			
	}else{
		
		// normal edge
		
		var dx = d.target.x - d.source.x,
			dy = d.target.y - d.source.y,
			dr = Math.sqrt(dx * dx + dy * dy);
			
		return "M" + d.source.x + "," + d.source.y + "A" + dr + "," + dr + " 0 0,1 " + d.target.x + "," + d.target.y;
		
	}
	
}

function enterNode(d){

	// if we dragging a node, we dont want to see the node information
	if(!drag){
		makeNodeBigger(this);
		
		showNodeDescriptionBox(d.information);
	}
	
}

function exitNode(d){

	makeNodeSmaller(this);

	hideNodeDescriptionBox();
	
}

function enterOperatorCircle(d){

	makeOperatorCircleBigger(this);
	
	var operatorInformation = getOperatorInformation(d.operatorId);
	
	showOperatorDescriptionBox(d, operatorInformation);
	
}

function exitOperatorCircle(d){

	makeOperatorCircleSmaller(this);

	hideOperatorDescriptionBox();
	
}

function step(){
	
	if(stepIndex<steps.length){
	
		var currentStep = steps[stepIndex];
		
		saveStatuses(currentStep);
		
		// activated nodes
		for(i in currentStep.activatedNodes){
			statuses[currentStep.activatedNodes[i]] = "activated";
			makeNodeOpened(currentStep.activatedNodes[i]);
		}
		
		// inactivated nodes
		for(i in currentStep.inactivatedNodes){
			statuses[currentStep.inactivatedNodes[i]] = "inactivated";
			makeNodeUnvisited(currentStep.inactivatedNodes[i]);
		}
		
		// closed nodes
		for(i in currentStep.closedNodes){
			statuses[currentStep.closedNodes[i]] = "closed";
			makeNodeClosed(currentStep.closedNodes[i]);
		}
		
		// stepped on nodes
		for(i in currentStep.steppedOnNodes){
			statuses[currentStep.steppedOnNodes[i]] = "steppedOn";
			makeNodeActive(currentStep.steppedOnNodes[i]);
		}
		
		// activated connections
		for(i in currentStep.activatedConnections){
			statuses[currentStep.activatedConnections[i]] = "activated";
			makeConnectionVisited(currentStep.activatedConnections[i]);
			makeMarkerVisited(currentStep.activatedConnections[i]);
			makeOperatorCircleVisited(currentStep.activatedConnections[i]);
		}
		
		// inactivated connections
		for(i in currentStep.inactivatedConnections){
			statuses[currentStep.inactivatedConnections[i]] = "inactivated";
			makeConnectionUnvisited(currentStep.inactivatedConnections[i]);
			makeMarkerUnvisited(currentStep.inactivatedConnections[i]);
			makeOperatorCircleUnvisited(currentStep.inactivatedConnections[i]);
		}
		
		stepIndex++;
	
	}
	
}

function saveStatuses(step){
	
	var nodeSet = new Set();
	for(i in step.activatedNodes) nodeSet.add(step.activatedNodes[i]);
	for(i in step.inactivatedNodes) nodeSet.add(step.inactivatedNodes[i]);
	for(i in step.steppedOnNodes) nodeSet.add(step.steppedOnNodes[i]);
	for(i in step.closedNodes) nodeSet.add(step.closedNodes[i]);
	
	var connectionSet = new Set();
	for(i in step.activatedConnections) connectionSet.add(step.activatedConnections[i]);
	for(i in step.inactivatedConnections) connectionSet.add(step.inactivatedConnections[i]);
	
	var nodeStatuses = [];
	for(let node of nodeSet){
		var nodeStatus = {id: node, status: statuses[node]};
		nodeStatuses.push(nodeStatus);
	}
	
	var connectionStatuses = [];
	for(let connection of connectionSet){
		var connectionStatus = {id: connection, status: statuses[connection]};
		connectionStatuses.push(connectionStatus);
	}
	
	var currentStatus = {nodeStatuses: nodeStatuses, connectionStatuses: connectionStatuses};
	
	changeHistory.push(currentStatus);
	
}

function back(){
	
	if(changeHistory.length>0){
		
		var status = changeHistory.pop();
		
		// nodes
		for(i in status.nodeStatuses){
			
			switch(status.nodeStatuses[i].status){
				case "activated":
					statuses[status.nodeStatuses[i].id] = "activated";
					makeNodeOpened(status.nodeStatuses[i].id);
				break;
				case "inactivated":
					statuses[status.nodeStatuses[i].id] = "inactivated";
					makeNodeUnvisited(status.nodeStatuses[i].id);
				break;
				case "steppedOn":
					statuses[status.nodeStatuses[i].id] = "steppedOn";
					makeNodeActive(status.nodeStatuses[i].id);
				break;
				case "closed":
					statuses[status.nodeStatuses[i].id] = "closed";
					makeNodeClosed(status.nodeStatuses[i].id);
				break;
			}
			
		}
		
		// connections
		for(i in status.connectionStatuses){
			
			switch(status.connectionStatuses[i].status){
				case "activated":
					statuses[status.connectionStatuses[i].id] = "activated";
					makeConnectionVisited(status.connectionStatuses[i].id);
					makeMarkerVisited(status.connectionStatuses[i].id);
					makeOperatorCircleVisited(status.connectionStatuses[i].id);
				break;
				case "inactivated":
					statuses[status.connectionStatuses[i].id] = "inactivated";
					makeConnectionUnvisited(status.connectionStatuses[i].id);
					makeMarkerUnvisited(status.connectionStatuses[i].id);
					makeOperatorCircleUnvisited(status.connectionStatuses[i].id);
				break;
			}
			
		}
		
		stepIndex--;
		
	}
	
}

function showSolution(){
	
	if(solutionVisible){
		
		d3.select("#solution")
			.transition()
			.duration(500)
			.style("opacity", "0");
			
		solutionVisible = false;

	}else{
		
		d3.select("#solution")
			.transition()
			.duration(500)
			.style("opacity", "1");		
		
		solutionVisible = true;
		
	}
	
}

// gui functions

function makeOperatorCircleVisited(operatorCircleId){
	
	var operatorCircleSelector = "#o" + operatorCircleId;
	
	d3.select(operatorCircleSelector)
		.transition()
		.duration(500)
		.style("fill", "black");
	
}

function makeOperatorCircleUnvisited(operatorCircleId){
	
	var operatorCircleSelector = "#o" + operatorCircleId;
	
	d3.select(operatorCircleSelector)
		.transition()
		.duration(500)
		.style("fill", "lightgray");
	
}

function makeOperatorCircleBigger(operatorCircle){
	
	d3.select(operatorCircle)
		.transition()
		.duration(100)
		.attr("r", 5);
	
}

function makeOperatorCircleSmaller(operatorCircle){
	
	d3.select(operatorCircle)
		.transition()
		.duration(100)
		.attr("r", 3);
	
}

function getOperatorInformation(operatorId){
	
	var information;
	
	for(i in operators){
		if(operators[i].id==operatorId){
			information = operators[i].information;
			break;
		}
	}
	
	return information;
	
}

function showOperatorDescriptionBox(connectionData, operatorInformation){
	
	d3.select("#operatorDescription")
		.style("left", (d3.event.pageX + 20) + "px")
		.style("top", (d3.event.pageY - 5) + "px")
		.html(connectionData.source.id + "-->" + connectionData.target.id + "<br/>" + connectionData.operatorId + "<br/>" + operatorInformation)
		.transition()
		.duration(100)
		.style("opacity", 0.8);
	
}

function hideOperatorDescriptionBox(){
	
	d3.select("#operatorDescription")
		.transition()
		.duration(100)
		.style("opacity", 0);
	
}

function makeNodeActive(nodeId){
	
	var nodeSelector = "#n" + nodeId;
	
	d3.select(nodeSelector)
		.transition()
		.duration(500)
		.attr("r", 5)
		.style("fill", "orange")
		.style("stroke", "black");
	
}

function makeNodeOpened(nodeId){
	
	var nodeSelector = "#n" + nodeId;
	
	d3.select(nodeSelector)
		.transition()
		.duration(500)
		.attr("r", 5)
		.style("fill", "white")
		.style("stroke", "black");
	
}

function makeNodeClosed(nodeId){
	
	var nodeSelector = "#n" + nodeId;
	
	d3.select(nodeSelector)
		.transition()
		.duration(500)
		.attr("r", 5)
		.style("fill", "gray")
		.style("stroke", "black");
	
}

function makeNodeUnvisited(nodeId){
	
	var nodeSelector = "#n" + nodeId;
	
	d3.select(nodeSelector)
		.transition()
		.duration(500)
		.attr("r", 5)
		.style("fill", "white")
		.style("stroke", "lightgray");
	
}

function makeNodeBigger(operatorCircle){
	
	d3.select(operatorCircle)
		.transition()
		.duration(100)
		.attr("r", 7);
	
}

function makeNodeSmaller(operatorCircle){
	
	d3.select(operatorCircle)
		.transition()
		.duration(100)
		.attr("r", 5);
	
}

function showNodeDescriptionBox(nodeInformation){
	
	d3.select("#nodeDescription")
		.style("left", (d3.event.pageX + 20) + "px")
		.style("top", (d3.event.pageY - 5) + "px")
		.html(nodeInformation)
		.transition()
		.duration(100)
		.style("opacity", 0.8);
	
}

function hideNodeDescriptionBox(){
	
	d3.select("#nodeDescription")
		.transition()
		.duration(100)
		.style("opacity", 0);
	
}

function makeConnectionVisited(connectionId){
	
	var connectionSelector = "#c" + connectionId;
	
	d3.select(connectionSelector)
		.transition()
		.duration(500)
		.style("stroke", "black");
	
}

function makeConnectionUnvisited(connectionId){
	
	var connectionSelector = "#c" + connectionId;
	
	d3.select(connectionSelector)
		.transition()
		.duration(500)
		.style("stroke", "lightgray");
	
}

function makeMarkerVisited(markerId){
	
	var markerSelector = "#m" + markerId;
	
	d3.select(markerSelector)
		.transition()
		.duration(500)
		.style("fill", "black");
	
}

function makeMarkerUnvisited(markerId){
	
	var markerSelector = "#m" + markerId;
	
	d3.select(markerSelector)
		.transition()
		.duration(500)
		.style("fill", "lightgray");
	
}