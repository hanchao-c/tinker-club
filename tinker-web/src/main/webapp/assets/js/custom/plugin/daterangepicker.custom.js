(function ($) {
	$.fn.extend({
		"buildPicker" : function(option) {
			var $this = $(this);
			if(!option) {
				option = {};
			}
			var formatPatten = option.timePicker ? "YYYY-MM-DD HH:mm:ss" : "YYYY-MM-DD";
			var defaultSettings = {
					"drops"				: "down",                           //向上弹出还是向下弹出
					"opens" 			: "right",                          //左中右打开模式
					"format"			: formatPatten,                     //格式化 格式
					"timePicker"		: false,                            //是否显示时间
					"timePicker12Hour"	: false,                            //12小时或者24小时
					"singleDatePicker"	: option.single,                    //使用单个或者范围控件
					"showDropdowns"		: false,                            
					"showWeekNumbers"	: false,                            //是否显示周号
					"timePickerSeconds" : false,                            //是否显示秒
					"startDate"			: moment().startOf("day"),          //默认开始时间
					"endDate"  			: moment().endOf("day"),            //默认结束时间
					"showCalendars"		: true,                             //
					"locale"			: {                                 //国际化语言
						"format"		: "YYYY-MM-DD",                     
						"separator"		: " - ",                            
						"applyLabel"	: "确定",                          
						"cancelLabel"	: "清除",                          
						"fromLabel"		: "从",                            
						"toLabel"		: "至",                            
						"customRangeLabel" : "Custom",
						"daysOfWeek"	: [ "日", "一", "二", "三", "四", "五", "六" ],
						"monthNames"	: [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
						"firstDay"		: 1
					},
					"timePickerIncrement" : 1		//分钟间隔 为1
				};
			option = $.extend({}, defaultSettings, option);
 			return $this.daterangepicker(option)
 				//清除事件
 				.on("cancel.daterangepicker", function(ev, picker) {
 					//remove
 					$this.removeAttr("time-start").removeAttr("time-end").val("");		
					if(option.cancel){
						option.cancel(ev,picker);
					}
				//选中事件
				}).on("apply.daterangepicker", function(ev, picker) {		
					var start = picker.startDate.format(formatPatten);		//格式化开始时间
					var end   = picker.endDate.format(formatPatten);		//格式化结束时间
					$this.attr("time-start", start).attr("time-end", end);	//将时间作为属性绑定在控件上(避免多个控件同时出现的bug)
					if(option.apply){										
						option.apply(ev,picker);
					}
				//显示事件	
				}).on("show.daterangepicker", function(ev, picker) {
				//隐藏事件
				}).on("hide.daterangepicker", function(ev, picker) {			
				});		
		},
		/**
		 * 获取/设置控件的开始时间
		 * 如果参数不为空,则设置时间,如果为空,则获取时间.功能上类似于jquery.val(?) 和 jquery.val()
		 */
		startTime : function(){
			if(arguments.length > 0 ){
				var time = arguments[0];
				var $this = $(this);
				$this.attr("time-start",time);
				$this.data("daterangepicker").setStartDate(time);
			}else{
				return $(this).attr("time-start");
			}
		},
		/**
		 * 获取/设置控件的结束时间(当单个控件时,结束时间=开始时间)
		 * 如果参数不为空,则设置时间,如果为空,则获取时间.功能上类似于jquery.val(?) 和 jquery.val()
		 */
		endTime :  function(){
			if(arguments.length > 0 ){
				var time = arguments[0];
				var $this = $(this);
				$this.attr("time-end",time);
				$this.data("daterangepicker").setEndDate(time);
			}else{
				return $(this).attr("time-end");
			}
		},
		/**
		 * 设置时间(单个控件时候,为代码可读性,可使用这个方法)
		 */
		setTime : function(time){
			if(time){
				var $this = $(this);
				$this.attr("time-start", time).attr("time-end", time);
				$this.data("daterangepicker").setStartDate(time);
				$this.data("daterangepicker").setEndDate(time);
			}
		},
		/**
		 * 清除控件绑定的时间
		 */
		cleanPicker : function(){
			var $this = $(this);
			$this.removeAttr("time-start").removeAttr("time-end").val("");
		}
	});
})(jQuery);
