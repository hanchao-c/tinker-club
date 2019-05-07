package org.tinker.cms.web;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.cms.model.mock.WatchMock;
import org.tinker.cms.repository.tk.model.Watch;
import org.tinker.cms.service.WatchService;
import org.tinker.util.Propagater;

@RestController
@RequestMapping("watches")
public class WatchController {

	@Autowired
	private WatchService watchService;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<Watch>> queryPage(@Valid SearchablePageRequest pageRequest) {
		Page<Watch> page = watchService.queryPage(pageRequest);
		return ResponseEntityWrapper.OK(page);
	}
	
	/**
	 * 
	 * @param watch
	 * @return
	 */
	@PostMapping
	public void create(@Validated WatchMock watch) {
		watchService.create(watch);
	}
	
	/**
	 * 
	 * @param watch
	 * @return
	 */
	@PutMapping
	public void update(@Validated WatchMock watch) {
		watchService.update(watch);
	}
	
	/**
	 * 
	 * @param watchId
	 * @return
	 */
	@GetMapping("{watchId}")
	public ResponseEntity<Watch> getById(@NotBlank @PathVariable("watchId") String watchId) {
		Watch watch = watchService.getById(watchId);
		if(null == watch) {
			Propagater.throwOf("记录不存在");
		}
		return ResponseEntityWrapper.OK(watch);
	}
	
	/**
	 * 
	 * @param watchId
	 * @return
	 */
	@DeleteMapping("{watchId}")
	public void deleteById(@NotBlank @PathVariable("watchId") String watchId) {
		watchService.deleteById(watchId);
	}
	
}
