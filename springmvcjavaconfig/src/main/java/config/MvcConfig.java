package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import controller.FrontController;

// 웹 MVC 활성화 & 설정파일로 선언 & 스캔 기능 부여
// 스캔시에 basePackages는 배열이기 때문에 중괄호 내에 폴더명을 입력해야 함
// dispatcher-servlet.xml 파일 역할을 대신함(config파일)
// ㄴ모든 파일이 자바로 이루어짐(?)
//@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "controller" })
public class MvcConfig implements WebMvcConfigurer {
	// config 인터페이스 불러옴

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	// <mvc:resource location="/resources/" mapping="/resources/**" />
	// my 프로젝트의 dispatcher-servlet.xml 파일에 선언한 리소스 사용 선언
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean(name = "/test1")
	public FrontController test1() {
		return new FrontController();
	}
}
