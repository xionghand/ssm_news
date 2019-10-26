<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//D HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
    <script>

        function changepic() {
            var reads= new FileReader();
            f=document.getElementById('picture').files[0];
            reads.readAsDataURL(f);
            reads.οnlοad=function (e) {
                document.getElementById('show').src=this.result;
            };
        }
    </script>
</head>
<body>
    <form action="news/addNews" method="post" enctype="multipart/form-data" onsubmit="return confirm('是否添加该新闻！')">
        
       新闻编号<input name="newsId" type="text"><p>
       新闻标题<input name="title" type="text"><p>
       新闻内容<input name="context"  type="text"><p>
       新闻作者<input name="newsMan" type="text"><p>
       新闻时间<input name="newsDate" type="date">
       新闻图片<input name="imgPic" id="picture" type="file" onchange="changepic()"><p>
       新闻类别 <select name="typeId">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select><p>
        <input type="submit" value="添加">
    </form>
</body>
</html>
