$(function($){
	//修改数量
	$("#qty").change(function(){
		var value=$(this).val();
		if((value == "")||!(/^[0-9]*[1-9][0-9]*$/.test(value))){
			alert("数量不能为空，且只能为正整数");
			$(this).val(1);
		}
		var itemid=$("#item").text();
		var num=$(this).val();
		$.ajax({
			type: "post",
			url: "DoCart",
			data: {
				action: "Change",
				itemid: itemid,
				num: num
			},
			statusCode: {
				404: function() {
					
				}
			},
			success: function(data,textStatus) {
				location.reload(true);
			}
		})
	});
})