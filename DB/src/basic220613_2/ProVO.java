package basic220613_2;

public class ProVO {

	private String pronum;
	private String name;
	private String memo;
	private int price;
	private int stock;

	public ProVO() {

	}

	public ProVO(String pronum, String name, String memo, int price, int stock) {
		this.pronum = pronum;
		this.name = name;
		this.memo = memo;
		this.price = price;
		this.stock = stock;
	}

	public String getPronum() {
		return pronum;
	}

	public void setPronum(String pronum) {
		this.pronum = pronum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "[pronum=" + pronum + ", name=" + name + ", memo=" + memo + ", price=" + price + ", stock=" + stock
				+ "]";
	}

}
