<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World!<a href="/upload">上传</a>
	<ul id="showFile"></ul>
</body>
<script>
$(function(){
	$.get("/getTitles",function(data,status){
		if(status=='success'){
			console.log(data);
			for(var i=0;i<data.length;i++){
				$("#showFile").append('<li><a href="/detail/'+data[i].id+'">'+data[i].titleName+'</a></li>');
			}
		}
	});

});
</script>
</html>