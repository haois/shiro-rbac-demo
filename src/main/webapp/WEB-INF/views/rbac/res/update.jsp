<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/meta.jsp" %>
    <title>res/update</title>
</head>
<body>
<%@ include file="/common/top.jsp" %>
<div class="container" style="width: 300px">
    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">更新权限资源</span></h3>
        </div>
    </div>
    <form action= "${ctx}/res/update"  method="post">
        <div class="form-group" style="margin-top: 50px">
            <input type="hidden" value="${res.id}" name="id">
            <div class="input-group">
                <div class="input-group-addon">名称</div>
                <input class="form-control" placeholder="Name" name="name" value="${res.name}">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">资源限定</div>
                <input class="form-control" placeholder="Url" name="url" value="${res.url}">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <div class="input-group-addon">权限字</div>
                <input class="form-control" placeholder="Permission" name="permission" value="${res.permission}">
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
