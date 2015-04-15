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
	private static Map<String, String> cachePalindrome = new HashMap<String, String>();

	/**
	 * Gets the min number of insertions
	 * 
	 * @param string
	 * @return
	 */
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
			// cut of first caharcter
			int cutHead = findMiniPalindrome(string.substring(1,
					string.length())) + 1;

			// cut of last character
			int cutTail = findMiniPalindrome(string.substring(0,
					string.length() - 1)) + 1;

			if (cutHead < cutTail) {
				result = cutHead;
			} else {
				result = cutTail;
			}
		}

		// cache the result
		cache.put(string, result);

		return result;
	}

	/**
	 * get the palindrome
	 * 
	 * @param string
	 * @return
	 */
	public static String getMiniPalindrome(String string) {
		// debug, print tested substring
		// System.out.println(string);

		// string with length <= 1 is always a palindrom, so no insertions are
		// needed
		if (string.length() <= 1)
			return string;

		// lookup cache
		if (cachePalindrome.containsKey(string))
			return cachePalindrome.get(string);

		// get first and last char for comparison
		char head = string.charAt(0);
		char tail = string.charAt(string.length() - 1);

		String result;
		if (head == tail) {
			// if head and tail are the same, we an cut of both characters
			result = head
					+ getMiniPalindrome(string
							.substring(1, string.length() - 1)) + tail;
		} else {

			// cut of first caharcter
			int cutHead = findMiniPalindrome(string.substring(1,
					string.length()));

			// cut of last character
			int cutTail = findMiniPalindrome(string.substring(0,
					string.length() - 1));

			if (cutHead < cutTail) {
				result = head
						+ getMiniPalindrome(string
								.substring(1, string.length())) + head;
			} else {

				if (cutHead == cutTail && head < tail) {
					result = head
							+ getMiniPalindrome(string.substring(1,
									string.length())) + head;
				} else {

					result = tail
							+ getMiniPalindrome(string.substring(0,
									string.length() - 1)) + tail;
				}
			}

		}

		// cache the result
		cachePalindrome.put(string, result);

		return result;
	}

	public static void main(String[] args) {
		String testString = "CBDDECBEDCEBEEEAEBCCAEEAE";

		String result = getMiniPalindrome(testString);
		System.out.println(result);
	}

}
