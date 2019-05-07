var $table, table, $modal, $modal2, $form, jsTree, select2DataAuth, $apiSelect, pathData;
$(function(){
	$table = $("#data-table");
	$modal = $("#modal");
	$modal2 = $("#modal2");
	$form = $("#form");
	initCascadeMenu();
	initJspTree();
	initValidation();
	initModalEvent();
	initIconEvent();
	initSelect2Authorities();
	initCheckbox();
});

function initCheckbox(){
	$(".menu-checkbox").change(function(){
		$(".menu-checkbox").removeAttr("checked");
		$(this).attr("checked", "checked");
	});
	$("#parent-menu").click(function(){
		$("#pemission-div").hide();
		$("#authorities-div").hide();
		$('#permission').rules("remove");
		var subPermissions = $('[name^="permission-sub-"]');
		if(subPermissions && subPermissions.length > 0) {
			subPermissions.rules("remove");
		}
		$("#authorities").rules("remove");
	});
	$("#real-menu").click(function(){
		$("#pemission-div").show();
		$("#authorities-div").show();
		
		$('#permission').rules("add",{ 
			required: true, 
			maxlength : 150,
			messages: {
				required: "请输入链接地址",
				maxlength : $.validator.format( "子链接地址不能超过{0}个字符" )
			} 
		});
		var subPermissions = $('[name^="permission-sub-"]');
		if(subPermissions && subPermissions.length > 0) {
			subPermissions.rules("add",{ 
				required: true, 
				maxlength : 150,
				messages: {
					required: "请输入子链接地址",
					maxlength : $.validator.format( "子链接地址不能超过{0}个字符" )
					
				} 
			});
		}
		$('#authorities').rules("add",{ 
			required: true, 
			messages: {
				required: "请选择后台权限",
			} 
		});
		
	});
}

function initJspTree(){
	AjaxHelper.get({
		"url" : "../permissions/jspViews",
		"async" : false,
		"success" : function(data){
			pathData = data;
			drawPermissionSelectBtns($("#paths"));
		}
	});
}

function drawPermissionSelectBtns(el) {
	el.html("");
	for(var i = 0; i < pathData.length; i++) {
		el.append('<li><a href="javascript:void(0);" onclick="pastePath(this)">' + pathData[i] + '</a></li>')
	}
}

function pastePath(el) {
	$(el).parents("div.input-group").find("input.form-control").val($(el).html());
}

function initSelect2Authorities(){
	if(!select2DataAuth){
		AjaxHelper.get({
			"url" : "../permissions/authorities",
			"async" : false,
			"success" : function(data){
				select2DataAuth = data;
			}
		});
	}
}

function initSelectOption(){
	var html = '';
	for(var i = 0; i < select2DataAuth.length; i++){
		var item = select2DataAuth[i];
		html += '<option value="' + item.id + '">' + item.text + '</option>';
	}
	$apiSelect = $("#authorities");
	$apiSelect.html(html);
	$apiSelect.buildSelect2({
		"type" 		: "default",
		"usePlaceholderBy" : "请选择后台权限",
		"multiple" : true
	});
	$apiSelect.clearSelect();
}

function initIconEvent(){
	$("#tab-icons").find(".text-center").mouseover(function(){
		$(this).css("background-color","#d9e0e7");
		$(this).addClass("select-on-style");
	}).mouseout(function(){
		$(this).removeAttr("style");
		$(this).removeClass("select-on-style");
	});
	$("#tab-icons").find(".text-center").dblclick(function(){
		var input = $("<input />");
		input.addClass($(this).find(".fa").attr("class")).removeClass("fa-2x");
		$("#icon-box").html($(this).html());
		$("#icon").val(iconClass(input.attr("class")));
		$modal2.hideModal();
	});
}

function iconClass(style){
	style = style + " text-default fa-lg";
	return style;
}

function initValidation() {
    $form.validate({
        rules : {
            permissionName : {
                required : true,
                maxlength : 20
            },
            note : {
                maxlength : 200
            }
        },
        messages : {
        	permissionName: {
                required : "请输入菜单名称",
                maxlength : $.validator.format( "菜单名称不能超过{0}个字符" )
            },
            note : {
                maxlength : $.validator.format( "备注不能超过{0}个字符" )
            }
        }
    })
}

