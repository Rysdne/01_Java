package basic220518;

public class IntArrayMain {

	public static void main(String[] args) {
		int[][] position = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } }; // int [3행][3열]
		for (int r = 0; r < position.length; r++) {
			for (int c = 0; c < position[r].length; c++) {
				System.out.println(position[r][c]);
			}
		}
	}
}
