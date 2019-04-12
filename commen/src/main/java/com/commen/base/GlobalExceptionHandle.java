package com.commen.base;

import java.util.NoSuchElementException;

import com.commen.pojo.RestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandle {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandle.class);
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public RestData baseExceptionHandle(Exception e) {
		e.printStackTrace();
		LOGGER.error("捕获到exception异常", e);
		return new RestData(200, "程序发生异常" , e.toString());
	}
	

	@ResponseBody
	@ExceptionHandler(value=NoSuchElementException.class)
	public RestData notSuchElementExceptionHandle(NoSuchElementException e) {
		e.printStackTrace();
		LOGGER.error("规则不匹配", e);
		return new RestData(200, "规则不匹配" , e.toString());
	}
	
}