function initModalEvent(){
	$modal.modalEvent({
		"showOrhidden" : function(){
			$form.clearForm();
			$("#icon-box").html('<div><i class="fa fa-2x fa-th-list"></i></div><div class="hidden-xs">fa-th-list</div>');
			$("[name^=permission-sub]").parents(".form-group").remove();
			initSelectOption();
		}
	});
}
function initCascadeMenu(){
	$('#cascade-menu-jstree').jstree("destroy");
	AjaxHelper.get({
		"url" : "../permissions",
		"data" : {
			"parentId" : 'root'
		},
		"async" : false, 
		"success" : function(data){
			buildJstree(data);
		}
	});
	function buildJstree(data) {
		jsTree = $("#cascade-menu-jstree").jstree({
	        "core": {
	            "themes": {
	                "responsive": false
	            }, 
	            "check_callback": true,
	            'data': [{
	            		"id" : "root",
	                    "text": "系统菜单",
	                    "state" : {
	                    	"opened" : true
	                    },
	                    "children" : data
	                }
	            ]
	        },
	        'contextmenu' : {
	        	select_node:true,  
	            show_at_node:true,
	            items : {
	            	"create" : {
						"separator_before"	: false,
						"separator_after"	: true,
						"_disabled"			: function (data) {
							 var selector = data.reference.prevObject.selector;
							 //[系统菜单]可以创建下级菜单
							 if(selector == "#root") {
								 return false;
							 }
							var inst = $.jstree.reference(data.reference),
								obj = inst.get_node(data.reference);
							//如果是业务菜单则禁止创建下级菜单
							if(!obj.original.catalog) {
								return true;
							}
							return false; 
						 }, 
						"icon"				: "fa fa-wrench",
						"label"				: "创建下级菜单",
						"action"			: function (data) {
							var inst = $.jstree.reference(data.reference),
								obj = inst.get_node(data.reference);
							$modal.showModal();
							$("#parent-menu").click();
							$("#icon").val("fa fa-th-list text-default fa-lg");
							$("#btn-save").attr("onclick", "create()");
							$("#parentId").val(obj.id);
							if("root" === obj.id) {
								$("#icon-box-container").show();
							}else {
								$("#icon-box-container").hide();
							}
						}
					},
					"rename" : {
						"separator_before"	: false,
						"separator_after"	: false,
						"_disabled"			: function (obj) { 
							 var selector = obj.reference.prevObject.selector;
							 if(selector == "#root") {
								 return true;
							 }
							 return false; 
						 }, 
						"label"				: "修改",
						"icon"				: "fa fa-pencil-square-o",
						"action"			: function (data) {
							var inst = $.jstree.reference(data.reference),
								obj = inst.get_node(data.reference);
							if(obj.children.length > 0) {
								$("#parent-menu").click();
								$("#real-menu").attr("disabled", "disabled");
							} else {
								$("#real-menu").removeAttr("disabled");
								if(!obj.original.catalog) {
									$("#real-menu").click();
								}
							}
							if(obj.id === "root") {
								return;
							}
							openEdit(obj.id);
							if("root" === obj.parent) {
								$("#icon-box-container").show();
							}else {
								$("#icon-box-container").hide();
							}
						}
					},
					"remove" : {
						"separator_before"	: false,
						"icon"				: false,
						"separator_after"	: false,
						"_disabled"			: function (obj) { 
							 var selector = obj.reference.prevObject.selector;
							 if(selector == "#root") {
								 return true;
							 }
							 return false; 
						 }, 
						"icon"				: "fa fa-times",
						"label"				: "删除",
						"action"			: function (data) {
							var inst = $.jstree.reference(data.reference),
								obj = inst.get_node(data.reference);
							if(obj.id === "root") {
								return;
							}
							if(inst.is_selected(obj)) {
								
								Confirm.danger({
									"title" : "确定删除?",
									"text" : "删除当前菜单包括子菜单?"
								}, function(params){
									AjaxHelper.del({
										"url" : "../permissions/" + obj.id,
										"success" : function(data){
											inst.delete_node(inst.get_selected());
											Notification.success("删除成功");
										}
									});	
								});
							}
						}
					}
	            }
	        },
	        "types": {
	            "default": {
	                "icon": "fa fa-th-list text-default fa-lg"
	            }
	        },
	        "plugins": [ "contextmenu", "types", "dnd" ]
	    }).on('move_node.jstree', function(e,data){
	    	var obj = jsTree.jstree("get_node", data.parent);
	    	AjaxHelper.patch({
	    		"url" : "../permissions/sequence",
	    		"data" : {
	    			"currentId" : data.node.id,
	    			"parentId" : data.parent,
	    			"childrenIds" : obj.children
	    		},
	    		"success" : function(data){
    				Notification.success("操作成功");
	    		},
	    		"error" : function(){
	    			initCascadeMenu();
	    		}
	    	});
	    });
	}
}

function deleteById(id) {
	AjaxHelper.del({
		"url" : "../permissions/" + id,
		"success" : function(data){
			inst.delete_node(inst.get_selected());
			Notification.success("删除成功");
		}
	});			
}
function openEdit(id){
	$modal.showModal();
	AjaxHelper.get({
		"url" : "../permissions/" + id,
		"success" : function(data){
			$("#id").val(data.id);
			$("#parentId").val(data.parentId);
			$("#sequence").val(data.sequence);
			$("#permissionName").val(data.permissionName);
			if(data.permission) {
				var permissions = data.permission.split(",");
				for(var i = 0; i < permissions.length; i++) {
					if(i == 0 ) {
						$("#permission").val(permissions[0]);
					}else {
						addSubPermission();
						$("[name^=permission-sub]").eq(-1).val(permissions[i]);
					}
				}
			}
			var isCatalog = data.catalog;
			if(isCatalog) {
				$('#parent-menu').click();
			}else {
				$("#real-menu").click();
			}
			$("#note").val(data.note);
			$("#icon").val(data.icon);
			var $html = $("<input />");
			$html.addClass(data.icon);
			$html.removeClass("text-default").removeClass("fa-lg").removeClass("fa");
			var td_el = $("#tab-icons").find("." + $html.attr("class")).parent("div").parent("td");
			if(data.authorities) {
				$apiSelect.selectValues(data.authorities);
			}
			$("#icon-box").html(td_el.html());
			$("#btn-save").attr("onclick", "edit()")
		}
	});
}

