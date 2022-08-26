package aop2;

public class Advice {

	public Advice() {

	}

	public void before() {
		System.out.println("before");
	}

	public void after() {
		System.out.println("after");
	}

	public void after_returning() {
		System.out.println("after_returning");
	}

	public void after_throwing() {
		System.out.println("after_throwing");
	}

}