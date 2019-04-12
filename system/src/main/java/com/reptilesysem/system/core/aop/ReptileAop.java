package com.reptilesysem.system.core.aop;


import com.reptilesysem.system.core.dao.IHtmlInfoDao;
import com.reptilesysem.system.core.dao.IPageHtmlDao;
import com.reptilesysem.system.core.pojo.HtmlInfo;
import com.reptilesysem.system.core.pojo.HtmlQueueInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReptileAop {

    @Autowired
    private IHtmlInfoDao dao;

    @Autowired
    private IPageHtmlDao pageHtmlDao;

    @Pointcut("execution(* com.reptilesysem.system.core.action.JsoupHtmlAction.jsoupGetHtml(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("AOP Before Advice...");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        String url = joinPoint.getArgs()[0].toString();
        HtmlInfo htmlInfo = dao.findByUrl(url);
        Document doc = Jsoup.parse(htmlInfo.getHtml());
        Elements elements = doc.select("a[href]");
        for (Element e:
             elements) {
            HtmlQueueInfo htmlQueueInfo = new HtmlQueueInfo(htmlInfo.getId(), e.text(), e.attr("href"), "0");
            pageHtmlDao.save(htmlQueueInfo);
        }
    }

    @AfterReturning(pointcut="pointCut()",returning="returnVal")
    public void afterReturn(JoinPoint joinPoint,Object returnVal){
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    @AfterThrowing(pointcut="pointCut()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("AOP Aronud before...");
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Aronud after...");
    }
}
