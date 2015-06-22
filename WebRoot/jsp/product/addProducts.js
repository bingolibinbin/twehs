Ext.onReady(function() {
	
	Ext.QuickTips.init();
	
	var catigoryStore = new Ext.data.JsonStore({
			fields:["value","text"],
			totalProperty: 'total',
			data:[{value:'1',text:'公司动态'},{value:'2',text:'媒体聚焦'},{value:'3',text:'行业新闻'}]
	});
	
	

    var form = new Ext.form.FormPanel({
       title : "添加新闻",
       autoWidth : true,
       minWidth:800,
       autoHeight : true,
       frame : true,
       renderTo:'addProducts',
       layout : "form", // 整个大的表单是form布局
       labelWidth : 65,
       labelAlign : "right",
       border:true,
       items : [
       {
       		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'title',
			fieldLabel:'新闻标题'
       },{
       		layout : "column",
          items : [{
             
             layout : "form",
             items : [{
		                labelWidth:120,
			       	 	id:'smallPicPath',
						width:400,
						xtype:'textfield',
						name:'smallPicPath',
						fieldLabel:'缩略图'
               }]
            }, {
             
             layout : "form",
             items : [{
               xtype:'button',
       	 	text:'上传到服务器',
       	 	handler: function(inputId){
				var finder = new CKFinder() ; 
				finder.basePath = '../../plugins/ckfinder/'; //导入CKFinder的路径 
				finder.selectActionFunction = SetFileField; //设置文件被选中时的函数 
				finder.selectActionData = inputId; //接收地址的input ID 
				finder.popup() ; 
       	 	}
               }]
            }]
			
       	 	
       },
        {
        	labelWidth:120,
   		    id:'attrCheckbox',     
            xtype: 'checkboxgroup', 
            width:100,
            fieldLabel: '新闻属性',     
            columns: 2,     
            items: [     
                {boxLabel: '头条', name: '1'},     
                {boxLabel: '推荐', name: '2'}
            ]     
       },
       
        {
       		labelWidth:60,
			width:120,
			xtype:'combo',
			hiddenName:'catigory',
			fieldLabel:'新闻分类',
			mode:'local',
			triggerAction:'all',
			valueField:'value',
			displayField:'text',
			editable:false,
			emptyText: '所有栏目',
			store:catigoryStore
       },
        {
       		labelWidth:120,
			width:150,
			xtype:'textfield',
			name:'source', 
			fieldLabel:'新闻来源'
       },
       {
       		labelWidth:120,
			width:80,
			xtype:'textfield',
			name:'author',
			fieldLabel:'新闻作者'
       },
       {
       		labelWidth:120,
			width:80,
			xtype:'textfield',
			name:'order',
			fieldLabel:'文章排序'
       },
       {
            xtype : 'ckeditor',
			fieldLabel : '新闻内容',
			name : 'content',
			CKConfig : {
				/* Enter your CKEditor config paramaters here or define a custom CKEditor config file. */
				customConfig : '../../plugins/ckeditor/config.js' // This allows you to define the path to a custom CKEditor config file.
			}
            }
       ],
       buttonAlign : "center",
       buttons : [{
			text : '保存',
			handler : function() {
				if (form.getForm().isValid()) {
					form.getForm().submit({
						url : 'products_saveOrUpdateNews.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							store.reload();
						},
						failure : function(form, action) {
							if(action.result.errors){
								Ext.Msg.alert('信息提示',action.result.errors);
							}else{
								Ext.Msg.alert('信息提示','连接失败');
							}
						},
						waitTitle : '提交',
						waitMsg : '正在保存数据，稍后...'
					});
				}
			}
		}, {
			text : '重置',
			handler : function() {
				form.form.reset();
			}
		}]
      });
      

		//文件选中时执行 
	function SetFileField(fileUrl,data) 
	{ 
		document.getElementById('smallPicPath').value = fileUrl ; 
	} 
   });