<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/meta.jsp" %>
    <title>user/list</title>
</head>
<body>
<%@ include file="/common/top.jsp" %>
    <div class="container">
        <div class="row" style="margin-bottom: 10px;">
            <div class="col-md-12" style="text-align: center">
                <h3><span class="label label-warning">用户列表</span></h3>
            </div>
        </div>
        <table class="table">
            <tr>
                <td>用户编号</td>
                <td>用户登录名</td>
                <td>用户真实姓名</td>
                <td>用户状态</td>
                <td>用户密码</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${userList}" var="users">
                <tr>
                    <td>${users.id}</td>
                    <td>${users.username}</td>
                    <td>${users.nickname}</td>
                    <td>
                        ${users.status}
                    </td>
                    <td>*******</td>
                    <td>
                        <a  class="btn btn-info" href="${ctx}/user/update/${users.id}">更新</a>
                        <a  class="btn btn-info" href="${ctx}/user/res/${users.id}">查看资源管理</a>
                        <a  class="btn btn-info" href="${ctx}/user/delete/${users.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
