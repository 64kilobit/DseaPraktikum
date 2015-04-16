package tag4;

import java.util.Arrays;
import java.util.HashMap;

public class Aufgabe1 {

	public static final int[] coins = { 1, 2, 5, 10, 20, 100, 200 };;

	// Datenstruktur zum Zwischenspeichern
	public static final HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

	public static int coinInit(int amount) {
//		if (amount > Arrays.asList(coins).stream().max((x, y) -> x - y).get(0)) {
//
//		}

		return 0;
	}

	// berechnet die min. Anzahl von Münzen um amount zu wechseln
	public static int coin(int amount) {

		// in Cache nachschauen ob bereits berechnet
		if (cache.containsKey(amount)) {
			return cache.get(amount);
		}
		int min = Integer.MAX_VALUE;
		// probiere alle Münzen durch
		for (int i = 0; i < coins.length; i++) {
			// Abbruchbedingung
			if (amount - coins[i] == 0) {
				return 1;
			}
			// Rekursionsfall
			if (amount - coins[i] > 0) {
				// berechne für jede münze rekursiv die Münzanzahl
				int tempCoins = coin(amount - coins[i]);
				// suche Minimum
				if (tempCoins < min) {
					min = tempCoins;
				}
			}

		}
		// bereits berechnete Werte cachen
		cache.put(amount, min + 1);
		// gib Minimum aus plus die eine Münze die wir durchprobiert haben
		return min + 1;
	}

	public static void main(String[] args) {
		int tempCoins = coin(36791234);
		System.out.println(tempCoins);

	}

}
