package login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDAO;
import login.dao.LoginDaoInter;
import login.vo.LoginVO;

public class LoginService implements LoginServiceInter {
	LoginDaoInter dao = new LoginDAO();

	public boolean login(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		LoginVO vo = new LoginVO(id, password);

		boolean result = dao.login(vo);
		if (result) {
			req.getSession().setAttribute("id", req.getParameter("id"));
		}
		return result;
	}

}
