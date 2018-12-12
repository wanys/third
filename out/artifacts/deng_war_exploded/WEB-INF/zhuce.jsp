<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/16
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<script type="text/javascript">
function checkaccount(obj) {
    if (obj.trim().length==0){
        $("#checkaccount").textContent("账户不能为空");
        obj.focus();
    }
}
function checkpsw(obj) {
    if(obj.trim().length==0){
        $("checkpsw").text("密码不能为空");
        obj.focus();
    }
}
function checkrpsw(obj) {
    if (obj.trim().length==0){
        $("checkrpsw").text("确认密码不能为空")
    }
    obj.focus();
}
$(function(){
    $("#name").blur(function(){
        var account=$(this).val();
        $.ajax(
            {
                url:"checkacc",
                type:"get",
                data:{"account":account},
                dataType:"json",
                success:function(data){
                    if(data==false){
                        $("#checkaccount").text("该用户名已存在！");
                        $("#checkaccount").focus();
                    }
                }
            }
        );
    });
});

</script>
<div align="center">
    <div><h1>用户注册</h1></div><br>
    <form action="zhuce.do" method="post">
        <div id="account">
            请输入用户名：<input name="name" type="text" value="${User.name}" onblur="checkaccount(this.vale())">
        </div>
        <div id="password">
            请输入密码：<input name="psw" type="text" value="${User.psw}" onblur="checkpsw(this.value)">
        </div>
        <div id="rpassword">
            请确认密码：<input name="rpsw" type="text" onblur="checkrpsw(value)">
        </div>
        <div id="sub"><input type="submit" value="注册"></div>

    </form>
</div>
</body>
</html>
