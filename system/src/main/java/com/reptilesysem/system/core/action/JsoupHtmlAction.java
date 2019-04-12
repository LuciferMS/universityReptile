package com.reptilesysem.system.core.action;


import com.commen.base.BaseHttpCode;
import com.commen.base.BaseHttpMessage;
import com.commen.pojo.RestData;
import com.reptilesysem.system.core.pojo.HtmlInfo;
import com.reptilesysem.system.core.service.IHtmlInfoService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsoup/html")
@Slf4j
public class JsoupHtmlAction {

    @Autowired
    private IHtmlInfoService service;

    @RequestMapping("/getHtml")
    public RestData jsoupGetHtml(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            HtmlInfo htmlInfo = new HtmlInfo(doc.title(), doc.html(), url);
            service.save(htmlInfo);
            return RestData.builderOfSuccess().details("获取成功");
        }catch (Exception e){
            return RestData.builderOfFail().details("获取失败");
        }
    }

    @RequestMapping("/getHtmlNotAop")
    public RestData getHtmlByUrl(String url, String type){
        try{
            Document doc = Jsoup.connect(url).get();
            HtmlInfo htmlInfo = new HtmlInfo(doc.title(), doc.html(), url);
            service.save(htmlInfo);
            return RestData.builderOfSuccess().details("获取成功");
        }catch (Exception e){
            return new RestData(BaseHttpCode.FAIL.getCode(), "Error", null);
        }
    }
}
