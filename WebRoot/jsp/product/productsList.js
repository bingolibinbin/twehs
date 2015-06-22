/*!
 * 产品管理
 */
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	
	var ProductsObj = [
		{ name:'contentid', type:'int'},
		{ name:'typeid', type:'int'},
		{ name:'typename', type:'String'},
		{ name:'title', type:'string'},
		{ name:'topline', type:'boolean'},
		{ name:'source', type:'String'},
		{ name:'recommender',type:'boolean'},
		{ name:'operatetime',type:'string'},
		{ name:'display',type:'boolean'},
		{ name:'smallpicaddress',type:'string'},
		{ name:'smallpicname',type:'string'},
	/*	{ name:'midpicaddress',type:'string'},
		{ name:'bigpicaddress',type:'string'},*/
		{ name:'specification',type:'string'},
		{ name:'price',type:'float'},
		{ name:'content',type:'string'},
		{ name:'order',type:'int'}
		
	];
	
	var productsStore = new Ext.data.JsonStore({
	    url: 'products_findPageProducts.do',
	    root: 'root',
	    totalProperty: 'total',
	    fields: ProductsObj
	});
	

	productsStore.load({params:{start:0, limit:30}});
	
	var typeStore = new Ext.data.JsonStore({
			url: 'products_findTypeType.do',
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
								fieldLabel:'产品名称'
								}]
							}
						,{
							width:300,
							items:[{
								fieldLabel:'产品分类',
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
									productsStore.load({params:{start:0,limit:30,title:f.findField("title").getValue(),
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
			
		 productsStore.on("beforeload",function(thiz,options)
	{	
		thiz.baseParams["typeid"] = searchForm.getForm().findField("typeid").getValue(),
		thiz.baseParams["title"] = searchForm.getForm().findField("title").getValue()
		
	});
 
    var productsGrid = new Ext.grid.GridPanel({
        id:"productsGrid",
    	store: productsStore,
        cm: new Ext.grid.ColumnModel({
			defaults: {	menuDisabled : true},//禁止表头菜单
			columns:[new Ext.grid.RowNumberer(),
			    {header: '标题', width: 150,align:'center', dataIndex: 'title'},    
	            {header: '分类', width: 150,align:'center', dataIndex: 'typename'},
	            {header: '日期', width: 150,align:'center', dataIndex: 'operatetime'},
	            {header: '头条', width: 150,align:'center', dataIndex: 'topline'},
	            {header: '推荐', width: 150,align:'center', dataIndex: 'recommender'},
	            {header: '显示/不显示', width: 150,align:'center',dataIndex: 'display'}
	            ]
	            
        }),
        stripeRows: true, 	//行分隔符
        columnLines : true, //列分隔符
		loadMask : true,	//加载时的遮罩
		frame : true,
        title:'产品管理',
        iconCls:'menu-51',
        margins:'0',
        
		region:'center',
		
	
        
        tbar:[{
        	text:'增加',
        	iconCls:'btn-add',
        	handler:  function(){ 
		    	productsWindow.show();
        		productsForm.getForm().reset();
    		}
        },'-',{
        	text:'修改',
        	iconCls:'btn-edit',
        	handler: function(){
        		var record= productsGrid.getSelectionModel().getSelected(); 
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要修改的新闻');
				}else{
					productsWindow.show();
					productsForm.getForm().loadRecord(record);
		    		}	
				}
        	
        },'-',{
        	text:'删除',
        	iconCls:'btn-remove',
        	handler: function(){
        		var record= productsGrid.getSelectionModel().getSelected();
				if(!record){
                	Ext.Msg.alert('信息提示','请选择要删除的新闻');  
				}else{
					Ext.MessageBox.confirm('删除提示', '是否删除该新闻？', function(c) {
					   if(c=='yes'){
					   		Ext.Ajax.request({
					   			url : "products_deleteProducts.do",
					   			params:{ contentid : record.get("contentid") },
					   			success : function() {
					   				productsStore.reload();
					   			}
					   		});
					    }
					});
				}
        	}
        }],
        
        bbar: new Ext.PagingToolbar({
            pageSize: 30,
            store: productsStore,
            displayInfo: true
        })

    });
    
    var productsForm = new Ext.form.FormPanel({
     	
    	layout:'form',
		baseCls:'x-plain',
		labelWidth:80,
		border:false,
		frame:true,
		padding : '15 10 0 8',

        items:[
{
		labelWidth:120,
	width:300,
	xtype:'textfield',
	name:'contentid',
	fieldLabel:'id'
},
               {
       		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'title',
			fieldLabel:'产品标题'
       },
       {
       	labelWidth:120,
  		  id:'topline',     
           xtype: 'radiogroup', 
           width:150,
           fieldLabel: '头条',     
           columns: 2,     
           items: [     
               {boxLabel: '是', name: 'topline',inputValue:'1',checked:true},     
               {boxLabel: '否', name: 'topline',inputValue:'2' }
           ],
           
      },
      {
        	  labelWidth:120,
   		  id:'recommender',     
            xtype: 'radiogroup', 
            width:150,
            fieldLabel: '推荐',     
            columns: 2,     
            items: [     
                {boxLabel: '是', name: 'recommender',inputValue:'1',checked:true},     
                {boxLabel: '否', name: 'recommender',inputValue:'2' }
            ],
            
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
			fieldLabel:'产品分类',
			mode:'local',
			triggerAction:'all',
			valueField:'value',
			displayField:'text',
			editable:false,
			emptyText: '所有分类',
			store:typeStore
       },
       
       
       
       
       {
    	   xtype:'compositefield',
    	   fieldLabel:'缩略图',
    	   items:[{
    		   		id:'smallpicaddress',
    		   		xtype:'textfield',
    		   		width:'300',
    		   		name:'smallpicaddress'
    		   
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
    	   xtype:'compositefield',
    	   fieldLabel:'中图',
    	   items:[{
    		   		id:'smallpicname',
    		   		xtype:'textfield',
    		   		width:'300',
    		   		name:'smallpicname'
    		   
    	   },{
    		   xtype:'button',
    		   text:'上传图片',
    		   handler: function(inputId){
				var finder = new CKFinder() ; 
				finder.basePath = '../../plugins/ckfinder/'; //导入CKFinder的路径 
				finder.selectActionFunction = SetFileFieldMid; //设置文件被选中时的函数 
				finder.selectActionData = inputId; //接收地址的input ID 
				finder.popup() ; 
     	 	}   
    	    } 
    	   ]
       },
       
       
       {
    	   xtype:'compositefield',
    	   fieldLabel:'大图',
    	   items:[{
    		   		id:'source',
    		   		xtype:'textfield',
    		   		width:'300',
    		   		name:'source'
    		   
    	   },{
    		   xtype:'button',
    		   text:'上传图片',
    		   handler: function(inputId){
				var finder = new CKFinder() ; 
				finder.basePath = '../../plugins/ckfinder/'; //导入CKFinder的路径 
				finder.selectActionFunction = SetFileFieldBig; //设置文件被选中时的函数 
				finder.selectActionData = inputId; //接收地址的input ID 
				finder.popup() ; 
     	 	}   
    	    }
    	   ]  
       },
       
     {
    		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'specification',
			fieldLabel:'产品规格'
    },
    {
   		labelWidth:120,
		width:50,
		xtype:'textfield',
		name:'price',
		fieldLabel:'产品价格'
   },
       {
       		labelWidth:120,
			width:20,
			xtype:'textfield',
			name:'order',
			fieldLabel:'产品排序'
       },
       {
            xtype : 'ckeditor',
			fieldLabel : '产品简介',
			name : 'content',
			CKConfig : {
				/* Enter your CKEditor config paramaters here or define a custom CKEditor config file. */
				customConfig : '../../plugins/ckeditor/config.js' // This allows you to define the path to a custom CKEditor config file.
			}
       },{
     	  xtype : 'hidden',
   	  name : 'operatetime'
     }
  ]
 });
    
    function SetFileField(fileUrl,data) 
	{ 
		document.getElementById('smallpicaddress').value = fileUrl ; 
	} 
    function SetFileFieldMid(fileUrl,data) 
	{ 
		document.getElementById('smallpicname').value = fileUrl ; 
	}
    function SetFileFieldBig(fileUrl,data) 
	{ 
		document.getElementById('source').value = fileUrl ; 
	}
    
      
		var productsWindow = new Ext.Window({
		title : '添加窗口',
		width:800,
		height:520,
		closeAction:'hide',
		modal : true,
		
		buttonAlign : 'center',
		autoScroll : 'auto',	
		constrain : 'true',
		items : [productsForm],
		buttons : [{
			text : '保存',
			handler : function() {
				/*alert(productsForm.getForm().isValid());*/
				if (productsForm.getForm().isValid()) {
					
					productsForm.getForm().submit({
						url : 'products_savebingoOrUpdateProducts.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
							productsWindow.hide();
							productsStore.reload();
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
			productsWindow.hide();
			}
		}]
	});
		
		

    new Ext.Viewport({
		layout:'fit',
		items:[{
			frame:true,
			title:'新闻管理',
			iconCls:'menu-11',
			layout:'border',
			items:[searchForm,productsGrid]
		}]
	});

});