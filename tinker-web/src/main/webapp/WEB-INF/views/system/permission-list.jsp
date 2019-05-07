<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('系统设置 - 菜单管理');
</script>
<!-- ================== END PAGE LEVEL JS ================== -->

<link href="../assets/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" />
<style type="text/css">
	.modal-message .modal-body, .modal-message .modal-footer, .modal-message .modal-header {
		width: 80%;
	}
	.select-on-style {
		cursor:pointer;
	}
</style>

<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">系统设置</a></li>
        <li class="active">菜单管理</li>
    </ol>
    <!-- end breadcrumb -->
    
    <!-- begin row -->
    <div class="row">
        <!-- begin col-12 -->
        <div class="col-md-12">
            <!-- begin panel -->
            <div class="panel panel-inverse cc">
                <div class="panel-heading">
                    <div class="panel-heading-btn">
                        <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                    </div>
                    <h4 class="panel-title">菜单列表</h4>
                </div>
                <div class="panel-body">
                     <div id="cascade-menu-jstree"> </div>
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
				<h4 class="modal-title">菜单详情</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="form">
						<input type="hidden" id="parentId" name="parentId" />
						<input type="hidden" id="id" name="id" />
						<input type="hidden" id="sequence" name="sequence" >
						<div class="form-group">
							<label class="col-md-2 control-label">菜单名称</label>
							<div class="col-md-10">
								<input type="text" id="permissionName" name="permissionName" class="form-control" placeholder=""  />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label"></label>
							<div class="col-md-10">
								<label class="checkbox-inline">
									<input type="checkbox" value="" class="menu-checkbox" id="parent-menu" checked="checked"/>目录菜单
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="" class="menu-checkbox" id="real-menu">业务菜单
								</label>
							</div>
						</div>
						<div id="pemission-div" style="display: none;">
							<div class="form-group" id="permission-group">
								<label class="col-md-2 control-label">链接</label>
								<div class="col-md-10">
									<div class="input-group">
										<input type="text" class="form-control" id="permission" name="permission" placeholder="链接的相对路径"/>
										<div class="input-group-btn">
											<ul class="dropdown-menu pull-right" id="paths" style="height:300px;overflow-y:auto;">
											</ul>
											<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
												<span class="caret"></span>
											</button>
											<button type="button" class="btn btn-success" onclick="addSubPermission()">添加子链接</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group" id="icon-box-container">
							<label class="col-md-2 control-label">icon</label>
							<div class="col-md-4">
								<div class="table-responsive">
			                        <table class="table table-bordered m-b-0">
										<td class="text-center" id="icon-box" style="cursor:pointer" onclick="showIconModal()">
											<div>
												<i class="fa fa-2x fa-th-list"></i>
											</div>
											<div class="hidden-xs">fa-th-list</div>
										</td>
										<input type="hidden" id="icon" name="icon" />
									</table>
								</div>
							</div>
						</div>
						<div class="form-group" id="authorities-div" style="display: none;">
							<label class="col-md-2 control-label">权限</label>
							<div class="col-md-10">
								<select class=" form-control" id="authorities" name="authorities" multiple="multiple" style="width: 100%;"></select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">备注</label>
							<div class="col-md-10">
								<textarea class="form-control" id="note" name="note" placeholder="" rows="5"></textarea>
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
<div class="modal modal-message fade" id="modal2" style="width: 100%;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title">icon选择</h4>
				<h5 class="modal-title" style="color:red;">(使用双击选择)</h5>
			</div>
			<div class="modal-body">
			<div class="row">
					<ul class="nav nav-tabs">
		              	<li class="active">
							<a href="#default-tab-1" data-toggle="tab">
								<span class="visible-xs">Tab 1</span>
								<span class="hidden-xs">Web Application Icon</span>
							</a>
						</li>
						<li class="">
							<a href="#default-tab-2" data-toggle="tab">
								<span class="visible-xs">Tab 2</span>
								<span class="hidden-xs">Fiel type Icons</span>
							</a>
						</li>
						<li class="">
							<a href="#default-tab-3" data-toggle="tab">
								<span class="visible-xs">Tab 3</span>
								<span class="hidden-xs">Directional Icons</span>
							</a>
						</li>
						<li class="">
							<a href="#default-tab-4" data-toggle="tab">
								<span class="visible-xs">Tab 4</span>
								<span class="hidden-xs">Text Editor Icons</span>
							</a>
						</li>
		            </ul>
		            <div class="tab-content" id="tab-icons">
		            	<div class="tab-pane fade active in" id="default-tab-1">
		                	<div class="row">
						        <div class="col-md-12">
						        	<div class="table-responsive">
				                        <table class="table table-bordered m-b-0">
				                            <tbody>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-adjust" ></i></div><div class="hidden-xs">fa-adjust1</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-anchor"></i></div><div class="hidden-xs">fa-anchor</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-archive"></i></div><div class="hidden-xs">fa-archive</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-arrows"></i></div><div class="hidden-xs">fa-arrows</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-arrows-h"></i></div><div class="hidden-xs">fa-arrows-h</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-arrows-v"></i></div><div class="hidden-xs">fa-arrows-v</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-asterisk"></i></div><div class="hidden-xs">fa-asterisk</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-automobile"></i></div><div class="hidden-xs">fa-automobile <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-ban"></i></div><div class="hidden-xs">fa-ban</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bank"></i></div><div class="hidden-xs">fa-bank <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bar-chart-o"></i></div><div class="hidden-xs">fa-bar-chart-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-barcode"></i></div><div class="hidden-xs">fa-barcode</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bars"></i></div><div class="hidden-xs">fa-bars</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-beer"></i></div><div class="hidden-xs">fa-beer</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bell"></i></div><div class="hidden-xs">fa-bell</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bell-o"></i></div><div class="hidden-xs">fa-bell-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bolt"></i></div><div class="hidden-xs">fa-bolt</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bomb"></i></div><div class="hidden-xs">fa-bomb</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-book"></i></div><div class="hidden-xs">fa-book</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bookmark"></i></div><div class="hidden-xs">fa-bookmark</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bookmark-o"></i></div><div class="hidden-xs">fa-bookmark-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-briefcase"></i></div><div class="hidden-xs">fa-briefcase</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bug"></i></div><div class="hidden-xs">fa-bug</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-building"></i></div><div class="hidden-xs">fa-building</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-building-o"></i></div><div class="hidden-xs">fa-building-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bullhorn"></i></div><div class="hidden-xs">fa-bullhorn</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bullseye"></i></div><div class="hidden-xs">fa-bullseye</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cab"></i></div><div class="hidden-xs">fa-cab <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-calendar"></i></div><div class="hidden-xs">fa-calendar</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-calendar-o"></i></div><div class="hidden-xs">fa-calendar-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-camera"></i></div><div class="hidden-xs">fa-camera</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-camera-retro"></i></div><div class="hidden-xs">fa-camera-retro</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-car"></i></div><div class="hidden-xs">fa-car</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-caret-square-o-down"></i></div><div class="hidden-xs">fa-caret-square-o-down</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-caret-square-o-left"></i></div><div class="hidden-xs">fa-caret-square-o-left</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-caret-square-o-right"></i></div><div class="hidden-xs">fa-caret-square-o-right</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-caret-square-o-up"></i></div><div class="hidden-xs">fa-caret-square-o-up</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-certificate"></i></div><div class="hidden-xs">fa-certificate</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-check"></i></div><div class="hidden-xs">fa-check</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-check-circle"></i></div><div class="hidden-xs">fa-check-circle</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-check-circle-o"></i></div><div class="hidden-xs">fa-check-circle-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-check-square"></i></div><div class="hidden-xs">fa-check-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-check-square-o"></i></div><div class="hidden-xs">fa-check-square-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-child"></i></div><div class="hidden-xs">fa-child</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-circle"></i></div><div class="hidden-xs">fa-circle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-circle-o"></i></div><div class="hidden-xs">fa-circle-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-circle-o-notch"></i></div><div class="hidden-xs">fa-circle-o-notch</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-circle-thin"></i></div><div class="hidden-xs">fa-circle-thin</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-clock-o"></i></div><div class="hidden-xs">fa-clock-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cloud"></i></div><div class="hidden-xs">fa-cloud</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cloud-download"></i></div><div class="hidden-xs">fa-cloud-download</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cloud-upload"></i></div><div class="hidden-xs">fa-cloud-upload</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-code"></i></div><div class="hidden-xs">fa-code</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-code-fork"></i></div><div class="hidden-xs">fa-code-fork</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-coffee"></i></div><div class="hidden-xs">fa-coffee</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cog"></i></div><div class="hidden-xs">fa-cog</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cogs"></i></div><div class="hidden-xs">fa-cogs</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-comment"></i></div><div class="hidden-xs">fa-comment</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-comment-o"></i></div><div class="hidden-xs">fa-comment-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-comments"></i></div><div class="hidden-xs">fa-comments</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-comments-o"></i></div><div class="hidden-xs">fa-comments-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-compass"></i></div><div class="hidden-xs">fa-compass</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-credit-card"></i></div><div class="hidden-xs">fa-credit-card</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-crop"></i></div><div class="hidden-xs">fa-crop</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-crosshairs"></i></div><div class="hidden-xs">fa-crosshairs</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cube"></i></div><div class="hidden-xs">fa-cube</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cubes"></i></div><div class="hidden-xs">fa-cubes</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cutlery"></i></div><div class="hidden-xs">fa-cutlery</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-dashboard"></i></div><div class="hidden-xs">fa-dashboard <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-database"></i></div><div class="hidden-xs">fa-database</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-desktop"></i></div><div class="hidden-xs">fa-desktop</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-dot-circle-o"></i></div><div class="hidden-xs">fa-dot-circle-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-download"></i></div><div class="hidden-xs">fa-download</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-edit"></i></div><div class="hidden-xs">fa-edit <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-ellipsis-h"></i></div><div class="hidden-xs">fa-ellipsis-h</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-ellipsis-v"></i></div><div class="hidden-xs">fa-ellipsis-v</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-envelope"></i></div><div class="hidden-xs">fa-envelope</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-envelope-o"></i></div><div class="hidden-xs">fa-envelope-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-envelope-square"></i></div><div class="hidden-xs">fa-envelope-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-eraser"></i></div><div class="hidden-xs">fa-eraser</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-exchange"></i></div><div class="hidden-xs">fa-exchange</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-exclamation"></i></div><div class="hidden-xs">fa-exclamation</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-exclamation-circle"></i></div><div class="hidden-xs">fa-exclamation-circle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-exclamation-triangle"></i></div><div class="hidden-xs">fa-exclamation-triangle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-external-link"></i></div><div class="hidden-xs">fa-external-link</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-external-link-square"></i></div><div class="hidden-xs">fa-external-link-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-eye"></i></div><div class="hidden-xs">fa-eye</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-eye-slash"></i></div><div class="hidden-xs">fa-eye-slash</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-fax"></i></div><div class="hidden-xs">fa-fax</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-female"></i></div><div class="hidden-xs">fa-female</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-fighter-jet"></i></div><div class="hidden-xs">fa-fighter-jet</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-archive-o"></i></div><div class="hidden-xs">fa-file-archive-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-audio-o"></i></div><div class="hidden-xs">fa-file-audio-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-code-o"></i></div><div class="hidden-xs">fa-file-code-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-excel-o"></i></div><div class="hidden-xs">fa-file-excel-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-image-o"></i></div><div class="hidden-xs">fa-file-image-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-movie-o"></i></div><div class="hidden-xs">fa-file-movie-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-pdf-o"></i></div><div class="hidden-xs">fa-file-pdf-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-photo-o"></i></div><div class="hidden-xs">fa-file-photo-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-picture-o"></i></div><div class="hidden-xs">fa-file-picture-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-powerpoint-o"></i></div><div class="hidden-xs">fa-file-powerpoint-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-sound-o"></i></div><div class="hidden-xs">fa-file-sound-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-video-o"></i></div><div class="hidden-xs">fa-file-video-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-word-o"></i></div><div class="hidden-xs">fa-file-word-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-zip-o"></i></div><div class="hidden-xs">fa-file-zip-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-film"></i></div><div class="hidden-xs">fa-film</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-filter"></i></div><div class="hidden-xs">fa-filter</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-fire"></i></div><div class="hidden-xs">fa-fire</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-fire-extinguisher"></i></div><div class="hidden-xs">fa-fire-extinguisher</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-flag"></i></div><div class="hidden-xs">fa-flag</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-flag-checkered"></i></div><div class="hidden-xs">fa-flag-checkered</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-flag-o"></i></div><div class="hidden-xs">fa-flag-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-flash"></i></div><div class="hidden-xs">fa-flash <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-flask"></i></div><div class="hidden-xs">fa-flask</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-folder"></i></div><div class="hidden-xs">fa-folder</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-folder-o"></i></div><div class="hidden-xs">fa-folder-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-folder-open"></i></div><div class="hidden-xs">fa-folder-open</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-folder-open-o"></i></div><div class="hidden-xs">fa-folder-open-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-frown-o"></i></div><div class="hidden-xs">fa-frown-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-gamepad"></i></div><div class="hidden-xs">fa-gamepad</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-gavel"></i></div><div class="hidden-xs">fa-gavel</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-gear"></i></div><div class="hidden-xs">fa-gear <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-gears"></i></div><div class="hidden-xs">fa-gears <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-gift"></i></div><div class="hidden-xs">fa-gift</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-glass"></i></div><div class="hidden-xs">fa-glass</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-globe"></i></div><div class="hidden-xs">fa-globe</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-group"></i></div><div class="hidden-xs">fa-group <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-hdd-o"></i></div><div class="hidden-xs">fa-hdd-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-headphones"></i></div><div class="hidden-xs">fa-headphones</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-heart"></i></div><div class="hidden-xs">fa-heart</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-heart-o"></i></div><div class="hidden-xs">fa-heart-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-history"></i></div><div class="hidden-xs">fa-history</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-home"></i></div><div class="hidden-xs">fa-home</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-inbox"></i></div><div class="hidden-xs">fa-inbox</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-info"></i></div><div class="hidden-xs">fa-info</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-info-circle"></i></div><div class="hidden-xs">fa-info-circle</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-institution"></i></div><div class="hidden-xs">fa-institution <span class="text-muted">alias</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-key"></i></div><div class="hidden-xs">fa-key</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-keyboard-o"></i></div><div class="hidden-xs">fa-keyboard-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-language"></i></div><div class="hidden-xs">fa-language</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-laptop"></i></div><div class="hidden-xs">fa-laptop</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-leaf"></i></div><div class="hidden-xs">fa-leaf</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-legal"></i></div><div class="hidden-xs">fa-legal <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-lemon-o"></i></div><div class="hidden-xs">fa-lemon-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-level-down"></i></div><div class="hidden-xs">fa-level-down</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-level-up"></i></div><div class="hidden-xs">fa-level-up</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-life-bouy"></i></div><div class="hidden-xs">fa-life-bouy <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-life-ring"></i></div><div class="hidden-xs">fa-life-ring</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-life-saver"></i></div><div class="hidden-xs">fa-life-saver <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-lightbulb-o"></i></div><div class="hidden-xs">fa-lightbulb-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-location-arrow"></i></div><div class="hidden-xs">fa-location-arrow</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-lock"></i></div><div class="hidden-xs">fa-lock</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-magic"></i></div><div class="hidden-xs">fa-magic</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-magnet"></i></div><div class="hidden-xs">fa-magnet</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-mail-forward"></i></div><div class="hidden-xs">fa-mail-forward <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-mail-reply"></i></div><div class="hidden-xs">fa-mail-reply <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-mail-reply-all"></i></div><div class="hidden-xs">fa-mail-reply-all</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-male"></i></div><div class="hidden-xs">fa-male</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-map-marker"></i></div><div class="hidden-xs">fa-map-marker</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-meh-o"></i></div><div class="hidden-xs">fa-meh-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-microphone"></i></div><div class="hidden-xs">fa-microphone</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-microphone-slash"></i></div><div class="hidden-xs">fa-microphone-slash</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-minus"></i></div><div class="hidden-xs">fa-minus</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-minus-circle"></i></div><div class="hidden-xs">fa-minus-circle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-minus-square"></i></div><div class="hidden-xs">fa-minus-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-minus-square-o"></i></div><div class="hidden-xs">fa-minus-square-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-mobile"></i></div><div class="hidden-xs">fa-mobile</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-mobile-phone"></i></div><div class="hidden-xs">fa-mobile-phone <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-money"></i></div><div class="hidden-xs">fa-money</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-moon-o"></i></div><div class="hidden-xs">fa-moon-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-mortar-board"></i></div><div class="hidden-xs">fa-mortar-board</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-music"></i></div><div class="hidden-xs">fa-music</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-navicon"></i></div><div class="hidden-xs">fa-navicon <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-paper-plane"></i></div><div class="hidden-xs">fa-paper-plane</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-paper-plane-o"></i></div><div class="hidden-xs">fa-paper-plane-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-paw"></i></div><div class="hidden-xs">fa-paw</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-pencil"></i></div><div class="hidden-xs">fa-pencil</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-pencil-square"></i></div><div class="hidden-xs">fa-pencil-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-pencil-square-o"></i></div><div class="hidden-xs">fa-pencil-square-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-phone"></i></div><div class="hidden-xs">fa-phone</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-phone-square"></i></div><div class="hidden-xs">fa-phone-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-photo"></i></div><div class="hidden-xs">fa-photo <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-picture-o"></i></div><div class="hidden-xs">fa-picture-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-plane"></i></div><div class="hidden-xs">fa-plane</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-plus"></i></div><div class="hidden-xs">fa-plus</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-plus-circle"></i></div><div class="hidden-xs">fa-plus-circle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-plus-square"></i></div><div class="hidden-xs">fa-plus-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-plus-square-o"></i></div><div class="hidden-xs">fa-plus-square-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-power-off"></i></div><div class="hidden-xs">fa-power-off</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-print"></i></div><div class="hidden-xs">fa-print</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-puzzle-piece"></i></div><div class="hidden-xs">fa-puzzle-piece</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-qrcode"></i></div><div class="hidden-xs">fa-qrcode</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-question"></i></div><div class="hidden-xs">fa-question</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-question-circle"></i></div><div class="hidden-xs">fa-question-circle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-quote-left"></i></div><div class="hidden-xs">fa-quote-left</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-quote-right"></i></div><div class="hidden-xs">fa-quote-right</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-random"></i></div><div class="hidden-xs">fa-random</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-refresh"></i></div><div class="hidden-xs">fa-refresh</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-reorder"></i></div><div class="hidden-xs">fa-reorder <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-reply"></i></div><div class="hidden-xs">fa-reply</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-reply-all"></i></div><div class="hidden-xs">fa-reply-all</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-retweet"></i></div><div class="hidden-xs">fa-retweet</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-road"></i></div><div class="hidden-xs">fa-road</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-rocket"></i></div><div class="hidden-xs">fa-rocket</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-rss"></i></div><div class="hidden-xs">fa-rss</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-rss-square"></i></div><div class="hidden-xs">fa-rss-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-search"></i></div><div class="hidden-xs">fa-search</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-search-minus"></i></div><div class="hidden-xs">fa-search-minus</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-search-plus"></i></div><div class="hidden-xs">fa-search-plus</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-send"></i></div><div class="hidden-xs">fa-send <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-send-o"></i></div><div class="hidden-xs">fa-send-o <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-share"></i></div><div class="hidden-xs">fa-share</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-share-square"></i></div><div class="hidden-xs">fa-share-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-share-square-o"></i></div><div class="hidden-xs">fa-share-square-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-shield"></i></div><div class="hidden-xs">fa-shield</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-shopping-cart"></i></div><div class="hidden-xs">fa-shopping-cart</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sign-in"></i></div><div class="hidden-xs">fa-sign-in</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sign-out"></i></div><div class="hidden-xs">fa-sign-out</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-signal"></i></div><div class="hidden-xs">fa-signal</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sitemap"></i></div><div class="hidden-xs">fa-sitemap</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sliders"></i></div><div class="hidden-xs">fa-sliders</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-smile-o"></i></div><div class="hidden-xs">fa-smile-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort"></i></div><div class="hidden-xs">fa-sort</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-alpha-asc"></i></div><div class="hidden-xs">fa-sort-alpha-asc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-alpha-desc"></i></div><div class="hidden-xs">fa-sort-alpha-desc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-amount-asc"></i></div><div class="hidden-xs">fa-sort-amount-asc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-amount-desc"></i></div><div class="hidden-xs">fa-sort-amount-desc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-asc"></i></div><div class="hidden-xs">fa-sort-asc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-desc"></i></div><div class="hidden-xs">fa-sort-desc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-down"></i></div><div class="hidden-xs">fa-sort-down <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-numeric-asc"></i></div><div class="hidden-xs">fa-sort-numeric-asc</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-numeric-desc"></i></div><div class="hidden-xs">fa-sort-numeric-desc</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sort-up"></i></div><div class="hidden-xs">fa-sort-up <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-space-shuttle"></i></div><div class="hidden-xs">fa-space-shuttle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-spinner"></i></div><div class="hidden-xs">fa-spinner</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-spoon"></i></div><div class="hidden-xs">fa-spoon</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-square"></i></div><div class="hidden-xs">fa-square</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-square-o"></i></div><div class="hidden-xs">fa-square-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-star"></i></div><div class="hidden-xs">fa-star</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-star-half"></i></div><div class="hidden-xs">fa-star-half</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-star-half-empty"></i></div><div class="hidden-xs">fa-star-half-empty <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-star-half-full"></i></div><div class="hidden-xs">fa-star-half-full <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-star-half-o"></i></div><div class="hidden-xs">fa-star-half-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-star-o"></i></div><div class="hidden-xs">fa-star-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-subscript"></i></div><div class="hidden-xs">fa-subscript</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-suitcase"></i></div><div class="hidden-xs">fa-suitcase</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-sun-o"></i></div><div class="hidden-xs">fa-sun-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-support"></i></div><div class="hidden-xs">fa-support <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-superscript"></i></div><div class="hidden-xs">fa-superscript</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tablet"></i></div><div class="hidden-xs">fa-tablet</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tachometer"></i></div><div class="hidden-xs">fa-tachometer</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tag"></i></div><div class="hidden-xs">fa-tag</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tags"></i></div><div class="hidden-xs">fa-tags</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tasks"></i></div><div class="hidden-xs">fa-tasks</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-taxi"></i></div><div class="hidden-xs">fa-taxi</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-terminal"></i></div><div class="hidden-xs">fa-terminal</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-thumb-tack"></i></div><div class="hidden-xs">fa-thumb-tack</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-thumbs-down"></i></div><div class="hidden-xs">fa-thumbs-down</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-thumbs-o-down"></i></div><div class="hidden-xs">fa-thumbs-o-down</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-thumbs-o-up"></i></div><div class="hidden-xs">fa-thumbs-o-up</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-thumbs-up"></i></div><div class="hidden-xs">fa-thumbs-up</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-ticket"></i></div><div class="hidden-xs">fa-ticket</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-times"></i></div><div class="hidden-xs">fa-times</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-times-circle"></i></div><div class="hidden-xs">fa-times-circle</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-times-circle-o"></i></div><div class="hidden-xs">fa-times-circle-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tint"></i></div><div class="hidden-xs">fa-tint</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-toggle-down"></i></div><div class="hidden-xs">fa-toggle-down <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-toggle-left"></i></div><div class="hidden-xs">fa-toggle-left <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-toggle-right"></i></div><div class="hidden-xs">fa-toggle-right <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-toggle-up"></i></div><div class="hidden-xs">fa-toggle-up <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-trash-o"></i></div><div class="hidden-xs">fa-trash-o</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-tree"></i></div><div class="hidden-xs">fa-tree</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-trophy"></i></div><div class="hidden-xs">fa-trophy</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-truck"></i></div><div class="hidden-xs">fa-truck</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-umbrella"></i></div><div class="hidden-xs">fa-umbrella</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-university"></i></div><div class="hidden-xs">fa-university</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-unlock"></i></div><div class="hidden-xs">fa-unlock</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-unlock-alt"></i></div><div class="hidden-xs">fa-unlock-alt</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-unsorted"></i></div><div class="hidden-xs">fa-unsorted <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-upload"></i></div><div class="hidden-xs">fa-upload</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-user"></i></div><div class="hidden-xs">fa-user</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-users"></i></div><div class="hidden-xs">fa-users</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-video-camera"></i></div><div class="hidden-xs">fa-video-camera</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-volume-down"></i></div><div class="hidden-xs">fa-volume-down</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-volume-off"></i></div><div class="hidden-xs">fa-volume-off</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-volume-up"></i></div><div class="hidden-xs">fa-volume-up</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-warning"></i></div><div class="hidden-xs">fa-warning <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-wheelchair"></i></div><div class="hidden-xs">fa-wheelchair</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-wrench"></i></div><div class="hidden-xs">fa-wrench</div></td>
				                                    <td colspan="6"></td>
				                                </tr>
				                            </tbody>
				                        </table>
				                    </div>
						    	</div>
						    </div>
		                </div>
		                <div class="tab-pane fade" id="default-tab-2">
						    <div class="row">
						        <div class="col-md-12">
						        	<div class="panel panel-inverse" data-sortable-id="ui-icons-8">
						                <div class="panel-body">
						                    <div class="table-responsive">
						                        <table class="table table-bordered m-b-0">
						                            <tr>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file"></i></div><div class="hidden-xs">fa-file</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-archive-o"></i></div><div class="hidden-xs">fa-file-archive-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-audio-o"></i></div><div class="hidden-xs">fa-file-audio-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-code-o"></i></div><div class="hidden-xs">fa-file-code-o</div></td>
						                            </tr>
						                            <tr>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-excel-o"></i></div><div class="hidden-xs">fa-file-excel-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-image-o"></i></div><div class="hidden-xs">fa-file-image-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-movie-o"></i></div><div class="hidden-xs">fa-file-movie-o <span class="text-muted">(alias)</span></div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-o"></i></div><div class="hidden-xs">fa-file-o</div></td>
						                            </tr>
						                            <tr>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-pdf-o"></i></div><div class="hidden-xs">fa-file-pdf-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-photo-o"></i></div><div class="hidden-xs">fa-file-photo-o <span class="text-muted">(alias)</span></div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-picture-o"></i></div><div class="hidden-xs">fa-file-picture-o <span class="text-muted">(alias)</span></div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-powerpoint-o"></i></div><div class="hidden-xs">fa-file-powerpoint-o</div></td>
						                            </tr>
						                            <tr>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-sound-o"></i></div><div class="hidden-xs">fa-file-sound-o <span class="text-muted">(alias)</span></div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-text"></i></div><div class="hidden-xs">fa-file-text</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-text-o"></i></div><div class="hidden-xs">fa-file-text-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-video-o"></i></div><div class="hidden-xs">fa-file-video-o</div></td>
						                            </tr>
						                            <tr>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-word-o"></i></div><div class="hidden-xs">fa-file-word-o</div></td>
						                                <td class="text-center"><div><i class="fa fa-2x fa-file-zip-o"></i></div><div class="hidden-xs">fa-file-zip-o <span class="text-muted">(alias)</span></div></td>
						                                <td colspan="2"></td>
						                            </tr>
						                        </table>
						                    </div>
						                </div>
						            </div>
						    	</div>
						    </div>
		                </div>
		                <div class="tab-pane fade" id="default-tab-3">
		                	<div class="row">
						        <div class="col-md-12">
						        	<div class="table-responsive">
				                        <table class="table table-bordered m-b-0">
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-adn"></i></div><div class="hidden-xs">fa-adn</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-android"></i></div><div class="hidden-xs">fa-android</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-apple"></i></div><div class="hidden-xs">fa-apple</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-behance"></i></div><div class="hidden-xs">fa-behance</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-behance-square"></i></div><div class="hidden-xs">fa-behance-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-bitbucket"></i></div><div class="hidden-xs">fa-bitbucket</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-bitbucket-square"></i></div><div class="hidden-xs">fa-bitbucket-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-bitcoin"></i></div><div class="hidden-xs">fa-bitcoin <span class="text-muted">(alias)</span></div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-btc"></i></div><div class="hidden-xs">fa-btc</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-codepen"></i></div><div class="hidden-xs">fa-codepen</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-css3"></i></div><div class="hidden-xs">fa-css3</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-delicious"></i></div><div class="hidden-xs">fa-delicious</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-deviantart"></i></div><div class="hidden-xs">fa-deviantart</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-digg"></i></div><div class="hidden-xs">fa-digg</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-dribbble"></i></div><div class="hidden-xs">fa-dribbble</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-dropbox"></i></div><div class="hidden-xs">fa-dropbox</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-drupal"></i></div><div class="hidden-xs">fa-drupal</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-empire"></i></div><div class="hidden-xs">fa-empire</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-facebook"></i></div><div class="hidden-xs">fa-facebook</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-facebook-square"></i></div><div class="hidden-xs">fa-facebook-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-flickr"></i></div><div class="hidden-xs">fa-flickr</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-foursquare"></i></div><div class="hidden-xs">fa-foursquare</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-ge"></i></div><div class="hidden-xs">fa-ge <span class="text-muted">(alias)</span></div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-git"></i></div><div class="hidden-xs">fa-git</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-git-square"></i></div><div class="hidden-xs">fa-git-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-github"></i></div><div class="hidden-xs">fa-github</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-github-alt"></i></div><div class="hidden-xs">fa-github-alt</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-github-square"></i></div><div class="hidden-xs">fa-github-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-gittip"></i></div><div class="hidden-xs">fa-gittip</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-google"></i></div><div class="hidden-xs">fa-google</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-google-plus"></i></div><div class="hidden-xs">fa-google-plus</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-google-plus-square"></i></div><div class="hidden-xs">fa-google-plus-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-hacker-news"></i></div><div class="hidden-xs">fa-hacker-news</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-html5"></i></div><div class="hidden-xs">fa-html5</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-instagram"></i></div><div class="hidden-xs">fa-instagram</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-joomla"></i></div><div class="hidden-xs">fa-joomla</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-jsfiddle"></i></div><div class="hidden-xs">fa-jsfiddle</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-linkedin"></i></div><div class="hidden-xs">fa-linkedin</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-linkedin-square"></i></div><div class="hidden-xs">fa-linkedin-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-linux"></i></div><div class="hidden-xs">fa-linux</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-maxcdn"></i></div><div class="hidden-xs">fa-maxcdn</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-openid"></i></div><div class="hidden-xs">fa-openid</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-pagelines"></i></div><div class="hidden-xs">fa-pagelines</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-pied-piper"></i></div><div class="hidden-xs">fa-pied-piper</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-pied-piper-alt"></i></div><div class="hidden-xs">fa-pied-piper-alt</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-pied-piper-square"></i></div><div class="hidden-xs">fa-pied-piper-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-pinterest"></i></div><div class="hidden-xs">fa-pinterest</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-pinterest-square"></i></div><div class="hidden-xs">fa-pinterest-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-qq"></i></div><div class="hidden-xs">fa-qq</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-ra"></i></div><div class="hidden-xs">fa-ra <span class="text-muted">(alias)</span></div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-rebel"></i></div><div class="hidden-xs">fa-rebel</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-reddit"></i></div><div class="hidden-xs">fa-reddit</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-reddit-square"></i></div><div class="hidden-xs">fa-reddit-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-renren"></i></div><div class="hidden-xs">fa-renren</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-share-alt"></i></div><div class="hidden-xs">fa-share-alt</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-share-alt-square"></i></div><div class="hidden-xs">fa-share-alt-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-skype"></i></div><div class="hidden-xs">fa-skype</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-slack"></i></div><div class="hidden-xs">fa-slack</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-soundcloud"></i></div><div class="hidden-xs">fa-soundcloud</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-spotify"></i></div><div class="hidden-xs">fa-spotify</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-stack-exchange"></i></div><div class="hidden-xs">fa-stack-exchange</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-stack-overflow"></i></div><div class="hidden-xs">fa-stack-overflow</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-steam"></i></div><div class="hidden-xs">fa-steam</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-steam-square"></i></div><div class="hidden-xs">fa-steam-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-stumbleupon"></i></div><div class="hidden-xs">fa-stumbleupon</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-stumbleupon-circle"></i></div><div class="hidden-xs">fa-stumbleupon-circle</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-tencent-weibo"></i></div><div class="hidden-xs">fa-tencent-weibo</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-trello"></i></div><div class="hidden-xs">fa-trello</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-tumblr"></i></div><div class="hidden-xs">fa-tumblr</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-tumblr-square"></i></div><div class="hidden-xs">fa-tumblr-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-twitter"></i></div><div class="hidden-xs">fa-twitter</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-twitter-square"></i></div><div class="hidden-xs">fa-twitter-square</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-vimeo-square"></i></div><div class="hidden-xs">fa-vimeo-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-vine"></i></div><div class="hidden-xs">fa-vine</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-vk"></i></div><div class="hidden-xs">fa-vk</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-wechat"></i></div><div class="hidden-xs">fa-wechat <span class="text-muted">(alias)</span></div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-weibo"></i></div><div class="hidden-xs">fa-weibo</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-weixin"></i></div><div class="hidden-xs">fa-weixin</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-windows"></i></div><div class="hidden-xs">fa-windows</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-wordpress"></i></div><div class="hidden-xs">fa-wordpress</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-xing"></i></div><div class="hidden-xs">fa-xing</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-xing-square"></i></div><div class="hidden-xs">fa-xing-square</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-yahoo"></i></div><div class="hidden-xs">fa-yahoo</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-youtube"></i></div><div class="hidden-xs">fa-youtube</div></td>
				                            </tr>
				                            <tr>
				                                <td class="text-center"><div><i class="fa fa-2x fa-youtube-play"></i></div><div class="hidden-xs">fa-youtube-play</div></td>
				                                <td class="text-center"><div><i class="fa fa-2x fa-youtube-square"></i></div><div class="hidden-xs">fa-youtube-square</div></td>
				                                <td colspan="2"></td>
				                            </tr>
				                        </table>
				                    </div>
						    	</div>
						    </div>
		                </div>
		                <div class="tab-pane fade" id="default-tab-4">
		                	<div class="row">
						        <div class="col-md-12">
						        	<div class="table-responsive">
				                        <table class="table table-bordered m-b-0">
				                            <tbody>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-align-center"></i></div><div class="hidden-xs">fa-align-center</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-align-justify"></i></div><div class="hidden-xs">fa-align-justify</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-align-left"></i></div><div class="hidden-xs">fa-align-left</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-align-right"></i></div><div class="hidden-xs">fa-align-right</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-bold"></i></div><div class="hidden-xs">fa-bold</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-chain"></i></div><div class="hidden-xs">fa-chain <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-chain-broken"></i></div><div class="hidden-xs">fa-chain-broken</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-clipboard"></i></div><div class="hidden-xs">fa-clipboard</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-columns"></i></div><div class="hidden-xs">fa-columns</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-copy"></i></div><div class="hidden-xs">fa-copy <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-cut"></i></div><div class="hidden-xs">fa-cut <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-dedent"></i></div><div class="hidden-xs">fa-dedent <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-eraser"></i></div><div class="hidden-xs">fa-eraser</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file"></i></div><div class="hidden-xs">fa-file</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-o"></i></div><div class="hidden-xs">fa-file-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-text"></i></div><div class="hidden-xs">fa-file-text</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-file-text-o"></i></div><div class="hidden-xs">fa-file-text-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-files-o"></i></div><div class="hidden-xs">fa-files-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-floppy-o"></i></div><div class="hidden-xs">fa-floppy-o</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-font"></i></div><div class="hidden-xs">fa-font</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-header"></i></div><div class="hidden-xs">fa-header</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-indent"></i></div><div class="hidden-xs">fa-indent</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-italic"></i></div><div class="hidden-xs">fa-italic</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-link"></i></div><div class="hidden-xs">fa-link</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-list"></i></div><div class="hidden-xs">fa-list</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-list-alt"></i></div><div class="hidden-xs">fa-list-alt</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-list-ol"></i></div><div class="hidden-xs">fa-list-ol</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-list-ul"></i></div><div class="hidden-xs">fa-list-ul</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-outdent"></i></div><div class="hidden-xs">fa-outdent</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-paperclip"></i></div><div class="hidden-xs">fa-paperclip</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-paragraph"></i></div><div class="hidden-xs">fa-paragraph</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-paste"></i></div><div class="hidden-xs">fa-paste <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-repeat"></i></div><div class="hidden-xs">fa-repeat</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-rotate-left"></i></div><div class="hidden-xs">fa-rotate-left <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-rotate-right"></i></div><div class="hidden-xs">fa-rotate-right <span class="text-muted">(alias)</span></div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-save"></i></div><div class="hidden-xs">fa-save <span class="text-muted">(alias)</span></div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-scissors"></i></div><div class="hidden-xs">fa-scissors</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-strikethrough"></i></div><div class="hidden-xs">fa-strikethrough</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-subscript"></i></div><div class="hidden-xs">fa-subscript</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-superscript"></i></div><div class="hidden-xs">fa-superscript</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-table"></i></div><div class="hidden-xs">fa-table</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-text-height"></i></div><div class="hidden-xs">fa-text-height</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-text-width"></i></div><div class="hidden-xs">fa-text-width</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-th"></i></div><div class="hidden-xs">fa-th</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-th-large"></i></div><div class="hidden-xs">fa-th-large</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-th-list"></i></div><div class="hidden-xs">fa-th-list</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-underline"></i></div><div class="hidden-xs">fa-underline</div></td>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-undo"></i></div><div class="hidden-xs">fa-undo</div></td>
				                                </tr>
				                                <tr>
				                                    <td class="text-center"><div><i class="fa fa-2x fa-unlink"></i></div><div class="hidden-xs">fa-unlink <span class="text-muted">(alias)</span></div></td>
				                                    <td></td>
				                                    <td></td>
				                                    <td></td>
				                                </tr>
				                            </tbody>
				                        </table>
				                    </div>
						    	</div>
						    </div>
		                </div>
		            </div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../assets/plugins/jstree/dist/jstree.js?v4"></script>
<script type="text/javascript" src="../assets/js/support/system/permission-list.js"></script>
