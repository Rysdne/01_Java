package memo.vo;

public class MemoVO {

	long idx;
	String id;
	String subfolder;
	String title;
	String cdate;
	String ctime;

	public MemoVO() {
	}

	public MemoVO(long idx, String id, String subfolder, String title, String cdate, String ctime) {
		this.idx = idx;
		this.id = id;
		this.subfolder = subfolder;
		this.title = title;
		this.cdate = cdate;
		this.ctime = ctime;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubfolder() {
		return subfolder;
	}

	public void setSubfolder(String subfolder) {
		this.subfolder = subfolder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
}
