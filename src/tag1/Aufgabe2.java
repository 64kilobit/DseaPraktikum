package tag1;

public class Aufgabe2 {

	public int lis(int[] a) {

		int n = a.length;
		int[] q = new int[n];

		int max = 0;
		for (int k = 0; k < n; k++) {

			max = 0;
			for (int j = 0; j < k; j++) {

				if (a[k] > a[j]) {

					if (q[j] > max)
						max = q[j];
				}
				q[k] = max + 1;
			}
		}
		max = 0;
		for (int i = 0; i < n; i++) {
			if (q[i] > max)
				max = q[i];

		}
		return max;

	}

	public static void main(String[] args) {
		int[] array = { 1 };

		long result = (new Aufgabe2()).lis(array);
		System.out.println(result);
	}
}