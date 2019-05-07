(function($){
	$.fn.extend({
		"buildImageUploader" : function(option){
			option = $.extend({
				"method" : "POST",
				"maxFiles" : 10,
				"maxFilesize" : 2,
				"acceptedFiles": "image/*"			//".jpg,.png,.bmp,.jpeg"
			}, option);
			Dropzone.autoDiscover = false;
			var $this = $(this);
			return $this.dropzone({
				"url": option.url ? option.url : "../images",
				"method" 		: option.method,							//上传方式 建议使用 POST,PUT,PATCH
		        "maxFiles"		: option.maxFiles,						//最大数量
		        "maxFilesize"	: option.maxFilesize,						//大小限制(M为单位)
		        "acceptedFiles"	: option.acceptedFiles,					//允许的上传格式
		        "addRemoveLinks": true,									//显示删除按钮
		        "clickable" 	: true	,								//设置为true,支持拖拽和点击,false时候只支持拖拽
		        "autoProcessQueue" : true,								//自动上传
		        "dictDefaultMessage" 	: option.dictDefaultMessage ? option.dictDefaultMessage : "拖拽或者点击",				
		        "dictFallbackMessage" 	: "当前浏览器不支持拖拽文件到控件",
		        "dictInvalidFileType" 	: "只支持 " + option.acceptedFiles +" 文件类型",
		        "dictFileTooBig" 		: "文件大小不能超过" + option.maxFilesize + "MB",
		        "dictResponseError" 	: "上传到服务器失败",
		        "dictMaxFilesExceeded" 	: "最多可以上传" + option.maxFiles + "个文件",
		        "dictCancelUpload"		: "取消上传",
		        "dictRemoveFile"		: "删除",
		        "dictCancelUploadConfirmation" : "确定",					//在上传过程中,在用户点击取消上传的时候,出现confrim弹窗的文字信息(可以自定义提示方式)
		        "imgWidth" : option.imgWidth ? option.imgWidth : null,
		        "imgHeight" : option.imgHeight ? option.imgHeight : null,
		        "thumbnailWidth" : option.thumbnailWidth ? option.thumbnailWidth : null,
		        "thumbnailHeight" : option.thumbnailHeight ? option.thumbnailHeight : null,
		        "moveable" : option.moveable,
		        "init" :	function(){
		        	var _this = this;
		        	//附加删除事件
		        	_this.on("removedfile", function(file){		//删除事件
		                processDropzoneFile($this, _this);
		            //附加上传成功事件
		            }).on("success", function(file, data, e){		//上传成功事件
	                	file.resourceId = data.resourceId;
		                processDropzoneFile($this, _this);
		            });
		        	//存储当前控件
		            $this.data("dropzoneinstance", _this);
		        }
			});
		},
		"imageValues" : function(){
			var $this = $(this);
			if(arguments.length > 0 ){	
				//赋值
				var source = arguments[0];
				if(source){
					var $this = $(this);
					var array = (source.constructor == String) ? source.split(",") : source;
					var dropzoneInstance = $this.data("dropzoneinstance");
					for(var i = 0 ; i < array.length ; i++){
						setView(dropzoneInstance, array[i], $this);
					}
				}
			}else{
				//取值
				var dropzoneInstance = $this.data("dropzoneinstance");
				processDropzoneFile($this, dropzoneInstance);
				return $this.data("views");						//获取上传文件的路径
			}
			
			/**
			 * 回显时候显示的缩略图
			 * @param myDropzone
			 * @param resourceId
			 * @param el
			 */
			function setView(myDropzone, resourceId, el){
				var mockFile = { 
							"resourceId" :  resourceId, 
							"status":"success" , 
							"accepted" : true, 
							"dataURL" : resourceId
						};
				myDropzone.emit("addedfile", mockFile);
				myDropzone.createThumbnailFromUrl(
						mockFile, 
						myDropzone.options.thumbnailWidth, 
						myDropzone.options.thumbnailHeight, 
						myDropzone.options.thumbnailMethod,
						true,
						function(thumbnail){
							myDropzone.emit("thumbnail", mockFile, thumbnail);
						},
						'anonymous');
				myDropzone.emit("complete", mockFile);
				myDropzone.files.push(mockFile);
				$(mockFile.previewElement).find(".dz-size,.dz-filename").hide();//隐藏图片大小、名称信息,因为后台并没有给返回
				processDropzoneFile(el, myDropzone);
			}
		},
		"clearImages" : function(){
			var $this = $(this);
			var dropzoneInstance = $this.data("dropzoneinstance");
			dropzoneInstance.removeAllFiles();
		},
//		"getAcceptedFiles" : function(){
//			var $this = $(this);
//			var dropzoneInstance = $this.data("dropzoneinstance");
//			return dropzoneInstance.getAcceptedFiles();
//		},
		//获取上传成功的文件
		"getSuccessFiles" : function(){
			var $this = $(this);
			var dropzoneInstance = $this.data("dropzoneinstance");
			return dropzoneInstance.getFilesWithStatus(Dropzone.SUCCESS);
		},
		//获取上传失败的文件
		"getErrorFiles" : function(){
			var $this = $(this);
			var dropzoneInstance = $this.data("dropzoneinstance");
			return dropzoneInstance.getFilesWithStatus(Dropzone.ERROR);
		},
		//是否有文件正在上传
		"isUploading" : function(){
			var $this = $(this);
			var dropzoneInstance = $this.data("dropzoneinstance");
			var uploadingFiles = dropzoneInstance.getActiveFiles();
			return uploadingFiles.length > 0;
		}
	});
})(jQuery);

/**
 * 对控件所有有效文件操作
 * @param el
 * @param _this
 */
function processDropzoneFile(el, _this){
	var fileArray = _this.getFilesWithStatus(Dropzone.SUCCESS);
	var fileResourceIds = $.map(fileArray, function(file, index){
		return file.resourceId;
	}).filter(function(resourceId){
		return undefined != resourceId && resourceId && resourceId.length > 0;
	}).join();
    el.data("views", fileResourceIds);
    
}



