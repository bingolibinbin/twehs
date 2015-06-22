/*!
 * 企业管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	

	var CompanysObj = [
		{ name:'companyid', type:'int'},
		{ name:'companyname', type:'string'},
		{ name:'profession', type:'string'},
		{ name:'area', type:'string'},
		{ name:'website', type:'string'},
		{ name:'connector',type:'string'},
		{ name:'phoneno',type:'string'},
		{ name:'mobileno',type:'string'},
		{ name:'fax',type:'string'},
		{ name:'postcode',type:'string'},
		{ name:'email',type:'string'},
		{ name:'content',type:'string'}
	];
	
	var companysStore = new Ext.data.JsonStore({
		url:'companys_findPageCompanys.do',
	   	root: 'root',
	    totalProperty: 'total',
	    fields: CompanysObj
	});

	
	companysStore.load({params:{start:0, limit:30}});
	
	
	 
 
    var companysGrid = new Ext.grid.GridPanel({
        id:"companysGrid",
    	store: companysStore,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),
			    {header: '企业名称', width: 150,align:'center', dataIndex: 'companyname'},    
	            {header: '行业', width: 150,align:'center', dataIndex: 'profession'},
	            {header: '地区', width: 150,align:'center', dataIndex: 'area'},
	            {header: '联系人', width: 150,align:'center', dataIndex: 'connector'},
	            {header: '电话', width: 150,align:'center', dataIndex: 'phoneno'},
	            {header: '手机', width: 150,align:'center',dataIndex: 'mobileno'}
	           
	            ]
	            
        }),
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'企业管理',
        iconCls:'menu-51',
        margins:'0',
        
		region:'center',
		
	
        
        tbar:[{
        	text:'增加',
        	iconCls:'btn-add',
        	handler:  function(){ 
		    	companyWindow.show();
        		companyForm.getForm().reset();
    		}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= companysGrid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的企业');
				}else{
					companyWindow.show();
					companyForm.getForm().loadRecord(record);
		    		}	
				}
        	
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){
        		var record= companysGrid.getSelectionModel().getSelected();
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要删除的企业');  
				}else{
					Ext.MessageBox.confirm('删除提示', '是否删除该企业？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "companys_deleteCompanys.do",
					   			params:{ companyid : record.get("companyid") },
					   			success : function() {
					   				companysStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        
        bbar: new Ext.PagingToolbar({
            pageSize: 2000,
            store: companysStore,
            displayInfo: true
        })

    });

    var companyForm = new Ext.form.FormPanel({
        layout : 'form',
		baseCls:'x-plain',
		labelWidth:80,
		border : false, 
		padding : '15 10 0 8',
		defaults : {
		xtype : 'textfield',
		labelAlign:'right'
		},
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
            },{
          	  xtype:'hidden',
        	  name:'companyid'
          }
       ]
      });
      
      var companyWindow = new Ext.Window({
		title : '添加窗口',
		width:800,
		height:600,
		closeAction:'hide',
		modal : true,
		layout : 'fit',
		buttonAlign : 'center',
		autoScroll : 'true',
		resizable : 'false',
		constrain : 'true',
		items : [companyForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (companyForm.getForm().isValid()) {
					companyForm.getForm().submit({
						url : 'companys_saveOrUpdateCompany.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							companyWindow.hide();
							companysStore.reload();
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
			text : '取消',
			handler : function() {
				companyWindow.hide();
			}
		}]
	});
   
    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'企业管理',
			iconCls:'menu-11',
			layout:'border',
			items:[companysGrid]
		}]
	});

});