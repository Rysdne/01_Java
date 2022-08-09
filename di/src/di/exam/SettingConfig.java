package di.exam;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration : Autowired 기능, xml의 <context:annotation-config></context:annotation-config>를 대신함
@Configuration
// @ComponentScan("~~~") : Bean 생성 기능, xml의 <context:component-scan base-package="di.exam"></context:component-scan>을 대신함
@ComponentScan("di.exam")
public class SettingConfig {
	
}
