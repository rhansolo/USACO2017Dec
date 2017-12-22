import java.io.*;
import java.util.*;
public class measurement {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		StringTokenizer st1 = new StringTokenizer(file.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		//int start = Integer.parseInt(st1.nextToken());
		CowProperties[] cowArr = new CowProperties[n];
		int start = 7;
		Map<String,Integer> uniqueMilkProduced = new HashMap<String,Integer>();
		Map<String,Integer> maxProducers = new HashMap<String,Integer>();

		for (int i = 0; i < n; i ++){
			StringTokenizer st = new StringTokenizer(file.readLine());	
			cowArr[i] = new CowProperties (Integer.parseInt(st.nextToken()),st.nextToken(), st.nextToken());
		}
		
		Arrays.sort(cowArr);
		int maxOccurances = 0;
		int max = start;
		String[] arr = new String[10000];
		int index = 0;
		for (int i = 0; i < n; i++){
			if (uniqueMilkProduced.containsKey(cowArr[i].ID))
			{
				
			}
			else{
				
				uniqueMilkProduced.put(cowArr[i].ID,7);
			}
		}
		for (int i = 0; i < n; i ++){
			
			int increment = cowArr[i].change;
			uniqueMilkProduced.put(cowArr[i].ID,uniqueMilkProduced.get(cowArr[i].ID) + increment);
			int tmpMaxProducer = 0;
			for (String cow : uniqueMilkProduced.keySet()){
				if (uniqueMilkProduced.get(cow) > tmpMaxProducer){
					tmpMaxProducer = uniqueMilkProduced.get(cow);
				}
			}
			String tmpWinner = "";
		
			for (String cow : uniqueMilkProduced.keySet()){
				if (uniqueMilkProduced.get(cow) == tmpMaxProducer){
					tmpWinner += cow;
				}
			}
			
			arr[index] = tmpWinner;
			index ++;
		}
		int ans = 1;
		String previousWinner = arr[0];
		
		for (int i = 1; i < arr.length; i ++){
			if (arr[i] == null){
				break;
			}
			if (arr[i].equals(previousWinner)){
				
			}
			
			else{
				previousWinner = arr[i];
				ans ++;
			}
		}
		outfile.println(ans);
		outfile.close();
		System.exit(0);
	}
}
class CowProperties implements Comparable<CowProperties>{
	public int lastChecked;
	public String ID;
	public int change;
	public CowProperties(int day, String ID, String change){
		lastChecked = day;
		this.ID = ID;
		this.change = Integer.parseInt(change);
	}
	public int compareTo(CowProperties other){
		return this.lastChecked - other.lastChecked;
	}
}
