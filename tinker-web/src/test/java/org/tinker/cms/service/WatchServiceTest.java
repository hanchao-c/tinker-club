package org.tinker.cms.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.tinker.CompositeJUnit4SpringContext;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.asset.persistent.Transactional_cms;
import org.tinker.asset.util.IDUtil;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.cms.repository.tk.model.Watch;

import lombok.extern.slf4j.Slf4j;

@Transactional_cms
@Slf4j
public class WatchServiceTest extends CompositeJUnit4SpringContext {

	@Autowired
	private WatchService watchService;
	
	@Test
	@Rollback
	public void testCreate() {
		String id = IDUtil.uuid();
		Watch watch = new Watch();
		watch.setId(id);
		watch.setLastModifedTime(LocalDateTime.now());
		watch.setSubject("subject here!");
		watch.setOpertor("tinker");
		watchService.create(watch);
		
		SearchablePageRequest searchableRequest = new SearchablePageRequest();
		searchableRequest.setOffset(0);
		searchableRequest.setPageSize(10);
		Page<Watch> pagedList = watchService.queryPage(searchableRequest);
		Assert.assertFalse(pagedList.isEmpty());
		log.info(JacksonUtil.toJSONString(pagedList));
	}



}
