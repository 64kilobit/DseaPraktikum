package tag4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class Aufgabe1Kurz {

	static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	private static Integer[] coins = { 1, 2, 5, 10, 20, 50, 100 };

	public static void main(String[] args) {
		System.out.println(coin(123));
	}

	// Eine kurze Variante zum Münzwechselalgorithmus
	private static Integer coin(Integer value) {
		Optional<Integer> min = Arrays
				.asList(coins)
				.stream()
				.filter(x -> (value - x) >= 0)
				.map(x -> cache.containsKey(value) ? cache.get(value)
						: coin(value - x) + 1).min((x, y) -> x - y);
		cache.put(value, min.isPresent() ? min.get() : 0);
		return min.isPresent() ? min.get() : 0;
	}

}