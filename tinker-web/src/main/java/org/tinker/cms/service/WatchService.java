package org.tinker.cms.service;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.cms.repository.tk.model.Watch;

public interface WatchService {

	Page<Watch> queryPage(PageRequest pageRequest);

	void create(Watch watch);

	void update(Watch watch);

	Watch getById(String watchId);

	void deleteById(String watchId);

}
