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
    <title>role/update</title>
</head>
<body>
<%@ include file="/common/top.jsp" %>
<div class="row" style="margin-bottom: 10px;">
    <div class="col-md-12" style="text-align: center">
        <h3><span class="label label-warning">更新资源属性</span></h3>
    </div>
</div>
<div class="container" style="width: 300px">
    <form action= "${ctx}/role/update"  method="post">
        <div class="form-group" style="margin-top: 50px">
            <input type="hidden" name="id" value="${role.id}">
            <div class="input-group">
                <div class="input-group-addon">角色名</div>
                <input class="form-control" placeholder="name" name="name" value="${role.name}">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">角色sn</div>
                <input class="form-control" placeholder="Sn" name="sn" value="${role.sn}">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group" style="margin: auto">
                <button class="btn btn-success" type="submit">更新</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
