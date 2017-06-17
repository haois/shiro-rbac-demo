$(function () {
     $("#subBtn").click(function () {
         edit();
     })
    function edit() {
        if (yanzheng()){
            document.getElementById("editFrom").submit();
        }
    }

    function yanzheng() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var nickname = document.getElementById("nickname").value;
        if ((username == null || username == "")) {
            alert('用户名不能为空');
            return false;
        }
        if ((password == null || password == "")) {
            alert('密码不能为空');
            return false;
        }
        if ((nickname == null || nickname == "")) {
            alert('真实姓名不能为空');
            return false;
        }
        return true;
    }
})