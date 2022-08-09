package di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	@Autowired
	Sungjuk sungjuk;
	String id;
	String password;

	public Student() {
	}
	
	//@Autowired
	public Student(Sungjuk sungjuk, String id, String password) {
		this.sungjuk = sungjuk;
		this.id = id;
		this.password = password;
	}
	
	//@Autowired
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