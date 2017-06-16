$(function(){
    var hasReses = new Array();
    $(".hasRes").each(function(){
        hasReses.push($(this).val());
    });
    $(".setPermission").each(function(){
        if($.inArray($(this).val(),hasReses)>=0) {
            $(this).attr("checked","checked");
        }
    });
    $(".setPermission").click(function(){
        var aOrd = 0;
        if(this.checked) {
            aOrd = 1;
        }
        var resId = $(this).val();
        var roleId = $("#roleId").val();
        $.post(
            window.ctx + "/rest/role/res/update",
            {aOrd:aOrd,resId:resId,roleId:roleId},
            function(data){
        });
    });
});