/*!
 * 评论管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var MessagesObj = [
			{ name:'messageid', type:'int'},
			{ name:'username', type:'string'},
			{ name:'phoneno', type:'string'},
			{ name:'address',type:'string'},
			{ name:'operatetime',type:'date'},
			{ name:'messagescontent', type:'string'}
		
		];
	

	var messagesStore = new Ext.data.JsonStore({
	    url: 'messages_findPageMessages.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: MessagesObj
	});
	

	messagesStore.load({params:{start:0, limit:30}});
	

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
							width:300,
							items:[{
								labelWidth:100,
								width:180,
								xtype:'textfield',
								name:'phoneno',
								fieldLabel:'电话'
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
								messagesStore.load({params:{start:0,limit:30,title:f.findField("phoneno").getValue()
									}});
							}
							}
							}
							]
					}
					       ]
						
				//查询form结束
				
					
						}]});
		 
			/*        newsStore.on("beforeload",function(thiz,options)
					{	
						
						thiz.baseParams["phoneno"] = searchForm.getForm().findField("phoneno").getValue()
						
					});*/
		 
		 
		 
		 
		 
		
		var sm = new Ext.grid.CheckboxSelectionModel();
		
		var messagesGrid = new Ext.grid.GridPanel({
        id:"messagesGrid",
    	store: messagesStore,
    	region:'center',
    	selModel:sm,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),sm,
			    {header: '姓名', width: 150,align:'center', dataIndex: 'username'},    
	            {header: '电话', width: 150,align:'center', dataIndex: 'phoneno'},
	            {header: '地址', width: 300,align:'center', dataIndex: 'address'},
	            {header: '日期', width: 300,align:'center', dataIndex: 'operatetime'},
	            {id:'messagescontent',header: '内容', width: 200,align:'center', dataIndex: 'messagescontent'}
	            ]
	            
        }),
        autoExpandColumn: 'messagescontent', //自动扩展列
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'留言管理',
        iconCls:'menu-51',
        margins:'0',
        
         tbar:[{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){

        		var records= commentsGrid.getSelectionModel().getSelections();
        		var selIds = null;
        		
				if(records.length==0){
                	Ext.Msg.alert('信息提示','请选择要删除的留言');  
				}else{
					for(var i = 0; i < records.length; i++){
						selIds += records[i].get("messageid");
	    				if(i < records.length-1) selIds += ",";
					}
					Ext.MessageBox.confirm('删除提示', '是否删除该留言？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "messages_deleteMessages.do",
					   			params:{ messageids : selIds },
					   			success : function() {
					   				messagesStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        bbar: new Ext.PagingToolbar({
            pageSize: 30,
            store: messagesStore,
            displayInfo: true
        })
		
		});
    
		messagesStore.on("beforeload",function(thiz,options)
				{	
					
					thiz.baseParams["phoneno"] = searchForm.getForm().findField("phoneno").getValue()
					
				});
	
    
    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'留言管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,messagesGrid]
		}]
	});

});