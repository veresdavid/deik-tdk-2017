$(function(){
    $(document).tooltip({
        position: { my: "left+30 center", at: "right center" }
    });
});

function collectFormData(){

	var username = $("#username").val();
	var password = $("#password").val();
	var confirmPassword = $("#confirmPassword").val();
	var email = $("#email").val();

	var data = {};
	data["username"] = username;
	data["password"] = password;
	data["confirmPassword"] = confirmPassword;
	data["email"] = email;

	return data;

}

function highlightField(id){
	var selector = "#" + id;
	$(selector).css("border", "1px solid red");
}

function displayErrorDiv(id, message){
	var selector = "#" + id;
	$(selector).css("display", "block");
	$(selector).text(message);
}

function displayError(error){

	if(error.field=="username"){
		highlightField("username");
		displayErrorDiv("usernameErrors", error.message);
	}else if(error.field=="password"){
		highlightField("password");
		highlightField("confirmPassword");
		displayErrorDiv("passwordErrors", error.message);
	}else if(error.field=="email"){
		highlightField("email");
		displayErrorDiv("emailErrors", error.message);
	}

}

function displayErrors(errors){

	for(var i in errors){
		displayError(errors[i]);
	}

}

function clearHighlight(id){
	var selector = "#" + id;
	$(selector).css("border", "1px solid rgb(204, 204, 204)");
}

function hideErrorDiv(id){
		var selector = "#" + id;
		$(selector).css("display", "none");
		$(selector).text("");
}

function clearForm(){

	clearHighlight("username");
	clearHighlight("password");
	clearHighlight("confirmPassword");
	clearHighlight("email");

	hideErrorDiv("usernameErrors");
	hideErrorDiv("passwordErrors");
	hideErrorDiv("emailErrors");

}

function clearInput(id){
	var selector = "#" + id;
	$(selector).val("");
}

function clearInputs(){

	clearInput("username");
	clearInput("password");
	clearInput("confirmPassword");
	clearInput("email");

}

function registration(){

	clearForm();

	var data = collectFormData();

	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : context + "/registration",
			data : JSON.stringify(data),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);

				if(data.error){
					displayErrors(data.errors);
				}else{
					clearInputs();
					window.location.replace(context + "/");
				}

			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});


}