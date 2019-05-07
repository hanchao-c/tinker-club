;
(function($) {
	$.fn.extend({
		"isValidForm" : function() {
			var $form = $(this);
			var validation = $form.validate();
			if (validation) {
				return validation.form();
			} else {
				return false;
			}
		},
		"clearForm" : function() {
			var $form = $(this);
			var validation;
			if (validation = $form.validate()) {
				validation.resetForm(); // 清除错误验证信息
			}
			$form[0].reset(); // 清空表单数据
			$form.find(".error").removeClass("error"); // 删除错误信息标签的class
			$form.find("input[type='hidden']").val(''); // 清空隐藏元素的值
		},
		"getFormData" : function() {
			var $form = $(this);
			var data = {};
			
			// input[text,hidden]
			var getInputData = function() {
				$form.find("input[type='text'],input[type='hidden']").each(function() {
					var id = $(this).attr("id");
					var key = id ? id : $(this).attr("name");
					data[key] = $(this).val();
				});
			}
			
			// select
			var getSelectData = function() {
				$form.find("select").each(function() {
					var id = $(this).attr("id");
					var key = id ? id : $(this).attr("name");
					var value = $(this).val();
					if (value instanceof Array) {
						data[key] = value.join();
					} else {
						data[key] = value;
					}
				});
			}
			
			// textarea
			var getTextareaData = function() {
				$form.find("textarea").each(function() {
					var id = $(this).attr("id");
					var key = id ? id : $(this).attr("name")
					data[key] = $(this).val();
				});
			}
			
			// input[radio]
			var getRadioData = function() {
				var radioNames = {};
				$form.find("input[type='radio']").each(function() {
					var radioName = $(this).attr("name");
					if (radioName) {
						radioNames[radioName] = radioName;
					}
				});
				for ( var radioName in radioNames) {
					data[radioName] = $("input[type='radio'][name='" + radioName + "']:checked").val();
				}
			}
			
			// input[checkbox]
			var getCheckboxData = function() {
				var checkboxNames = {};
				$form.find("input[type='checkbox']").each(function() {
					var checkboxName = $(this).attr("name");
					if (checkboxName) {
						checkboxNames[checkboxName] = checkboxName;
					}
				});
				for ( var checkboxName in checkboxNames) {
					data[checkboxName] = $("input[type='checkbox'][name='" + checkboxName + "']:checked").map(function() {
						return $(this).val();
					}).get().join();
				}
			}
			
			getInputData();
			getSelectData();
			getTextareaData();
			getTextareaData();
			getRadioData();
			getCheckboxData();
			return data;
		},
		"setFormData" : function(data) {
			var $form = $(this);

			// input[text]
			var setInputData = function() {
				$form.find("input[type='text'],input[type='hidden']").each(function() {
					var id = $(this).attr("id");
					var key = id ? id : $(this).attr("name");
					if (key) {
						var value = data[key];
						if (value !== undefined && value !== null) {
							$(this).val(value);
						}
					}

				});
			};

			// select
			var setSelectData = function() {
				$form.find("select").each(
						function() {
							var id = $(this).attr("id");
							var key = id ? id : $(this).attr("name");
							if (key) {
								var value = data[key];
								if ($(this).attr("multiple")) {
									$(this).val(value.split(",") || []).trigger("change");
								} else {
									$(this).val(value).trigger("change");
								}
							}
						});
			};

			// textarea
			var setTextareaData = function() {
				$form.find("textarea").each(function() {
					var id = $(this).attr("id");
					var key = id ? id : $(this).attr("name");
					if (key) {
						var value = data[key];
						if (value !== undefined && value !== null) {
							$(this).text(value);
						}
					}
				});
			};

			// input[radio]
			var setRadioData = function() {
				var radioNames = {};
				$form.find("input[type='radio']").each(function() {
					var radioName = $(this).attr("name");
					if (radioName) {
						radioNames[radioName] = radioName;
					}
				});
				for ( var radioName in radioNames) {
					var value = data[radioName];
					if (value !== undefined && value !== null) {
						$("input[type=radio][name='" + radioName + "'][value='" + value + "']").attr("checked", "checked");
					}
				}
			};

			// input[checkbox]
			var setCheckboxData = function() {
				var checkboxNames = {};
				$form.find("input[type='checkbox']").each(function() {
					var checkboxName = $(this).attr("name");
					if (checkboxName) {
						checkboxNames[checkboxName] = checkboxName;
					}
				});
				for ( var checkboxName in checkboxNames) {
					var value = data[checkboxName];
					if (value !== undefined && value !== null) {
						if (value.constructor != String) {
							value = value.split(",");
						}
						if (value.constructor != Array) {
							for (var i = 0; i < value.length; i++) {
								$("input[type='checkbox'][name='" + checkboxName + "'][value='" + value[i] + "']") .prop("checked", "checked");
							}
						}
					}
				}
			}

			setInputData();
			setSelectData();
			setTextareaData();
			setRadioData();
			setCheckboxData();
		}
	});
})(jQuery);
