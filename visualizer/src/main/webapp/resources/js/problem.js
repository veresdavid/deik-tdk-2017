var algorithmNames = [];
var errors = [];
var customSearchAlgorithmTexts = [];

$(document).ready(function(){

	jQuery.i18n.properties({
		name: "messages",
		path: "resources/i18n/",
		mode: 'both',
		language: locale,
		async: true,
		callback: function() {

            // algorithm names
		    jQuery.i18n.prop("problem_algorithm_backtrack_simple");
		    jQuery.i18n.prop("problem_algorithm_backtrack_circle");
		    jQuery.i18n.prop("problem_algorithm_backtrack_path_length_limit");
		    jQuery.i18n.prop("problem_algorithm_backtrack_optimal");
		    jQuery.i18n.prop("problem_algorithm_breadth_first");
		    jQuery.i18n.prop("problem_algorithm_depth_first");
		    jQuery.i18n.prop("problem_algorithm_optimal");
		    jQuery.i18n.prop("problem_algorithm_best_first");
		    jQuery.i18n.prop("problem_algorithm_a");
		    jQuery.i18n.prop("problem_algorithm_custom");

		    algorithmNames["problem_algorithm_backtrack_simple"] = problem_algorithm_backtrack_simple;
		    algorithmNames["problem_algorithm_backtrack_circle"] = problem_algorithm_backtrack_circle;
		    algorithmNames["problem_algorithm_backtrack_path_length_limit"] = problem_algorithm_backtrack_path_length_limit;
		    algorithmNames["problem_algorithm_backtrack_optimal"] = problem_algorithm_backtrack_optimal;
		    algorithmNames["problem_algorithm_breadth_first"] = problem_algorithm_breadth_first;
		    algorithmNames["problem_algorithm_depth_first"] = problem_algorithm_depth_first;
		    algorithmNames["problem_algorithm_optimal"] = problem_algorithm_optimal;
		    algorithmNames["problem_algorithm_best_first"] = problem_algorithm_best_first;
		    algorithmNames["problem_algorithm_a"] = problem_algorithm_a;
		    algorithmNames["problem_algorithm_custom"] = problem_algorithm_custom;

		    // errors
		    jQuery.i18n.prop("problem_error_name_empty");
            jQuery.i18n.prop("problem_error_statespace_empty");
            jQuery.i18n.prop("problem_error_algorithm_empty");
            jQuery.i18n.prop("problem_error_backtrack_pathlengthlimit_limit_empty");
            jQuery.i18n.prop("problem_error_backtrack_pathlengthlimit_limit_invalid");
            jQuery.i18n.prop("problem_error_backtrack_optimal_limit_empty");
            jQuery.i18n.prop("problem_error_backtrack_optimal_limit_invalid");

            errors["problem_error_name_empty"] = problem_error_name_empty;
            errors["problem_error_statespace_empty"] = problem_error_statespace_empty;
            errors["problem_error_algorithm_empty"] = problem_error_algorithm_empty;
            errors["problem_error_backtrack_pathlengthlimit_limit_empty"] = problem_error_backtrack_pathlengthlimit_limit_empty;
            errors["problem_error_backtrack_pathlengthlimit_limit_invalid"] = problem_error_backtrack_pathlengthlimit_limit_invalid;
            errors["problem_error_backtrack_optimal_limit_empty"] = problem_error_backtrack_optimal_limit_empty;
            errors["problem_error_backtrack_optimal_limit_invalid"] = problem_error_backtrack_optimal_limit_invalid;

            // custom search algorithm texts
            jQuery.i18n.prop("problem_custom_algorithm_files");
            jQuery.i18n.prop("problem_custom_algorithm_heuristic");
            jQuery.i18n.prop("problem_custom_algorithm_uses_heuristic");
            jQuery.i18n.prop("problem_custom_algorithm_variables");

            customSearchAlgorithmTexts["problem_custom_algorithm_files"] = problem_custom_algorithm_files;
            customSearchAlgorithmTexts["problem_custom_algorithm_heuristic"] = problem_custom_algorithm_heuristic;
            customSearchAlgorithmTexts["problem_custom_algorithm_uses_heuristic"] = problem_custom_algorithm_uses_heuristic;
            customSearchAlgorithmTexts["problem_custom_algorithm_variables"] = problem_custom_algorithm_variables;

		}
	});

});

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
	var backTrackPathLengthLimitationLimit = $("#backTrackPathLengthLimitationLimit").val();
	var backTrackOptimalLimit = $("#backTrackOptimalLimit").val();
	var doTree = collectDoTreeValue();
	var heuristic = $("#heuristic").val();
	var variablesInHeuristicFunction = $("#variablesInHeuristicFunction").val();

	var data = {};
	data["name"] = name;
	data["stateSpace"] = stateSpace;
	data["algorithms"] = algorithms;
	data["backTrackPathLengthLimitationLimit"] = backTrackPathLengthLimitationLimit;
	data["backTrackOptimalLimit"] = backTrackOptimalLimit;
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
	$(selector).append(errors[message] + "<br/>");
}

