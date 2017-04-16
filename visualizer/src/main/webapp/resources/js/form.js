$(document).ready(function(){
	
	// Load demo statce-space representations
	var demos = $.getJSON(demosJson, function(json){
		
		// Assign demos to buttons
		initDemoButton("demoHanoi", json.stateSpaceHanoi);
		initDemoButton("demoKnight", json.stateSpaceKnight);
		initDemoButton("demoQueens", json.stateSpaceQueens);
		initDemoButton("demoJugs", json.stateSpaceJugs);
		
	});
	
});

function initDemoButton(buttonId, demoText){
	
	var buttonSelector = "#" + buttonId;
	
	$(buttonSelector).click(function(){
		
		$("#stateSpace").val(demoText);
		
	});
	
}