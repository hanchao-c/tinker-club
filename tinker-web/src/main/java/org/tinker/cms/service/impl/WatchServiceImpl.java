package org.tinker.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.util.IDUtil;
import org.tinker.cms.repository.WatchRepository;
import org.tinker.cms.repository.tk.model.Watch;
import org.tinker.cms.service.WatchService;

@Service
public class WatchServiceImpl implements WatchService {
	
	@Autowired
	private WatchRepository repository;

	@Override
	public Page<Watch> queryPage(PageRequest pageRequest) {
		return repository.queryPage(pageRequest);
	}

	@Override
	public void create(Watch watch) {
		watch.setId(IDUtil.uuid());
		repository.create(watch);
	}

	@Override
	public void update(Watch watch) {
		repository.update(watch);
	}

	@Override
	public Watch getById(String watchId) {
		return repository.getById(watchId);
	}

	@Override
	public void deleteById(String watchId) {
		repository.deleteById(watchId);
	}

}
