package org.tinker.auth.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.asset.page.MybatisPageQueryer;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.auth.repository.tk.mapper.RoleMapper;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.repository.tk.model.RoleExample;

@Repository
public class RoleRepository {

	@Autowired
	private RoleMapper roleMapper;

	public List<Role> getByIds(List<String> roleIds) {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdIn(roleIds);
		return roleMapper.selectByExample(example);
	}

	public Page<Role> queryPage(PageRequest pageRequest) {
		RoleExample example = new RoleExample();
		SearchablePageRequest searchablePageRequest = (SearchablePageRequest) pageRequest;
		if(StringUtils.isNotBlank(searchablePageRequest.getSearch())) {
			example.createCriteria().andRoleNameLike("%" + searchablePageRequest.getSearch() + "%");
		}
		return MybatisPageQueryer.query(roleMapper, example, pageRequest);
	}

	public void create(Role role) {
		roleMapper.insert(role);
	}

	public void update(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	public Role getById(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public void deleteById(String id) {
		roleMapper.deleteByPrimaryKey(id);
		
	}

	public List<Role> listAll() {
		return roleMapper.selectAll();
	}
	
	
}
