/**
 * 
 */
 
 
 
var schedule = $(".word_num").children("a");

schedule[0].onclick = function(){
	location = "bookFilter?name=word_num" + "&value=全部";
}

schedule[1].onclick = function(){
	location = "bookFilter?name=word_num" + "&value=30万字以下";
}

schedule[2].onclick = function(){
	location = "bookFilter?name=word_num" + "&value=30-50万";
}

schedule[3].onclick = function(){
	location = "bookFilter?name=word_num" + "&value=50-100万";
}

schedule[4].onclick = function(){
	location = "bookFilter?name=word_num" + "&value=100-200万";
}

schedule[5].onclick = function(){
	location = "bookFilter?name=word_num" + "&value=200万以上";
}