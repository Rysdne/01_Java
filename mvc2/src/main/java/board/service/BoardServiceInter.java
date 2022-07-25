package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.BoardVO;
import board.vo.PageList;
import login.vo.MemberVO;


public interface BoardServiceInter {

	PageList pageList(HttpServletRequest req, HttpServletResponse resp);

	BoardVO findOne(HttpServletRequest req, HttpServletResponse resp);

	MemberVO findOne(String id);

}
