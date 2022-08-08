package basic220613;

import java.util.List;

// 설계서 : DAO에 넣을 인터페이스 생성
public interface PhonebookInter {
	// 커서 호버 후 Create VO
	public int insert(PhonebookVO pb);
	public List<PhonebookVO> findAll();
	public PhonebookVO findOne(int id);
	public int update(PhonebookVO pb);
	public int delete (int id);
	public boolean exist(int id);
	
}
