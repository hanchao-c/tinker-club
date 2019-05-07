<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('订单管理 - 未完成订单');
</script>
<!-- ================== END PAGE LEVEL JS ================== -->
<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">订单管理</a></li>
        <li class="active">未完成订单</li>
    </ol>
    <!-- end breadcrumb -->
    
    <!-- begin row -->
    <div class="row">
        <!-- begin col-12 -->
        <div class="col-md-12">
            <!-- begin panel -->
            <div class="panel panel-inverse">
                <div class="panel-heading">
                    <h4 class="panel-title">未完成订单列表</h4>
                </div>
                <div class="panel-body">
                	<div class="col-md-4">
	                	<div class="btn-group">
	                    	<a class="btn btn-info" href="javascript:;" onclick="selectAll()" >全选</a>
	                    	<a class="btn btn-info" href="javascript:;" onclick="deselectAll()" >全不选</a>
	                    	<a class="btn btn-info" href="javascript:;" onclick="selectByCondition()" >选中金额大于15的记录</a>
	                    	<a class="btn btn-info" href="javascript:;" onclick="amountSummary()" >金额统计</a>
	                    </div>
                	</div>
                	<div class="col-md-3">
                		<div class="form-group form-horizontal">
							<label class="col-md-4 control-label">支付状态</label>
							<div class="col-md-8">
								<select class=" form-control" id="payState" name="payState" >
								 	  <option value="SUCCESS">支付成功</option>
									  <option value="FAIL">支付失败</option>
									  <option value="WAITING_FOR">待支付</option>
									  <option value="CLOSED">支付关闭</option>
								</select>
							</div>
						</div>
                	</div>
                	<div class="col-md-3">
                		<div class="form-group form-horizontal">
							<label class="col-md-4 control-label">订单状态</label>
							<div class="col-md-8">
								<select class=" form-control" id="orderState" name="orderState" >
								 	  <option value="OPEN">开启</option>
									  <option value="STOP">暂停</option>
									  <option value="DELAY">延时</option>
									  <option value="CLOSE">关闭</option>
									  <option value="UN_KNOW">未知</option>
								</select>
							</div>
						</div>
                	</div>
                    <table id="data-table" class="table table-striped table-bordered" style="width: 100%;"></table>
                </div>
            </div>
            <!-- end panel -->
        </div>
        <!-- end col-12 -->
    </div>
    <!-- end row -->
</div>
<script type="text/javascript" src="../assets/js/support/cms/uncompleted-order-list.js"></script>
