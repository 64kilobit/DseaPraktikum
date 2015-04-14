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
	
	
	private static void dijkstra(){
		ArrayList<Integer> nodes=new ArrayList<Integer>();
		for (int i=0;i<distance.length;i++)
			nodes.add(i);
		while (!nodes.isEmpty()){
			Integer node=nodes.get(0);
			for (Integer no : nodes) {
				if(distance[0][node]>distance[0][no])
					node=no;
			}
			 nodes.remove(node);
			for(int i=0;i<distance.length;i++)
				if(nodes.contains(i))
					update(node, i);
			
		}
		
	}

	private static void update(int a, int b){
		if(distance[0][a]<Integer.MAX_VALUE && distance[a][b]<Integer.MAX_VALUE){
		int testDist=distance[0][a]+distance[a][b];
		if(testDist<distance[0][b]){
			distance[0][b]=testDist;
			pre[0][b]=a;
		}
	}}
	
	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("sample.in");

			BufferedReader br = new BufferedReader(fr);
			Scanner scan = new Scanner(br);

			int count = scan.nextInt();

			while (count > 0) {
				int m = scan.nextInt();
				int[][] arr = new int[m][m];
				for(int l = 0;l<m;l++)
					for(int k=0;k<m;k++){
						arr[l][k]=scan.nextInt();
						if(arr[l][k]==-1)
							arr[l][k]=Integer.MAX_VALUE;
					}
				
				
				distance=arr;
				pre =new int[m][m];

				dijkstra();
				n=m;
				long result = distance[0][m-1];
				System.out.println(result);

				count--;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}