<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<!--[if IE 8]> <html lang="zh-cn" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-cn">
<!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<title id="page-title">TINKER | HOME</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link rel="shortcut icon" type="images/x-icon" href="../assets/img/favicon.png">
	<link href="../assets/css/googles.fonts.css" rel="stylesheet" />
	<link href="../assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
	<link href="../assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../assets/plugins/font-awesome/css/font-awesome.min.css?v1" rel="stylesheet" />
	<link href="../assets/css/animate.min.css" rel="stylesheet" />
	<link href="../assets/css/style.min.css?v4" rel="stylesheet" />
	<link href="../assets/css/style-responsive.min.css" rel="stylesheet" />
	<link href="../assets/css/theme/default.css?v1" rel="stylesheet" id="theme" />
	<link href="../assets/plugins/DataTables/media/css/dataTables.bootstrap.min.css" rel="stylesheet" />
	<link href="../assets/plugins/DataTables/extensions/Buttons/css/buttons.bootstrap.min.css" rel="stylesheet" />
	<link href="../assets/plugins/DataTables/extensions/Responsive/css/responsive.bootstrap.min.css" rel="stylesheet" />
	<link href="../assets/plugins/DataTables/extensions/Select/css/select.dataTables.min.css" rel="stylesheet" />
	<link href="../assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css?v1" rel="stylesheet" />
	<link href="../assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" />
	<link href="../assets/plugins/bootstrap-sweetalert/sweetalert.css?v1" rel="stylesheet" />
	<link href="../assets/css/style.custom.css?v6" rel="stylesheet" />
	<link href="../assets/plugins/select2/dist/css/select2.css?v1" rel="stylesheet" />
	<link href="../assets/plugins/dropzone/basic.css?v1" rel="stylesheet" >
	<link href="../assets/plugins/dropzone/dropzone.css?v5" rel="stylesheet">
