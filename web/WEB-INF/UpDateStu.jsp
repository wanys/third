<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
  <title>修改学生信息</title>
</head>
<body >
    <div style="height: 150px;width: 500px;margin-left: 430px;">
      <form action="updateStu.do" method="post">
        <div align="center" style="padding-top: 60px">
          <div>
            <p>姓名：<input type="text" name="stuname" value="${Student.stuname}"/></p>
          </div>
          <br/>
          <div>
            <p>性别：<input type="text" name="stusex" value="${Student.stusex}"/></p>
          </div>
          <br/>
          <div>
            <p>年龄：<input type="text" name="stuage" value="${Student.stuage}"/></p>
          </div>
          <br/>
          <div>
            <p>分数：<input type="text" name="stumark" value="${Student.stumark}"/></p>
          </div>
          <input type="hidden" name="id" value="${Student.id}"/>
          <br/>
          <button type="submit">提交</button>
        </div>
      </form>
    </div>
</body>
</html>