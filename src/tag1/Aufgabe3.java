package tag1;

public class Aufgabe3 {

	public int las(int[] a) {
		int[][] alternation = new int[a.length][2];
		for (int i = 0; i < a.length; i++) {

			alternation[i][0] = 1;
			alternation[i][1] = 1;

			for (int j = 0; j < i ; j++) {

				if (a[i] < a[j]) {
					alternation[i][0] = Math.max(alternation[j][1] + 1,
							alternation[i][0]);
				} else {
					if (a[i] > a[j]) {
						alternation[i][1] = Math.max(alternation[j][0] + 1,
								alternation[i][1]);
					}
				}
			}
		}

		for (int i = 0; i < alternation.length; i++) {
			// System.out.println(alternation[i][1]);

		}
		return Math.max(alternation[a.length - 1][0],
				alternation[a.length - 1][1]);
	}

	public static void main(String[] args) {
		int[] array = { 1,3,2 };

		long result = (new Aufgabe3()).las(array);
		System.out.println(result);
	}
}