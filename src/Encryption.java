public class Encryption {
	public String encrypt(String rawText) {
		double sqrt = Math.sqrt(rawText.length());
		int rows = (int) sqrt, cols = (int) Math.ceil(sqrt);
		if (rows * cols < rawText.length()) {
			rows++;
		}
		char[][] matrix = new char[rows][cols];
		int currRow = 0, currCol = 0;
		for (int i = 0; i < rawText.length(); i++) {
			matrix[currRow][currCol % cols] = rawText.charAt(i);
			if (currCol == cols - 1) {
				currRow++;
			}
			currCol = (currCol + 1) % cols;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (matrix[j][i] == 0) {
					break;
				}
				res.append(matrix[j][i]);
			}
			res.append(" ");
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Encryption en = new Encryption();
		String res = en.encrypt("chillout");
		System.out.println(res);
	}

}
