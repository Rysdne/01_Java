package memo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import memo.dao.MemoDaoInter;

@Service
public class MemoService implements MemoServiceInter{

	@Autowired
	MemoDaoInter MemoDAO;
	
}
