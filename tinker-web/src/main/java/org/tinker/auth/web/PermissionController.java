package org.tinker.auth.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.asset.webplugin.select2.Select2Structure;
import org.tinker.auth.model.mock.PermissionMock;
import org.tinker.auth.model.structure.AuthStructure;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.Permission;
import org.tinker.auth.service.PermissionService;
import org.tinker.auth.util.ViewFileExplorer;
import org.tinker.util.Propagater;

/**
 * 菜单
 */
@RestController
@RequestMapping("permissions")
public class PermissionController {

	/**
	 * 后台权限
	 */
	private List<Select2Structure> authorities;

	@Autowired
	private PermissionService permissionService;
	@Autowired
	private WebApplicationContext applicationContext;
	
	private final ViewFileExplorer explorer = new ViewFileExplorer();
	
	/**
	 * 获取所有[后台权限]
	 * [后台权限 : 标记在controller上的requestMapping的value值]
	 * 如果用户没有对应[后台权限]请不能请求对应controller的接口
	 * @return
	 */
	@GetMapping("authorities")
	public ResponseEntity<List<Select2Structure>>  getAllAuthorities(){
		if(CollectionUtils.isEmpty(authorities)) {
			Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Controller.class);
			Set<Entry<String,Object>> beanEntrySet = beansWithAnnotation.entrySet();
			authorities = beanEntrySet.stream()
				.map(entry -> AnnotationUtils.findAnnotation(entry.getValue().getClass(), RequestMapping.class))
				.filter(Objects::nonNull)
				.map(RequestMapping::value)
				.filter(ArrayUtils::isNotEmpty)
				.flatMap(Arrays::stream)
				.distinct()
				.map(AuthStructure::new)
				.collect(Collectors.toList());
		}
		return ResponseEntityWrapper.OK(authorities);
	}
	
	
	/**
	 * 获取所有菜单
	 * @param parentId
	 * @return
	 */
	@GetMapping
	public List<PermissionCascade> getCascade(@NotBlank String parentId) {
		return permissionService.getCascade(parentId);
	}
	
	/**
	 * 获取所有jsp的相对路径
	 * @return
	 */
	@GetMapping("jspViews")
	public List<String> listViews(){
		return explorer.getAllValidJspPath();
	}
	
	/**
	 * 创建菜单
	 * @param permission 菜单信息
	 * @return
	 */
	@PostMapping
	public void create(@Valid PermissionMock permission) {
		permissionService.create(permission);
	}
	
	/**
	 * 已激活的菜单
	 * @param account 账号
	 * @return
	 */
	@GetMapping("active")
	public List<PermissionCascade> getAcitveCascadeByAccount(@NotBlank String account) {
		return permissionService.getAcitveCascadeByAccount(account);
	}
	
	/**
	 * 获取菜单详情
	 * @param id 菜单id
	 * @return
	 */
	@GetMapping("{id}")
	public ResponseEntity<Permission> getById(@NotBlank @PathVariable("id") String id) {
		Permission permission = permissionService.getById(id);
		return ResponseEntityWrapper.OK(permission);
	}
	
	/**
	 * 修改菜单
	 * @param permission 菜单信息
	 * @return
	 */
	@PutMapping
	public void update(@Valid PermissionMock permission) {
		permissionService.update(permission);
	}
	
	/**
	 * 删除菜单
	 * @param id 菜单id
	 * @return
	 */
	@DeleteMapping("{id}")
	public void deleteById(@NotBlank @PathVariable("id") String id) {
		permissionService.deleteById(id);
	}
	
	/**
	 * 菜单位置排序
	 * @param currentId 当前子层级Id
	 * @param parentId 父层级Id
	 * @param childrenIds 同级所有子层级Id
	 * @return
	 */
	@PatchMapping("sequence")
	public void sortSequence(@NotBlank String currentId, @NotBlank String parentId, @RequestParam("childrenIds[]") String[] childrenIds ) {
		if(Objects.equals(parentId, "#")) {
			Propagater.throwOf("当前菜单必须属于[系统菜单]");
		}
		permissionService.sortSequence(currentId, parentId, childrenIds);
	}

	
}