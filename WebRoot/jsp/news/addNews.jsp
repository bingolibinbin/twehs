<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>TUWA-IE后台管理</title>
    <link rel="stylesheet" type="text/css" href="../../ext/resources/css/ext-all.css">
    <link rel="stylesheet" type="text/css" href="../../css/ext-icon.css">
    <script type="text/javascript" src="../../ext/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="../../ext/ext-all.js"></script>
    <script type="text/javascript" src="../../ext/ext-lang-zh_CN.js"></script>
    
    <script type="text/javascript" src="addNews.js"></script>
    <script type="text/javascript" src="../../plugins/ckeditor/ckeditor.js"></script>
     <script type="text/javascript" src="../../plugins/ckfinder/ckfinder.js"></script>
    <script type="text/javascript" src="../../ext/ux/ExtCkeditor.js"></script>
    
   <script type="text/javascript">
   		var record = Ext.util.Cookies.get("newsJson");
   		if(!record){
   				form.form.reset();
   			}else{
   				form.getForm().loadRecord(record);
   			}
   		//var obj = Ext.decode(record);
   </script>
  </head>
  <body>
  <div id="addNews"></div>
  </body>
</html>