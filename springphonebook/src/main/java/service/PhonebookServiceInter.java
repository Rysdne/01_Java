package service;

import java.util.List;

import vo.PhonebookVO;

public interface PhonebookServiceInter {

	public List<PhonebookVO> getList();

	public List<PhonebookVO> find(String search);

	public int insert(PhonebookVO pb);

	public PhonebookVO findOne(int idx);

	public int delete(int idx);

	public int update(int idx, String name, String hp, String memo);

}
