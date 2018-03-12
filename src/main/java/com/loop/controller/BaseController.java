package com.loop.controller;

import com.loop.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exceptionHandle(Exception e) {
		//参数e就是被捕获到的异常对象
		e.printStackTrace();
		System.out.println("exceptionHandle");
		return new JsonResult(e);
	}

}