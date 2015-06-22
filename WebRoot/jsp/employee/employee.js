/*!
 * 评论管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var EmployeeObj = [
			{ name:'employeeid', type:'int'},
			{ name:'title'},
			{ name:'content', type:'string'},
			{ name:'operatetime', type:'date'},
			{ name:'display', type:'boolean'}
			
		];
	

	var employeeStore = new Ext.data.JsonStore({
	    url: 'employee_findPageEmployee.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: EmployeeObj
	});
	

	employeeStore.load({params:{start:0, limit:30}});
	

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
								name:'title',
								fieldLabel:'招聘标题'
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
								employeeStore.load({params:{start:0,limit:30,title:f.findField("title").getValue()
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
		
		var employeeGrid = new Ext.grid.GridPanel({
        id:"employeeGrid",
    	store: employeeStore,
    	selModel: sm,
    	region:'center',
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),sm,
			    {header: '招聘标题', width: 150,align:'center', dataIndex: 'title'},    
	            {header: '日期', width: 150,align:'center', dataIndex: 'operatetime'},
	            {header: '显示/不显示', width: 150,align:'center', dataIndex: 'display'}
	            ]
	            
        }),
       
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
        		employeeWindow.show();
        		employeeForm.getForm().reset();
        	}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= employeeGrid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的数据');
				}else{
					employeeWindow.show();
					employeeForm.getForm().loadRecord(record);
        	}
        }
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){

        		var records= employeeGrid.getSelectionModel().getSelections();
        		var selIds = null;
        		
				if(records.length==0){
                	Ext.Msg.alert('信息提示','请选择要删除的公告');  
				}else{
					for(var i = 0; i < records.length; i++){
						selIds += records[i].get("employeeid");
	    				if(i < records.length-1) selIds += ",";
					}
					Ext.MessageBox.confirm('删除提示', '是否删除该公告？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "employee_deleteEmployee.do",
					   			//params:{ contentid : record.get("contentid") },
					   			params:{ employeeids : selIds },
					   			success : function() {
					   				employeeStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        bbar: new Ext.PagingToolbar({
            pageSize: 30,
            store: employeeStore,
            displayInfo: true
        })
		
		});
    
    
	  var employeeForm = new Ext.FormPanel({
		layout : 'form',
		baseCls:'x-plain',
		labelWidth:80,
		border : false,
		padding : '15 10 0 8',
		defaults : {
			width:100,
			xtype : 'textfield'
		},
		items:[  {
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
				labelWidth:100,
				width:200,
				xtype:'textfield',
				name:'title',
				fieldLabel:'招聘标题'
				
			},
			{
				xtype : 'ckeditor',
				fieldLabel : '招聘内容',
				name : 'content',
				CKConfig : {
					/* Enter your CKEditor config paramaters here or define a custom CKEditor config file. */
					customConfig : '../../plugins/ckeditor/config.js' // This allows you to define the path to a custom CKEditor config file.
				}
			},{
				name:'employeeid',
				xtype:'hidden'
			}
				]
	});
    
    var employeeWindow = new Ext.Window({
		title : '添加窗口',
		width:600,
		height:400,
		closeAction:'hide',
		modal : true,
		layout : 'fit',
		buttonAlign : 'center',
		items : [employeeForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (employeeForm.getForm().isValid()) {
					employeeForm.getForm().submit({
						url : 'employee_saveOrUpdateEmployee.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							employeeWindow.hide();
							employeeStore.reload();
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
				employeeWindow.hide();
			}
		}]
	});
    
    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'评论管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,employeeGrid]
		}]
	});

});