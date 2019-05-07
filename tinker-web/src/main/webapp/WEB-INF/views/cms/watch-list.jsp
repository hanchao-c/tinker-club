<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('商品清单 - 手表管理');
</script>
<!-- ================== END PAGE LEVEL JS ================== -->
		
<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">商品清单</a></li>
        <li class="active">手表管理</li>
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
                    <h4 class="panel-title">手表列表</h4>
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
<script type="text/javascript" src="../assets/js/support/cms/watch-list.js"></script>