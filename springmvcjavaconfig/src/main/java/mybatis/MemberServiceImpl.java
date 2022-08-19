package mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberservice")
public class MemberServiceImpl implements MemberService {

	// mapper 선언
	// 어노테이션으로 객체 연결
	@Autowired
	MemberMapper mapper;
	
	@Override
	public void insert(String id, String password) {
		// insert 함수 수행 시 1 반환 & 1일 경우 성공 출력 & 아니면 실패 출력
		System.out.println(mapper.insert(id, password)==1?"성공":"실패");
	}

	@Override
	public String select(String id) {
		return mapper.select(id);
	}

	@Override
	public List<Member> getList() {
		return mapper.getList();
	}

	@Override
	public boolean update(Member member) {
		// 일반적으로 객체를 받아서 처리할 땐 좀 달라짐
		// update 함수 수행 시 1 반환 & 1일 경우 true 반환 & 아니면 false 반환
		return mapper.update(member)==1?true:false;
	}

	@Override
	public boolean delete(String id) {
		return mapper.delete(id)==1?true:false;
	}
}
