package login.dao;

import login.vo.MemberVO;

public interface MemberDAOInter {
	public boolean exist(String id);

	public boolean login(MemberVO member);
}
