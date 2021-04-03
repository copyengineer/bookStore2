

var schedule = $(".write_schedule").children("a");

schedule[0].onclick = function(){
	location = "bookFilter?name=write_schedule" + "&value=全部";
}

schedule[1].onclick = function(){
	location = "bookFilter?name=write_schedule" + "&value=连载中";
}

schedule[2].onclick = function(){
	location = "bookFilter?name=write_schedule" + "&value=已完结";
}