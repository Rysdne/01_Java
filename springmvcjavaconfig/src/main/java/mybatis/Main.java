package mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void Main(String[] args) {

		// config.xml 파일에서 member 함수들 가져옴(?)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mybatis/config.xml");

		// MemberServiceImpl에서 어노테이션 적용
		// ㄴ> @Service
		// MemberMapper Impl에서 @Autowired로 연결시켜줘야 함
		// Member 클래스도 @Component로 연결
		MemberService service = (MemberService) ctx.getBean("memberservice", mybatis.MemberServiceImpl.class);

//		// service.insert("aaaa","1111");
//		System.out.println(service.select("admin"));

		// 리스트 출력
		List<Member> list = service.getList();
		for(Member m:list) {
			System.out.println(m.toString());
		}
		
	}

}
