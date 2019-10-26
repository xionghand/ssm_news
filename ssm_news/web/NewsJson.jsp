<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript" src="jquery-2.1.4/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            $.ajax({
                url:"news/newsMainJson",
                dataType:"json",
                type:"post",
                dataType:"json",
                data:{"curPage":1},
                success:function (data) {
                    var tr;
                    for (var i=0;i<data.length;i++){
                        tr = "<tr><td><input type=\'checkbox\'>"+data[i].id+"</input></td>" +
                            "<td>"+data[i].id+"</td>" +
                            "<td>"+data[i].newsId+"</td>" +
                            "<td>"+data[i].title+"</td>" +
                            "<td>"+data[i].context+"</td>" +
                            "<td>"+data[i].newsMan+"</td>" +
                            "<td>"+data[i].newsDate+"</td>" +
                            "<td>"+data[i].pic+"</td>" +
                            "<td>"+data[i].typeId+"</td>";
                            tr +="</tr>";
                        $("#empTable").append(tr)
                    }
                },
                error:function (data) {
                    alert("ajax请求出错");
                }
            })
        })
    </script>
</head>
<body>
<table border="1px" class="context" id="empTable">
    <tr>
        <td><input type="checkbox" id="checkAll" value="ids" onclick="selAll()">全选</td>
        <td>序号</td>
        <td>新闻编号</td>
        <td>新闻标题</td>
        <td>新闻内容</td>
        <td>新闻作者</td>
        <td>新闻日期</td>
        <td>新闻图片</td>
        <td>新闻类别</td>
        <td>删除新闻</td>
        <td>修改新闻</td>
    </tr>

</table>
</body>
</html>
