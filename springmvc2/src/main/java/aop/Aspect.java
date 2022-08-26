package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect {

	public Object frontEndFunc(ProceedingJoinPoint joinpoint) throws Throwable{
		
		System.out.println("start");
		
		// 핵심 기능
		Object obj=joinpoint.proceed();
		
		// 뒤
		System.out.println("end");
		return obj;
	}
}