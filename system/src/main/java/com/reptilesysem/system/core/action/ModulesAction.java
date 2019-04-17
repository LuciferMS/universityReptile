package com.reptilesysem.system.core.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commen.pojo.RestData;
import com.reptilesysem.system.core.pojo.Modules;
import com.reptilesysem.system.core.service.IModulesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/modules")
public class ModulesAction {
	
	@Autowired
	private IModulesService modulesService;

	@Autowired
	private HttpServletRequest request;

	@PostMapping("/createModules")
	public RestData createModules(String modulesName) {
        modulesService.saveModules(new Modules(modulesName));
        return RestData.builderOfSuccess().details("创建模型成功");
	}
	
	@GetMapping("/getModules")
	private RestData getModules() {
		List<Modules> modules = modulesService.getModules();
        return RestData.builderOfSuccess().details(modules);
	}

	@PostMapping("/freezeModules")
	public RestData freezeModules() {
	    return RestData.builderOfSuccess().details("冻结模型成功");
	}
	
	@GetMapping("/getModulesByHtmlId")
	public RestData getModulesByHtmlId(String htmlId) {
		List<Modules> modules = modulesService.findModulesByHtmlId(htmlId);
		return RestData.builderOfSuccess().details(modules);
	}
}
