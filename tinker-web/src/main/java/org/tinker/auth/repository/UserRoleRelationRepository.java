package org.tinker.auth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.auth.repository.tk.mapper.UserRoleRelationMapper;
import org.tinker.auth.repository.tk.model.UserRoleRelation;
import org.tinker.auth.repository.tk.model.UserRoleRelationExample;

@Repository
public class UserRoleRelationRepository {

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	public List<UserRoleRelation> getByAccount(String account) {
		UserRoleRelationExample example = new UserRoleRelationExample();
		example.createCriteria().andAccountEqualTo(account);
		return userRoleRelationMapper.selectByExample(example);
	}

	public void create(UserRoleRelation relation) {
		userRoleRelationMapper.insert(relation);
	}

	public List<UserRoleRelation> getByUserAccount(String account) {
		UserRoleRelationExample example = new UserRoleRelationExample();
		example.createCriteria().andAccountEqualTo(account);
		return userRoleRelationMapper.selectByExample(example);
	}

	public void deleteByAccountAndRoleId(String account, String roleId) {
		UserRoleRelationExample example = new UserRoleRelationExample();
		example.createCriteria().andAccountEqualTo(account).andRoleIdEqualTo(roleId);
		userRoleRelationMapper.deleteByExample(example);
	}

	public void deleteByAccount(String account) {
		UserRoleRelationExample example = new UserRoleRelationExample();
		example.createCriteria().andAccountEqualTo(account);
		userRoleRelationMapper.deleteByExample(example);
	}

	public int countByRoleId(String roleId) {
		UserRoleRelationExample example = new UserRoleRelationExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return userRoleRelationMapper.selectCountByExample(example);
	}
}
