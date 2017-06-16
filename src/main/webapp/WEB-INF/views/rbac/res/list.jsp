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
    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">全部权限资源</span></h3>
        </div>
    </div>

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
                    <a  class="btn btn-info" href="${ctx}/res/update/${ress.id}">更新</a>
                    <a  class="btn btn-info" href="${ctx}/res/delete/${ress.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container" style="width: 300px">
    <form action= "${ctx}/res/add"  method="post">
        <div class="form-group" style="margin-top: 50px">
            <div class="input-group">
                <div class="input-group-addon">名称</div>
                <input class="form-control" placeholder="Name" name="name">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">资源限定</div>
                <input class="form-control" placeholder="Url" name="url">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">权限字</div>
                <input class="form-control" placeholder="Permission" name="permission">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group" style="margin: auto">
                <button class="btn btn-success" type="submit">增加</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
