var hintDialog = function(msg){
		$.dialog({
			content : msg,
			time : 3,
			focus : false,
			resize : true,
			lock : true,
			ok : true,
			okValue : "确定"
		});
	};