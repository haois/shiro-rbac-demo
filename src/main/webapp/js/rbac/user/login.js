$(function () {
    $("#subBtn").click(function () {
        var inputName = $("input[name=username]").val();
        var inputPwd = $("input[name=password]").val();
        var checkName = /^[a-zA-Z]{1}([a-zA-Z0-9]| [._]){1,10}/;
        if (!checkName.exec(inputName)) {
            alert("用户名以字母开头!");
            return false;
        }
        else if (inputPwd == null || inputPwd == "") {
            alert("密码不能为空!");
            return false;
        } else {
            $("#form").submit();
        }
    });
})
