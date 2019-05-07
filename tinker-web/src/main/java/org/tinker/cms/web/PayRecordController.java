package org.tinker.cms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.cms.service.PayRecordService;
import org.tinker.payment.model.PayRecordTransfer;

@RestController
@RequestMapping("payRecords")
public class PayRecordController {

	@Autowired
	private PayRecordService payRecordService;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<PayRecordTransfer>> queryPage(@Valid SearchablePageRequest pageRequest) {
		Page<PayRecordTransfer> page = payRecordService.queryPage(pageRequest);
		return ResponseEntityWrapper.OK(page);
	}
}
