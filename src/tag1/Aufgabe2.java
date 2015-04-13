package tag1;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe2 {

	public int longestIncresingSubset(int[] a) {

		// get the length of the input array
		int n = a.length;

		// temp storage
		int[] q = new int[n];

		int max;

		for (int k = 0; k < n; k++) {

			max = 1;

			for (int j = 0; j < k; j++) {

				if (a[k] > a[j]) {

					if (q[j] > max)
						max = q[j];
				}
				q[k] = max + 1;
			}
		}
		max = 1;
		for (int i = 0; i < n; i++) {
			if (q[i] > max)
				max = q[i];

		}
		return max;

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 3, 4 };

		long result = (new Aufgabe2()).longestIncresingSubset(array);
		System.out.println(result);
	}
}