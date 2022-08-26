package advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class LoginAdvice {
	@Autowired
	HttpServletRequest req;

	public LoginAdvice() {

	}

	public Object loginCheck(ProceedingJoinPoint joinpoint) throws Throwable {
		
		// req 받는 방법 1
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println(req.getAttribute("id"));

//		// req 받는 방법 2
//		Object[] obj=joinpoint.getArgs();
//		HttpSession session=(HttpSession)obj[2];
//		System.out.println(session.getAttribute("id"));
		
		if (req.getSession().getAttribute("id") == null) {
			// login/login으로 이동
			return null;
		} else {

			Object obj = joinpoint.proceed();
			return obj;
		}
	}
}
