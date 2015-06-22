/*!
 * 评论管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var NotificationsObj = [
			{ name:'notificationid', type:'int'},
			{ name:'notification', type:'string'},
			{ name:'operatetime', type:'date'},
			{ name:'display', type:'boolean'}
			
		];
	

	var notificationsStore = new Ext.data.JsonStore({
	    url: 'notifications_findPageNotifications.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: NotificationsObj
	});
	

	notificationsStore.load({params:{start:0, limit:30}});
	

		 var searchForm = new Ext.FormPanel({
				id:"searchForm",
				region:'north',
				height: 50,
				border : false,
				layout : 'form',
				labelWidth:60,
				padding : '5 0 0 0',
				items:[{
					id:"fieldset",
					xtype:"fieldset",
					padding:'0 20 0 15',
					//查询form开始
					items:[{
						layout:"column",
						defaults:{
						xtype:"container",
						autoEl:"div",
						labelAlign:'right',
						layout:'form'
						},
						items:[{
							width:400,
							items:[{
								labelWidth:100,
								width:300,
								xtype:'textfield',
								name:'notification',
								fieldLabel:'公告内容'
							}]
						},{
							width:100,
							width:75,
							xtype:"button",
							text:'查询',
							handler:function(){
							var f = searchForm.getForm();
							if(f.isValid()){
								//employeerStore.load({params:{start:0, limit:15}});
								notificationsStore.load({params:{start:0,limit:30,title:f.findField("notification").getValue()
									}});
							}
							}
							}
							]
					}
					       ]
						
				//查询form结束
				
					
						}]});
		
		var sm = new Ext.grid.CheckboxSelectionModel();
		
		var notificationsGrid = new Ext.grid.GridPanel({
        id:"notificationsGrid",
    	store: notificationsStore,
    	selModel:sm,
    	region:'center',
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),sm,
	            {header: '日期', width: 150,align:'center', dataIndex: 'operatetime'},
	            {header: '显示/不显示', width: 150,align:'center', dataIndex: 'display'},
	            {id:'notification',header: '公告内容', width: 150,align:'center', dataIndex: 'notification'}
	            ]
	            
        }),
        autoExpandColumn: 'notification', //自动扩展列
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'公文管理',
        iconCls:'menu-51',
        margins:'0',
        
         tbar:['->',{
        	text:'增加',
        	iconCls:'btn-add',
        	handler: function(){
        		notificationWindow.show();
        		notificationForm.getForm().reset();
        	}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= notificationsGrid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的数据');
				}else{
	        		notificationWindow.show();
					notificationForm.getForm().loadRecord(record);
        	}
        }
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){

        		var records= notificationsGrid.getSelectionModel().getSelections();
        		var selIds = null;
        		
				if(records.length==0){
                	Ext.Msg.alert('信息提示','请选择要删除的公告');  
				}else{
					for(var i = 0; i < records.length; i++){
						selIds += records[i].get("notificationid");
	    				if(i < records.length-1) selIds += ",";
					}
					Ext.MessageBox.confirm('删除提示', '是否删除该公告？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "notifications_deleteNotifications.do",
					   			params:{ notificationids : selIds },
					   			success : function() {
					   				notificationsStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        bbar: new Ext.PagingToolbar({
            pageSize: 30,
            store: notificationsStore,
            displayInfo: true
        })
		
		});
    
    
	  var notificationForm = new Ext.FormPanel({
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
				xtype:'radiogroup',
				name:'display',
				fieldLabel:'显示/不显示',
				allowBlank : true,
				items:[
					{boxLabel:'显示',name:'display',inputValue:'1',checked:true},
					{boxLabel:'不显示',name:'display',inputValue:'2'}
				]
				
			},{
				name:'notification',
				fieldLabel:'通知内容',
				maxLength :20,
				allowBlank : false,
				xtype: 'textarea',
				height:200,
				width:150,
				value:'通知内容'
			},{
				name:'notificationid',
				xtype:'hidden'
			}
				]
	});
    
    var notificationWindow = new Ext.Window({
		title : '添加窗口',
		width:400,
		height:300,
		closeAction:'hide',
		modal : true,
		layout : 'fit',
		buttonAlign : 'center',
		items : [notificationForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (notificationForm.getForm().isValid()) {
					notificationForm.getForm().submit({
						url : 'notifications_saveOrUpdateNotifications.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							notificationWindow.hide();
							notificationsStore.reload();
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
				notificationWindow.hide();
			}
		}]
	});
    
    notificationsStore.on("beforeload",function(thiz,options)
			{	
				
				thiz.baseParams["notification"] = searchForm.getForm().findField("notification").getValue()
				
			});
    
    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'评论管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,notificationsGrid]
		}]
	});

});