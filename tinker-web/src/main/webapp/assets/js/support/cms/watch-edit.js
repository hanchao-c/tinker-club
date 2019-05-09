var mainPicture, subPictures;
var $form = $("#form");

function initSelect2() {
	$("#brand").buildSelect2({
		"type" 		: "default",
		"usePlaceholderBy" : "请选择品牌"
	});
	$("#type").buildSelect2({
		"type" 		: "default",
		"usePlaceholderBy" : "请选择类型"
	});
}

function initDropzone() {
	mainPicture = $("#mainPictureUrl").buildImageUploader({
		"dictDefaultMessage" : "拖拽或点击,像素要求 800 x 800",
		"maxFiles" : 1,					
		"maxFilesize" : 5,
 		"imgWidth" : 800,
 		"imgHeight" : 800,
		"thumbnailWidth" : 150,
		"thumbnailHeight" : 150
	});
	subPictures = $("#subPictureUrls").buildImageUploader({
		"dictDefaultMessage" : "拖拽或点击,像素要求 800 x 800",
		"maxFiles" : 4,
		"maxFilesize" : 5,
 		"imgWidth" : 800,
 		"imgHeight" : 800,
		"thumbnailWidth" : 150,
		"thumbnailHeight" : 150,
		"moveable" : true		//多图片上传支持移动排序
	});
}

function initValidation() {
	$form.validate({
        rules : {
        	"subject" : {
                required : true,
                maxlength : 50
            },
            "brand" : {
                required : true
            },
            "type" : {
                required : true
            },
            "price" : {
            	required : true,
            	digits:true
            },
            "description" : {
            	maxlength : 300
            }
        },
        messages : {
        	"subject" : {
                required : "请输入主题",
                maxlength : $.validator.format( "主题不能超过{0}个字符" )
            },
            "brand" : {
                required : "请选择品牌"
            }, 
            "type" : {
                required : "请选择类型"
            },
            "price" : {
            	required : "请输入价格",
            	digits : "请输入正整数或者0"
            },
            "description" : {
	            maxlength : $.validator.format( "描述不能超过{0}个字符" )
            }
        }
    });
}

function initWatchInfo(id) {
	AjaxHelper.get({
		"url" : "../watches/" + id,
		"success" : function(data){
			//不在页面加载结束初始化,而是在查询到记录之后初始化
			initSelect2();
			initDropzone();
			initValidation();
			$form.setFormData(data);
			if(data.mainPictureUrl) {
				mainPicture.imageValues(data.mainPictureUrl);
			}
			if(data.subPictureUrls) {
				subPictures.imageValues(data.subPictureUrls);
			}
		},
		"error" : function(XMLHttpRequest, textStatus, errorThrown){
			Confirm.danger({
				"title" : "记录不存在",
				"showCancelButton" : false
			}, function(params){
				$.redirect("#cms/watch-list");
			});
		}
	});
}

function edit() {
	if($form.isValidForm()) {
		//获取所有基本标签key以及value
		var data = $form.getFormData();
		//验证是否有图片正在上传
		if(mainPicture.isUploading() || subPictures.isUploading()) {
			Notification.warn("请等待图片上传结束");
			return;
		}
		//验证是否已经上传图片
		if(!mainPicture.imageValues()) {
			Notification.warn("请上传顶部大图");
			return;
		}
		data.mainPictureUrl = mainPicture.imageValues();
		//验证是否已经上传图片
		if(!subPictures.imageValues()) {
			Notification.warn("请上传底部图片");
			return;
		}
		data.subPictureUrls = subPictures.imageValues();
		//后台提交
		AjaxHelper.put({
			"url" : "../watches",
			"data" : data,
			"success" : function(data){
				Confirm.success({
					"confirmButtonText" : "返回列表",
					"title" : "修改成功",
					"showCancelButton" : false
				}, function(){
					Notification.success("修改成功")
					//history.go(-1); 特殊情况不能返回列表
					$.redirect("#cms/watch-list");
				});
			}
		});
	}
}