$(function(){
	
	switch(title)
	{
	case 'about':
		$('#about').addClass("active");
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;
	case 'home':
		$('#home').addClass('active');
		break;
	case 'All Product':
		$('#allproduct').addClass('active');
		break;
		
	default:
		$('#a_'+title).addClass('active');
	
	
	}
});