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
        $(function () {
            $("#username").blur(function(){
                var nameVal = $(this).val();

                //发送ajax请求
                $.ajax({
                    //该ajax发送请求到那个地址处理
                    url:"news/registerUser",
                    //请求方式
                    type:"post",
                    //预计服务器返回的数据格式
                    dataType:"json",
                    //发送的数据
                    data:{"userId":$("#username").val()},
                    /*
                        响应成功以后的回调函数,参数的data用来接收后台传递过来的数据
                     */
                    success:function(data){
                        if(data.flag){
                            $("#nameSpan").html("可用").css({"color":"green","font-size":"5"});
                        }else{
                            $("#nameSpan").html("不可用").css({"color":"red","font-size":"5"});
                        }
                        if (nameVal==""){
                            $("#nameSpan").html("不能为空!").css({"color":"red","font-size":"5"});
                        }
                    },
                    //响应失败以后执行的回调函数
                    error:function(){
                        alert("失败....");
                    }
                });
            });
            $("#pwd").blur(function () {
                var pwd = $(this).val();
                var rePwd = $("#repwd").val();
                if (pwd==rePwd){
                    $("#pwdSpan").html("密码一致").css({"color":"green","font-size":"5"});
                }else{
                    $("#pwdSpan").html("密码不一致").css({"color":"red","font-size":"5"});
                }
            });
        })
    </script>
</head>
<body>
    <form action="##" method="post">
        账号:<input type="text" id="username"><span id="nameSpan"></span><p>
        性别:<input type="text" id="">
        密码:<input type="password" id="pwd"><p>
        确认密码:<input type="password" id="repwd"><span id="pwdSpan"></span><p>
        <input type="submit" value="注册">
    </form>

</body>
</html>
