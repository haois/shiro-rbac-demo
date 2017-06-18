$(function(){
    $("#usAddBtn").click(function(){
       window.location.href =window.ctx + "/user/add";
    });
    $("#usListBtn").click(function(){
        window.location.href =window.ctx + "/user/list";
    });

    $("#roAddBtn").click(function(){
        window.location.href =window.ctx + "/role/add";
    });
    $("#roListBtn").click(function(){
        window.location.href =window.ctx + "/role/list";
    });

    $("#reAddBtn").click(function(){
        window.location.href =window.ctx + "/res/add";
    });
    $("#reListBtn").click(function(){
        window.location.href =window.ctx + "/res/list";
    });
    $("#logoutBtn").click(function(){
        window.location.href = window.ctx +"/login/logout";
    })
    $("#bbsIndex").click(function(){
        alert("该功能不存在");
    })

    $("#InfoBtn").click(function(){
        window.location.href = window.ctx +"/user/info";
    })
})