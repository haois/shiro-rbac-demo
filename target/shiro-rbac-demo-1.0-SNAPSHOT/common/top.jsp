<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/meta.jsp" %>
</head>
<body class="login">
<div class="container">
    <h4><p class="bg-success" style="text-align: center;margin-top: 10px">用户管理</p></h4>
    <div class="row">

        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-success" type="button" id="usListBtn">用户列表</button>
                </div>
            </div>
        </div>
        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-success" type="button" id="usAddBtn">用户增加</button>
                </div>
            </div>
        </div>
        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-success" type="button" id="reListBtn">资源管理</button>
                </div>
            </div>
        </div>
        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-success" type="button" id="roListBtn">角色管理</button>
                </div>
            </div>
        </div>
        <div class="col-md-1">

        </div>
        <div class="col-md-1">

        </div>
        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <a class="btn btn-success" type="button" id="InfoBtn">我的信息</a>
                </div>
            </div>
        </div>
        <div class="col-md-1">

        </div>

        <div class="col-md-1">

        </div>


        <div class="col-md-1">

        </div>

        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-success" type="button" id="bbsIndex">论坛</button>
                </div>
            </div>
        </div>

        <div class="col-md-1">
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-danger" type="button" id="logoutBtn">退出</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/rbac/top.js"></script>
</html>
