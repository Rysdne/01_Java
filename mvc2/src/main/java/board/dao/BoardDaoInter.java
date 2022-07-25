package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDaoInter {

	public int insert(BoardVO pb);

	public int totalCount();

	public List pageList(int startRow, int endRow, int totalPage, int currentPage, int totalCount);

	public BoardVO findOne(int idx);

	public void readCountUp(int idx);

//public List<BoardVO> findAll();
//public int update(BoardVO pb);
//public int delete(int idx);
//public boolean exist(int idx);

}
