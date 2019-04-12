package com.reptilesysem.system.core.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commen.base.BaseHttpCode;
import com.commen.base.BaseHttpMessage;
import com.commen.pojo.RestData;
import com.reptilesysem.system.core.pojo.Moudles;
import com.reptilesysem.system.core.service.IMoudlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/moudles")
public class MoudlesAction {
	
	@Autowired
	private IMoudlesService moudlesService;

	@Autowired
	private HttpServletRequest request;

	@PostMapping("/createMoudles")
	public RestData createMoudles() {
		String moudleName = request.getParameter("moudleName");
		moudlesService.saveMoudles(new Moudles(moudleName));
		return new RestData(
		        BaseHttpCode.SUCCESS.getCode(),
                BaseHttpMessage.SUCCESS.getMessage(),
                "创建模型成功"
        );
	}
	
	@GetMapping("/getMoudles")
	private RestData getMoudles() {
		List<Moudles> moudles = moudlesService.getMoudles();
		return new RestData(
		        BaseHttpCode.SUCCESS.getCode(),
                BaseHttpMessage.SUCCESS.getMessage(),
                moudles
        );
	}

	@PostMapping("/freezeMoudles")
	public RestData freezeMoudles() {
		return new RestData(
		        BaseHttpCode.SUCCESS.getCode(),
                BaseHttpMessage.SUCCESS.getMessage(),
                "模型禁用成功"
        );
	}
	
	@GetMapping("/getMoudlesByHtmlId")
	public RestData getMoudlesByHtmlId(String htmlId) {
		List<Moudles> moudles = moudlesService.findMoudlesByHtmlId(htmlId);
		return new RestData(
		        BaseHttpCode.SUCCESS.getCode(),
                BaseHttpMessage.SUCCESS.getMessage(),
                moudles
        );
	}
}
