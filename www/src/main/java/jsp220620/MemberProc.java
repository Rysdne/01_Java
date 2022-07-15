package jsp220620;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberProc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String _no = req.getParameter("no");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int no = Integer.parseInt(_no);

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO(no, id, pw);
		dao.insert(vo);

		
	}

}
