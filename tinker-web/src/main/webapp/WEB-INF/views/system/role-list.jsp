<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('系统设置 - 角色管理');
</script>
<!-- ================== END PAGE LEVEL JS ================== -->

<link href="../assets/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" />
<script type="text/javascript" src="../assets/plugins/jstree/dist/jstree.js?v1"></script>
		
<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">系统设置</a></li>
        <li class="active">角色管理</li>
    </ol>
    <!-- end breadcrumb -->
    
    <!-- begin row -->
    <div class="row">
        <!-- begin col-12 -->
        <div class="col-md-12">
            <!-- begin panel -->
            <div class="panel panel-inverse">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                    </div>
                    <h4 class="panel-title">系统角色列表</h4>
                </div>
                <div class="panel-body">
                	<div class="col-md-6">
                		<button class="btn btn-info" onclick="openCreate()">创建</button>
                	</div>
                    <table id="data-table" class="table table-striped table-bordered" style="width: 100%;">
                    </table>
                </div>
            </div>
            <!-- end panel -->
        </div>
        <!-- end col-12 -->
    </div>
    <!-- end row -->
</div>
<!-- end #content -->
<div class="modal fade" id="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title">角色详情</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="form">
						<input type="hidden" id="id" name="id" />
						<div class="form-group">
							<label class="col-md-2 control-label">角色名称</label>
							<div class="col-md-10">
								<input type="text" id="roleName" name="roleName" class="form-control" placeholder=""  />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">描述</label>
							<div class="col-md-10">
								<textarea class="form-control" id="description" name="description" placeholder="" rows="5"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">菜单</label>
							<div class="col-md-10">
				            <!-- begin panel -->
				            <div class="panel panel-inverse">
				                <div class="panel-body">
				                	<div id="jstree-container">
				                     <div id="cascade-menu-jstree"></div>
				                	</div>
				                </div>
				            </div>
				            <!-- end panel -->
				        </div>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<a href="javascript:;" class="btn btn-sm btn-white" data-dismiss="modal">取消</a>
				<a href="javascript:;" id="btn-save" class="btn btn-sm btn-success" onclick="create()">保存</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../assets/js/support/system/role-list.js?v_1"></script>