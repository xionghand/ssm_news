<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="java.net.URLDecoder" %>
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
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .all{
            padding: 20px 20px;
            width: 400px;
            height: auto;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<div class="all">
    <form action="user/login" method="post">
        <span style="color: red">${param.error}</span></p>
        <table border="0">
            <tr>
                <td>账号</td>
                <td><input name="userId" type="text" value="${URLDecoder.decode(cookie.username.value,"utf-8")}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="pwd" type="password" value="${cookie.password.value}"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="checkbox" name="isno" value="yes">免登录
                </td>
            </tr>
            <tr>
                <td style="text-align: center" colspan="2">
                    <input type="submit" maxlength="40px" value="登录">
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
