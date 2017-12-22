

import java.io.*;
import java.util.*;
public class shuffle {
		static int[] indexToPos;
		static int n;
		//static ArrayList<Integer> visited = new ArrayList<Integer>();
		static HashSet<Integer> visited = new HashSet<Integer>();
		//static ArrayList<Integer> loops = new ArrayList<Integer>();
		static HashSet<Integer> loops = new HashSet<Integer>();
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
			n = Integer.parseInt(br.readLine());
			indexToPos = new int[n];
			//n = 6;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n ; i++){
				indexToPos[i] = Integer.parseInt(st.nextToken())-1;
			}
			//int total = 0;
			for (int i = 0; i < n; i ++){
				if (!visited.contains(i)){
					loop(i);
					}
			}
			//for (int i : visited){
			//	System.out.print(i);
			//}
			//System.out.println("");
			//for (int i : loops){
			//	System.out.print(i);
			//}
			//System.out.println();
			pw.println(loops.size());
			pw.close();
			System.exit(0);
		}
		public static void loop(int index){
		    LinkedHashSet<Integer> tmpvisited = new LinkedHashSet<Integer>();
			//HashSet<Integer> tmpvisited = new HashSet<Integer>();
		    //System.out.println("initial " + index);
			//System.out.println("index " + index);
		    tmpvisited.add(index);
			for (int i = 0; i < n; i++){
				//System.out.println("indexbefore " + index);
				index = indexToPos[index];
				if (visited.contains(index)){
					break;
				}
				//System.out.println("index going to " + index);
				if (!tmpvisited.contains(index)){
					tmpvisited.add(index);
					//System.out.println("not visited yet");
				//	for (int j : tmpvisited){
					//	System.out.print(j + " ");
					//}
					//System.out.println("");
					//System.out.println("");

				}
				else{
					// can only get here if index hasnt been repeated in local and global arr
					//System.out.println("visited");
					//for (int j : visited){
						//System.out.print(j + " ");
					//}
					//if (!loops.contains(index)){
					ArrayList<Integer> tmpArr = new ArrayList<Integer>(); 
					tmpArr.addAll(tmpvisited);
						loops.addAll(tmpArr.subList(tmpArr.indexOf(index), tmpArr.size()));
					//}

					//if (!visited.contains(index)){
						visited.addAll(tmpArr);
						//System.out.println("\nappeneded tmp arr to visited");
					//}
					//System.out.println("\n------------------");
					//System.out.println(index);
					break;

				}
			}
		}
}


