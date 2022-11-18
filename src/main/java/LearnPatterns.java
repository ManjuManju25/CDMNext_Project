
public class LearnPatterns {
	void pattern1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	void pattern2(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	void pattern3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= (n - i) + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	void pattern4(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	static void pattern5(int n) {
		int totalColsRow;
		for (int row = 0; row < 2 * n; row++) {
			if (row > n) {
				totalColsRow = 2 * n - row;
				for (int col = 0; col < totalColsRow; col++) {
					System.out.print("* ");
				}
				System.out.println();
			} else {
				totalColsRow = row;
				for (int col = 0; col < totalColsRow; col++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
	}

	static void pattern6(int n) {

		for (int row = 0; row < n; row++) {
			for (int i = 0; i < n - row; i++) {
				System.out.print(" ");
			}
			for (int col = 0; col <= row; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void pattern7(int n) {

		for (int row = 0; row < n; row++) {
			for (int i = 0; i < n - row; i++) {
				System.out.print(" ");
			}
			for (int col = 0; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void pattern8(int n) {

		for (int row = 0; row < n; row++) {

			for (int col = 0; col < n - row; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void pattern9(int n) {

		for (int row = 0; row < n; row++) {
			for (int i = 0; i <= row; i++) {
				System.out.print(" ");
			}
			for (int col = 0; col < n - row; col++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
	static void pattern10(int n) {

		for (int row = 1; row <= n; row++) {
			for (int i = 1; i <= n-row ; i++) {
				System.out.print(" ");
			}
			for (int col = 1; col < 2*row ; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void pattern11(int n) {

		for (int row = 0; row < n; row++) {
			for (int i = 0; i < row ; i++) {
				System.out.print(" ");
			}
			for (int col = 1; col < 2*n-2*row ; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String... args) {
		int n = 5;
		LearnPatterns p = new LearnPatterns();
		LearnPatterns.pattern11(n);
		LearnPatterns.pattern10(n);
		// p.pattern2(n);
		// p.pattern3(n);
		// p.pattern4(n);
	}

}
