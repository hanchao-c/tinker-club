package org.tinker.cms.repository;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.asset.page.MybatisPageQueryer;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.cms.repository.tk.mapper.WatchMapper;
import org.tinker.cms.repository.tk.model.Watch;
import org.tinker.cms.repository.tk.model.WatchExample;
import org.tinker.cms.repository.tk.model.WatchExample.Criteria;

@Repository
public class WatchRepository {
	
	@Autowired
	private WatchMapper watchMapper;

	public Page<Watch> queryPage(PageRequest pageRequest) {
		WatchExample example = new WatchExample();
		Criteria criteria = example.createCriteria();
		SearchablePageRequest searchableRequest = (SearchablePageRequest) pageRequest;
		if (StringUtils.isNotBlank(searchableRequest.getSearch())) {
			criteria.andSubjectLike("%" + searchableRequest.getSearch() + "%");
		}
		return MybatisPageQueryer.query(watchMapper, example, pageRequest);
	}

	public void create(Watch watch) {
		watch.setLastModifedTime(LocalDateTime.now());
		if(StringUtils.isBlank(watch.getOpertor())) {
			Subject subject = SecurityUtils.getSubject();
			watch.setOpertor((String) subject.getPrincipal());
		}
		watchMapper.insert(watch);
	}

	public void update(Watch watch) {
		watch.setLastModifedTime(LocalDateTime.now());
		if(StringUtils.isBlank(watch.getOpertor())) {
			Subject subject = SecurityUtils.getSubject();
			watch.setOpertor((String) subject.getPrincipal());
		}
		watchMapper.updateByPrimaryKey(watch);
	}

	public Watch getById(String watchId) {
		return watchMapper.selectByPrimaryKey(watchId);
	}

	public void deleteById(String watchId) {
		watchMapper.deleteByPrimaryKey(watchId);
	}

}
