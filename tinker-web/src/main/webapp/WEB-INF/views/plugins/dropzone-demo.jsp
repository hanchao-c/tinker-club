<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script>
    App.restartGlobalFunction();
    App.setPageTitle('dropzone-demo');
</script>

<!-- ================== END PAGE LEVEL JS ================== -->
<script type="text/javascript">
var el_dropzone;

$(function(){
	el_dropzone = $("#images").buildImageUploader({
		"url" : "../dropzone/upload",	//对应PluginDropzoneController.imageUpload
		"maxFiles" : 10,					
		"maxFilesize" : 5,
// 		"imgWidth" : 400,
// 		"imgHeight" : 600,
		"thumbnailWidth" : 200,
		"thumbnailHeight" : 300
	});
});

function getAllValues(){
	alert(el_dropzone.imageValues());
}

function getIndex() {
	return Math.floor((Math.random() * 4));
}

/**
 * 图片回显
 */
function setSingleView() {
	//参数可以是图片的地址 比如 http://www.xxx.com/imageurl
	el_dropzone.imageValues("../assets/img/local-baby-" + getIndex() + ".jpg");
	//el_dropzone.imageValues("http://139.199.107.128:8081/pictures/20140113100830-2063178105.jpg");
	
}

/**
 * 同上
 */
function setMultiView() {
	//两种方式都可以
	
	//参数为数组
	el_dropzone.imageValues(["../assets/img/local-baby-" + getIndex() + ".jpg", "../assets/img/local-baby-" + getIndex() + ".jpg"]);
	//参数为“,”分隔的字符串
	el_dropzone.imageValues("../assets/img/local-baby-" + getIndex() + ".jpg,../assets/img/local-baby-" + getIndex() + ".jpg");
}

function clearViews(){
	el_dropzone.clearImages();
}

</script>
		
<!-- begin #content -->
<div id="content" class="content">
    <!-- begin breadcrumb -->
    <ol class="breadcrumb pull-left">
        <li><a href="javascript:;">主页</a></li>
        <li><a href="javascript:;">plugins</a></li>
        <li class="active">dropzone</li>
    </ol>
    <!-- end breadcrumb -->
    
    <!-- begin row -->
    <div class="row">
        <!-- begin col-12 -->
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
                	<div class="col-md-8">
	                	 <form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 control-label">dropzone</label>
								<div class="col-md-10">
									<div id="images" class="dropzone fallback"></div>
								</div>
							</div>
		                </form>
                	</div>
                	<div class="col-md-4">
                		<a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="getAllValues()">获取所有图片上传返回的resourdeId</a>
                		<br>
                		<br>
                		<a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="setSingleView()">设置一张图片</a>
                		<br>
                		<br>
                		<a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="setMultiView()">设置多张图片</a>
                		<br>
                		<br>
                		<a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="clearViews()">清空所有</a>
                	</div>
                </div>
            </div>
            <!-- end panel -->
        </div>
    </div>
    <!-- end row -->
</div>
<!-- end #content -->