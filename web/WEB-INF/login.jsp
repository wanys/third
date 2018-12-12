<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/16
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center" style="color: red"><h1>登录成功！</h1></div>
<form action="login.do" method="post">
    <div>
        <a href="AddStu.do">新增学生信息</a>
    </div>
    <div>
        <div align="center" style="padding-top: 60px">
            姓名：<input type="text" name="stuname"><input type="submit" value="查询">
        </div>
    </div>
    <div align="center">
        <table>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>分数</th>
                <th>操作</th>
            </tr>
            <c:forEach var="item" items="${pageBean.list}" varStatus="s">
                <tr>
                    <td>${s.index+1}</td>
                    <td>${item.stuname}</td>
                    <td>${item.stuage}</td>
                    <td>${item.stusex}</td>
                    <td>${item.stumark}</td>
                    <td>
                        <a href="deleteStu.do?id=${item.id}">删除</a>
                        <a href="updateStu.do?id=${item.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="height:50px ">
    </div>
    <div align="center">
    <%-- 构建分页导航 --%>
    共有${requestScope.pageBean.totalRecord}个员工，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
    <br/>
    <a href="Paging.do?pageNum=1">首页</a>
    <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
    <c:if test="${pageBean.pageNum ==1 && pageBean.totalPage !=1}">
        <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
            <c:if test="${pageBean.pageNum == i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum != i}">
                <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${i}">${i}</a>
            </c:if>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${pageBean.pageNum+1}">下一页</a>
    </c:if>
    <%--如果只有一页 --%>
    <c:if test="${pageBean.pageNum ==1 && pageBean.totalPage ==1}">
        <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
            <c:if test="${pageBean.pageNum == i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum != i}">
                <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${i}">${i}</a>
            </c:if>
        </c:forEach>
    </c:if>
    <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
    <c:if test="${pageBean.pageNum > 1 && pageBean.pageNum < pageBean.totalPage}">
        <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${pageBean.pageNum-1}">上一页</a>
        <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
            <c:if test="${pageBean.pageNum == i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum != i}">
                <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${i}">${i}</a>
            </c:if>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${pageBean.pageNum+1}">下一页</a>
    </c:if>

    <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
    <c:if test="${pageBean.pageNum == pageBean.totalPage && pageBean.totalPage!=0 && pageBean.totalPage !=1}">
        <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${pageBean.pageNum-1}">上一页</a>
        <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
            <c:if test="${pageBean.pageNum == i}">
                ${i}
            </c:if>
            <c:if test="${pageBean.pageNum != i}">
                <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${i}">${i}</a>
            </c:if>
        </c:forEach>
    </c:if>
    <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
    <c:if test="${pageBean.pageNum == 0 && pageBean.totalPage==0}">

    </c:if>
    <%--尾页 --%>
    <a href="${pageContext.request.contextPath}/Paging.do?pageNum=${pageBean.totalPage}">尾页</a>
    </div>
</form>
</body>
</html>
