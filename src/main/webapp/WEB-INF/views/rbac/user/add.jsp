<%--
  Created by IntelliJ IDEA.
  User: haol
  Date: 2016/9/10
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/meta.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/js/lib/validate/validate.css">
    <script type="text/javascript" src="${ctx}/js/lib/validate/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/lib/validate/jquery.validate.common_rules.js"></script>
    <script type="text/javascript" src="${ctx}/js/lib/validate/messages_cn.js"></script>
    <script type="text/javascript" src="${ctx}/js/gcu/rbac/user/add.js"></script>
    <title>user/add</title>
</head>
<body>
<div class="container">
    <%@ include file="/common/top.jsp" %>
    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">增加用户</span></h3>
            <input type="hidden" value="${user.id}" name="id"/>
        </div>
    </div>
    <form id="addFrom">
        <div class="container" style="width: 500px">
                <div class="form-group" style="margin-top: 50px">
                    <div class="input-group">
                        <div class="input-group-addon">用户名</div>
                        <input class="form-control" placeholder="username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">用户密码</div>
                        <input class="form-control" placeholder="password" name="password">
                    </div>
                </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">真实姓名</div>
                    <input class="form-control" placeholder="nickname" name="nicknane">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">状态</div>
                    <select name="status" class="form-control">
                        <option value="1">启用</option>
                        <option value="0">锁定</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <c:forEach items="${roleList}" var="roles">
                    <span class="label label-success" style="margin-left:5px">
                        ${roles.name} <input type="checkbox" name="roles_name" value="${roles.id}">
                    </span>
                </c:forEach>
            </div>
                <div class="form-group">
                    <div class="input-group" style="margin: auto">
                        <button class="btn btn-success" type="button"  id="addBtn">增加</button>
                    </div>
                </div>
        </div>
    </form>

</div>
</body>
</html>
