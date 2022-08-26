package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PhonebookDAO;
import dao.PhonebookDaoInter;
import vo.PhonebookVO;

@Service
public class PhonebookService implements PhonebookServiceInter {

	@Autowired
	PhonebookDaoInter dao = new PhonebookDAO();

	@Override
	public List<PhonebookVO> getList() {
		return dao.getList();
	}

	@Override
	public List<PhonebookVO> find(String search) {
		return dao.find(search);
	}

	@Override
	public int insert(PhonebookVO pb) {
		return dao.insert(pb);
	}

	@Override
	public PhonebookVO findOne(int idx) {
		return dao.findOne(idx);
	}

	@Override
	public int delete(int idx) {
		return dao.delete(idx);
	}

	@Override
	public int update(int idx, String name, String hp, String memo) {
		return dao.update(idx, name, hp, memo);
	}

}
