
var names = $(".book_type").children("a");



names[0].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=全部作品";
}

names[1].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=奇幻玄幻";
}

names[2].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=武侠仙侠";
}

names[3].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=历史军事";
}

names[4].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=都市娱乐";
}

names[5].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=科幻游戏";
}

names[6].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=悬疑灵异";
}

names[7].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=竞技同人";
}

names[8].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=评论文集";
}

names[9].onclick = function(){
	location = "bookFilter?name=book_type&" + "value=二次元";
}






