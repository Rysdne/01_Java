package dao;

import java.util.List;

import vo.PhonebookVO;

//설계서
public interface PhonebookDaoInter {
public int insert(PhonebookVO pb);
public List<PhonebookVO> findAll();
public PhonebookVO findOne(int id);
public int update(PhonebookVO pb);
public int delete(int id);
public boolean exist(int id);
public int totalCount();
public List pageList(int startRow, int endRow, int totalPage, int currentPage, int totalCount);
}
