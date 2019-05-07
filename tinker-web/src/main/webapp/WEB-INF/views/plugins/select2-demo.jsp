<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('select2-demo');
</script>

<!-- ================== END PAGE LEVEL JS ================== -->
<script type="text/javascript">
var $_single, $_multi;

$(function(){
	
	$("#default-1").buildSelect2({
		"placeholder": 'this is a placeholder'
	});
	
	$("#without-search").buildSelect2({
		"search" : false
	});
	
	$("#default-multi").buildSelect2({
		"placeholder": 'this is a multi select'
	});
	
	var array = [
	             {  "id": "id-orange",   "text": "orange"  },
	             {  "id": "id-white",  "text": "white --> disabled", "disabled" : true  },
	             {  "id": "id-purple",   "text": "purple"  },
	             {  "id": "id-red",    "text": "red"  },
	             {  "id": "id-black",  "text": "black"  }
          ];
	
	$("#default-array").buildSelect2({
		"type" 		: "data",
		"data"		: array,
		"placeholder": 'data from jsonArray'
	});
	
	$("#multi-array").buildSelect2({
		"type" 		: "data",
		"data"		: array,
		"placeholder": 'data from jsonArray'
	});
	
	$("#default-remote").buildSelect2({
		"type" 		: "remote",
		"url"		: "../select2/colors",
		"params" : {
		},
		"placeholder": 'data from remote'
	});
	
	$("#default-multi-remote").buildSelect2({
		"type" 		: "remote",
		"url"		: "../select2/colors",
		"params" : {
		},
		"placeholder": 'data from remote multi'
	});
	
	$_single = $("#single").buildSelect2({
		"search" : false,
		"placeholder": 'operation demo',
		"open" : function(event){
			textAppend("select2打开");
		},
		"close" : function(event){
			textAppend("select2关闭");
		},
		"select" : function(event){
			textAppend("select2选中  --" + event.params.data.text);
		},
		"unselect" : function(event){
			textAppend("select2清除 --" + event.params.data.text);
		}
	});
	
	function textAppend(text) {
		var originText = $("#logs").text();
		$("#logs").text(originText + text + "\r\n");
	}
	
	$_multi = $("#multi").buildSelect2({
		"placeholder": 'operation demo',
		"maxLength" : 2
	});
});

function singleOpen(){
	$_single.select2("open");
}

function singleClose(){
	$_single.select2("close");
}

function singleSet(){
	$_single.selectValues("id_red_");
}

function singleGet(){
	alert($_single.selectValues());
}

function sinleClear(){
	$_single.clearSelect();
}


function multiSet(){
	//$_multi.selectValues("id_red_multi,id_white_multi");	//效果相同
	$_multi.selectValues(["id_red_multi", "id_white_multi"]);
}

function multiGet(){
	console.log($_multi);
	alert($_multi.selectValues());
}

function multiClear(){
	$_multi.clearSelect();
}
</script>
		
