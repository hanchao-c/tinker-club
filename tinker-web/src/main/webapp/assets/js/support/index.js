var _YGewJm41_$resetPasswordForm, _YGewJm41_$resetPasswordModal;
		$(function(){
			App.init();
			_YGewJm41_$resetPasswordForm = $("#form-97702de7842a27b947bb590518822544");
			_YGewJm41_$resetPasswordModal = $("#modal-97702de7842a27b947bb590518822544");
			_YGewJm41_initResetPasswordModalEvent();
			_YGewJm41_initRestPasswordValidation();
		});

		function _YGewJm41_initUserNameDisplay(info){
			var userInfo = JSON.parse(info);
			$("#userName-97702de7842a27b947bb590518822544").html(userInfo.userName);
		}

		function _YGewJm41_initMenu(menu){
			if(menu) {
				var permissions = JSON.parse(menu);
				for(var i = 0; i < permissions.length; i++) {
					_YGewJm41_draw(permissions[i], "nav-menu-list");
				}
			}
			$("#nav-menu-list").append('<li><a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li>');
			if(window.location.hash) {
				window.location.hash = window.location.hash;
			}else {
				var links = $("#nav-menu-list").find("a");
				for(var i = 0; i < links.length; i++) {
					var $link = $(links[i]);
					var _href = $link.attr("href");
					if(_href) {
						if(_href.startWith("#")) {
							window.location.hash=_href;
							break;
						}
					}
				}
			}
		}

		function _YGewJm41_initResetPasswordModalEvent() {
			_YGewJm41_$resetPasswordModal.modalEvent({
				"showOrhidden" : function(){
					_YGewJm41_$resetPasswordForm.clearForm();
				}
			});
		}

		function _YGewJm41_initRestPasswordValidation(){
			
		    jQuery.validator.addMethod("usefulPassword", function(value, element) {  
		        var password = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{8,16}$/;  
		        return this.optional(element) || (password.test(value));    
		    }, "密码必须是8到16位的数字+字母的组合"); 
		    
		    _YGewJm41_$resetPasswordForm.validate({
		        rules : {
		            "password-new-97702de7842a27b947bb590518822544" : {
		                required : true,
		                usefulPassword : true
		            },
		            "re-password-new-97702de7842a27b947bb590518822544" : {
		                required : true,
		                equalTo : "#password-new-97702de7842a27b947bb590518822544"
		            }
		        },
		        messages : {
		        	"password-new-97702de7842a27b947bb590518822544" : {
		                required : "请输入新密码"
		            },
		            "re-password-new-97702de7842a27b947bb590518822544" : {
		                required : "请确认密码",
		                equalTo : "密码不一致"
		            }
		        }
		    });
		}

		function _YGewJm41_draw(item, parentId, isSub) {
			var hassub = item.children.length > 0;
			var html = ''+
				'<li id="' + item.id + '"class="' + (hassub ? "has-sub" : "") + '">'+
				'	<a href="' + getPermission(item.permission) + '" data-toggle="ajax">'+
				(hassub ? '		<b class="caret pull-right"></b>' : '') +
				'	    <i class="' + ( isSub ? "" : item.icon) + '"></i><span>' + item.text + '</span>'+
				'	</a>'+
				'</li>';
			if(isSub) {
				var $container = $("#container-" + parentId);
				if($container.length == 0) {
					html = '<ul class="sub-menu" id="container-' + parentId + '">' + html + '</ul>'
				} else {
					parentId = "container-" + parentId;
				}
			}
			$("#"+ parentId).append(html);
			if(hassub) {
				var children = item.children;
				for(var i = 0; i < children.length; i++) {
					var child = children[i];
					_YGewJm41_draw(child, item.id, true);
				}
			}
			
			function getPermission(permissions){
				if(!permissions) {
					return "javascript:;";
				}
				return "#" + permissions.split(",")[0];
			}
		}

		function _YGewJm41_logout(){
			var $form = $("<form ></form>");
			$form.attr('method', 'GET');
			$form.attr('action', '../logout');
			$form.appendTo("body")
			$form.submit();
		}

		function _YGewJm41_openResetPasswordModal(){
			_YGewJm41_$resetPasswordModal.showModal();
		}

		function _YGewJm41_resetPassword(){
			if(_YGewJm41_$resetPasswordForm.isValidForm()){
				/*AjaxHelper.patch({
					"url" : "../authc/password",
					"data" : {
						"password" : $("#password-new-97702de7842a27b947bb590518822544").val()
					},
					"success" : function(data){
						_YGewJm41_$resetPasswordModal.hideModal();
						Notification.success("修改密码成功");
					}
				});*/
			}
		}