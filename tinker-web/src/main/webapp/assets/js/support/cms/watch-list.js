var $table, table;
$(function(){
	$table = $("#data-table");
	initDataTable();
});
function initDataTable(){
	table = $table.buildDataTable({
		"processing" : true,
		"url"  : "../watches",
		"searching" : true,
		"placeholder" : "请输入主题...",
	     "columns" : [
						{"title" : "主题", "data" : "subject", "orderable" : false},
						{"title" : "陈列图片", "data" : "mainPictureUrl", "orderable" : false, "render" : function(data, type, row, meta) {
							var main = "<img src='" + data + "' style='width:70px;height:70px;'/>";
							var subs = "";
							var subPictureUrls = row.subPictureUrls.split(",");
							for(var i = 0; i < subPictureUrls.length; i++) {
								subs += "<img src='" + subPictureUrls[i] + "' style='width:50px;height:50px;' />";
							}
							return main + subs;
						}},
						{"title" : "价格", "data" : "price"},
						{"title" : "类型", "data" : "type", "orderable" : false},
						{"title" : "状态", "data" : "state", "orderable" : false},
						{"title" : "最后一次修改时间", "data" : "lastModifedTime", "name" : "last_modifed_time"},
						{"title" : "操作", "data" : "id", "orderable" : false, "width" : "10%", "render" : function(data, type, row, meta) {
							return  '<div class="btn-group">'+
			                    '    <button class="btn btn-sm btn-info" onclick="openEdit(\'' + data + '\')">编辑</button>'+
			                    '    <button class="btn btn-sm btn-danger" onclick="deleteThis(\'' + data + '\')">删除</button>'+
			                    '</div>';
							}
						}
       			  	 ]
	});
}

function deleteThis(id){
	Confirm.danger({
		"title" : "确定删除?"
	}, function(params){
		AjaxHelper.del({
			"url" : "../watches/" + id,
			"success" : function(data){
				Notification.success("删除成功");
				table.reload();
			}
		});
	});
}

function openCreate() {
	//跳转到目标子页面
	//window.location.href = "#cms/watch-create";
	$.redirect("#cms/watch-create");
}

function openEdit(id){
	$.redirect("#cms/watch-edit", {"id" : id});
}