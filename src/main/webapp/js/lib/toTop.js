$(function(){
	try{
		$('body').append('<div id="goTopBtn" onclick="toTop()"><a><img src="../images/top.png" alt="TOP" /></a></div>');
		
		$('#goTopBtn').css({"position":"fixed","lineHeight":"50px","width":"50px","bottom":"10px","height":"50px","cursor":"pointer","display":"none","z-index":"100"});
	
		$('#goTopBtn a img').css("opacity","0.3");
	
		$('#goTopBtn a').hover(function() {
			$(this).find("img").css("opacity","1");
		},function(){
			$(this).find("img").css("opacity","0.3");
		});
		
		$(window).scroll(function(){   
			  var sc = $(window).scrollTop();
			  var rightWidth = $(window).width();
				if(sc>0){
					$("#goTopBtn").css("display", "block");
					$("#goTopBtn").css("left", (rightWidth - 120) + "px");
				}
				else{
					$("#goTopBtn").css("display","none");
				}
		});
		
		
		$('#goTopBtn').click(function(){
			$('body,html').animate({scrollTop : 0},500);
		});
		
	}catch(e){
		
	}
});

