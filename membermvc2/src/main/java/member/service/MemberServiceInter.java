package member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.vo.MemberVO;

public interface MemberServiceInter {

	// findOne는 MemberVO를 반환함
	MemberVO findOne(HttpServletRequest req, HttpServletResponse resp);
	List<MemberVO> findAll(HttpServletRequest req, HttpServletResponse resp);

	
	
}
