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
</head>
<body>
<%@ include file="/common/top.jsp" %>
<div class="container">
    <form action="/role/res/update" method="post">
    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">更新${role.name}的权限资源</span></h3>
        </div>
    </div>
    <c:forEach var="hr" items="${role_res}">
        <input type="hidden" class="hasRes" value="${hr.id}"/>
    </c:forEach>
    <input type="hidden" value="${role.id}" name="roleId" id="roleId">
    <table class="table table-bordered">
        <tr>
            <td>编号</td>
            <td>资源名称</td>
            <td>资源url</td>
            <td>资源权限字符串</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${resList}" var="ress" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${ress.name}</td>
                <td>${ress.url}</td>
                <td>${ress.permission}</td>
                <td>
                    <input type="checkbox" value="${ress.id}" name="resId" id="resId" class="setPermission">
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/rbac/role/updateRes.js"></script>
</html>
