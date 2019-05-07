package org.tinker.cms.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.asset.webplugin.select2.Select2Params;
import org.tinker.asset.webplugin.select2.Select2Response;
import org.tinker.asset.webplugin.select2.Select2Structure;
import org.tinker.auth.model.structure.ColorStructure;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("select2")
@Slf4j
public class PluginSelect2Controler {

	private final List<String> colors = Arrays.asList("orange", "white", "purple", "red", "black", "green", "blue",
			"scarlet", "mauve", "lilac", "pansy", "gray", "yellow", "pink", "peru", "wine", "beige", "olive", "coffee",
			"gold");
	
	/**
	 * 模拟前端控件select2后台分页获取数据的场景
	 * @param params
	 * @return
	 */
	@GetMapping("colors")
	public ResponseEntity<Select2Response> getColors(Select2Params params) {
		log.info(JacksonUtil.toJSONString(params));
		List<Select2Structure> items = colors.stream()
				.filter(color -> {
					String searchStr = params.getSearchStr();
					if(StringUtils.isBlank(searchStr)) {
						return true;
					} else {
						return StringUtils.contains(color, searchStr);
					}
				})
				.map(ColorStructure::new)
				.skip(params.getStart())
				.limit(params.getExpectedLength())
				.collect(Collectors.toList());
		return ResponseEntityWrapper.OK(new Select2Response(items));
		//实际开发中可根据请求参数查询数据库等
	}

}
