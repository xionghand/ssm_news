<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.pojo.User" %>
<%@ page import="com.pojo.News" %>
<%@ page import="com.pojo.PageShow" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .header{
            margin-top: 30px;
            height: 80px;
            width: auto;
        }
        .header-h{
            padding-top: 15px;
            text-align: center;
        }
        .header-btn{
            float: right;
            margin-right: 100px;;
        }

        .context{
            margin: 20px auto;
            width: 1000px;
            height: 300px;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function selAll(){
            var cb = document.getElementById("checkAll");
            if (cb.checked==true){
                var cbAll = document.getElementsByName("ids");
                for (var i=0;i<cbAll.length;i++){
                    cbAll[i].checked = true;
                }
            }else{
                var cbAll = document.getElementsByName("ids");
                for (var i=0;i<cbAll.length;i++){
                    cbAll[i].checked = false;
                }
            }
        }
        function sure() {
            var cbAll = document.getElementsByName("ids");
            for (var i = 0 ; i<cbAll.length;i++){
                if (cbAll[i].checked == true){
                    return true;
                }
            }
            alert("未选择数据，请先选择!!");
            return false;
        }
    </script>
</head>
<body>
    <div class="context">
        <fmt:formatDate value="${pageShow.query.qStartDate}" var="startDate" pattern="yyyy-MM-dd"></fmt:formatDate>
        <fmt:formatDate value="${pageShow.query.qEndNewsDate}" var="endDate" pattern="yyyy-MM-dd"></fmt:formatDate>
        <form action="news/newsMain" method="get" >
            新闻标题：<input type="text" name="query.qTitle" value="${pageShow.query.qTitle}">
            开始时间：<input type="date" name="query.qStartDate" value="${startDate}">
            结束时间：<input type="date" name="query.qEndNewsDate" value="${endDate}">
            <input type="submit" value="搜索">
        </form>

        <form action="news/delNews" method="post" class="context">
            <table border="1px" class="context">
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
                <c:forEach items="${list}" var="news">
                <tr>
                    <td><input type="checkbox" name="ids" value="${news.id}"></td>
                    <td>${news.id}</td>
                    <td>${news.newsId}</td>
                    <td>${news.title}</td>
                    <td>${news.context}</td>
                    <td>${news.newsMan}</td>
                    <td><fmt:formatDate value="${news.newsDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td><img src="${news.pic}" style="width: 102px" onerror="javascript:this.src='img/a.jpg'"></td>
                    <td>${news.typeId}</td>
                    <td><a href="news/toUpdate?id=${news.id}">修改</a></td>
                    <td><a href="news/delNews?ids=${news.id}" onclick="return confirm('是否删除？')">删除</a></td>
                </tr>
                </c:forEach>
            </table>
            <button type="submit" id="delSubmit" onclick="return sure()">全部删除</button>
            <div style="position: absolute">

                <c:url var="pageModule" value="news/newsMain">
                    <c:param name="query.qTitle" value="${pageShow.query.qTitle}"></c:param>
                    <c:param name="query.qStartDate" value="${startDate}"></c:param>
                    <c:param name="query.qEndNewsDate" value="${endDate}"></c:param>
                </c:url>

                <c:choose>
                    <c:when test="${pageShow.curPage==1}">首页&nbsp;上一页</c:when>
                    <c:otherwise><a href="${pageModule}&curPage=1">首页</a>&nbsp;<a href="${pageModule}&curPage=${pageShow.curPage-1}">上一页</a></c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${pageShow.curPage==pageShow.pageNum}">下一页&nbsp;尾页</c:when>
                    <c:otherwise><a href="${pageModule}&curPage=${pageShow.curPage+1}">下一页</a>&nbsp;<a href="${pageModule}&curPage=${pageShow.pageNum}">尾页</a></c:otherwise>
                </c:choose>
                <span>${pageShow.totalCount}条数 当前页为${pageShow.curPage}/共${pageShow.pageNum}页</span>
            </div>
        </form>
    </div>



</body>
</html>
