package index.service;

import index.dao.IndexDAO;
import index.dao.IndexDaoInter;

public class IndexService implements IndexServiceInter {
	IndexDaoInter dao = new IndexDAO();

	public void init() {
		dao.tableCheck();
		dao.close();
	}

}
