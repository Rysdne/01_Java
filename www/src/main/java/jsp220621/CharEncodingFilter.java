package jsp220621;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class CharEncodingFilter implements Filter {

	@Override
	// 내부적으로 실행되기 때문에 ServletRequest 형태로 만들어짐
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 필터를 적용하는 명령어(?)
		chain.doFilter(request, response);

		System.out.println("after filter");
	}

}
