package vo;

import java.util.ArrayList;
import java.util.List;

public class PageList {
	// 전체게시물 수, 페이지당 글의 수, 전체페이지수, 시작페이지, 끝페이지,글의 시작번호, 글의 끝번호
	private int totalCount;
	private int countPerPage = 10;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private int currentPage;
	private List<PhonebookVO> list;

	public PageList() {
	}

	public PageList(int totalCount, int countPerPage, int totalPage, int startPage, int endPage, int startRow,
			int endRow, int currentPage, List<PhonebookVO> list) {
		this.totalCount = totalCount;
		this.countPerPage = countPerPage;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.currentPage = currentPage;
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<PhonebookVO> getList() {
		return list;
	}

	public void setList(List<PhonebookVO> list) {
		this.list = list;
	}

	
	
	
}
