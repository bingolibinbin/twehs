/*!
 * 产品管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var SolutionsObj = [
		{ name:'contentid', type:'int'},
		{ name:'typeid', type:'int'},
		{ name:'typename', type:'String'},
		{ name:'title', type:'string'},
		{ name:'operatetime',type:'date'},
		{ name:'display',type:'boolean'},
		{ name:'smallpicaddress',type:'string'},
		{ name:'smallpicname',type:'string'},
		{ name:'content',type:'string'},
	];
	
	var solutionsStore = new Ext.data.JsonStore({
	    url: 'solutions_findPageSolutions.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: SolutionsObj
	});
	

	solutionsStore.load({params:{start:0, limit:30}});
	
	var typeStore = new Ext.data.JsonStore({
			url: 'solutions_findTypeType.do',
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
								fieldLabel:'方案名称'
								}]
							}
						,{
							width:300,
							items:[{
								fieldLabel:'方案分类',
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
									solutionsStore.load({params:{start:0,limit:30,title:f.findField("title").getValue(),
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
			
		 solutionsStore.on("beforeload",function(thiz,options)
	{	
		thiz.baseParams["typeid"] = searchForm.getForm().findField("typeid").getValue(),
		thiz.baseParams["title"] = searchForm.getForm().findField("title").getValue()
		
	});
 
    var solutionsGrid = new Ext.grid.GridPanel({
        id:"solutionsGrid",
    	store: solutionsStore,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),
			    {header: '解决方案标题', width: 150,align:'center', dataIndex: 'title'},    
	            {header: '分类', width: 150,align:'center', dataIndex: 'typename'},
	            {header: '日期', width: 150,align:'center', dataIndex: 'operatetime'},
	            {header: '显示/不显示', width: 150,align:'center',dataIndex: 'display'}
	            ]
	            
        }),
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'解决方案管理',
        iconCls:'menu-51',
        margins:'0',
        
		region:'center',
		
	
        
        tbar:[{
        	text:'增加',
        	iconCls:'btn-add',
        	handler:  function(){ 
		    	solutionsWindow.show();
        		solutionsForm.getForm().reset();
    		}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= solutionsGrid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的解决方案');
				}else{
					solutionsWindow.show();
					solutionsForm.getForm().loadRecord(record);
		    		}	
				}
        	
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){
        		var record= solutionsGrid.getSelectionModel().getSelected();
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要删除的解决方案');  
				}else{
					Ext.MessageBox.confirm('删除提示', '是否删除该解决方案？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "solutions_deleteSolutions.do",
					   			params:{ contentid : record.get("contentid") },
					   			success : function() {
					   				solutionsStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        
        bbar: new Ext.PagingToolbar({
            pageSize: 30,
            store: solutionsStore,
            displayInfo: true
        })

    });
    
    var solutionsForm = new Ext.form.FormPanel({
     	
    	layout:'form',
		baseCls:'x-plain',
		labelWidth:80,
		border:false,
		frame:true,
		padding : '15 10 0 8',

        items:[{
       		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'title',
			fieldLabel:'解决方案标题'
       },
       
        {
       		labelWidth:60,
			width:120,
			xtype:'combo',
			hiddenName:'typename',
			fieldLabel:'解决方案分类',
			mode:'local',
			triggerAction:'all',
			valueField:'value',
			displayField:'text',
			editable:false,
			emptyText: '所有分类',
			store:typeStore
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
    	   xtype:'compositefield',
    	   fieldLabel:'缩略图',
    	   items:[{
    		   		id:'smallPicAddress',
    		   		xtype:'textfield',
    		   		width:'300',
    		   		name:'smallPicAddress'
    		   
    	   },{
    		   xtype:'button',
    		   text:'上传图片',
    		   handler: function(inputId){
				var finder = new CKFinder() ; 
				finder.basePath = '../../plugins/ckfinder/'; //导入CKFinder的路径 
				finder.selectActionFunction = SetFileField; //设置文件被选中时的函数 
				finder.selectActionData = inputId; //接收地址的input ID 
				finder.popup() ; 
     	 	}
    		   
    	   }
    	   ]
    	   
       },

      {
     		labelWidth:120,
     		id:'smallpicname',
			width:80,
			xtype:'textfield',
			name:'smallpicname',
			fieldLabel:'图片名称',
			readOnly:true,
			listeners:{
    	  		'focus':function(){
    	  				var picpath = Ext.getCmp('smallPicAddress').getValue();
    	  				var picname = picpath.substr(picpath.lastIndexOf('/')+1);
    	  				Ext.getCmp('smallpicname').setValue(picname);
      			}
    	  
      }
			
     },
    
      
       {
            xtype : 'ckeditor',
			fieldLabel : '解决方案简介',
			name : 'content',
			CKConfig : {
				/* Enter your CKEditor config paramaters here or define a custom CKEditor config file. 

*/
				customConfig : '../../plugins/ckeditor/config.js' // This allows you to define the path to a custom CKEditor config file.
			}
            }
       ]
      });
    
    function SetFileField(fileUrl,data) 
	{ 
		document.getElementById('smallPicAddress').value = fileUrl ; 
	} 
      
		var solutionsWindow = new Ext.Window({
		title : '添加窗口',
		width:800,
		height:520,
		closeAction:'hide',
		modal : true,
		
		buttonAlign : 'center',
		autoScroll : 'auto',	
		constrain : 'true',
		items : [solutionsForm],
		buttons : [{
			text : '保存',
			handler : function() {
				if (solutionsForm.getForm().isValid()) {
					solutionsForm.getForm().submit({
						url : 'solutions_saveOrUpdateSolutions.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							solutionsWindow.hide();
							solutionsStore.reload();
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
			solutionsWindow.hide();
			}
		}]
	});
		
		

    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'解决方案管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,solutionsGrid]
		}]
	});

});