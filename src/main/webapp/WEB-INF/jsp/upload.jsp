<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form id="file-form-stuInfo" enctype="multipart/form-data" action="/canUpload" method="post">
    <table>
        <tr>
            <td align="right">文件标题名:</td>
            <!-- <td><input id="fileName" type="text" name="fileName" class="wu-text" placeholder="不能为空" /></td> -->
            <td>
            	<select id="titleSelect" name="titleSelect">
					<option value="0">请选择</option>
            	</select>
            </td>
        </tr>
        <tr>
            <td align="right">类型:</td>
            <td>
            	<select id="sel" name="fileType" id="fileType">
            		<option value="1">HTML</option>
            		<option value="2">MP3</option>
            		<option value="3">PDF</option>
            	</select>
            </td>
        </tr>
<!--         <tr>
            <td align="right">性别:</td>
            <td><input id="stuSex" type="text" name="stuSex" class="wu-text" placeholder="不能为空，例如：女" /></td>
        </tr> -->
        <tr>
            <td width="60" align="right">文件上传:</td>
            <td>
                <input class="fl" type="file" id="imgPath" name="file" onchange="javascript:setImagePreview();" multiple="multiple"/>
            </td>
        </tr>
        <tr>
            <td valign="top" align="right">介绍:</td>
            <td><textarea id="fileIntroduce" name="fileIntroduce" rows="6" class="wu-textarea" style="width:260px" placeholder="字数为200字以内。" maxlength="200"></textarea></td>
        </tr>
        <tr>
        	<td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
<script>
$(function(){
	loadTitleSelect();
});
function loadTitleSelect(){
	$.get("/getTitles",function(data,status){
		if(status=="success"){
			console.log(data);
			for(var i=0;i<data.length;i++)
				$("#titleSelect").append("<option value='"+data[i].id+"'>"+data[i].titleName+"</option>");
		}
	});
}
</script>
</html>






























