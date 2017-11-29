function acceptProcess(processId){

	$.ajax({
		type: "POST",
		url: "accept/" + processId,
		success: function(data){
			
			if(data==true){
				location.reload();
			}

		}
	});

}

function rejectProcess(processId){
	
	$.ajax({
		type: "POST",
		url: "reject/" + processId,
		success: function(data){
			
			if(data==true){
				location.reload();
			}

		}
	});

}