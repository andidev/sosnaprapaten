$(document).ready(function() {
	
	$(".subMenu").hide();
	
		 $.getJSON('/menu', {key: "/"}, function(menu) {
			 //alert(menu.contentText);
			 $(".contentArea").html(menu.contentText);
		 });
		
	
	$(".menu").click(function(){
		
		 $.getJSON('/menu', {key: this.id}, function(menu) {
			 $(".contentArea").html(menu.contentText);
		 });
	});
	
	$(".subMenu").click(function(){
		
		 $.getJSON('/menu', {key: this.id}, function(menu) {
			 $(".contentArea").html(menu.contentText);
		 });
	});

	$("#behandlning").hover(function() {
			$(this).find(".subMenu").show();
		},
		function() {
			$(this).find(".subMenu").hide();
	});
	
});


