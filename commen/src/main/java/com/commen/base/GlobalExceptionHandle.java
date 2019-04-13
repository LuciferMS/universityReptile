package com.commen.base;

import java.util.NoSuchElementException;

import com.commen.pojo.RestData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public RestData baseExceptionHandle(Exception e) {
		e.printStackTrace();
		log.error("捕获到exception异常", e);
		return RestData.builderOfFail().details("程序运行异常");
	}
	

	@ResponseBody
	@ExceptionHandler(value=NoSuchElementException.class)
	public RestData notSuchElementExceptionHandle(NoSuchElementException e) {
		e.printStackTrace();
		log.info("规则不匹配");
		return RestData.builderOfFail().details("有可能是规则不匹配");
	}
	
}
