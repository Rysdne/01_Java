package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAOv2;
import board.dao.BoardDaoInter;
import board.vo.BoardVO;
import board.vo.PageList;
import login.dao.MemberDAO;
import login.dao.MemberDAOInter;
import login.vo.MemberVO;

public class BoardService implements BoardServiceInter {
	BoardDaoInter dao = new BoardDAOv2();
	MemberDAOInter memberdao=new MemberDAO();

	public PageList pageList(HttpServletRequest req, HttpServletResponse resp) {
		// 전체게시물 수
		int totalCount = 0;
		// 페이지당 글의 수
		int countPerPage = 10;
		// 전체페이지수
		int totalPage = 0;
		// 시작페이지
		int startPage = 0;
		// 끝페이지
		int endPage = 0;
		// 글의 시작번호
		int startRow = 0;
		// 글의 끝번호
		int endRow = 0;
		// 현재페이지
		int currentPage = 1;
		List<BoardVO> list = null;

		// 위의 모든 정보는 pagelist에 모두 저장되어 cotroller에게 전달
		PageList plist = new PageList();

		// 전체게시물수 check
		totalCount = dao.totalCount();

		// 전체페이지수 check
		totalPage = (totalCount / countPerPage) + 1;
		if ((totalCount % countPerPage) == 0)
			totalPage = (totalCount / countPerPage);

		// 전달되어지는 현재페이지를 확인
		String _currentPage = req.getParameter("currentPage");
		if (_currentPage == null)
			currentPage = 1;
		else if (!_currentPage.equals(""))
			currentPage = Integer.parseInt(_currentPage);// check

		// 현재페이지에 대한 글의 시작번호 끝번호
		startRow = (currentPage - 1) * countPerPage + 1;
		endRow = startRow + countPerPage - 1;

		// 위에서 확인정보를 이용하여 페이지의 dao로부터 정보를 가져옴
		list = dao.pageList(startRow, endRow, totalPage, currentPage, totalCount);

		// 표시할 시작페이지
		if (currentPage <= 5) {
			startPage = 1;
		} else {
			if (currentPage % 5 == 0) {
				startPage = (currentPage / 5) * 5;
			} else {
				startPage = (currentPage / 5) * 5 + 1; // --처리 10페이지일 때 문제 발생
			}
		}

		// 표시할 끝페이지
		endPage = startPage + 4;

		// 전체페이지가 표현하려는 페이지보다 클 경우 전체페이지수까지 표시
		if (endPage > totalPage)
			endPage = totalPage;

		// findAll.jsp에 view를 하기위해 필요한 데이터 입력(MODEL)
		plist.setList(list);
		plist.setStartPage(startPage);
		plist.setEndPage(endPage);
		plist.setCurrentPage(currentPage);
		plist.setCountPerPage(countPerPage);
		plist.setTotalCount(totalCount);
		plist.setTotalPage(totalPage);
		for (BoardVO board : plist.getList()) {
			System.out.println(board);
		}
		return plist;

	}

	@Override
	public BoardVO findOne(HttpServletRequest req, HttpServletResponse resp) {
		int idx = Integer.parseInt(req.getParameter("idx"));
		dao.readCountUp(idx);
		BoardVO board = dao.findOne(idx);
		return board;
	}

	@Override
	public MemberVO findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
