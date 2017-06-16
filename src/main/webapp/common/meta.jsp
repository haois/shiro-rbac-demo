<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<title>用户权限管理V0.1</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>

<link type="text/css" rel="stylesheet" href="${ctx}/css/bootstrap.css" charset="utf-8"/>
<link type="text/css" rel="stylesheet" href="${ctx}/css/style.css" charset="UTF-8"/>
<link type="text/css" rel="stylesheet" href="${ctx}/css/hgits.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/js/lib/artDialog/skins/blue.css">

<script type="text/javascript" src="${ctx}/js/lib/underscore-1.5.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/backbone-1.0.0.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/lib/json2.js"></script>



<script type="text/javascript" src="${ctx}/js/lib/bootstrap.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload.js"></script>

<script type="text/javascript" src="${ctx}/js/lib/artDialog/jquery.artDialog.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/artDialog/iframeTools.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/artDialog/dialog.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/moment.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
    //系统全局上下文
    window.ctx = '${ctx}';
    //backbone模版文件解析, 防止和jsp的关键符号冲突
    _.templateSettings = {
        interpolate : /\<\@\=(.+?)\@\>/gim,
        evaluate : /\<\@([\s\S]+?)\@\>/gim,
        escape : /\<\@\-(.+?)\@\>/gim
    };
    //清空ajax缓存
    $.ajaxSetup({
        cache : false
    });
</script>