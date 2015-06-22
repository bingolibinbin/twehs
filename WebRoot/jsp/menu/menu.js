/*!
 * 用户管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var MenuObj = [
		{ name:'menuid', type:'int'},
		{ name:'menuname', type:'string'},
		{ name:'pid', type:'int'},
		{ name:'menuurl', type:'string'},
		{ name:'menutype', type:'int'},
		{ name:'ordernum', type:'int'},
		{ name:'icon', type:'string'}
	];
	
	var store = new Ext.data.JsonStore({
	    url: 'menu_findPageMenu.do',
	    root: 'root',
	    totalProperty: 'total',
	    autoLoad: {params:{start:0, limit:15}},
	    fields: MenuObj
	});
	
    var grid = new Ext.grid.GridPanel({
        store: store,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),
	            {header: '栏目编号', width: 150,align:'center', dataIndex: 'menuid'},
	            {header: '栏目名称', width: 150,align:'center', dataIndex: 'menuname'},
	            {header: '父节点编号', width: 150, align:'center',dataIndex: 'pid'},
	            {header: '子节点地址', width: 150, align:'center',dataIndex: 'menuurl'},
	            {header: '节点类型', width: 150, align:'center',dataIndex: 'menutype'},
	            {header: '节点排序', width: 150, align:'center',dataIndex: 'ordernum'},   
	            {header: '节点图标', width: 150, align:'center',dataIndex: 'icon'}
	            ]
        }),
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
		title:'栏目管理',
        iconCls:'menu-62',
        
        tbar:['->',{
        	text:'增加',
        	iconCls:'btn-add',
        	handler: function(){
        		menuWindow.show();
        		menuForm.getForm().reset();
        	}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= grid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的数据');
				}else{
					menuWindow.show();
					menuForm.getForm().loadRecord(record);
        	}
        }
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){
        		var record= grid.getSelectionModel().getSelected();
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要删除的数据');  
				}else{
					Ext.MessageBox.confirm('删除提示', '是否删除该栏目？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "../menu_deleteMenu.do",
					   			params:{ menuid : record.get("menuid") },
					   			success : function(response) {
					   			    var Result=Ext.decode(response.responseText);
					   			    if(!Result.success){
					   			    	Ext.Msg.alert("信息提示",Result.error);
					   			    	return;
					   			    }
					   				store.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        
        bbar: new Ext.PagingToolbar({
            pageSize: 15,
            store: store,
            displayInfo: true
        })
    });
    
  
	
	

    var menuForm = new Ext.FormPanel({
		layout : 'form',
		baseCls:'x-plain',
		labelWidth:80,
		border : false,
		padding : '15 10 0 8',
		defaults : {
			width:100,
			xtype : 'textfield'
		},
		items:[{
				name:'menuid',
				fieldLabel:'栏目编号',
				maxLength :10,
				allowBlank : false
			},{
				name:'menuname',
				fieldLabel:'栏目名称',
				maxLength :20,
				allowBlank : false
			},{
				name:'pid',
				fieldLabel:'父节点编号',
				maxLength :10,
				allowBlank : false
			},{
				name:'menuurl',
				fieldLabel:'子节点地址',
				maxLength :250,
				width:200,
				allowBlank : false
			},{
				name:'menutype',
				fieldLabel:'节点类型',
				maxLength :10,
				allowBlank : false
			},{
				name:'menuurl',
				fieldLabel:'节点排序',
				maxLength :10,
				allowBlank : false
			},{
				name:'menuurl',
				fieldLabel:'节点图标',
				maxLength :20,
				allowBlank : false
			}
				]
	});
    
    var menuWindow = new Ext.Window({
		title : '添加窗口',
		width:400,
		height:300,
		closeAction:'hide',
		modal : true,
		layout : 'fit',
		buttonAlign : 'center',
		items : [menuForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (menuForm.getForm().isValid()) {
					menuForm.getForm().submit({
						url : 'menu_saveOrUpdateMenu.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							menuWindow.hide();
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
			text : '取消',
			handler : function() {
				menuWindow.hide();
			}
		}]
	});
    
    new Ext.Viewport({
		layout:'border',
		items:[{
			region:'center',
			layout:'fit',
			border:false,
			items:grid
		}]
	});

});