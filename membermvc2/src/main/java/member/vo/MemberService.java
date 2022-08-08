package member.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.service.MemberServiceInter;

public class MemberService implements MemberServiceInter {
	MemberDAO dao = new MemberDAO();

	@Override
	public MemberVO findOne(HttpServletRequest req, HttpServletResponse resp) {
		return dao.findOne(Integer.parseInt(req.getParameter("idx")));
	}

	@Override
	public List<MemberVO> findAll(HttpServletRequest req, HttpServletResponse resp) {
		return dao.findAll();
	}


}
