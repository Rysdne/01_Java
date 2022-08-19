package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

	public int insert(@Param("id") String id, @Param("password") String password);

	public String select(String id);

	public List<Member> getList();

	public int update(Member member);

	public int delete(String id);

}
