package com.reptilesysem.system.core.service;

import java.util.List;

import com.reptilesysem.system.core.pojo.Moudles;

public interface IMoudlesService{
	
	Moudles saveMoudles(Moudles moudles);
	
	Integer updateMoudles(Moudles moudles);

	List<Moudles> getMoudles();

	List<Moudles> findMoudlesByHtmlId(String htmlId);
}
