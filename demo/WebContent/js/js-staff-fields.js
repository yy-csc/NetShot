function isCompleted(){
	if(document.getElementById("lastName").value==null || document.getElementById("lastName").value.length==0){
		alert("\"Last Name\" is mandatory !");
		return false;
	}
	if(document.getElementById("firstName").value==null || document.getElementById("firstName").value.length==0){
		alert("\"First Name\" is mandatory !");
		return false;
	}
	if(document.getElementById("shortName").value==null || document.getElementById("shortName").value.length==0){
		alert("\"Short Name\" is mandatory !");
		return false;
	}
	if(document.getElementById("loginId").value==null || document.getElementById("loginId").value.length==0){
		alert("\"LoginId\" is mandatory !");
		return false;
	}
	if(document.getElementById("empNo").value==null || document.getElementById("empNo").value.length==0){
		alert("\"Employee No\" is mandatory !");
		return false;
	}
	if(document.getElementById("position").value==null || document.getElementById("position").value.length==0){
		alert("\"Position\" is mandatory !");
		return false;
	}
	if(document.getElementById("email").value==null || document.getElementById("email").value.length==0){
		alert("\"E-mail\" is mandatory !");
		return false;
	}
	return true;
}
