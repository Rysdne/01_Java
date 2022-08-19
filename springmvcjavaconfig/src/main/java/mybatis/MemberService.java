package mybatis;

import java.util.List;

public interface MemberService {

	public void insert(String id, String password);
	public String select(String id);
	public List<Member> getList();
	public boolean update(Member member);
	public boolean delete(String id);
	
}
