package tag2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe3 {

	private static int[] arr;
	private static int gain = Integer.MIN_VALUE;
	private static int[][] cache;

	private static int check(int a, int b) {
		if (a == b)
			return arr[a];
		
		if (cache[a][b] > Integer.MIN_VALUE)
			return cache[a][b];
		if(a<b){
			int sum = check(a, b - 1);
			sum += arr[b];
			cache[a][b] = sum;
			if (gain < sum)
				gain = sum;
			return sum;
		}
		else{
			int sum1= check(a,arr.length-1);
			int sum2= check(0,b);
			int sum=sum1+sum2;
			if(gain<sum)
				gain=sum;
			return sum;
		}
	}

	private static void init() {
		for (int l = 0; l < arr.length; l++) {
			for (int k = 0; k < arr.length; k++) {
				cache[l][k] = Integer.MIN_VALUE;
			}
			cache[l][l] = arr[l];
		}
	}

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("bf_checked_random.in");

			BufferedReader br = new BufferedReader(fr);
			Scanner scan = new Scanner(br);

			int n = scan.nextInt();

			while (n > 0) {
				int m = scan.nextInt();
				arr = new int[m];
				for (int l = 0; l < m; l++)
					arr[l] = scan.nextInt();

				cache = new int[m][m];
				init();
				
				for(int i=0;i<m;i++){
				check(i, (m - 1+i)%m);
				}

				System.out.println(gain);
				gain = 0;
				n--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}