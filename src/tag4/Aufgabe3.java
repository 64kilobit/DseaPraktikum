package tag4;

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
	
	private static String treasure(int[] value,int[] weight, int size){
		
		//speicher für kleinere Probleme
		int[][] cache = new int[weight.length+1][size+1];
		
		for( int i=1;i<=weight.length;i++)
			for(int j=1;j<=size;j++)
				if(weight[i-1]<=j)
					//vergleich ob es besser ist einen Wert mit reinzunehmen oder nicht
					cache[i][j]=Math.max(value[i-1]+cache[i-1][j-weight[i-1]],cache[i-1][j]);
				else
					//passt item nicht in sack 
					cache[i][j]=cache[i-1][j];
		
		//best Value in letzter Zelle der Matrix
		return Integer.toString(cache[weight.length][size]);
		}
	
	

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("sample01.in");
			BufferedReader br = new BufferedReader(fr);
			Scanner scan = new Scanner(br);

			int n = scan.nextInt();

			while (n > 0) {
				int k=scan.nextInt();
				int column = scan.nextInt();
				int[] value=new int[column];
				int[] weight=new int[column];
				for(int i=0;i<column;i++)
					value[i]=scan.nextInt();
				for(int i=0;i<column;i++)
					weight[i]=scan.nextInt();
				
				System.out.println(treasure(value,weight,k));
				
				n--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}