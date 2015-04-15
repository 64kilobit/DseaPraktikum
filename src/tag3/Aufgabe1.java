package tag3;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe1 {

	private static Map<String, Integer> cache = new HashMap<String, Integer>();

	/**
	 * Gets the min number of operations
	 * 
	 * @param string
	 * @return
	 */
	public static int findMiniPalindrome(String string) {

		// debug, print tested substring
		// System.out.println(string);

		// lookup cache
		if (cache.containsKey(string)) {
			return cache.get(string);
		}

		if (string.length() == 0)
			return 0;
		if (string.length() == 1)
			return 1;

		//replace same consecutive characters with one aaaaaaabbbbbbb => ab
		String stringShort = string.replaceAll("(.)\\1+", "$1");
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < stringShort.length(); i++) {

			// delete one character
			String tempString = stringShort.substring(0, i)
					+ stringShort.substring(i + 1, stringShort.length());
			int tempCount = findMiniPalindrome(tempString) + 1;
			// get the minimum
			if (tempCount < min) {
				min = tempCount;
			}
		}

		// cache the result
		cache.put(string, min);

		return min;
	}

	public static void main(String[] args) {
		//tested with strings of length 24
		String testString = "ABACDBABDFDFJDFDFBCCDFIAH";

		int result = findMiniPalindrome(testString);
		System.out.println(result);

	}

}
