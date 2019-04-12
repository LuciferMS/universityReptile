package com.reptilesysem.system.core.service;

import java.util.Optional;

import com.reptilesysem.system.core.pojo.EduJsonBean;

public interface IEduJsonBeanService {
	
	Integer saveBean(EduJsonBean bean);
	
	Optional<EduJsonBean> findBeanById(String id);
	
	Integer updateBean(EduJsonBean bean);
}
