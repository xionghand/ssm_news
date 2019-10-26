<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
</head>
<body>
<fmt:formatDate value="${news.newsDate }" pattern="yyyy-MM-dd" var="nDate"></fmt:formatDate>
    <form action="news/update" method="post" enctype="multipart/form-data">
        <table border="1px">
                序号<input name="id" type="text" readonly="readonly" value="${news.id}"><p>
            新闻编号：<input name="newsId" type="text" value="${news.newsId}"><p>
                新闻标题：<input name="title" type="text" value="${news.title}"><p>
                新闻内容：<input name="context" type="text" value="${news.context}"><p>
                新闻作者：<input name="newsMan" type="text" value="${news.newsMan}"><p>
                新闻时间：<input name="newsDate" type="date" value="${nDate}">
                          <input type="hidden" name="imgPic" value="${news.pic}">
                新闻图片：<input name="imgPic" type="file" accept="image/vnd.sealedmedia.softseal-jpg"><p>
                新闻类别：<select name="typeId">
                          <c:forEach items="${list}" var="lnews">
                              <option value="${lnews.typeId}" <c:if test="${news.typeId==lnews.typeId}">selected="selected"</c:if>>${lnews.typeId}</option>
                          </c:forEach>
                         </select><p>
            <img src="${news.pic}" width="200px"><p>
            <input type="submit" value="修改" onclick="return confirm('确定修改！')">

        </table>
    </form>


</body>
</html>
