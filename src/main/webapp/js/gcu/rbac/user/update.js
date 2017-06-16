$(function(){
    $("#subBtn").click(function(){
        var roleList = new Array();
        $("input[name='rids']:checked").each(function () {
            roleList.push($(this).val());
        });
        var param = {id: $("[name=id]").val()};
        param["username"] = $("[name=username]").val();
        param["password"] = $("[name=password]").val();
        param["status"] = $("[name = status]").val();
        param["nickname"] = $("[name = nickname]").val();
        param["rolesitems"] = roleList.toString();
        $.ajax({
            type: "post",
            url: window.ctx + "/rest/user/update",
            contentType : "application/json",
            data: JSON.stringify(param),
            datatype: "json",
            success: function (data) {
                art.dialog.tips('修改信息成功!');
                setTimeout("location.reload()", 1000);//页面刷新
                setTimeout("location.reload()", 1000);//页面刷新
            },
            error: function (data) {
                art.dialog.tips('修改信息失败!');
            }
        });
    });
    $("#addBtn").click(function () {
        var validate = $("#addFrom").validate({
            debug: false,
            rules: {
                "username": {
                    required: true,
                    remote: {
                        url: window.ctx + "/rest/user/checkNameUnique",
                        type: "post",
                        data: {
                            username: function () {
                                return $("[name=username]").val();}
                        },
                        dataType: "json"
                    }
                },
                "password":{
                    required:true
                }
            },
            messages: {
                username: {
                    required: "用户名不能为空",
                    remote: "用户名已存在",
                },
                password:{
                    required:"密码不能为空",
                }
            },
            submitHandler: function () {

                var roleList = new Array();
                $("input[name='roles_name']:checked").each(function () {
                    roleList.push($(this).val());
                });
                var param = {id: $("[name=id]").val()};
                param["username"] = $("[name=username]").val();
                param["password"] = $("[name=password]").val();
                param["status"] = $("[name = status]").val();
                param["nickname"] = $("[name = nickname]").val();
                param["rolesitems"] = roleList.toString();
                $.ajax({
                    type: "post",
                    url: window.ctx + "/rest/user/update",
                    contentType : "application/json",
                    data: JSON.stringify(param),
                    datatype: "json",
                    success: function (data) {
                        art.dialog.tips('修改信息成功!');
                        setTimeout("location.reload()", 1000);//页面刷新
                    },
                    error: function (data) {
                        art.dialog.tips('修改信息失败!');
                    }
                });
            }
        });
    });
})