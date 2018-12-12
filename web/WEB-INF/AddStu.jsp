<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/1
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form action="AddStu.do" method="post">
        <div align="center" style="padding-top: 60px">
            <div>
                <p>姓名：<input type="text" name="stuname" value="${Student.stuname}"></p>
            </div><br>
            <div>
                <p>性别：<input type="text" name="stusex" value="${Student.stusex}"></p>
            </div><br>
            <div>
                <p>年龄：<input type="text" name="stuage" value="${Student.stuage}"></p>
            </div><br>
            <div>
                <p>分数：<input type="text" name="stumark" value="${Student.stumark}"></p>
            </div>
            <button type="submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>
