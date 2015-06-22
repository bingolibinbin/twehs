/*!
 * 新闻管理
 */


Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var SupportsObj = [
		{ name:'contentid', type:'int'},
		{ name:'typeid', type:'int'},
		{ name:'typename', type:'string'},
		{ name:'title', type:'string'},
		{ name:'operatetime',type:'string'},
		{ name:'display',type:'string'},
		{ name:'content',type:'string'},
	];
	
	var supportsStore = new Ext.data.JsonStore({
	    url: 'supports_findPageSupports.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: SupportsObj
	});
	

	supportsStore.load({params:{start:0, limit:30}});
	
	var typeStore = new Ext.data.JsonStore({
			url: 'supports_findTypeType.do',
			root:'root',
			totalProperty: 'total',
			fields : ["value", "text"],
			 listeners:{
		    	load:function(s){
		    		var r = new typeStore.recordType({value:'',text:'所有分类'});
		    		typeStore.insert(0,r);
		    	}
		    }
		});
		
		typeStore.load();
		
		 
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
							width: 300,
							items:[{
								labelWidth:100,
								width:200,
								xtype:'textfield',
								name:'title',
								fieldLabel:'技术标题'
								}]
							}
						,{
							width:300,
							items:[{
								fieldLabel:'技术分类',
								labelWidth:100,
								width:200,
								xtype:'combo',
								hiddenName:'typeid',
								mode:'local',
								triggerAction:'all',
								valueField:'value',
								displayField:'text',
								editable:false,
								emptyText: '所有分类',
								store:typeStore
								}]
				       		
								
						},{
							width:100,
							items:[{
								width:75,
								xtype:"button",
								text:'查询',
								handler:function(){
								var f = searchForm.getForm();
								if(f.isValid()){
									//employeerStore.load({params:{start:0, limit:15}});
									supportsStore.load({params:{start:0,limit:30,title:f.findField("title").getValue(),
										typeid:f.findField("typeid").getValue()}});
										}
									}
								}]
												
							}
							]
					}
					       ]
						
				//查询form结束
				
					
						}]});
			
		 supportsStore.on("beforeload",function(thiz,options)
	{	
		thiz.baseParams["typeid"] = searchForm.getForm().findField("typeid").getValue(),
		thiz.baseParams["title"] = searchForm.getForm().findField("title").getValue()
		
	});
 
    var supportsGrid = new Ext.grid.GridPanel({
        id:"supportsGrid",
    	store: supportsStore,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),
			    {header: '标题', width: 150,align:'center', dataIndex: 'title'},    
	            {header: '分类', width: 150,align:'center', dataIndex: 'typename'},
	            {header: '日期', width: 150,align:'center', dataIndex: 'operatetime'},
	            {header: '显示/不显示', width: 150,align:'center',dataIndex: 'display'}
	            ]
	            
        }),
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'技术支持管理',
        iconCls:'menu-51',
        margins:'0',
        
		region:'center',
		
	
        
        tbar:[{
        	text:'增加',
        	iconCls:'btn-add',
        	handler:  function(){ 
		    	supportsWindow.show();
        		supportsForm.getForm().reset();
    		}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= newsGrid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的技术支持');
				}else{
					supportsWindow.show();
					supportsForm.getForm().loadRecord(record);
		    		}	
				}
        	
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){
        		var record= newsGrid.getSelectionModel().getSelected();
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要删除的技术支持');  
				}else{
					Ext.MessageBox.confirm('删除提示', '是否删除该技术支持？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "supports_deleteSupports.do",
					   			params:{ contentid : record.get("contentid") },
					   			success : function() {
					   				supportsStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        
        bbar: new Ext.PagingToolbar({
            pageSize:30,
            store: supportsStore,
            displayInfo: true
        })

    });
    
    var supportsForm = new Ext.form.FormPanel({
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
       {
       		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'title',
			fieldLabel:'技术支持标题'
       },
       
       {
          	labelWidth:120,
     		  id:'display',     
              xtype: 'radiogroup', 
              width:150,
              fieldLabel: '显示/不显示',     
              columns: 2,     
              items: [     
                  {boxLabel: '显示', name: 'display',inputValue:'1',checked:true},     
                  {boxLabel: '不显示', name: 'display',inputValue:'2' }
              ],
              
         },
        {
       		labelWidth:60,
			width:120,
			xtype:'combo',
			hiddenName:'typeid',
			fieldLabel:'技术支持分类',
			mode:'local',
			triggerAction:'all',
			valueField:'value',
			displayField:'text',
			editable:false,
			emptyText: '所有分类',
			store:typeStore
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
       ]
      },{
    	  xtype : 'hidden',
    	  name : 'operatetime'
      },{
    	  xtype : 'hidden',
    	  name : 'contentid'
      });
      
		var supportsWindow = new Ext.Window({
		id:'supportsWindow',
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
		items : [supportsForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (supportsForm.getForm().isValid()) {
					supportsForm.getForm().submit({
						url : 'supports_saveOrUpdateSupports.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							supportsWindow.hide();
							supportsStore.reload();
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
				supportsWindow.hide();
			}
		}]
	});

    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'技术支持管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,supportsGrid]
		}]
	});

});