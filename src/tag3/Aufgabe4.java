package tag3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe4 {

	private static Map<String, String> cache = new HashMap<String, String>();

	private static String elimination(String arg) {
		String a = new String();
		if (arg.length() == 2)
			return "oo";
		if (arg.length() == 1)
			return "o";
		if (cache.containsKey(arg))
			if (!cache.get(arg).equals("-")
					&& (!cache.get(arg).contains("<") && !cache.get(arg)
							.contains(">")))
				return cache.get(arg);
			else {
				Random rm = new Random();
				int i = rm.nextInt(arg.length()-2)+1;
				if (arg.charAt(i) == '>') {
					a = elimination(arg.substring(0, i) + arg.substring(i + 2, arg.length()));
					if(a.length()>i){
						cache.replace(arg, a.substring(0, i)+".."+a.substring(i, a.length()));
						a=a.substring(0, i)+".."+a.substring(i, a.length());
					}
					else	{
						cache.replace(arg, a+"..");
						a=a+"..";
					}
				} else if (arg.charAt(i) == '<') {
					a = elimination(arg.substring(0, i - 1) +  arg.substring(i + 1, arg.length()));
					if(a.length()>i){
						cache.replace(arg, a.substring(0, i-1)+".."+a.substring(i-1, a.length()));
						a=a.substring(0, i-1)+".."+a.substring(i-1, a.length());
					}
					else{
						cache.replace(arg, ".."+a);
						a=".."+a;
					}
				}
			}

		else {
			cache.put(arg, "-");
			a=elimination(arg);
		}
		//System.out.println(a);
		return a;
	}

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("sample.in");
			BufferedReader br = new BufferedReader(fr);
			Scanner scan = new Scanner(br);

			int n = scan.nextInt();
			scan.nextLine();
			while (n > 0) {
				String line = scan.nextLine();
				elimination(line);
				System.out.println(cache.get(line));
				cache.clear();
				n--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}