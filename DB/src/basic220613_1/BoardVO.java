package basic220613_1;

public class BoardVO {

	private int num;
	private String title;
	private String content;
	private String name;
	private String pass;

	public BoardVO() {

	}

	public BoardVO(int num, String title, String content, String name, String pass) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.name = name;
		this.pass = pass;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", content=" + content + ", name=" + name + ", pass=" + pass
				+ "]";
	}

}
