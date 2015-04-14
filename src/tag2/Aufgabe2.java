package tag2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aufgabe2 {
	
	private static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	private static int dist=Integer.MAX_VALUE;
	private static ArrayList<Integer> route = new ArrayList<Integer>();
	
	
	private static void routing(){
		ArrayList<Integer> tmpRoute = new ArrayList<Integer>();
		int tmpDist=0;
		for(int i=0;i<cache.size();i++){
			//TODO
		}
			
		
	}

	public static void main(String[] args) {
		FileReader fr;
		try {
		fr = new FileReader("smaple.in");

		BufferedReader br = new BufferedReader(fr);
		Scanner scan = new Scanner(br);

		int n = scan.nextInt();

		while (n > 0) {
			int m = scan.nextInt();
			for(int l = 0;l<m;l++)
					cache.put(scan.nextInt(), scan.nextInt());
					
				
			
			
			
			

			
			routing();
			long result=dist ;
			System.out.println("result");

			n--;
		}
		scan.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}