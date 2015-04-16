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
public class Aufgabe2 {
	
	private static String treasure(int[] arr){
		//test ob gesammtwert durch 2 teilbar
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		if(sum%2!=0)
			return "NO";
		
		//halber Wert = anteil für Bernd
		int packsize=sum/2;
		return packing( packsize, arr);
	}
	
	//knappsack size=größe des rucksacks/anteil an beute 
	//value=weight!(arr)
	private static String packing(int size, int[] arr ){
		//speicher für kleinere Probleme
		int[][] cache = new int[arr.length+1][size+1];
		
		
		for( int i=1;i<=arr.length;i++)
			for(int j=1;j<=size;j++)
				if(arr[i-1]<=j)
					//vergleich ob es besser ist einen Wert mit reinzunehmen oder nicht
					cache[i][j]=Math.max(arr[i-1]+cache[i-1][j-arr[i-1]],cache[i-1][j]);
				else
					//passt item nicht in sack 
					cache[i][j]=cache[i-1][j];
		
		//best Value in letzter Zelle der Matrix, ist dieser Wert gleich der halben Beute
		//kann man die Beute fair auf 2Teile aufteilen
		if(cache[arr.length][size]==size)
			return "YES";
		return "NO";
		
		
	}

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("smaple.in");
			BufferedReader br = new BufferedReader(fr);
			Scanner scan = new Scanner(br);

			int n = scan.nextInt();

			while (n > 0) {
				int column = scan.nextInt();
				int[] arr=new int[column];
				for(int i=0;i<column;i++)
					arr[i]=scan.nextInt();
				
				
				System.out.println(treasure(arr));
				
				n--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}