<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">plugins</a></li>
        <li class="active">select2</li>
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
								<label class="col-md-2 control-label">default</label>
								<div class="col-md-10">
									<select class=" form-control" id="default-1" name="default-1" >
										  <option>orange</option>
										  <option>white</option>
										  <option>purple</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">without-search</label>
								<div class="col-md-10">
									<select class=" form-control" id="without-search" name="without-search" >
										  <option>orange</option>
										  <option>white</option>
										  <option>purple</option>
									</select>
								</div>
							</div>
		                	<div class="form-group">
								<label class="col-md-2 control-label">default multi</label>
								<div class="col-md-10">
									<select class=" form-control" id="default-multi" name="default-multi" multiple="multiple" >
										  <option value="orange" >orange</option>
										  <option disabled="disabled" >white --> disabled</option>
										  <option disabled="disabled" >purple --> disabled</option>
										  <option disabled="disabled" >red --> disabled</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">default [array] </label>
								<div class="col-md-10">
									<select class=" form-control" id="default-array" name="default-array" >
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">multi [array] </label>
								<div class="col-md-10">
									<select class=" form-control" id="multi-array" name="multi-array" multiple="multiple" >
									</select>
								</div>
							</div>
		                </form>
	                </div>
	            </div>
	            <!-- end panel -->
	        </div>
        </div>
        <div class="col-md-12">
        	<div class="col-md-12">
     	 	<!-- begin panel -->
	            <div class="panel panel-inverse" >
	                <div class="panel-heading">
	                    <div class="panel-heading-btn">
	                   		<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
	                    </div>
	                    <h4 class="panel-title">远程</h4>
	                </div>
	                <div class="panel-body">
		                <form class="form-horizontal col-md-8">
		                	<div class="form-group">
								<label class="col-md-2 control-label">default remote</label>
								<div class="col-md-10">
									<select class=" form-control" id="default-remote" name="default-remote" >
									</select>
								</div>
							</div>
		                	<div class="form-group">
								<label class="col-md-2 control-label">default multi remote  </label>
								<div class="col-md-10">
									<select class=" form-control" id="default-multi-remote" name="default-multi-remote" multiple="multiple" >
										  <option>orange</option>
										  <option>white</option>
										  <option disabled="disabled">purple --> disabled</option>
										  <option>red</option>
									</select>
								</div>
							</div>
		                </form>
	                </div>
	            </div>
	            <!-- end panel -->
	        </div>
        </div>
        <!-- end col-12 -->
        <div class="col-md-12">
        	<div class="col-md-12">
     	 	<!-- begin panel -->
	            <div class="panel panel-inverse" >
	                <div class="panel-heading">
	                    <div class="panel-heading-btn">
							<a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-warning" data-click="panel-collapse"><i class="fa fa-minus"></i></a>
						</div>
	                    <h4 class="panel-title">API</h4>
	                </div>
	                <div class="panel-body">
		                <form class="form-horizontal col-md-8">
							<div class="form-group">
								<label class="col-md-2 control-label">operations</label>
								<div class="col-md-10">
									<div class="btn-group">
										<a href="javascript:void(0);" onclick="singleOpen()" class="btn btn-info btn-sm">打开</a>
										<a href="javascript:void(0);" onclick="singleClose()" class="btn btn-info btn-sm">关闭</a>
				                        <a href="javascript:void(0);" onclick="singleSet()" class="btn btn-info btn-sm">选中red</a>
				                        <a href="javascript:void(0);" onclick="singleGet()" class="btn btn-info btn-sm">获取选中值</a>
				                        <a href="javascript:void(0);" onclick="sinleClear()" class="btn btn-info btn-sm">清空</a>
				                    </div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">single</label>
								<div class="col-md-10">
									<select class=" form-control" id="single" name="single" >
									 	  <option value="id_orange_">orange</option>
										  <option value="id_white_">white</option>
										  <option value="id_red_">red</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">日志</label>
								<div class="col-md-10">
									<textarea class="form-control" id="logs" name="logs" placeholder="" rows="10"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">operations</label>
								<div class="col-md-10">
									<div class="btn-group">
				                        <a href="javascript:void(0);" onclick="multiSet()" class="btn btn-info btn-sm">选中red和white</a>
				                        <a href="javascript:void(0);" onclick="multiGet()" class="btn btn-info btn-sm">获取选中值</a>
				                        <a href="javascript:void(0);" onclick="multiClear()" class="btn btn-info btn-sm">清空</a>
				                    </div>
								</div>
							</div>
		                	<div class="form-group">
								<label class="col-md-2 control-label">multi</label>
								<div class="col-md-10">
									<select class=" form-control" id="multi" name="multi" multiple="multiple" >
										  <option value="id_orange_multi">orange</option>
										  <option value="id_white_multi">white</option>
										  <option value="id_red_multi">red</option>
									</select>
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