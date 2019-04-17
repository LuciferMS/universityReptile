package com.reptilesysem.system.core.service;

import java.util.List;

import com.reptilesysem.system.core.pojo.Modules;

public interface IModulesService {
	
	Modules saveModules(Modules modules);
	
	Integer updateModules(Modules modules);

	List<Modules> getModules();

	List<Modules> findModulesByHtmlId(String htmlId);
}
