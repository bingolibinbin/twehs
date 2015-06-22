/*!
 * 用户管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var TypeObj = [
		{ name:'typeid', type:'int'},
		{ name:'menuid', type:'int'},
		{ name:'menuname', type:'string'},
		{ name:'typename', type:'String'},
		{ name:'bz',type:'string'}
	];
	
	var store = new Ext.data.JsonStore({
	    url: 'type_findPageTtype.do',
	    root: 'root',
	    totalProperty: 'total',
	    autoLoad: {params:{start:0, limit:15}},
	    fields: TypeObj
	});
	store.load({params:{start:0, limit:30}});

	
	var menuStore = new Ext.data.JsonStore({
		url: 'menu_findMenuType.do',
			root:'root',
			totalProperty: 'total',
			fields : ["value", "text"],
		 	listeners:{
    		load:function(s){
	    		var r = new menuStore.recordType({value:'',text:'所有栏目'});
	    		menuStore.insert(0,r);
		    	}
		    }
	}
	);
	
	menuStore.load();
	
	
    var grid = new Ext.grid.GridPanel({
        store: store,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),   
	            {header: '所属栏目', width: 150,align:'center', dataIndex: 'menuname'},
	            {header: '分类名称', width: 150, align:'center',dataIndex: 'typename'},
	            {id: 'typebz', header: '备注', width: 150, align:'center',dataIndex: 'bz'}
	            ]
        }),
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
		title:'分类管理',
		autoExpandColumn: 'typebz',
        iconCls:'menu-62',
        
        tbar:['->',{
        	text:'增加',
        	iconCls:'btn-add',
        	handler: function(){
        		typeWindow.show();
        		typeForm.getForm().reset();
        	}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= grid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的数据');
				}else{
	        		typeWindow.show();
					typeForm.getForm().loadRecord(record);
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
					   			url :"../type_deleteTtype.do",
					   			params:{ typeid : record.get("typeid") },
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
    
  
	
	

    var typeForm = new Ext.FormPanel({
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
					xtype:'combo',
					hiddenName:'menuid',
					fieldLabel:'栏目',
					mode: 'local',
					triggerAction: 'all',
					valueField :'value',
					displayField: 'text',
					emptyText: '请选择',
					allowBlank : false,
					editable : false,
					store : menuStore
			},{
				name:'typename',
				fieldLabel:'分类名称',
				maxLength :10,
				allowBlank : false
			},{
				name:'bz',
				fieldLabel:'备注',
				maxLength :250,
				width:200,
				allowBlank : true
			},{
				name:'typeid',
				xtype:'hidden'
			}
				]
	});
    
    var typeWindow = new Ext.Window({
		title : '添加窗口',
		width:400,
		height:300,
		closeAction:'hide',
		modal : true,
		layout : 'fit',
		buttonAlign : 'center',
		items : [typeForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (typeForm.getForm().isValid()) {
					typeForm.getForm().submit({
						url : 'type_saveOrUpdateTtype.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							typeWindow.hide();
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
				typeWindow.hide();
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