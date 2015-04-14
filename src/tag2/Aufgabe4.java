package tag2;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe4 {

	private static Map<String, Integer> cache = new HashMap<String, Integer>();

	public static int findMiniPalindrome(String string) {
		// debug, print tested substring
		// System.out.println(string);

		// string with length <= 1 is always a palindrom, so no insertions are
		// needed
		if (string.length() <= 1)
			return 0;

		// lookup cache
		if (cache.containsKey(string))
			return cache.get(string);

		// get first and last char for comparison
		char head = string.charAt(0);
		char tail = string.charAt(string.length() - 1);

		int result;
		if (head == tail) {
			// if head and tail are the same, we an cut of both characters
			result = findMiniPalindrome(string
					.substring(1, string.length() - 1));
		} else {
			result = Math
					.min(
					// cut of last character
					findMiniPalindrome(string.substring(0, string.length() - 1)),
					// cut of first caharcter
							findMiniPalindrome(string.substring(1,
									string.length()))) + 1;
		}

		// cache the result
		cache.put(string, result);

		return result;
	}

	public static void main(String[] args) {
		String testString = "okgopkmiomfsmafoisangfasngn�unapnfpfndsanfdsanfsufn";

		int result = findMiniPalindrome(testString);
		System.out.println(result);
	}

}
