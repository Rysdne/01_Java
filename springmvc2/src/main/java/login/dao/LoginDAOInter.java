package login.dao;

import member.vo.MemberVO;

public interface LoginDAOInter {
//	public boolean exist(String id);

	public boolean login(MemberVO member);

//	public MemberVO findOne(String id);
}
