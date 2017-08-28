function collectAlgorithms(){

	var algorithms = [];

	var checkboxes = document.getElementsByClassName("algorithmCheckbox");

	for(var i=0; i<checkboxes.length; i++){
		if(checkboxes[i].checked === true){
			algorithms.push(checkboxes[i].value);
		}
	}

	return algorithms;

}

function collectDoTreeValue(){

	return document.getElementById("doTree").checked;

}

function collectFormData(){

    var name = $("#name").val();
	var stateSpace = $("#stateSpace").val();
	var algorithms = collectAlgorithms();
	var doTree = collectDoTreeValue();
	var heuristic = $("#heuristic").val();
	var variablesInHeuristicFunction = $("#variablesInHeuristicFunction").val();

	var data = {};
	data["name"] = name;
	data["stateSpace"] = stateSpace;
	data["algorithms"] = algorithms;
	data["doTree"] = doTree;
	data["heuristic"] = heuristic;
	data["variablesInHeuristicFunction"] = variablesInHeuristicFunction;

	return data;

}

function displayInformationDiv(){
    $("#information").css("display", "block");
}

function hideInformationDiv(){
    $("#information").css("display", "none");
}

function scrollToTop(){
    $("html, body").animate({
        scrollTop: 0
    }, 600);
}

function disableSubmitButton(){
    $("#problemSubmitButton").addClass("disabled");
}

function enableSubmitButton(){
    $("#problemSubmitButton").removeClass("disabled");
}

function highlightField(id){
	var selector = "#" + id;
	$(selector).css("border", "1px solid red");
}

function displayErrorDiv(id, message){
	var selector = "#" + id;
	$(selector).css("display", "block");
	$(selector).append(message + "<br/>");
}

function displayServerSideError(message){
    $("#serverSideError .panel-body").text(message);
    $("#serverSideError").css("display", "block");
}

function hideServerSideError(){
    $("#serverSideError .panel-body").text("");
    $("#serverSideError").css("display", "none");
}

function displayError(key, message){

    if(key=="name"){
        highlightField("name");
        displayErrorDiv("nameErrors", message);
    }else if(key=="stateSpace"){
        highlightField("stateSpace");
        displayErrorDiv("stateSpaceErrors", message);
    }else if(key=="algorithms"){
        displayErrorDiv("algorithmErrors", message);
    }else if(key=="backTrackPathLengthLimitationLimit"){
        highlightField("backTrackPathLengthLimitationLimit");
        displayErrorDiv("algorithmErrors", message);
    }else if(key=="backTrackOptimalLimit"){
        highlightField("backTrackOptimalLimit");
        displayErrorDiv("algorithmErrors", message);
    }else if(key=="serverSide"){
        displayServerSideError(message);
    }

}

function displayErrors(errors){

	for(var key in errors){
		displayError(key, errors[key]);
	}

}

function clearHighlight(id){
	var selector = "#" + id;
	$(selector).css("border", "1px solid rgb(204, 204, 204)");
}

function clearHighlights(){
    clearHighlight("name");
    clearHighlight("stateSpace");
    clearHighlight("backTrackPathLengthLimitationLimit");
    clearHighlight("backTrackOptimalLimit");
}

function hideErrorDiv(id){
		var selector = "#" + id;
		$(selector).css("display", "none");
		$(selector).text("");
}

function hideErrorDivs(){
    hideErrorDiv("nameErrors");
    hideErrorDiv("stateSpaceErrors");
    hideErrorDiv("algorithmErrors");
    hideServerSideError();
}

function successInformation(algorithms, processIdentifiers){

    // clear
    $("#success .panel-body").text("");

    // put data
    $("#success .panel-body").append("You can check the output of the processes in the following links:");
    $("#success .panel-body").append("<ul>");
    for(var i=0; i<algorithms.length; i++){
        $("#success .panel-body").append("<li><a href=\"" + context + "/graph/view/" + processIdentifiers[i] + "\">" + algorithms[i] + "</a></li>");
    }
    $("#success .panel-body").append("</ul>");

    // animation
    // $("#success").css("display", "block");
    // $("#success").fadeToggle(800);
    $("#success").css('opacity', 0).slideDown('slow').animate(
        { opacity: 1 },
        { queue: false, duration: 'slow' }
    );

}

function removeForm(){
    $(".pageContainer").slideUp(800, function(){
        $(".pageContainer").remove();
    });
}

function newProblem(){

	var data = collectFormData();

    disableSubmitButton();
	displayInformationDiv();
	clearHighlights();
	hideErrorDivs();
	scrollToTop();

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : context + "/problem",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {

			if(data.error){
			    hideInformationDiv();
			    displayErrors(data.errors);
			    enableSubmitButton();
			}else{
			    hideInformationDiv();
			    removeForm();
			    successInformation(data.algorithms, data.processIdentifiers);
			}

		},
		error : function(e) {
		    hideInformationDiv();
			displayServerSideError("Please try again or come back later.");
			enableSubmitButton();
		},
		done : function(e) {
			console.log("DONE");
			enableSubmitButton();
		}
	});

}