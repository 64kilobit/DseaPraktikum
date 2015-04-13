package tag1;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe1 {

	static class Recursive {

		private int fib1Counter = 0;

		private long fibonacci(long n) {
			// count how often fibonacci(1) is called, increment on each use
			if (n == 1)
				fib1Counter++;
			if (n == 0)
				return 0;
			if (n == 1 || n == 2)
				return 1;

			long currentFibonacci = fibonacci(n - 1) + fibonacci(n - 2);
			return currentFibonacci;

		}
	}

	static class RecursiveCached {
		private Map<Long, Long> cache = new HashMap<Long, Long>();

		private long fibonacci(long n) {
			if (n == 0)
				return 0;
			if (n == 1 || n == 2)
				return 1;
			if (cache.containsKey(n))
				return cache.get(n);

			long currentFibonacci = fibonacci(n - 1) + fibonacci(n - 2);

			cache.put(n, currentFibonacci);
			return currentFibonacci;

		}
	}

	static class Iterative {
		private Map<Long, Long> cache = new HashMap<Long, Long>();

		private long fibonacci(long n) {
			cache.put(0l, 0l);
			cache.put(1l, 1l);
			cache.put(2l, 1l);

			long result = 0;
			for (long i = 3; i <= n; i++) {
				result = cache.get(i - 1) + cache.get(i - 2);
				cache.put(i, result);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		long n = 50l;

		Aufgabe1.Recursive recursive = new Aufgabe1.Recursive();
		long result1 = recursive.fibonacci(n);
		System.out.println("fibonacci(" + n + ") = " + result1);
		System.out.println("fibonacci(1) called " + recursive.fib1Counter
				+ " times");

		long result2 = new Aufgabe1.RecursiveCached().fibonacci(n);
		System.out.println("fibonacci(" + n + ") = " + result2);

		long result3 = new Aufgabe1.Iterative().fibonacci(n);
		System.out.println("fibonacci(" + n + ") = " + result3);
	}
}