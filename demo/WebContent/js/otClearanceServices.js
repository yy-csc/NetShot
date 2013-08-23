$(function() {

	$("input:checkbox").click(function() {
		var sum = 0;
		var tempId= this.id;
		if (this.checked == true) {
			
			$("input:checkbox").each(function() {
				if (tempId >= $(this).attr("id")) {
					this.checked = true;
				}else {
					this.checked = false;
				}
			});
		}else {
			$("input:checkbox").each(function() {
				if (tempId <= $(this).attr("id")) {
					this.checked = false;
				}else {
					this.checked = true;
				}
			});
		}
		
		$("input:checkbox:checked").each(function() {
			var id = this.value;
			$("input:hidden").each(function() {
				if ($(this).attr("id") == id) {
					/*sum += parseFloat(this.value);*/
					sum = accAdd(sum,parseFloat(this.value));
				};
			});

		});
		
		$("#transHours").val(sum);
		fixNumber($("#transHours"),1);
	});
	
	
	function accAdd(arg1,arg2)
	{
	    var r1,r2,m;
	    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
	    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
	    m=Math.pow(10,Math.max(r1,r2));
	    return (dcmMul(arg1,m)+dcmMul(arg2,m))/m;
	}
	function dcmMul(arg1,arg2){
	    var m=0,s1=arg1.toString(),s2=arg2.toString();
	    try{m+=s1.split(".")[1].length;}catch(e){}
	    try{m+=s2.split(".")[1].length;}catch(e){}
	    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
	}
	function fixNumber(o,n){
	    if(o.value==""||isNaN(o.value)||o.value==Infinity){
	        o.value=parseFloat("0").toFixed(n);
	    }else{
	    	var str = o.value.replace("-","").replace(".","");
	    	if(str.length<16){
	    		o.value=parseFloat(o.value).toFixed(n);
	    	}
	    }
	};
	function fixNumber1(o,n){
		if(o==""||isNaN(o)||o==Infinity){
			o=parseFloat("0").toFixed(n);
		}else{
			var str = o.replace("-","").replace(".","");
			if(str.length<16){
				o=parseFloat(o).toFixed(n);
			}
		}
	};
	
	
/*	$("input:checkbox").click(function() {
		var sum = 0;
		$("input:checkbox:checked").each(function() {
			var id = this.value;
			$("input:hidden").each(function() {
				if ($(this).attr("id") == id) {
					sum += parseFloat(this.value);
				};
			});
			
		});
		$("#transHours").val(sum);
	});
*/
	$("#checkAll").click(function() {

		var sum = 0;
		if (this.checked) {
			$("input[name='sumVO.tOSumId']").each(function() {
				this.checked = true;
			});
			$("input:checkbox:checked").each(function() {
				var id = this.value;
				$("input:hidden").each(function() {
					if ($(this).attr("id") == id) {
						sum += parseFloat(this.value);
					}
					;

				});

			});
			$("#transHours").val(sum);
		} else {
			$("input[name='sumVO.tOSumId']").each(function() {
				this.checked = false;
			});
			$("#transHours").val(sum);
		}
	});
	
	function checkComment(){
		var comm = $("#comment").val();
		if (comm == "" || comm.length <=0) {
			alert("Please input some comment!");
			return false;
		}
		return true;
	}

	function checkSelectList(){
		var trans = 0;
		$("input:checkbox:checked").each(function() {
			trans += 1;
		});

		if (trans == 0) {
			alert("You are not select any list!");
			return false;
		}
		if (trans == 1 && $("#checkAll").attr("checked")) {
			alert("You are not select any list!");
			return false;
		}
		
		if (!checkComment()) {
			return false;	
		}
		return true;
	}
	
	$("#otClearForm").submit(function() {
		if (checkSelectList()) {
			return confirm("Confirm to Clear the choosed OT?");	
		}else {
			return false;
		}
		
	});
	
	
	$("#Transfer1").click(function() {
		var trans = 0;
		$("input:checkbox:checked").each(function() {
			trans += 1;
		});

		if (trans == 0) {
			alert("You are not select any list!");
			return false;
		}
		if (trans == 1 && $("#checkAll").attr("checked")) {
			alert("You are not select any list!");
			return false;
		}
		
		if (!checkComment()) {
			return false;	
		}
		if(confirm("Confirm to Clear the choosed OT?")){
			$('#otClearForm').submit();
		}
	});
	
	$("#approve1").click(function() {

		var trans = 0;
		$("input:checkbox:checked").each(function() {
			trans += 1;
		});

		if (trans == 0) {
			alert("You are not select any list!");
			return false;
		}
		if (trans == 1 && $("#checkAll").attr("checked")) {
			alert("You are not select any list!");
			return false;
		}
		return confirm("Confirm to Approve the Payment?");
	});
	$("#reject1").click(function() {

		var trans = 0;
		$("input:checkbox:checked").each(function() {
			trans += 1;
		});

		if (trans == 0) {
			alert("You are not select any list!");
			return false;
		}
		if (trans == 1 && $("#checkAll").attr("checked")) {
			alert("You are not select any list!");
			return false;
		}
		return confirm("Confirm to Reject the Payment?");
	});
		
			

});
