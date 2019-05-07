<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('daterangpicker-demo');
</script>

<!-- ================== END PAGE LEVEL JS ================== -->
<script type="text/javascript">
$(function(){
	$("#daterangepicker-default").buildPicker();
	
	$("#daterangepicker-with-time").buildPicker({
		timePicker : true,
		timePickerSeconds : true
	});
	
	$("#daterangepicker-single").buildPicker({
		"single" : true
	});
});

</script>
		
<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">plugins</a></li>
        <li class="active">daterangepicker-demo</li>
    </ol>
    <!-- end breadcrumb -->
    
    <!-- begin row -->
    <div class="row">
        <!-- begin col-12 -->
        <div class="col-md-12">
	        <div class="col-md-12">
	            <!-- begin panel -->
	            <div class="panel panel-inverse" >
	                <div class="panel-heading">
	                    <div class="panel-heading-btn">
	                    	<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
	                    </div>
	                    <h4 class="panel-title">默认</h4>
	                </div>
	                <div class="panel-body">
		                <form class="form-horizontal col-md-8">
		                	<div class="form-group">
								<label class="col-md-2 control-label">range default</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="daterangepicker-default" name="daterangepicker-default" placeholder="请选择起始时间" readonly="readonly" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">range with time</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="daterangepicker-with-time" name="daterangepicker-with-time" placeholder="请选择起始时间" readonly="readonly"  />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">single</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="daterangepicker-single" name="daterangepicker-single" placeholder="请选择起始时间" readonly="readonly" />
								</div>
							</div>
		                </form>
	                </div>
	            </div>
	            <!-- end panel -->
	        </div>
        </div>
    </div>
    <!-- end row -->
</div>
<!-- end #content -->