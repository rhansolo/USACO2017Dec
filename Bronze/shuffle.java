

import java.io.*;
import java.util.*;
public class shuffle {
	static int[] indexToIndex;
	static int numCows;
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		
		numCows = Integer.parseInt(file.readLine());
		int[] orgPosArray = new int[numCows];

		int[] resultArr = new int[numCows];
		indexToIndex = new int[numCows];
		int[] cowID = new int[numCows];
		
		StringTokenizer st = new StringTokenizer(file.readLine());	
		for (int i = 0; i < numCows; i ++){
			indexToIndex[i] = Integer.parseInt(st.nextToken()) -1;
			orgPosArray[i] = i;
		}
		StringTokenizer st1 = new StringTokenizer(file.readLine());	
		
		for (int i = 0; i < numCows; i++){
			cowID[i] = Integer.parseInt(st1.nextToken());
		}
		
		for (int j = 0; j < 3; j++){
			orgPosArray = posSwap(orgPosArray);
		}
		
		for (int k = 0; k < numCows; k ++){
			resultArr[orgPosArray[k]] = cowID[k];
		}
		
		for (int cow : resultArr){
			outfile.println(cow);
		}
		outfile.close();
		System.exit(0);
		
	}
	
	public static int[] posSwap(int [] index){
		int [] tmparr = new int[numCows];
		for (int i = 0; i < numCows; i++){
			tmparr[indexToIndex[i]] = index[i];
		}
		return tmparr;
	}
}


