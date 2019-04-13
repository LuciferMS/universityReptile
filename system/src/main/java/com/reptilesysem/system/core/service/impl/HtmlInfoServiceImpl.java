package com.reptilesysem.system.core.service.impl;

import com.reptilesysem.system.core.dao.IHtmlInfoDao;
import com.reptilesysem.system.core.pojo.HtmlInfo;
import com.reptilesysem.system.core.service.IHtmlInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HtmlInfoServiceImpl implements IHtmlInfoService {

    @Autowired
    private IHtmlInfoDao htmlInfoDao;

    @Override
    public HtmlInfo save(HtmlInfo htmlInfo) {
        return htmlInfoDao.save(htmlInfo);
    }

}
