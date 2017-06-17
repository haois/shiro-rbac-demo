<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/meta.jsp" %>
    <title>user/res</title>
</head>
<body>
<%@ include file="/common/top.jsp" %>
<div class="container">
    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">角色列表</span></h3>
        </div>
    </div>

    <table class="table table-bordered">
        <tr>
            <td>编号</td>
            <td>角色名</td>
            <td>角色sn</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${roleList}" var="ros" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${ros.name}</td>
                <td>${ros.sn}</td>
                <td>
                    <a  class="btn btn-info" href="${ctx}/role/update/${ros.id}">更新</a>
                    <a  class="btn btn-info" href="${ctx}/role/res/${ros.id}">查看资源管理</a>
                    <a  class="btn btn-info" href="${ctx}/role/delete/${ros.id}">删除</a>
                    <a  class="btn btn-info" href="${ctx}/role/res/update/${ros.id}">更新资源管理</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container" style="width: 300px">
    <form action= "${ctx}/role/add"  method="post">
        <div class="form-group" style="margin-top: 50px">
            <div class="input-group">
                <div class="input-group-addon">角色名</div>
                <input class="form-control" placeholder="name" name="name">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">角色sn</div>
                <input class="form-control" placeholder="Sn" name="sn">
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
