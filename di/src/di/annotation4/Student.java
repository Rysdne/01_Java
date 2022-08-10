package di.annotation4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 컴포넌트 스캔을 하지 않게 되어 필요가 없음
//@Component
public class Student {
//	
	@Autowired
	Sungjuk sungjuk;
	String id;
	String password;

	public Student() {
	}
	
	public Student(Sungjuk sungjuk, String id, String password) {
		this.sungjuk = sungjuk;
		this.id = id;
		this.password = password;
	}
	
	public void setsungjuk(Sungjuk sungjuk) {
		this.sungjuk = sungjuk;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [sungjuk=" + sungjuk + ", id=" + id + ", password=" + password + "]";
	}

}
