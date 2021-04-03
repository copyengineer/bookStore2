/**
 * 
 */
 
   var other = $(".other").children("a");

other[0].onclick = function(){
	location = "bookFilter?name=other" + "&value=全部";
}

other[1].onclick = function(){
	location = "bookFilter?name=other" + "&value=免费";
}

other[2].onclick = function(){
	location = "bookFilter?name=other" + "&value=VIP";
}