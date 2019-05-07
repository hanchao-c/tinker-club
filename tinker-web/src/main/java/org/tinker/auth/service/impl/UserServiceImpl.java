package org.tinker.auth.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.persistent.Transactional_auth;
import org.tinker.asset.util.IDUtil;
import org.tinker.asset.webplugin.select2.Select2Structure;
import org.tinker.auth.model.structure.RoleStructure;
import org.tinker.auth.repository.UserRepository;
import org.tinker.auth.repository.UserRoleRelationRepository;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.repository.tk.model.UserRoleRelation;
import org.tinker.auth.service.RoleService;
import org.tinker.auth.service.UserService;
import org.tinker.util.Propagater;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRelationRepository userRoleRelationRepository;
	@Autowired
	private RoleService roleService;
	
	@Override
	public User getByAccount(String account) {
		return userRepository.getByAccount(account);
	}

	@Override
	public int create(User user) {
		user.encryptPassword();
		user.setId(IDUtil.uuid());
		return userRepository.create(user);
	}

	@Override
	public Page<User> queryPage(PageRequest pageRequest) {
		return userRepository.queryPage(pageRequest);
	}

	@Transactional_auth
	@Override
	public void updateUserRoleExcludePassword(User user, String[] lastRoleIds, String[] currentRoleIds) {
		//String[] -> Set<String>
		Set<String> last = ArrayUtils.isNotEmpty(lastRoleIds) ? Sets.newTreeSet(Arrays.asList(lastRoleIds)) : Sets.newTreeSet();
		//String[] -> Set<String>
		Set<String> current = ArrayUtils.isNotEmpty(currentRoleIds) ? Sets.newTreeSet(Arrays.asList(currentRoleIds)) : Sets.newTreeSet();
		//删除无效用户角色对应关系
		Sets.difference(last, current).stream().forEach(roleId -> {
			userRoleRelationRepository.deleteByAccountAndRoleId(user.getAccount(), roleId);
		});
		//创建有效用户角色对应关系
		Sets.difference(current, last).stream().map(roleId -> {
			return new UserRoleRelation()
				.withId(IDUtil.uuid())
				.withAccount(user.getAccount())
				.withRoleId(roleId);
		}).forEach(userRoleRelationRepository::create);
		//修改用户信息
		userRepository.updateExcludePassword(user);
	}

	@Override
	public User getById(String id) {
		return userRepository.getById(id);
	}

	@Transactional_auth
	@Override
	public void deleteUserRoleByUserId(String userId) {
		User user = userRepository.getById(userId);
		//删除用户
		userRepository.deleteById(userId);
		//删除用户角色对应关系
		userRoleRelationRepository.deleteByAccount(user.getAccount());
		
	}

	@Transactional_auth
	@Override
	public void createUserAndRole(User user, String[] roleIds) {
		//校验当前用户是否存在
		User historyUser = userRepository.getByAccount(user.getAccount());
		if(null != historyUser) {
			Propagater.throwOf("当前用户已经存在");
		}
		//添加用户
		this.create(user);
		//添加用户以及用户角色对应关系
		Stream.of(roleIds).map(roleId -> {
			return new UserRoleRelation()
				.withId(IDUtil.uuid())
				.withAccount(user.getAccount())
				.withRoleId(roleId);
		}).forEach(userRoleRelationRepository::create);

	}

	@Override
	public UserRoleModel getUserRoleByUserId(String id) {
		User user = this.getById(id);
		if(null == user) {
			Propagater.throwOf("当前用户不存在");
		}
		List<UserRoleRelation> relations = userRoleRelationRepository.getByUserAccount(user.getAccount());
		List<String> roleIds = relations.stream().map(UserRoleRelation::getRoleId).collect(Collectors.toList());
		return new UserRoleModel(user, roleIds);
	}

	@Override
	public void refreshPassword(String userId, String password) {
		/**
		 * 1，管理员修改其他用户密码 userId不能为空
		 * 2，用户修改自己账号的喵喵 userId为空
		 */
		User user = null;
		if(StringUtils.isNotBlank(userId)) {
			user = this.getById(userId);
		}else {
			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			user = this.getByAccount(account);
		}
		if(null == user) {
			Propagater.throwOf("当前用户不存在, 修改密码失败");
		}
		//修改密码
		user.setPassword(password);
		user.encryptPassword();
		userRepository.refreshPassword(user);
	}
	
	@Override
	public List<Select2Structure> getRoleStructures() {
		List<Role> roles = roleService.getAllRoles();
		List<Select2Structure> roleStructures = roles.stream()
				.map(role -> new RoleStructure(role.getId(), role.getRoleName()))
				.collect(Collectors.toList());
		return roleStructures;
	}
	

	@Setter
	@Getter
	@ToString
	public static class UserRoleModel {
		private User user;
		private List<String> roleIds = Lists.newArrayList();
		public UserRoleModel(User user, List<String> roleIds) {
			this.user = user;
			this.roleIds = roleIds;
		}
	}
	

}
