function Notification(){
}
function doGritter(option) {
	$.gritter.add(option);
}

(function($) {
	var _default = {
		sticky: false,
		time: 2000
	};
	
	Notification.danger = function(title, time){
		var option = {
				"class_name" : "gritter-danger",
				"title" : '<i class="fa fa-times-circle fa-2x pull-left"></i>'  + '&nbsp;&nbsp;' + title
		};
		if(time) {
			option.time = time;
		}
		option = $.extend({}, _default, option);
		doGritter(option);
	};
	Notification.success = function(title, time){
		var option = {
				"class_name" : "gritter-success",
				"title" : '<i class="fa fa-check-circle fa-2x pull-left"></i>'  + '&nbsp;&nbsp;' + title
		};
		if(time) {
			option.time = time;
		}
		option = $.extend({}, _default, option);
		doGritter(option);
	};
	Notification.info = function(title, time){
		var option = {
				"class_name" : "gritter-info",
				"title" : '<i class="fa fa-info-circle fa-2x pull-left"></i>'  + '&nbsp;&nbsp;' + title
		};
		if(time) {
			option.time = time;
		}
		option = $.extend({}, _default, option);
		doGritter(option);
	};
	Notification.warn = function(title, time){
		var option = {
				"class_name" : "gritter-warn",
				"title" : '<i class="fa fa-exclamation-circle fa-2x pull-left"></i>'  + '&nbsp;&nbsp;' + title
		};
		if(time) {
			option.time = time;
		}
		option = $.extend({}, _default, option);
		doGritter(option);
	};
})(jQuery);
