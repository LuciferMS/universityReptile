package com.reptilesysem.system.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.reptilesysem.system.core.pojo.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.dao.IMoudleHtmlRefDao;
import com.reptilesysem.system.core.dao.IMoudlesDao;
import com.reptilesysem.system.core.pojo.MoudleHtmlInfoRef;
import com.reptilesysem.system.core.service.IModulesService;

@Service
public class MoudleServiceImpl implements IModulesService {
	
	@Autowired
	private IMoudlesDao moudlesDao;

	@Autowired
	private IMoudleHtmlRefDao moudleRefDao;
	
	@Override
	public Modules saveModules(Modules modules) {
		return moudlesDao.save(modules);
	}

	@Override
	public Integer updateModules(Modules moudles) {
		return null;
	}

	@Override
	public List<Modules> getModules() {
		return (List<Modules>) moudlesDao.findAll();
	}

	@Override
	public List<Modules> findModulesByHtmlId(String htmlId) {
		List<Modules> result = new ArrayList<Modules>();
		List<MoudleHtmlInfoRef> moduleRefs = moudleRefDao.findByHtmlInfoId(htmlId);
		moduleRefs.stream().forEach((Item) -> {
			Modules modules  = moudlesDao.findById(Item.getMoudleId()).get();
			result.add(modules);
		});
		return result;
	}

}
