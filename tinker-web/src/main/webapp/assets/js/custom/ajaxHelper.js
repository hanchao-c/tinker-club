;function AjaxHelper() {
}

function doAjax(option, type) {
	var _default = {
		"type" : type,
		"dataType" : "json"
	};
	option = $.extend({}, _default, option);

	/**
	 * 修改空字符串不能进行json解析bug
	 */
	option.dataFilter = function(data, type) {
		if(typeof data === 'string' && "json" === type.toLowerCase()) {
			if (data.length === 0) {
				return null;
			}
			//处理session超时用户ajax请求
			if(data.indexOf("DOCTYPE html") > 0) {
				window.location.href="..";
			}
		}
		return data;
	};

	/**
	 * 重写ajax的beforeSend函数,ajax执行过程加入页面的遮罩
	 */
	var beforeSendFunction = option.beforeSendFunction;
	option.beforeSend = function(XMLHttpRequest) {
		if (!option.overrideBeforeSend) {
			if (option.shadow !== false) {
				if (mask) {
					mask();
				}
			}
		}
		if (beforeSendFunction) {
			beforeSendFunction(XMLHttpRequest);
		}
	}

	/**
	 * 重写ajax的complete函数, ajax请求结束后,清除遮罩
	 */
	var completeFunction = option.complete;
	option.complete = function(XMLHttpRequest, textStatus) {
		if (!option.overrideComplete) {
			if (option.mask !== false) {
				if (unmask) {
					unmask();
				}
			}
		}
		if (completeFunction) {
			completeFunction(XMLHttpRequest, textStatus);
		}
	}

	/**
	 * httpStatusCode >= 400 时执行
	 */
	var errorFunction = option.error;
	option.error = function(XMLHttpRequest, textStatus, errorThrown) {
		if (!option.overrideError) {
			var errorResponse;
			try {
				errorResponse = JSON.parse(XMLHttpRequest.responseText);
			} catch (e) {
				console.log(e);
			}
			if (errorResponse) {
				Notification.danger(errorResponse.message);
			}
		}
		if (errorFunction) {
			errorFunction(XMLHttpRequest, textStatus, errorThrown);
		}
	}
	$.ajax(option);
}

(function($) {
	AjaxHelper.get = function(option) {
		doAjax(option, "get")
	}
	AjaxHelper.post = function(option) {
		doAjax(option, "post")
	}
	AjaxHelper.del = function(option) {
		doAjax(option, "delete")
	}
	AjaxHelper.put = function(option) {
		doAjax(option, "put")
	}
	AjaxHelper.patch = function(option) {
		doAjax(option, "patch")
	}
})(jQuery);