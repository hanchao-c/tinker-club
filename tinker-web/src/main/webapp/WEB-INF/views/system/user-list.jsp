<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('系统设置 - 用户管理');
</script>
<!-- ================== END PAGE LEVEL JS ================== -->

<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">系统设置</a></li>
        <li class="active">用户管理</li>
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
                    <h4 class="panel-title">系统用户列表</h4>
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
				<h4 class="modal-title">用户详情</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="form">
						<input type="hidden" id="id" name="id" />
						<div class="form-group">
							<label class="col-md-2 control-label">用户名称</label>
							<div class="col-md-10">
								<input type="text" id="name" name="name" class="form-control" placeholder=""  />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">账号</label>
							<div class="col-md-10">
								<input type="text" id="account" name="account" class="form-control" placeholder="账号中不建议使用中文"  />
							</div>
						</div>
						<div class="form-group " id="password-group">
							<label class="col-md-2 control-label">密码</label>
							<div class="col-md-10">
								<input type="password" id="password" name="password" class="form-control" placeholder="8-16位字母+数字"  autocomplete="off" />
							</div>
						</div>
						<div class="form-group" id="re-password-group">
							<label class="col-md-2 control-label">确认密码</label>
							<div class="col-md-10">
								<input type="password" id="re-password" name="re-password" class="form-control" placeholder="确认密码" autocomplete="off" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">角色</label>
							<div class="col-md-10">
								<select class=" form-control" id="roleIds-select2" name="roleIds-select2" multiple="multiple" style="width:100%;"></select>
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

<div class="modal fade" id="modal-password">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title">密码重置</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="form-password">
						<input type="hidden" id="password-id" name="password-id"  />
						<div class="form-group">
							<label class="col-md-2 control-label">新密码</label>
							<div class="col-md-10">
								<input type="password" id="password-ref" name="password-ref" class="form-control" placeholder="8-16位字母+数字" autocomplete="off" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">确认密码</label>
							<div class="col-md-10">
								<input type="password" id="re-password-ref" name="re-password-ref" class="form-control" placeholder="" autocomplete="off" />
							</div>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<a href="javascript:;" class="btn btn-sm btn-white" data-dismiss="modal">取消</a>
				<a href="javascript:;" id="btn-save-password" class="btn btn-sm btn-success" onclick="refreshPassword()">保存</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../assets/js/support/system/user-list.js?v_1"></script>