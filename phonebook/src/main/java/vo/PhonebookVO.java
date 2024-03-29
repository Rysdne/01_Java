package vo;

import org.springframework.stereotype.Component;

@Component
public class PhonebookVO {

	private int idx;
	private String name;
	private String hp; 
	private String memo;
	
	public PhonebookVO() {
	}

	public PhonebookVO(int idx, String name, String hp, String memo) {
		this.idx = idx;
		this.name = name;
		this.hp = hp;
		this.memo = memo;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
