//--------------------------------------------mask-------------------------------------------------------------------
function mask(target) {
	target = target || $(document).find(".panel");
	if (!$(target).hasClass('panel-loading')) {
        var targetBody = $(target).find('.panel-body');
        var spinnerHtml = '<div class="panel-loader"><span class="spinner-small"></span></div>';
        $(target).addClass('panel-loading');
        $(targetBody).prepend(spinnerHtml);
    }
}

function unmask(target) {
	target = target || $(document).find(".panel");
	$(target).removeClass('panel-loading');
	$(target).find('.panel-loader').remove();
}

(function(){
	String.prototype.trim = function() {
	    return undefined === this ? '' : this.replace(/(^\s*)|(\s*$)/g,'');  
	};
	
	String.prototype.startWith = function(s) {
		if (s == null || s == "" || this.length == 0 || s.length > this.length)
			return false;
		if (this.substr(0, s.length) == s)
			return true;
		else
			return false;
		return true;
	}
})();

