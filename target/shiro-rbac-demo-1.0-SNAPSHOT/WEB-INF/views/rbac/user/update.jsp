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
    <title>user/update</title>
</head>
<body>
<%@ include file="/common/top.jsp" %>
<div class="container">
    <div class="row" style="margin-bottom: 10px;">
        <div class="col-md-12" style="text-align: center">
            <h3><span class="label label-warning">更新用户</span></h3>

        </div>
    </div>
    <form id="editFrom" action="${ctx}/user/update" method="post">
        <input type="hidden" value="${user.id}" name="id"/>
        <div class="container" style="width: 500px">
            <div class="form-group" style="margin-top: 50px">
                <div class="input-group">
                    <div class="input-group-addon">用户名</div>
                    <input class="form-control"  name="username" id="username" value="${user.username}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">用户密码</div>
                    <input class="form-control" placeholder="password" type="password"
                           name="password" id="password" value="${user.password}"disabled/>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon">真实姓名</div>
                    <input class="form-control" placeholder="nickname" name="nickname" id="nickname" value="${user.nickname}">
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
                <c:forEach var="hr" items="${my_roles}">
                    <input type="hidden" class="hasRole" name="hasRole" value="${hr}"/>
                </c:forEach>

                <c:forEach items="${roleList}" var="roles">
                    <span class="label label-success" style="margin-left:5px">
                        ${roles.name} <input type="checkbox" name="rolesitems" value="${roles.id}" class="rids">
                    </span>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="input-group" style="margin: auto">
                    <button class="btn btn-success" type="button"  id="subBtn">提交</button>
                </div>
            </div>
        </div>
    </form>

</div>
</body>
<script type="text/javascript" src="${ctx}/js/rbac/user/edit.js"></script>
<script type="text/javascript">
    $(function(){
        var hasRoles = new Array();
        $(".hasRole").each(function(){
            hasRoles.push($(this).val());
        });
        $(".rids").each(function(){
            if($.inArray($(this).val(),hasRoles)>=0) {
                $(this).attr("checked","checked");
            }
        });
    });
</script>
</html>
