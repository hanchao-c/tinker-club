;(function ($) {
	$.fn.extend({
		"modalEvent" : function (option){
			var $modal = $(this);
			option = option || {};
			if(option.showOrhidden){
				option.show   = option.showOrhidden;
				option.hidden = option.showOrhidden;
			}
			return $(this).on('show.bs.modal', function (event) {
				if(option.show){
					option.show(event);
				}
			}).on('hide.bs.modal', function (event) {
				if(option.hide){
					option.hide(event);
				}
			}).on('shown.bs.modal', function (event) {
				if(option.shown){
					option.shown(event);
				}
			}).on('hidden.bs.modal', function (event) {
				if(option.hidden){
					option.hidden(event);
				}
			});
		},
		"showModal" : function (){
			var $modal = $(this);
			$modal.modal({"backdrop" : "static"});
		},
		"hideModal" : function (){
			var $modal = $(this);
			$modal.modal("hide");
		}
	});
})(jQuery);