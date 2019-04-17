package com.reptilesysem.system.core.util.log.service.impl;

import com.commen.utils.RequestHolder;
import com.reptilesysem.system.core.util.log.annotion.HistoryLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.util.log.dao.ISearchHistoryDao;
import com.reptilesysem.system.core.util.log.pojo.SearchHistory;
import com.reptilesysem.system.core.util.log.service.ISearchHistoryService;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Service
public class HistorySearchServiceImpl implements ISearchHistoryService{

	@Autowired
	private ISearchHistoryDao searchHistoryDao;


    @Override
    public SearchHistory logHistory(JoinPoint joinPoint) {
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        HistoryLog logAnnotation = method.getAnnotation(HistoryLog.class);
        SearchHistory history = new SearchHistory();
        history.setValue(request.getParameter("siteName"));
        history.setPath(logAnnotation.path());
        return searchHistoryDao.save(history);
    }
}
