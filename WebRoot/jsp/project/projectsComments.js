/*!
 * 评论管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var CommentsObj = [
			{ name:'commentid', type:'int'},
			{ name:'contentid', type:'int'},
			{ name:'title', type:'string'},
			{ name:'commentor',type:'string'},
			{ name:'commentscontent', type:'string'},
			{ name:'display',type:'boolean'},
			{ name:'check',type:'boolean'},
			{ name:'operatetime',type:'date'}
		];
	

	var commentsStore = new Ext.data.JsonStore({
	    url: 'comments_findPageComments.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: CommentsObj
	});
	

	commentsStore.load({params:{start:0, limit:30}});
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
								name:'title',
								fieldLabel:'工程评论'
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
								commentsStore.load({params:{start:0,limit:30,title:f.findField("title").getValue()
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
		
		var commentsGrid = new Ext.grid.GridPanel({
        id:"commentsGrid",
    	store: commentsStore,
    	selModel:sm,
    	region:'center',
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),sm,
			    {header: '新闻标题', width: 150,align:'center', dataIndex: 'title'},    
	            {header: '评论人', width: 150,align:'center', dataIndex: 'commentor'},
	            {header: '日期', width: 150,align:'center', dataIndex: 'operatetime'},
	            {header: '审核/未审核', width: 150,align:'center', dataIndex: 'check'},
	            {id:'commentscontent',header: '内容', width: 200,align:'center', dataIndex: 'commentscontent'}
	            ]
	            
        }),
        autoExpandColumn: 'commentscontent', //自动扩展列
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'评论管理',
        iconCls:'menu-51',
        margins:'0',
        
         tbar:[{
        	text:'批量审核',
        	iconCls:'btn-edit',
        	handler: function(){
        		
        		var records= commentsGrid.getSelectionModel().getSelections();
        		var selIds = null;
        		if(records.length==0){
        			Ext.MessageBox.alert('信息提示','请选择要审核的评论');
        		}else{
        			for(var i = 0; i < records.length; i++){
						selIds += records[i].get("commentid");
	    				if(i < records.length-1) selIds += ",";
	    				
					}
        			Ext.MessageBox.confirm('审核提示', '是否审核该新闻评论？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "comments_checkComments.do",
					   			params:{ commentids : selIds },
					   			success : function() {
					   				commentsStore.reload();
					   			}
					   		});
					    }
					});
        		}
        		
				
        	}
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){

        		var records= commentsGrid.getSelectionModel().getSelections();
        		var selIds = null;
        		
				if(records.length==0){
                	Ext.Msg.alert('信息提示','请选择要删除的评论');  
				}else{
					for(var i = 0; i < records.length; i++){
						selIds += records[i].get("commentid");
	    				if(i < records.length-1) selIds += ",";
					}
					Ext.MessageBox.confirm('删除提示', '是否删除该评论？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "comments_deleteComments.do",
					   			params:{ commentids : selIds },
					   			success : function() {
					   				commentsStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        bbar: new Ext.PagingToolbar({
            pageSize: 30,
            store: commentsStore,
            displayInfo: true
        })
		
		});
    
    
	
    
    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'评论管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,commentsGrid]
		}]
	});

});