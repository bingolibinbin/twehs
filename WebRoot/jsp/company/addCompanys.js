Ext.onReady(function() {
	
	Ext.QuickTips.init();
	
    var form = new Ext.form.FormPanel({
       title : "添加企业",
       autoWidth : true,
       minWidth:800,
       autoHeight : true,
       frame : true,
       renderTo:'addCompanys',
       layout : "form", // 整个大的表单是form布局
       labelWidth : 65,
       labelAlign : "right",
       border:true,
       items : [
       {xtype:'compositefield',
       	fieldLabel:'企业名称',
       	items:[
       		{
       		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'companyname',
			fieldLabel:'企业名称'
       		},{
       			xtype:'displayfield',
       			html:'<font color=red>※</font>'
       		}
       	]
       		
       },
        {
        	labelWidth:120,
			width:150,
			xtype:'textfield',
			name:'profession',
			fieldLabel:'行业'
       },
        {
       		labelWidth:120,
			width:150,
			xtype:'textfield',
			name:'area', 
			fieldLabel:'地区'
       },
       {
       		labelWidth:120,
			width:200,
			xtype:'textfield',
			name:'website',
			fieldLabel:'企业网站'
       },
       {
       		labelWidth:120,
			width:80,
			xtype:'textfield',
			name:'connector',
			fieldLabel:'联系人'
       },
       {
       		labelWidth:120,
			width:100,
			xtype:'textfield',
			name:'phoneno',
			fieldLabel:'电话'
       },
       {
       		labelWidth:120,
			width:100,
			xtype:'textfield',
			name:'mobileno',
			fieldLabel:'手机'
       },
       {
       		labelWidth:120,
			width:100,
			xtype:'textfield',
			name:'fax',
			fieldLabel:'传真'
       },
       {
       		labelWidth:120,
			width:80,
			xtype:'textfield',
			name:'postcode',
			fieldLabel:'邮编'
       },
         {
       		labelWidth:120,
			width:180,
			xtype:'textfield',
			name:'email',
			fieldLabel:'邮箱'
       },
       
       {
            xtype : 'ckeditor',
			fieldLabel : '企业简介',
			name : 'htmlcode',
			CKConfig : {
				/* Enter your CKEditor config paramaters here or define a custom CKEditor config file. */
				customConfig : '../../ckeditor/config.js' // This allows you to define the path to a custom CKEditor config file.
			}
            }
       ],
       buttonAlign : "center",
       buttons : [{
			text : '保存',
			handler : function() {
				if (form.getForm().isValid()) {
					form.getForm().submit({
						url : 'companys_saveOrUpdateCompanys.do',
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
      
     
   });