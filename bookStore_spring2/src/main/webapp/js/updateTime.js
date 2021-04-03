/**
 * 
 */
 
 var update = $(".update_time").children("a");

update[0].onclick = function(){
	location = "bookFilter?name=book_updatetime" + "&value=全部";
}
 
update[1].onclick = function(){
	location = "bookFilter?name=book_updatetime" + "&value=三日内";
}

update[2].onclick = function(){
	location = "bookFilter?name=book_updatetime" + "&value=七日内";
}

update[3].onclick = function(){
	location = "bookFilter?name=book_updatetime" + "&value=半月内";
}

update[4].onclick = function(){
	location = "bookFilter?name=book_updatetime" + "&value=一月内";
}