function displayStateSpaceErrorDiv(message){
	var selector = "#stateSpaceErrors";
	$(selector).css("display", "block");
	if(message=="problem_error_statespace_empty"){
	    $(selector).append(errors[message] + "<br/>");
	}else{
	    $(selector).append(message + "<br/>");
	}
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
		displayStateSpaceErrorDiv(message);
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

	// put data
	$("#success .panel-body").append("<ul>");
	for(var i=0; i<algorithms.length; i++){
		$("#success .panel-body").append("<li><a href=\"" + context + "/graph/view/" + processIdentifiers[i] + "\">" + algorithmNames[algorithms[i]] + "</a></li>");
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

function newProblem(customSearchAlgorithms){

	var data = collectFormData();
	data["customSearchAlgorithms"] = customSearchAlgorithms;

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

function removeNewCustomSearchAlgorithmButton(){
    $("#newCustomSearchAlgorithm").remove();
}

function addNewCustomSearchAlgorithmButton(){
    $("#customSearchAlgorithms").append("<span id=\"newCustomSearchAlgorithm\" onclick=\"addNewCustomSearchAlgorithm()\" class=\"glyphicon glyphicon-plus-sign\" aria-hidden=\"true\"></span>");
}

function removeParentCustomSearchAlgorithmDiv(element){
    // $(element).parent().remove();
    $(element).parent().slideUp("slow", function(){
        $(this).remove();
    });
}

function addNewCustomSearchAlgorithmFileButton(element){

    $("<span onclick=\"addNewCustomSearchAlgorithmFile(this)\" class=\"glyphicon glyphicon-plus-sign\" aria-hidden=\"true\"></span>").appendTo(element);

}

function removeParentCustomSearchAlgorithmFileDiv(element){
    $(element).parent().remove();
}

function addNewCustomSearchAlgorithmFile(element){

    var filesDiv = $(element).siblings(".customSearchAlgorithmFilesDiv");

    // add new div with file input and delete button
    var fileDiv = $("<div>").appendTo(filesDiv);
    $(fileDiv).css("display", "none");
    $("<input type=\"file\" class=\"form-control customSearchAlgorithmFile\" />").appendTo(fileDiv);
    $("<span onclick=\"removeParentDiv(this)\" class=\"glyphicon glyphicon-remove removeCustomSearchAlgorithmFileButton\" aria-hidden=\"true\"></span>").appendTo(fileDiv);

    $(fileDiv).slideDown("slow");

}

function removeParentDiv(element){
    $(element).parent().slideUp("slow", function(){
        $(this).remove();
    });
}

function addNewCustomSearchAlgorithmVariable(element){

    var variablesDiv = $(element).siblings(".customSearchAlgorithmVariablesDiv");
    var newVariableDiv = $("<div class=\"customSearchAlgorithmVariableDiv\">").appendTo(variablesDiv);
    $(newVariableDiv).css("display", "none");
    var typeSelect = $("<select class=\"form-control variableInput\">").appendTo(newVariableDiv);
    $("<option value=\"int\">int</option>").appendTo(typeSelect);
    $("<option value=\"double\">double</option>").appendTo(typeSelect);
    $("<option value=\"string\">string</option>").appendTo(typeSelect);
    $("<option value=\"boolean\">boolean</option>").appendTo(typeSelect);
    $("<input type=\"text\" class=\"form-control variableInput\" />").appendTo(newVariableDiv);
    $("<span onclick=\"removeParentDiv(this)\" class=\"glyphicon glyphicon-remove removeCustomSearchAlgorithmVariableButton\" aria-hidden=\"true\"></span>").appendTo(newVariableDiv);

    $(newVariableDiv).slideDown("slow");

}

function addNewCustomSearchAlgorithmDiv(){

    // new div
    var customSearchAlgorithmDiv = $("<div class=\"customSearchAlgorithmDiv\">").appendTo("#customSearchAlgorithms");
    $(customSearchAlgorithmDiv).css("display", "none");

    // remove button
    $("<span onclick=\"removeParentCustomSearchAlgorithmDiv(this)\" class=\"glyphicon glyphicon-remove removeCustomSearchAlgorithm\" aria-hidden=\"true\"></span>").appendTo(customSearchAlgorithmDiv);

    // inner div for files
    $("<span class=\"customSearchAlgorithmDivHeading\">" + customSearchAlgorithmTexts["problem_custom_algorithm_files"] + "</span>").appendTo(customSearchAlgorithmDiv);
    var customSearchAlgorithmFilesDiv = $("<div class=\"customSearchAlgorithmFilesDiv\">").appendTo(customSearchAlgorithmDiv);
    $("<input type=\"file\" class=\"customSearchAlgorithmFile form-control\" />").appendTo(customSearchAlgorithmFilesDiv);
    $("<span onclick=\"addNewCustomSearchAlgorithmFile(this)\" class=\"glyphicon glyphicon-plus-sign newCustomSearchAlgorithmFileButton\" aria-hidden=\"true\"></span>").appendTo(customSearchAlgorithmDiv);

    // inner div for checkbox
    $("<span class=\"customSearchAlgorithmDivHeading\">" + customSearchAlgorithmTexts["problem_custom_algorithm_heuristic"] + "</span>").appendTo(customSearchAlgorithmDiv);
    var usesHeuristicDiv = $("<div class=\"usesHeuristic\">").appendTo(customSearchAlgorithmDiv);
    $("<input type=\"checkbox\" />").appendTo(usesHeuristicDiv);
    $("<span>" + customSearchAlgorithmTexts["problem_custom_algorithm_uses_heuristic"] + "</span>").appendTo(usesHeuristicDiv);

    // inner div for variable
    $("<span class=\"customSearchAlgorithmDivHeading\">" + customSearchAlgorithmTexts["problem_custom_algorithm_variables"] + "</span>").appendTo(customSearchAlgorithmDiv);
    var customSearchAlgorithmVariablesDiv = $("<div class=\"customSearchAlgorithmVariablesDiv\">").appendTo(customSearchAlgorithmDiv);
    $("<span onclick=\"addNewCustomSearchAlgorithmVariable(this)\" class=\"glyphicon glyphicon-plus-sign newCustomSearchAlgorithmVariableButton\" aria-hidden=\"true\"></span>").appendTo(customSearchAlgorithmDiv);

    // animation
    $(customSearchAlgorithmDiv).slideDown("slow");

}

function addNewCustomSearchAlgorithm(){

    // new div
    addNewCustomSearchAlgorithmDiv();

}

function collectCustomSearchAlgorithmData(){

    var customSearchAlgorithms = [];

    var customSearchAlgorithmElements = document.getElementsByClassName("customSearchAlgorithmDiv");

    var files = [];
    var usesHeuristics = [];
    var variables = [];

    for(var i=0; i<customSearchAlgorithmElements.length; i++){

        for(var j=0; j<customSearchAlgorithmElements[i].childNodes.length; j++){

            var childClassName = customSearchAlgorithmElements[i].childNodes[j].className;

            if(childClassName == "customSearchAlgorithmFilesDiv"){

                var nthFiles = [];

                var customSearchAlgorithmFilesDiv = customSearchAlgorithmElements[i].childNodes[j];

                nthFiles.push(customSearchAlgorithmFilesDiv.childNodes[0].files[0]);

                for(var k=1; k<customSearchAlgorithmFilesDiv.childNodes.length; k++){
                    nthFiles.push(customSearchAlgorithmFilesDiv.childNodes[k].childNodes[0].files[0]);
                }

                files.push(nthFiles);

            }else if(childClassName == "usesHeuristic"){

                usesHeuristics.push(customSearchAlgorithmElements[i].childNodes[j].childNodes[0].checked);

            }else if(childClassName == "customSearchAlgorithmVariablesDiv"){

                var nthVariables = [];

                var customSearchAlgorithmVariablesDiv = customSearchAlgorithmElements[i].childNodes[j];

                for(var k=0; k<customSearchAlgorithmVariablesDiv.childNodes.length; k++){

                    var variable = {};
                    variable["type"] = customSearchAlgorithmVariablesDiv.childNodes[k].childNodes[0].value;
                    variable["value"] = customSearchAlgorithmVariablesDiv.childNodes[k].childNodes[1].value;

                    nthVariables.push(variable);

                }

                variables.push(nthVariables);

            }

        }

    }

    for(var i=0; i<files.length; i++){

        var customSearchAlgorithm = {};

        customSearchAlgorithm["files"] = files[i];
        customSearchAlgorithm["usesHeuristic"] = usesHeuristics[i];
        customSearchAlgorithm["variables"] = variables[i];

        customSearchAlgorithms.push(customSearchAlgorithm);

    }

    return customSearchAlgorithms;

}

function newProblemWithCustomSearchAlgorithms(){

    var customSearchAlgorithms = collectCustomSearchAlgorithmData();

    var numberOfFiles = 0;
    var numberOfReadyFiles = 0;

    var serverFileNames = [];
    for(var i=0; i<customSearchAlgorithms.length; i++){
        serverFileNames[i] = [];
        numberOfFiles += customSearchAlgorithms[i].files.length;
    }

    for(var i=0; i<customSearchAlgorithms.length; i++){

        for(var j=0; j<customSearchAlgorithms[i].files.length; j++){

            var formData = new FormData();

            formData.append("index", i);
            formData.append("file", customSearchAlgorithms[i].files[j]);

            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: context + "/uploadAlgorithm",
                data: formData,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {

                    serverFileNames[data.index].push(data.name);

                    numberOfReadyFiles++;

                    if(numberOfReadyFiles==numberOfFiles){

                        for(var k=0; k<customSearchAlgorithms.length; k++){
                            customSearchAlgorithms[k].files = serverFileNames[k];
                        }

                        newProblem(customSearchAlgorithms);

                    }

                },
                error: function (e) {

                    console.log("ERROR : ", e);

                }
            });

        }

    }

}

function postForm(){

    if(document.getElementsByClassName("customSearchAlgorithmDiv").length==0){

        var emptyArray = [];

        newProblem(emptyArray);

    }else{

        newProblemWithCustomSearchAlgorithms();

    }

}

function testFileShit(){

    var formData = new FormData();

    var file = $("#testFile");

    if(document.getElementById("testFile").files.length==0){
        formData.append("file", null);
    }else{
        formData.append("file", document.getElementById("testFile").files[0]);
    }

    console.log(document.getElementById("testFile").files.length);

    console.log(formData.get("file"));

    // AJAX MADAFAKAAAAAA

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: context + "/uploadAlgorithm",
        data: formData,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);

        },
        error: function (e) {

            console.log("ERROR : ", e);

        }
    });

}