<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('商品清单 - 手表展示');
</script>
<!-- ================== END PAGE LEVEL JS ================== -->

<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">商品清单</a></li>
        <li class="active">手表展示</li>
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
                    <h4 class="panel-title">手表详情</h4>
                </div>
                <div class="panel-body">
                	<form class="form-horizontal" id="form">
                		<input type="hidden" id="id">
						<div class="form-group">
							<label class="col-md-2 control-label">主题</label>
							<div class="col-md-6">
								<input type="text" id="subject" name="subject" class="form-control" placeholder=""  />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">品牌</label>
							<div class="col-md-6">
								<select class=" form-control" id="brand" name="brand" >
									<option value="Patek Philippe">Patek Philippe</option>
									<option value="Audemars Piguet">Audemars Piguet</option>
									<option value="Vacheron Constantin">Vacheron Constantin</option>
									<option value="Breguet">Breguet</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">类型</label>
							<div class="col-md-6">
								<select class=" form-control" id="type" name="type" multiple="multiple">
									<option value="0">电子表</option>
									<option value="1">石英表</option>
									<option value="2">机械表</option>
									<option value="3">晶体管摆轮表</option>
									<option value="4">光动能表</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">价格</label>
							<div class="col-md-6">
								<input type="text" id="price" name="price" class="form-control" placeholder=""  />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">描述</label>
							<div class="col-md-6">
								<textarea class="form-control" id="description" name="description" placeholder="" rows="3"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">状态</label>
							<div class="col-md-10">
								<label class="checkbox-inline">
									<input type="radio" value="1" name="state" checked="checked"/>生效
								</label>
								<label class="checkbox-inline">
									<input type="radio" value="0" name="state" >无效
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">标签</label>
							<div class="col-md-10">
								<label class="checkbox-inline">
									<input type="checkbox" value="0" name="tags" />商务
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="1" name="tags" />时尚
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="2" name="tags" />复古
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">顶部大图</label>
							<div class="col-md-6">
								<div id="mainPictureUrl" name="mainPictureUrl" class="dropzone fallback" style="height: 250px;width: 230px;"></div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">底部图片(可多张)</label>
							<div class="col-md-6">
								<div id="subPictureUrls" name="subPictureUrls" class="dropzone fallback" ></div>
							</div>
						</div>
						<div class="col-md-offset-2">
							<a href="#cms/watch-list" class="btn btn-white" >返回</a>
							<a href="javascript:;" class="btn btn-success" onclick="edit()">保存</a>
						</div>
					</form>
                </div>
            </div>
            <!-- end panel -->
        </div>
        <!-- end col-12 -->
    </div>
    <!-- end row -->
</div>
<script type="text/javascript" src="../assets/js/support/cms/watch-edit.js?v1"></script>
<script type="text/javascript">
	var id = '${id}';
	$(function(){
		initWatchInfo(id);
	});
	
</script>