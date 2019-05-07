package org.tinker.auth.repository.custom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tinker.auth.repository.custom.model.PermissionCascade;

public interface PermissionCascadeMapper {
	
	/**
	 * 获取菜单级联
	 * @param parentId 父菜单id
	 * @return
	 */
	List<PermissionCascade> getCascade(@Param("parentId") String parentId);
	
	/**
	 * 获取已被激活的菜单id列表
	 * @param account 账号
	 * @return
	 */
	@Select("SELECT permission_id FROM auth_role_permission_relation WHERE role_id in ( SELECT role_id FROM auth_user_role_relation WHERE account = #{account})")
	List<String> getActivePermissionIds(String account);

	/**
	 * 获取最大的排序值
	 * @param parentId 父菜单id
	 * @return
	 */
	@Select("SELECT MAX(sequence) FROM auth_permission WHERE parent_id = #{parentId}")
	Integer getMaxSequenceByParentId(String parentId);
	
}