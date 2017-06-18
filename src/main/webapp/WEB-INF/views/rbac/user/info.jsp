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
            <h3><span class="label label-warning">拥有的角色</span></h3>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <td>编号</td>
            <td>角色名</td>
            <td>角色sn</td>
        </tr>
        <c:forEach items="${roleList}" var="ros" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${ros.name}</td>
                <td>${ros.sn}</td>
            </tr>
        </c:forEach>
    </table>


    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">可以访问的资源</span></h3>
        </div>
    </div>

    <table class="table table-bordered">
        <tr>
            <td>编号</td>
            <td>资源名称</td>
            <td>资源url</td>
            <td>资源权限字符串</td>
        </tr>
        <c:forEach items="${resList}" var="res" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${res.name}</td>
                <td>${res.url}</td>
                <td>${res.permission}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
