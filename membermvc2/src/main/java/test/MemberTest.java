package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import member.dao.MemberDAO;

public class MemberTest {

	@Test
	public void test() {
		MemberDAO dao=new MemberDAO();
		
		assertEquals("rysdne2", dao.findOne(2).getId());
		
		
		
		
		
	}

}
