(function($){
	//服务器报错时, 进行任何提示
	$.fn.dataTable.ext.errMode = "none";
	$.fn.extend({
		"buildDataTable" : function (option){
			option = option || {};
			var $this = $(this);
        	var columns = option.columns;
        	if(columns) {
        		var titles = $.map(columns, function(column, index){
        			return column.title || column.sTitle || "";
        		});
        		if(titles && titles.length > 0) {
        			var thead = $this.children("thead");
            		if(thead.length == 0) {
            			var $thead = $("<thead></thead>");
            			var $tr = $("<tr></tr>");
            			$.each(titles, function(index, title){
            				var $th = $("<th></th>");
            				$th.text(title);
            				$th.appendTo($tr);
            			});
            			$tr.appendTo($thead);
            			$thead.appendTo($this);
            		}
        		}
        	}
        	option.buttons = option.buttons || [];
        	//是否绘画显示、隐藏列按钮
        	if(option.colvis) {
        		option.buttons.push({
                    extend: 'colvis',
                    text : '<li class="fa fa-navicon"></li>',
                    className : '',
                    postfixButtons: [ { extend: 'colvisRestore', text: '重置' } ]
                });
        	}
        	//默认的ajax请求
        	var _defaultAjax = {
					"ajax": {
						"beforeSend" : function() {
						},
						"url" 		 : option.url,							//数据请求地址
						"data"		 : function(data) {						//参数data 为请求参数,一个json对象
							//分页以及排序参数整理
							data.offset = data.start;
							data.pageSize = data.length;
							data.search	= data.search.value;				//在data中添加属性searchStr 值为 搜索框中的值
							if (data.order.length > 0) {					//如果设置了排序
								var target = data.columns[data.order[0].column];
								data.sortColumn  = target.name || target.data;	//在data中添加属性sortColumn 值为 点击某一列对应的值
								data.sortSequence  = data.order[0].dir;			//在data中添加属性sortSequence 值为 点击某一列的排列顺序
								if(data.sortSequence) {
									//asc desc 转大写
									data.sortSequence = data.sortSequence.toUpperCase();
								}
							}
							//防止提交过多内容到后台
							data.columns = undefined;
							data.order = undefined;
							data.start = undefined;
							data.length = undefined;
							//加载自定义参数
							if(option.ajaxData){
                        		option.ajaxData(data);
                        	}
						},
						"dataFilter" : function(data, type) {
							if(typeof data === 'string' && "json" === type.toLowerCase()) {
								//处理空字符串
								if (data.length === 0) {
									return null;
								}
								//处理session超时用户ajax请求
								if(data.indexOf("DOCTYPE html") > 0) {
									window.location.href="..";
									return null;
								}
							}
							return data;
						},
						"dataSrc" : function(json) {
							//后台返回分页参数 data 或者 content
							//这里没有使用aaData属性
							if(!json.data) {
								json.data = json.content;
							}
							return json.data;
						}
					}
			};
        	
        	//使用自定义的ajax进行服务器请求
        	option.ajax = _defaultAjax.ajax;
        	
        	//使用默认的配置,在option中加入对应属性进行替换
        	var _defaultSettings = {
        			"responsive"     : false,
        			"autoWidth"		 : true,						//控制Datatables是否自适应宽度
        			"lengthChange" 	 : true, 						//是否允许用户改变表格每页显示的记录数()
        			"ordering" 		 : true,						//是否允许Datatables开启排序()
        			"serverSide" 	 : true,						//是否开启服务器模式()
        			"destroy" 		 : true,						//销毁所有符合选择的table，并且用新的options重新创建表格
        			"displayStart"   : 0,							//初始化显示的时候从第几条数据开始显示(一开始显示第几页)
        			"scrollCollapse" : true,						//当显示更少的记录时，是否允许表格减少高度
        			"dom" 			 : '<"col-md-offset-6 colvis-float-right"Bf>' +
									   'rt'+		
									   '<"col-md-4 uni-el"l><"col-md-4 uni-el"i><"col-md-4 uni-el"p>',
															    	/*
																	l - 每页显示行数的控件	f - 检索条件的控件
																	t - 表格控件 			i - 表信息总结的控件
																	p - 分页控件 			r - 处理中的控件
																	注意:如果需要使用按钮则添加 'B'
																	*/
									   
				    "paging" 		: true,							//是否开启本地分页()
				    "processing"    : true,							//是否显示处理状态
				    "searching"		: false,						//是否允许Datatables开启本地搜索
				    "destroy" 		: true,							//销毁所有符合选择的table，并且用新的options重新创建表格
				    "displayStart"  : 0,							//初始化显示的时候从第几条数据开始显示(一开始显示第几页)
				    "lengthMenu" 	: [10, 20, 50, 100],			//定义在每页显示记录数的select中显示的选项
				    "pageLength" 	: 10,							//改变初始的页面长度(每页显示的记录数)
				    "pagingType" 	: "full_numbers",				//分页按钮的显示方式 numbers,simple,simple_numbers ,full ,full_numbers
				    "order"		 	:  [],							//("order": []表示不排序)表格在初始化的时候的排序
				    "language"	 	: {								//在不修改源码的同时,修改语言为中文
        	    	    "url" : "../assets/plugins/DataTables/json/dataTables.json?v2",
        	    	    "sSearchPlaceholder" : option.placeholder ? option.placeholder : "search here!"
				    },
        			"scrollX" 		: true,							//设置水平滚动
        			"scrollCollapse": true,							//(默认 false)当显示更少的记录时，是否允许表格减少高度
        	}
        	
        	//初始化datatable
        	return this.DataTable($.extend({}, _defaultSettings, option))
        		//加载过程显示的图标
        		.on('processing.dt', function (e, settings, processing) {
    				 if(processing) {
    					$(this).prepend('<div class="panel-loader"><span class="spinner-small"></span></div>');
    				}else {
    					$(this).find('.panel-loader').remove();
    				}
    			//处理ajax返回
    			}).on('xhr.dt', function (e, settings, json, XMLHttpRequest) {
    				//如果状态码不是200, 则报错
    			    if (XMLHttpRequest.status != 200) {
    			    	var errorResponse;
						try {
							errorResponse = JSON.parse(XMLHttpRequest.responseText);
						} catch (e) {
							console.log(e);
						}
						if (errorResponse) {
							Notification.danger(errorResponse.message, 3000);
						}
    			    } 
    			});
		}
	});
})(jQuery);