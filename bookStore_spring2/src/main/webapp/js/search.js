/**
 * 搜索
 */
 
 
   
   var search_btn = $(".search_btn");
   
search_btn.onclick = function(){
	console.log(12);
	var search = $(".search");
	var value = search.val();
	location = "searchBook?value=" + value;
}