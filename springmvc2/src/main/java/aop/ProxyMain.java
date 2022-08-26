package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {

	public static void main(String[] args) {

		// 일반 객체
		Print p = new APrint();
		// 일반 객체와 프록시 객체를 이어줄 인터페이스가 필요
		// 접근 자체를 인터페이스를 통하도록 해줘야 함
		
		
		// 프록시 객체
		// aop.Print.class.getClassLoader() : 일단 클래스를 메모리에 올리는 작업
		// new Class[] {Print.class} : 실질적인 클래스 생성, proxy 적용할 Print 객체를 알려줌
		// new InvocationHandler() : 동작 핸들러 생성(트리거?), aspect 코드 작성
		Print proxy = (Print) Proxy.newProxyInstance(aop.Print.class.getClassLoader(), new Class[] { Print.class },
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						// 특정 함수가 호출될 때 그 전에 실행될 내용 정의
						System.out.println("start");

						// 특정 함수 위치
						// 동작할 객체인 p가 들어가야 불러올 수 있음
						Object result = method.invoke(p, args);
						
						// 특정 함수가 호출될 때 그 후에 실행될 내용 정의
						System.out.println("end");
						return result;
					}
				});

		proxy.print1();
		proxy.print2();
		
	}

}