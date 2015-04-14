package tag2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Aufgabe1 {

	private static int[][] distance;
	private static int[][] pre;
	private static int n;

	private static void floydWarshall() {
		for (int i = 1; i < n; i++)
			for (int j = 1; j < n; j++)
				for (int k = 1; k < n; k++)
					if (distance[j][i] + distance[i][k] < distance[j][k]
							&& distance[j][i] > 0 && distance[i][k] > 0) {
						distance[j][k] = distance[j][i] + distance[i][k];
						pre[j][k] = i;
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
				int[][] arr = new int[m][m];
				for(int l = 0;l<m;l++)
					for(int k=0;k<m;k++){
						arr[l][k]=scan.nextInt();
					}
				
				
				distance=arr;
				

				floydWarshall();
				
				long result = distance[0][n];
				System.out.println(result);

				n--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}