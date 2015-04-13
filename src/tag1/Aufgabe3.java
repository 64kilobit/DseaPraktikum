package tag1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Ken Schalhorn, Marco Ehl
 * @location 03-428
 */
public class Aufgabe3 {

	public int longestAlternatingSubsequence(int[] a) {
		int[][] alternation = new int[a.length][2];
		for (int i = 0; i < a.length; i++) {

			alternation[i][0] = 1;
			alternation[i][1] = 1;

			for (int j = 0; j < i; j++) {

				if (a[i] < a[j]) {
					alternation[i][0] = Math.max(alternation[j][1] + 1,
							alternation[i][0]);
				} else {
					if (a[i] > a[j]) {
						alternation[i][1] = Math.max(alternation[j][0] + 1,
								alternation[i][1]);
					}
				}
			}
		}

		return Math.max(alternation[a.length - 1][0],
				alternation[a.length - 1][1]);
	}

	public static void main(String[] args) {
		 FileReader fr;
		try {
			fr = new FileReader("smaple.in");
		
		    BufferedReader br = new BufferedReader(fr);
		Scanner scan= new Scanner(br);
		ArrayList<int[]> array=new ArrayList<int[]>() ;

		int n = scan.nextInt();
		
		while(n>0){
			int m =scan.nextInt();
			int[] arr =new int[m];
			int l =0;
			while(l<m){
				arr[l]=scan.nextInt();
				l++;
			}
			array.add(arr);
			long result = (new Aufgabe3()).longestAlternatingSubsequence(arr);
			System.out.println(result);
			
			n--;
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}