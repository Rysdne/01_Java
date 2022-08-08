package test220712;

public class Cal {

	private float result;

	public Cal() {
	}

	public Cal(int a, int b, String op) {
		if (op.equals("+")) {
			this.result = sum(a, b);
		} else if (op.equals("-")) {
			this.result = sub(a, b);
		} else if (op.equals("*")) {
			this.result = mux(a, b);
		} else if (op.equals("/")) {
			this.result = div(a, b);
		}

	}

	public int sum(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mux(int a, int b) {
		return a * b;
	}

	public float div(int a, int b) {
		return (float) a / b;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

}
