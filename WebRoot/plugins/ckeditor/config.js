/*
Copyright (c) 2003-2009, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	 // Define changes to default configuration here. For example:  
    // config.language = 'fr';  
    // config.uiColor = '#AADC6E';  
  
    //CKFinder.SetupCKEditor(null, '../ckfinder/'); //注意ckfinder的路径对应实际放置的位置  
    config.skin = 'kama'; // 皮肤  
    //config.uiColor = '#FFF'; // 皮肤背景颜色  
    //config.resize_enabled = false;   // 取消 “拖拽以改变尺寸”功能     
    config.language = 'zh-cn'; //配置语言   
    config.font_names = '宋体;楷体_GB2312;新宋体;黑体;隶书;幼圆;微软雅黑;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana'; // 字体  
    config.width = 1000; //宽度  
    config.height = 450; //高度  
    
  
    //config.toolbar = "Basic";  // 基础工具栏  
    config.toolbar = "Full";  // 全能工具栏   
    // 自定义工具栏    
    config.toolbar_Full =  
    [  
        ['Source', '-', 'Preview', '-', 'Templates'],  
        ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Print', 'SpellChecker', 'Scayt'],  
        ['Undo', 'Redo', '-', 'Find', 'Replace', '-', 'SelectAll', 'RemoveFormat'],  
        ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],  
        '/',  
        ['Bold', 'Italic', 'Underline', 'Strike', '-', 'Subscript', 'Superscript'],  
        ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', 'Blockquote', 'CreateDiv'],  
        ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],  
        ['Link', 'Unlink', 'Anchor'],  
          ['Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'],  
        '/',  
        ['Styles', 'Format', 'Font', 'FontSize'],  
        ['TextColor', 'BGColor'],  
        ['Maximize', 'ShowBlocks', '-', 'About']  
    ];  
  
    config.toolbar_Basic =  
    [  
        ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink', '-', 'About']  
    ];  
    
   /* config.disableObjectResizing = false;  //图片可拉伸性设置
*/    
    
	config.filebrowserBrowseURL='../../plugins/ckfinder/ckfinder.html',
	config.filebrowserImageBrowseUrl ='../../plugins/ckfinder/ckfinder.html?type=Images',
	config.filebrowserFlashBrowseUrl ='../../plugins/ckfinder/ckfinder.html?type=Flash',        
	config.filebrowserUploadUrl  ='../../plugins/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',       
	config.filebrowserImageUploadUrl  ='../../plugins/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',      
	config.filebrowserFlashUploadUrl  ='../../plugins/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash',
	
	config.filebrowserWindowWidth = '900';
	config.filebrowserWindowHeight = '700'
};
