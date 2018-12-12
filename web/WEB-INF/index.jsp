<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/16
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<div align="center">
  <div><h1>欢迎登录</h1></div><br>
  <form action="index.do" method="post">
    <div id="account"><h3>
      账号：<input name="account" type="text" ></h3>
    </div>
    <div id="password"><h3>
      密码：<input name="psw" type="password" ></h3>
    </div>
    <div id="sub"><input type="submit" value="登录"></div>
    <div id="link"><h4>
      <a href="zhuce.do" style="text-decoration: none;color:gray"><font size="1">没有账号？免费注册</font></a>
        </h4></div>
  </form>
</div>
  </body>
</html>
