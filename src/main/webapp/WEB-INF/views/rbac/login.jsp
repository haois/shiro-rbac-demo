<%--
  Created by IntelliJ IDEA.
  User: haol
  Date: 2016/9/4
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/meta.jsp" %>
</head>
<body class="login">
<div class="row text-center">
    <h1>基于Apache shiro 设计的权限管理demo</h1>
</div>
<div class="container" style="width: 300px">
    <form action= "${ctx}/login/login" id="form" method="post">
    <div class="form-group" style="margin-top: 50px">
        <div class="input-group">
            <div class="input-group-addon">用户名</div>
            <input class="form-control" placeholder="UserName" name="username" value="${account}">
        </div>
    </div>
    <div class="form-group">
        <div class="input-group">
            <div class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码</div>
            <input class="form-control" placeholder="Password" name="password" type="password">
        </div>
    </div>
    <div class="form-group">
        <div class="input-group" style="margin: auto">
           <button class="btn btn-success" type="button" id="subBtn">登陆</button>
        </div>
    </div>
        <div class="form-group">
            <div class="input-group" style="margin: auto">
                <p class="bg-warning"> ${error} </p>
            </div>
        </div>

        <div class="form-group">
            <div class="input-group text-center" style="margin: auto">
                <p class="bg-info">超级管理员</p>
                <p class="bg-info">账号:gcu</p>
                <p class="bg-info">密码:gcu</p>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/rbac/user/login.js"></script>
</html>
