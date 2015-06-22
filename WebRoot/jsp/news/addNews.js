Ext.onReady(function() {
	
	Ext.QuickTips.init();
	
	var ttypeStore = new Ext.data.JsonStore({
			url: 'news_findTypeType.do',
			root:'root',
			totalProperty: 'total',
			fields : ["value", "text"],
			 listeners:{
		    	load:function(s){
		    		var r = new ttypeStore.recordType({value:'',text:'所有分类'});
		    		ttypeStore.insert(0,r);
		    	}
		    }
		});
		
		ttypeStore.load();
		
	
    var form = new Ext.form.FormPanel({
       title : "新闻管理",
       autoWidth : true,
       minWidth:800,
       autoHeight : true,
       frame : true,
       renderTo:'addNews',
       layout : "form", // 整个大的表单是form布局
       labelWidth : 65,
       labelAlign : "right",
       border:true,
       items : [
       {
       		labelWidth:120,
			width:300,
			xtype:'textfield',
			name:'title',
			fieldLabel:'新闻标题'
       },
       {
       	labelWidth:120,
  		  id:'topline',     
           xtype: 'radiogroup', 
           width:150,
           fieldLabel: '头条',     
           columns: 2,     
           items: [     
               {boxLabel: '是', name: 'topline',inputValue:'1'},     
               {boxLabel: '否', name: 'topline',inputValue:'2',checked:true }
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
                {boxLabel: '是', name: 'recommender',inputValue:'1',},     
                {boxLabel: '否', name: 'recommender',inputValue:'2',checked:true }
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
			hiddenName:'typename',
			fieldLabel:'新闻分类',
			mode:'local',
			triggerAction:'all',
			valueField:'value',
			displayField:'text',
			editable:false,
			emptyText: '所有分类',
			store:ttypeStore
       },
        {
       		labelWidth:120,
			width:150,
			xtype:'textfield',
			name:'source', 
			fieldLabel:'新闻来源'
       },
       {
       		labelWidth:120,
			width:80,
			xtype:'textfield',
			name:'author',
			fieldLabel:'新闻作者'
       },
       {
       		labelWidth:120,
			width:80,
			xtype:'textfield',
			name:'order',
			fieldLabel:'文章排序'
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
       ],
       buttonAlign : "center",
       buttons : [{
			text : '保存',
			handler : function() {
				if (form.getForm().isValid()) {
					form.getForm().submit({
						url : 'news_saveOrUpdateNews.do',
						success : function(form, action) {
							Ext.Msg.alert('信息提示',action.result.message);
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
			text : '重置',
			handler : function() {
				form.form.reset();
			}
		}]
      });
      
     
   });