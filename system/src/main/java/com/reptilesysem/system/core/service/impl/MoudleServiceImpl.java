package com.reptilesysem.system.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.dao.IMoudleHtmlRefDao;
import com.reptilesysem.system.core.dao.IMoudlesDao;
import com.reptilesysem.system.core.pojo.MoudleHtmlInfoRef;
import com.reptilesysem.system.core.pojo.Moudles;
import com.reptilesysem.system.core.service.IMoudlesService;

@Service
public class MoudleServiceImpl implements IMoudlesService{
	
	@Autowired
	private IMoudlesDao moudlesDao;

	@Autowired
	private IMoudleHtmlRefDao moudleRefDao;
	
	@Override
	public Moudles saveMoudles(Moudles moudles) {
		return moudlesDao.save(moudles);
	}

	@Override
	public Integer updateMoudles(Moudles moudles) { 
		return null;
	}

	@Override
	public List<Moudles> getMoudles() {
		return (List<Moudles>) moudlesDao.findAll();
	}

	@Override
	public List<Moudles> findMoudlesByHtmlId(String htmlId) {
		List<Moudles> result = new ArrayList<Moudles>();
		List<MoudleHtmlInfoRef> moudleRefs = moudleRefDao.findByHtmlInfoId(htmlId);
		moudleRefs.stream().forEach((Item) -> {
			Moudles moudles  = moudlesDao.findById(Item.getMoudleId()).get();
			result.add(moudles);
		});
		return result;
	}

}
