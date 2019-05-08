var $table, table, $modal, $form, $modal_password, $form_password;
var $apiSelect;
var roleIds_store;
$(function(){
	$table = $("#data-table");
	$modal = $("#modal");
	$modal_password = $("#modal-password")
	$form = $("#form");
	$form_password = $("#form-password");
	initDataTable();
	initModalEvent();
	initValidation();
});
function initSelectOption(){
	AjaxHelper.get({
		"url" : "../users/roleStructures",
		"async" : false,
		"success" : function(data){
			select2DataRole = data;
			var html = '';
			for(var i = 0; i < select2DataRole.length; i++){
				var item = select2DataRole[i];
				html += '<option value="' + item.id + '">' + item.text + '</option>';
			}
			$apiSelect = $("#roleIds-select2");
			$apiSelect.html(html);
			$apiSelect.buildSelect2({
				"type" 		: "default",
				"usePlaceholderBy" : "请选择角色"
			});
			$apiSelect.clearSelect();
		}
	});
	
}

function initModalEvent(){
	$modal.modalEvent({
		"show" : function(){
			$form.clearForm();
			initSelectOption();
		}, 
		"hide" : function(){
			$form.clearForm();
		}
	});
	$modal_password.modalEvent({
		"showOrhidden" : function(){
			$form_password.clearForm();
		}
	});
}

function initValidation() {
    $form.validate({
        rules : {
           name : {
                required : true,
                maxlength : 30
            },
            account : {
                required : true,
                maxlength : 50
            },
            "roleIds-select2" : {
                required : true
            }
        },
        messages : {
        	name : {
                required : "请输入用户名称",
                maxlength : $.validator.format( "用户名称不能超过{0}个字符" )
            },
            account : {
                required : "请输入账号",
                maxlength : $.validator.format( "账号不能超过{0}个字符" )
            }, 
            "roleIds-select2" : {
                required : "请选择角色"
            }
        }
    });
    
    $form_password.validate({
        rules : {
            "password-ref" : {
                required : true,
                usefulPassword : true
            },
            "re-password-ref" : {
                required : true,
                equalTo : "#password-ref"
            }
        },
        messages : {
        	"password-ref" : {
                required : "请输入新密码"
            },
            "re-password-ref": {
                required : "请确认密码",
                equalTo : "密码不一致"
            }
        }
    });
}
function initDataTable(){
	table = $table.buildDataTable({
		"processing" : true,
		"url"  : "../users",
		"searching" : true,
		"placeholder" : "请输入用户账号...",
	     "columns" : [
						{"title" : "名称", "data" : "name", "orderable" : false},
						{"title" : "账号", "data" : "account", "orderable" : false},		
						{"title" : "操作", "data" : "id", "orderable" : false, "width" : "15%", "render" : function(data, type, row, meta) {
							return  '<div class="btn-group">'+
			                    '    <button class="btn btn-sm btn-info" onclick="openEdit(\'' + data + '\')">编辑</button>'+
			                    '    <button class="btn btn-sm btn-info" onclick="openRefreshPassword(\'' + data + '\') ">修改密码</button>'+
			                    '    <button class="btn btn-sm btn-danger" onclick="deleteThis(\'' + data + '\')">删除</button>'+
			                    '</div>';
							}
						}
       			  	 ]
	});
}

function openRefreshPassword(id) {
	$modal_password.showModal();
	$("#password-id").val(id);
}

function refreshPassword(){
	if($form_password.isValidForm()){
		/*AjaxHelper.patch({
			"url" : "../users/password",
			"data" : {
				"userId" : $("#password-id").val(),
				"password" : $("#password-ref").val()
			},
			"success" : function(data){
				$modal_password.hideModal();
				Notification.success("修改成功");
			}
		});*/
	}
}

function deleteThis(id){
	Confirm.danger({
		"title" : "确定删除?",
		"text" : "用户删除后,当前账号将无法使用"
	}, function(params) {
		/*AjaxHelper.del({
			"url" : "../users/" + id,
			"success" : function(data){
				Notification.success("删除成功");
				table.reload();
			}
		});*/
	});
}
function openCreate() {
	showPasswordArea();
	$("#account").removeAttr("disabled");
	$modal.showModal();
	$("#btn-save").attr("onclick","create()");
}
function showPasswordArea(){
	$("#password-group,#re-password-group").show();
	$("#password").rules("add",{required:true, usefulPassword : true, messages:{required:"请输入密码"}});  
	$("#re-password").rules("add",{required:true,equalTo : "#password",messages:{required:"请确认密码",equalTo:"密码不一致"}});
}
function hidePasswordArea(){
	$("#password-group,#re-password-group").hide();
	$("#password").rules("remove");  
	$("#re-password").rules("remove");
}
function create(){
	if($form.isValidForm()){
		AjaxHelper.post({
			"url" : "../users",
			"data" : {
				"name" : $("#name").val(),
				"account" : $("#account").val(),
				"password" : $("#password").val(),
				"roleIds" : $apiSelect.val()
			},
			"success" : function(data){
				Notification.success("创建成功");
				$modal.hideModal();
				table.reload(true);
			}
		});
	}
}

function openEdit(id){
	AjaxHelper.get({
		"url" : "../users/" + id,
		"success" : function(data){
			$("#account").attr("disabled", "disabled");
			$("#btn-save").attr("onclick","edit()");
			$modal.showModal();
			$("#id").val(data.user.id);
			$("#name").val(data.user.name);
			$("#account").val(data.user.account);
			hidePasswordArea();
			$apiSelect.selectValues(data.roleIds);
			roleIds_store = data.roleIds;
		}
	});
	
}

function edit(){
	if($form.isValidForm()){
		AjaxHelper.put({
			"url" : "../users",
			"data" : {
				"id" : $("#id").val(),
				"account" : $("#account").val(),
				"name" : $("#name").val() ,
				"lastRoleIds" : roleIds_store,
				"currentRoleIds" : $apiSelect.val() 
			},
			"success" : function(data){
				Notification.success("修改成功");
				$modal.hideModal();
				table.reload();
			}
		});
	}
}