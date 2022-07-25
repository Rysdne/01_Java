package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.PageList;

public interface PhonebookServiceInter {

	PageList pageList(HttpServletRequest req, HttpServletResponse resp);

}
