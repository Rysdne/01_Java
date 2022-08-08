package basic220613_1;

import java.util.List;

public interface BoardInter {

	public int insert(BoardVO bv);

	public List<BoardVO> findAll();

	public BoardVO findOne(int num);

	public boolean exist(int num);

	public int update(BoardVO bv);

	public int delete(int num);

}
