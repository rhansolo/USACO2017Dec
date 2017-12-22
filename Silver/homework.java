

import java.io.*;
import java.util.*;

public class homework {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("homework.in"));
		PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		int totalQuestions = Integer.parseInt(file.readLine());
		int[] scores = new int[totalQuestions];
		StringTokenizer st = new StringTokenizer(file.readLine());
		for (int i = 0; i < totalQuestions; i++){
			scores[i] = Integer.parseInt(st.nextToken());
		}
		double[] averagesWithCut = new double[totalQuestions];
		double highAvg = 0;
		double tmpAvg = scores[totalQuestions-1];
		int lowestScore = scores[totalQuestions-1];
		int scoreCounted = 0;
		for (int i = totalQuestions - 1; i > 0; i --){
			if (scores[i] < lowestScore){
				tmpAvg = ((tmpAvg * scoreCounted) + lowestScore) / (scoreCounted + 1);
				lowestScore = scores[i];
			}
			
			else{
				tmpAvg = ((tmpAvg * scoreCounted) + scores[i]) / (scoreCounted + 1);
				
				scoreCounted ++;
			}
			
			averagesWithCut[i] = tmpAvg;
			
			highAvg = tmpAvg > highAvg ? tmpAvg : highAvg;
		}
		for (int i = 1; i  < totalQuestions-1; i++){
			if (averagesWithCut[i] == highAvg){
				outfile.println(i);
			}
		}
		outfile.close();
		System.exit(0);
	}
}


