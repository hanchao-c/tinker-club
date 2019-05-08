var $table, table, $modal, $form, jsTree;
var pemissionIds_store;
$(function(){
	$table = $("#data-table");
	$modal = $("#modal");
	$form = $("#form");
	initDataTable();
	initModalEvent();
	initValidation();
});

function initDataTable(){
	table = $table.buildDataTable({
		"url"  : "../roles",
		"searching" : true,
		"placeholder" : "请输入角色名称...",
		//"colvis" : true,
	    "columns" : [
						{"title" : "角色名称", "data" : "roleName", "orderable" : false},
						{"title" : "描述", "data" : "description", "orderable" : false},
						{"title" : "操作", "data" : "id", "orderable" : false, "width" : "10%", "render" : function(data, type, row, meta) {
					    	return  '' +
					    	'<div class="btn-group">' +
		                    '    <button class="btn btn-sm btn-info" onclick="openEdit(\'' + data + '\')">编辑</button>' +
		                    '    <button class="btn btn-sm btn-danger" onclick="deleteThis(\'' + data + '\') ">删除</button>' +
		                    '</div>';
		    				}
						}
         			  ]
	});
}
function deleteThis(id){
	Confirm.danger({
		"title" : "确定删除?"
	}, function(params) {
		/*AjaxHelper.del({
			"url" : "../roles/" + id,
			"success" : function(data) {
				Notification.success("删除成功");
				table.reload();
			}
		});*/
	});
}

function openEdit(id) {
	$modal.showModal();
	initCascadeMenu(id);
}

function initById(id) {
	AjaxHelper.get({
		"url" : "../roles/" + id,
		"success" : function(data) {
			var role = data.role;
			$("#id").val(role.id);
			$("#roleName").val(role.roleName);
			$("#description").val(role.description);
			var permissionIds = data.permissionIds;
			$("#btn-save").attr("onclick", "edit()");
			pemissionIds_store = permissionIds;
			selectNode(permissionIds);
		}
	});
}

function edit() {
	if ($form.isValidForm()) {
		AjaxHelper.put({
			"url" : "../roles",
			"data" : {
				"id" : $("#id").val(),
				"roleName" : $("#roleName").val(),
				"description" : $("#description").val(),
				"lastPermissionIds" : pemissionIds_store || [],
				"currentPermissionIds" : jsTree.jstree("get_checked") || []
			},
			"success" : function(data) {
				Notification.success("修改成功");
				table.reload();
				$modal.hideModal();
			}
		});
	}
}
function selectNode(permissionIds) {
	for (var i = 0; i < permissionIds.length; i++) {
		var permissionId = permissionIds[i];
		var el = $("#" + permissionId);
		var obj = jsTree.jstree("get_node", permissionId);
		jsTree.jstree(true).select_node(obj);
	}
}

function initValidation() {
	$form.validate({
		rules : {
			roleName : {
				required : true,
				maxlength : 30
			},
			description : {
				maxlength : 200
			}
		},
		messages : {
			roleName : {
				required : "请输入角色名称",
				maxlength : $.validator.format("角色名称不能超过{0}个字符")
			},
			description : {
				maxlength : $.validator.format("描述不能超过{0}个字符")
			}
		}
	})
}
function initModalEvent() {
	$modal.modalEvent({
		"showOrhidden" : function() {
			$form.clearForm();
		}
	});
}
function openCreate() {
	$modal.showModal();
	$("#btn-save").attr("onclick", "create()");
	initCascadeMenu();
}
function create() {
	if ($form.isValidForm()) {
		AjaxHelper.post({
			"url" : "../roles",
			"data" : {
				"roleName" : $("#roleName").val(),
				"description" : $("#description").val(),
				"permissionIds" : jsTree.jstree("get_checked")
			},
			"success" : function(data) {
				Notification.success("创建成功");
				$modal.hideModal();
				table.reload(true);
			}
		});
	}
}
function initCascadeMenu(id) {
	$("#jstree-container").html('<div id="cascade-menu-jstree"></div>');
	AjaxHelper.get({
		"url" : "../roles/cascade",
		"data" : {
			"parentId" : 'root'
		},
		"async" : false,
		"success" : function(data) {
			jsTree = $("#cascade-menu-jstree").jstree({
				"core" : {
					"themes" : {
						"responsive" : false
					},
					"check_callback" : true,
					'data' : [ {
						"id" : "root",
						"text" : "系统菜单",
						"state" : {
							"opened" : true
						},
						"children" : data
					} ]
				},
				"types" : {
					"default" : {
						"icon" : "fa fa-th-list text-default fa-lg"
					}
				},
				'plugins' : [ "wholerow", "checkbox", "types" ]
			}).on("ready.jstree", function() {
				if (id) {
					initById(id);
				}
			});
		}
	});
}