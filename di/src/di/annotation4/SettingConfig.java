package di.annotation4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

// 1) 컴포넌트 스캔을 제거하여 @Component 를 사용할 수 없도록 함
// ㄴ bean 생성기능 제거
//@ComponentScan("di.annotation3")
public class SettingConfig {

	// 2) @ComponentScan을 사용하지 않음
	// ㄴ 순수자바(@Component가 없는 자바 : Student, Sungjuk)를 설정자바(SettingConfig)에서 등록(?)
	// ㄴ 데이터를 처리하는 클래스에서 어노테이션을 제거하고 설정(setting) 역할을 하는 부분에만 등록
	
	@Bean
	public Student student() {
		return new Student();
	}

	@Bean
	public Sungjuk sungjuk() {
		return new Sungjuk(90,90,90);
	}

	@Bean
	public Student student1() {
		return new Student();
	}
	
}
