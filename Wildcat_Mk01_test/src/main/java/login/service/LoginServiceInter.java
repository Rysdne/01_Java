package login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginServiceInter {

	boolean login(HttpServletRequest req, HttpServletResponse resp);

}
