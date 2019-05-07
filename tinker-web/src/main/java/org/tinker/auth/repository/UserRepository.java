package org.tinker.auth.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.asset.constant.SystemUser;
import org.tinker.asset.page.MybatisPageQueryer;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.auth.repository.tk.mapper.UserMapper;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.repository.tk.model.UserExample;
import org.tinker.auth.repository.tk.model.UserExample.Criteria;

@Repository
public class UserRepository {

	@Autowired
	private UserMapper userMapper;

	public User getByAccount(String account) {
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(account);
		return userMapper.selectOneByExample(example);
	}

	public int create(User user) {
		return userMapper.insert(user);
	}

	public User getById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public void deleteById(String id) {
		userMapper.deleteByPrimaryKey(id);
	}

	public void updateExcludePassword(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	public void refreshPassword(User user) {
		userMapper.updateByPrimaryKey(user);
	}
	
	public Page<User> queryPage(PageRequest pageRequest) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountNotEqualTo(SystemUser.SYSTEM_OWNER_ACCOUNT);
		SearchablePageRequest searchablePageRequest = (SearchablePageRequest) pageRequest;
		if (StringUtils.isNoneBlank(searchablePageRequest.getSearch())) {
			criteria.andAccountLike("%" + searchablePageRequest.getSearch() + "%");
		}
		return MybatisPageQueryer.query(userMapper, example, pageRequest);
	}

}
