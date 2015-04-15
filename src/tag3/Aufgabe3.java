package tag3;

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

	private static int[][] fish;
	private static int cast;

	//like egg-dropping problem from ws2012/13
	private static int fishing(int b, int k) {
		//1 or no floor is easy to test...
		for(int i=1;i<=k;i++){
			fish[i][0]=0;
			fish[i][1]=1;
		}
		//just 1 lure
		for(int i=2;i<=b;i++)
			fish[1][i]=i;
		
		//filling the fishing matrix 
		for(int i=2;i<=k;i++)
			for(int j=2;j<=b;j++){
				fish[i][j]=Integer.MAX_VALUE;
				for(int l=1;l<=j;l++){
					int max = 1+Math.max(fish[i-1][l-1], fish[i][j-l]);
					if(max<fish[i][j])
						fish[i][j]=max;
				}
		}
		return fish[k][b];
	}

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("sample.in");
			BufferedReader br = new BufferedReader(fr);
			Scanner scan = new Scanner(br);

			int n = scan.nextInt();

			while (n > 0) {
				int b = scan.nextInt();
				int k = scan.nextInt();

				
				fish = new int[k+1][b+1];
				System.out.println(fishing(b,k));
				
				n--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}