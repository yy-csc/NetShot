function isCompleted() {
	if (document.getElementById("skillId").value == null
			|| document.getElementById("skillId").value.length == 0) {
		alert("\"SkillNum\" is mandatory !");
		return false;
	}
	if (document.getElementById("teamName").value == null
			|| document.getElementById("teamName").value.length == 0) {
		alert("\"teamName\" is mandatory !");
		return false;
	}
	if (document.getElementById("leaderName").value == null
			|| document.getElementById("leaderName").value.length == 0) {
		alert("\"leaderName\" is mandatory !");
		return false;
	}
	if (document.getElementById("abnAfter10s").value == null
			|| document.getElementById("abnAfter10s").value.length == 0) {
		alert("\"AbnAfter10s\" is mandatory !");
		return false;
	}
	if (document.getElementById("abnAfter20s").value == null
			|| document.getElementById("abnAfter20s").value.length == 0) {
		alert("\"AbnAfter20s\" is mandatory !");
		return false;
	}
	if (document.getElementById("abnAfter30s").value == null
			|| document.getElementById("abnAfter30s").value.length == 0) {
		alert("\"abnAfter30s\" is mandatory !");
		return false;
	}
	if (document.getElementById("connectionRate").value == null
			|| document.getElementById("connectionRate").value.length == 0) {
		alert("\"ConnectionRate\" is mandatory !");
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
	if (document.getElementById("abnAfter10s").value == null
			|| document.getElementById("needPers").value.length == 0) {
		alert("\"AbnAfter10s\" is mandatory !");
		return false;
	}
	if (document.getElementById("asaWithin20s").value == null
			|| document.getElementById("asaWithin20s").value.length == 0) {
		alert("\"AbnAfter20s\" is mandatory !");
		return false;
	}
	if (document.getElementById("asaWithin30s").value == null
			|| document.getElementById("asaWithin30s").value.length == 0) {
		alert("\"AbnAfter30s\" is mandatory !");
		return false;
	}
	if (document.getElementById("asaWithin60s").value == null
			|| document.getElementById("asaWithin60s").value.length == 0) {
		alert("\"AbnAfter60s\" is mandatory !");
		return false;
	}
	if (document.getElementById("asaWithin180s").value == null
			|| document.getElementById("asaWithin180s").value.length == 0) {
		alert("\"AbnAfter180s\" is mandatory !");
		return false;
	}
	if (document.getElementById("fcrResolvable").value == null
			|| document.getElementById("fcrResolvable").value.length == 0) {
		alert("\"FcrResolvable\" is mandatory !");
		return false;
	}
	if (document.getElementById("fcrRaw").value == null
			|| document.getElementById("fcrRaw").value.length == 0) {
		alert("\"FcrRaw\" is mandatory !");
		return false;
	}
	if (document.getElementById("csat").value == null
			|| document.getElementById("csat").value.length == 0) {
		alert("\"Cast\" is mandatory !");
		return false;
	}
	if (document.getElementById("comments").value == null
			|| document.getElementById("comments").value.length == 0) {
		alert("\"Comments\" is mandatory !");
		return false;
	}
	if (document.getElementById("kpi").value == null
			|| document.getElementById("kpi").value.length == 0) {
		alert("\"KPI\" is mandatory !");
		return false;
	}
	if (document.getElementById("skillName").value == null
			|| document.getElementById("skillName").value.length == 0) {
		alert("\"SkillName\" is mandatory !");
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
