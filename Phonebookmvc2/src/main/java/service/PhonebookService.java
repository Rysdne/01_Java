package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhonebookDAO;
import dao.PhonebookDaoInter;
import vo.PageList;
import vo.PhonebookVO;

public class PhonebookService implements PhonebookServiceInter {
	
	// 얘도 여기 선언하는게 더 나음
	// PhonebookDAO dao = new PhonebookDAO();
	// 객체는 DAO로 받지만 인터페이스 형태로 구현
	// 버전업을 위해 객체를 인터페이스 형태로 만들어줌
	// 인터페이스를 이용해보면 이렇게 됨
	PhonebookDaoInter dao = new PhonebookDAO();

	public PageList pageList(HttpServletRequest req, HttpServletResponse resp) {

		// PhonebookDAO dao = new PhonebookDAO();

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
		// 현재 페이지
		int currentPage = 1;
		List<PhonebookVO> list = null;

		PageList plist = new PageList();

		// 전체 게시물 수 check
		totalCount = dao.totalCount();

		// 전체페이지수 check
		totalPage = (totalCount / countPerPage) + 1;
		// 전체게시물수가 나머지 0이될 경우 페이지는 1페이지가 작아짐
		if ((totalCount % countPerPage) == 0)
			totalPage = (totalCount / countPerPage);

		System.out.println("전체페이지수:" + totalPage);

		startRow = (currentPage - 1) * countPerPage + 1;
		endRow = startRow + countPerPage - 1;

		String _currentPage = req.getParameter("currentPage");
		if(_currentPage==null) currentPage=1;
		else if (!_currentPage.equals(""))
			currentPage = Integer.parseInt(_currentPage);
		// check

		// check
		list = dao.pageList(startRow, endRow, totalPage, currentPage, totalCount);

		// 네비게이트에 표시한 시작번호 끝번호
		// 표시할 시작페이지와 끝페이지는 아래쪽 페이지를 표시하기 위한 네비게이트
		// 표시할 시작페이지 check
		if (currentPage <= 5) {
			startPage = 1;
		} else {
			if (currentPage % 5 == 0) {
				startPage = (currentPage / 5) * 5;
			} else {
				startPage = (currentPage / 5) * 5 + 1; // --처리 10페이지일 때 문제 발생
			}
		}

		// 표시할 끝페이지 check
		endPage = startPage + 4;
		// 전체페이지가 표현하려는 페이지보다 클 경우 전체페이지수까지 표시
		if (endPage > totalPage)
			endPage = totalPage;

		// findAll.jsp에 view를 하기 위한 데이터 입력(Model:DAO 요청 후 처리된 데이터 저장 -> 처리)
		plist.setList(list);
		plist.setStartPage(startPage);
		plist.setEndPage(endPage);
		plist.setCurrentPage(currentPage);
		plist.setCountPerPage(countPerPage);
		plist.setTotalCount(totalCount);
		plist.setTotalPage(totalPage);

		return plist;
	}

}