function edit() {
	if($form.isValidForm()){
		var id = $("#id").val();
		var el = $("#" + id);
		var catalog = $('#parent-menu').is(':checked');
		var data = {
				"permissionName" : $("#permissionName").val(),
				"sequence" : $("#sequence").val(),
				"note" : $("#note").val(),
				"parentId" : $("#parentId").val(),
				"icon" : $("#icon").val(),
				"id" : id,
				"catalog" : catalog
		};
		if(!catalog) {
			var pemissions = [$("#permission").val()];
			var subPermission = $("[name^=permission-sub]").map(function(){
				return $(this).val();
			}).get();
			pemissions = pemissions.concat(subPermission);
		    var permissionString = pemissions.join();
		    data.permission = permissionString;
	    	data.authorities = ($("#authorities").val() || []).join();
		}
		
		AjaxHelper.put({
			"url" : "../permissions",
			"data" : data,
			"success" : function(data){
				var obj = jsTree.jstree("get_node", id);
				obj.icon = $("#icon").val();
				obj.original.catalog = catalog;
				jsTree.jstree(true).edit(obj, $("#permissionName").val());
				$(".jstree-rename-input").blur();
				Notification.success("修改成功");
				$modal.hideModal();
			}
		});
	}
	
}

function showIconModal(){
	$modal2.showModal();
}

function create() {
	if($form.isValidForm()){
		var id = generateUUID();
	    var catalog = $('#parent-menu').is(':checked');
	    var data = {
	    		"permissionName" : $("#permissionName").val(),
	    		"catalog" : catalog,
	    		"id" : id,
	    		"note" : $("#note").val(),
	    		"parentId" : $("#parentId").val(),
	    		"icon" : $("#icon").val()
   		};
	    if(!catalog) {
	    	var pemissions = [$("#permission").val()];
			var subPermission = $("[name^=permission-sub]").map(function(){
				return $(this).val();
			}).get();
			pemissions = pemissions.concat(subPermission);
		    var permissionString = pemissions.join();
	    	data.permission = permissionString;
	    	data.authorities = ($("#authorities").val() || []).join();
	    }
	    
	    AjaxHelper.post({
			"url" : "../permissions",
			"data" : data,
			"success" : function(data){
				Notification.success("创建成功");
				var parentNodeId = $("#parentId").val();
				var obj = { 
							"text": $("#permissionName").val(), 
							"id":id , 
							"icon" : $("#icon").val(), 
							"catalog" : catalog 
						};
				jsTree.jstree('create_node', parentNodeId, obj, "last", function(data){
					jsTree.jstree("open_node", '#' + parentNodeId);
			    }, false);
				
				$modal.hideModal();
			}
			
		});
	}
}

function generateUUID() {
    function S4() {
       return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
}

function addSubPermission() {
	var timstamp = new Date().getTime()
	var html = '<div class="form-group">'+
	'	<label class="col-md-2 control-label">子链接</label>'+
	'	<div class="col-md-10">'+
	'		<div class="input-group">'+
	'			<input type="text" class="form-control" name="permission-sub-' + timstamp + '" placeholder="子链接的相对路径"/>'+
	'			<div class="input-group-btn">'+
	'				<ul class="dropdown-menu pull-right" id="paths' + timstamp + '" style="height:300px;overflow-y:auto;"></ul>'+
	'				<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">'+
	'				<span class="caret"></span>'+
	'				</button>'+
	'				<button type="button" class="btn btn-danger" onclick="removeThis(this)"><i class="fa fa-minus"></i></button>'+
	'			</div>'+
	'		</div>'+
	'	</div>'+
	'</div>';
	$("#pemission-div").append(html);
	drawPermissionSelectBtns($("#paths" + timstamp));
	
	$('[name="permission-sub-'+ timstamp +'"]').rules("add",{ 
		required: true, 
		maxlength : 150,
		messages: {
			required: "请输入子链接地址",
			maxlength : $.validator.format( "子链接地址不能超过{0}个字符" )
			
		} 
	});
	
}

function removeThis(el) {
	$(el).parents(".form-group").remove();
	if($("[name^=permission-sub]").length == 0) {
		 $("#permission").rules("remove"); 
	}
	$form.validate().element($("#permission"));
}