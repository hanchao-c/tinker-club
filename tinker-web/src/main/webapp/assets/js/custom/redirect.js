;(function($) {
	$.extend({
		/**
		 * 页面跳转
		 * 解决页面跳转带参数需要后台解析的问题
		 * @param url 跳转地址
		 * @param data 参数
		 */
		"redirect" : function(url , data) {
			var params = [];
			for(var key in data) {
				var value = data[key];
				if(key !== null && key !== undefined && value !== null && value !== undefined) {
					params.push(encodeURIComponent(key) + "=" + encodeURIComponent(value));
				}
			}
			if(params.length > 0) {
				url = url + "?" + params.join("&");
			}
			window.location.href = url;
		}
	});
})(jQuery);