package aop2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("aop2/config.xml");
		
		TargetA ta1=(TargetA) ctx.getBean("targetA");
		ta1.doSomething1();

		TargetB ta2=(TargetB) ctx.getBean("targetB");
		ta2.doSomething2();
		
	}
	
}