</head>
<body>
	<!-- begin #page-loader -->
	<div id="page-loader" class="fade in"><span class="spinner"></span></div>
	<!-- end #page-loader -->
	
	<!-- begin #page-container -->
	<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
		<!-- begin #header -->
		<div id="header" class="header navbar navbar-default navbar-fixed-top">
			<!-- begin container-fluid -->
			<div class="container-fluid">
				<!-- begin mobile sidebar expand / collapse button -->
				<div class="navbar-header">
					<a href="javascipt:void(0);" class="navbar-brand">Tinker Admin</a>
					<button type="button" class="navbar-toggle" data-click="sidebar-toggled">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- end mobile sidebar expand / collapse button -->
				
				<!-- begin header navigation right -->
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown navbar-user">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-user text-default fa-lg"></i>
							&nbsp;&nbsp;
							<span class="hidden-xs">个人设置</span> <b class="caret"></b>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</a>
						<ul class="dropdown-menu animated fadeInLeft">
							<li class="arrow"></li>
							<li><a href="javascript:;" onclick="_YGewJm41_openResetPasswordModal()">修改密码</a></li>
							<li class="divider"></li>
							<li><a href="javascript:;" onclick="_YGewJm41_logout()">退出登录</a></li>
						</ul>
					</li>
				</ul>
				<!-- end header navigation right -->
			</div>
			<!-- end container-fluid -->
		</div>
		<!-- end #header -->
		
		<!-- begin #sidebar -->
		<div id="sidebar" class="sidebar">
			<!-- begin sidebar scrollbar -->
			<div data-scrollbar="true" data-height="100%">
				<!-- begin sidebar user -->
				<ul class="nav">
					<li class="nav-profile">
						<div class="image">
							<a href="javascript:;"><img src="../assets/img/tinker.jpg" alt="" /></a>
						</div>
						<div class="info" id="userName-97702de7842a27b947bb590518822544">
						</div>
					</li>
				</ul>
				<!-- end sidebar user -->
				<!-- begin sidebar nav -->
				<ul class="nav" id="nav-menu-list">
				</ul>
				<!-- end sidebar nav -->
			</div>
			<!-- end sidebar scrollbar -->
		</div>
		<div class="sidebar-bg"></div>
		<!-- end #sidebar -->
		
		<!-- begin #ajax-content -->
		<div id="ajax-content"></div>
		<!-- end #ajax-content -->
		
		<!-- begin scroll to top btn -->
		<a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
		<!-- end scroll to top btn -->
	</div>
	<!-- end page container -->
	
	
	<div class="modal fade" id="modal-97702de7842a27b947bb590518822544">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">密码重置</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="form-97702de7842a27b947bb590518822544">
							<div class="form-group">
								<label class="col-md-2 control-label">新密码</label>
								<div class="col-md-10">
									<input type="password" id="password-new-97702de7842a27b947bb590518822544" name="password-new-97702de7842a27b947bb590518822544" class="form-control" placeholder="8-16位字母+数字" autocomplete="off"  />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">确认密码</label>
								<div class="col-md-10">
									<input type="password" id="re-password-new-97702de7842a27b947bb590518822544" name="re-password-new-97702de7842a27b947bb590518822544" class="form-control" placeholder="" autocomplete="off" />
								</div>
							</div>
						</form>
				</div>
				<div class="modal-footer">
					<a href="javascript:;" class="btn btn-sm btn-white" data-dismiss="modal">取消</a>
					<a href="javascript:;" id="btn-save-password" class="btn btn-sm btn-success" onclick="_YGewJm41_resetPassword()">保存</a>
				</div>
			</div>
		</div>
	</div>
	
	
	<script src="../assets/plugins/pace/pace.min.js"></script>
	<script src="../assets/plugins/jquery/jquery-1.9.1.min.js"></script>
	<script src="../assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
	<script src="../assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
	<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!--[if lt IE 9]>
		<script src="../assets/crossbrowserjs/html5shiv.min.js"></script>
		<script src="../assets/crossbrowserjs/respond.min.js"></script>
		<script src="../assets/crossbrowserjs/excanvas.min.js"></script>
	<![endif]-->
	<script src="../assets/plugins/jquery-hashchange/jquery.hashchange.min.js"></script>
	<script src="../assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/plugins/jquery-cookie/jquery.cookie.min.js"></script>
	
	<!-- ================== PLUGINS JS ================== -->
	<script type="text/javascript" src="../assets/plugins/DataTables/media/js/jquery.dataTables.min.js?v2"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/media/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Buttons/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Buttons/js/buttons.bootstrap.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Buttons/js/buttons.print.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Buttons/js/buttons.flash.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Buttons/js/buttons.html5.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Buttons/js/buttons.colVis.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Responsive/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/DataTables/extensions/Select/js/dataTables.select.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/validate/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/validate/js/messages_zh.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/gritter/js/jquery.gritter.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/bootstrap-sweetalert/sweetalert.min.js?v1"></script>
	<script type="text/javascript" src="../assets/plugins/select2/dist/js/select2.full.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/bootstrap-daterangepicker/moment.min.js?v1"></script>
	<script type="text/javascript" src="../assets/plugins/bootstrap-daterangepicker/daterangepicker.min.js"></script>
	<script type="text/javascript" src="../assets/plugins/dropzone/dropzone.min.js" ></script>
	<!-- ================== END PLUGINS JS ================== -->
	
	<!-- ================== CUSTOM JS ================== -->
	<script type="text/javascript" src="../assets/js/custom/plugin/select2.custom.min.js?v3"></script>
	<script type="text/javascript" src="../assets/js/custom/plugin/daterangepicker.custom.min.js?v2"></script>
	<script type="text/javascript" src="../assets/js/custom/plugin/jquery.datatable.custom.min.js?v4"></script>
	<script type="text/javascript" src="../assets/js/custom/plugin/dropzone.custom.min.js" ></script>	
	<script type="text/javascript" src="../assets/js/custom/custom.min.js"></script>
	<script type="text/javascript" src="../assets/js/custom/ajaxHelper.min.js"></script>
	<script type="text/javascript" src="../assets/js/custom/redirect.min.js"></script>
	<script type="text/javascript" src="../assets/js/custom/form.min.js"></script>
	<script type="text/javascript" src="../assets/js/custom/modal.min.js"></script>
	<script type="text/javascript" src="../assets/js/custom/confirm.min.js"></script>
	<script type="text/javascript" src="../assets/js/custom/notification.min.js"></script>
	<script type="text/javascript" src="../assets/js/apps.min.js"></script>
	<!-- ================== CUSTOM JS ================== -->
	
	<script>
		var _YGewJm41_menus = '${USER_MENUS}';
		var _YGewJm41_userBaseInfo = '${USER_BASE_INFO}';
		$(function(){
			_YGewJm41_initUserNameDisplay(_YGewJm41_userBaseInfo);
			_YGewJm41_initMenu(_YGewJm41_menus);
		});
	</script>
	<script type="text/javascript" src="../assets/js/support/index.js"></script>
</body>
</html>
