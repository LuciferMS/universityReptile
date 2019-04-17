package com.reptilesysem.system.core.util.log.service;

import com.reptilesysem.system.core.util.log.pojo.SearchHistory;
import org.aspectj.lang.JoinPoint;

/**
 * 
 * @author Elliot
 *
 */
public interface ISearchHistoryService {
	
	SearchHistory logHistory(JoinPoint joinPoint);
	
}
