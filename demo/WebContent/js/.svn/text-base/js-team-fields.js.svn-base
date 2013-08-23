function isCompleted() {

	if (document.getElementById("teamName").value == null
			|| document.getElementById("teamName").value.length == 0) {
		alert("\"Team Name\" is mandatory !");
		return false;
	}
	if (document.getElementById("needPers").value == null
			|| document.getElementById("needPers").value.length == 0) {
		alert("\"Need Pers\" is mandatory !");
		return false;
	}
	if (document.getElementById("minPers").value == null
			|| document.getElementById("minPers").value.length == 0) {
		alert("\"Min Pers\" is mandatory !");
		return false;
	}
	if (document.getElementById("status").value == null
			|| document.getElementById("status").value.length == 0) {
		alert("\"Status\" is mandatory !");
		return false;
	}
	return true;

}

function isNum(object) {

	if (isNaN(object.value)) {
		alert("Not Number");
		object.value = "";
	}
	if (object.value < 0) {
		alert("Not The Right Number");
		object.value = 0;
	}

}