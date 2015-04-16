package tag4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe1 {

	// Datenstruktur zum Zwischenspeichern
	public static final HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

	// Gibt an ob eine Greedy Strategie für große Zahelen verwendet werden darf
	public static boolean isGreedyAllowed = true;

	public static int coinInit(int amount, int[] coinsArray) {

		if (isGreedyAllowed) {

			// Finde das Maximum des Münz-Arrays
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < coinsArray.length; i++) {
				if (coinsArray[i] > max) {
					max = coinsArray[i];
				}
			}
			int tempAmount = amount;
			int tempResult = 0;

			// wenn der Betrag größer als die größte Münze ist dann rechne
			// Modulo
			if (amount > max) {
				tempResult = amount / max;
				tempAmount = amount % max;
			}
			return coin(tempAmount, coinsArray) + tempResult;
		} else {
			return coin(amount, coinsArray);

		}
	}

	// berechnet die min. Anzahl von Münzen um amount zu wechseln
	public static int coin(int amount, int[] coinsArray) {

		// in Cache nachschauen ob bereits berechnet
		if (cache.containsKey(amount)) {
			return cache.get(amount);
		}
		int min = Integer.MAX_VALUE;
		// probiere alle Münzen durch
		for (int i = 0; i < coinsArray.length; i++) {
			// Abbruchbedingung
			if (amount - coinsArray[i] == 0) {
				return 1;
			}
			// Rekursionsfall
			if (amount - coinsArray[i] > 0) {
				// berechne für jede münze rekursiv die Münzanzahl
				int tempCoins = coin(amount - coinsArray[i], coinsArray);
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

		// read the test file
		FileReader fileReader;
		try {
			fileReader = new FileReader("sample.in");

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Scanner scanner = new Scanner(bufferedReader);

			int testCaseCount = scanner.nextInt();
			System.out.println("testCaseCount: " + testCaseCount);

			// test cases
			for (int l = 0; l < testCaseCount; l++) {

				cache.clear();

				int amount = scanner.nextInt();
				int coinCount = scanner.nextInt();
				// System.out.println("amount: " + amount + " coinCount: "
				// + coinCount);

				int[] coinsArray = new int[coinCount];

				// coins
				for (int c = 0; c < coinCount; c++) {
					int coin = scanner.nextInt();
					coinsArray[c] = coin;

				}

				int tempCoins = coinInit(amount, coinsArray);
				System.out.println(tempCoins);

			}

			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
