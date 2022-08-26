package login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.dao.LoginDAOInter;
import member.vo.MemberVO;

@Service
public class LoginService implements LoginServiceInter {

	@Autowired
	LoginDAOInter dao;

	@Override
	public boolean login(MemberVO member) {
		return dao.login(member);
	}

//	@Override
//	public void addlogin(HttpServletRequest req, HttpServletResponse) {
//		req.getSession().setMaxInactiveInterval(timeout);
//		req.setAttribute
//		("sessiontime",req.getSession().getMaxInactiveInterval());	

}
