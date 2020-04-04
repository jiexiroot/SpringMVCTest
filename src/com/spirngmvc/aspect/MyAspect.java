package com.spirngmvc.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author GOU
 *
 */
@Aspect
@Component
public class MyAspect  {
	/**
	 * 定义切入点
	 */
	@Pointcut("execution(* com.spirngmvc.dao.impl.*.* (..))")
	private void myPointCut() {}
	/**
	 * 模拟权限检查的方法
	 */
	@Before("myPointCut()")
	public void checkPermission() {
		System.out.println("权限检查");
	}
	/**
	 * 模拟日志记录的方法
	 */
	@AfterReturning("myPointCut()")
	public void log() {
		System.out.println("日志记录");
	}


}