

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class measurement{
	static TreeMap<Integer, CowIdandMilkChange> daysMeasured = new TreeMap<Integer, CowIdandMilkChange>();
	static TreeMap<Integer, HashSet<String>> maxProducerswithId = new TreeMap<Integer, HashSet<String>>(Collections.reverseOrder());
	static Map<String,Cow> milkProduced = new HashMap<String,Cow>();
	static ArrayList<String> highestMilkProducers = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

		StringTokenizer st1 = new StringTokenizer(br.readLine());	
		int n = Integer.parseInt(st1.nextToken());
		//int start = Integer.parseInt(st1.nextToken());
		maxProducerswithId.put(0,new HashSet<String>());
		for (int i = 0; i < n; i ++){
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int day = Integer.parseInt(st.nextToken());
			String cowId = st.nextToken();
			int increment = Integer.parseInt(st.nextToken());
			daysMeasured.put(day,new CowIdandMilkChange(cowId,increment));
			if (!milkProduced.containsKey(cowId))
			{
				milkProduced.put(cowId, new Cow(cowId,0));
			}
			if (!maxProducerswithId.get(0).contains(cowId)){
				maxProducerswithId.get(0).add(cowId);
			}
			}
		Set set = daysMeasured.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			Map.Entry mentry = (Map.Entry)iterator.next();
			//System.out.println("cow Id : " + ((CowIdandMilkChange) mentry.getValue()).getId());
			String id = ((CowIdandMilkChange) mentry.getValue()).getId();
			int tmpIncrement = ((CowIdandMilkChange) mentry.getValue()).getIncrement();
			//System.out.println("change by : " + ((CowIdandMilkChange) mentry.getValue()).getIncrement());
			maxProducerswithId.get(milkProduced.get(id).getMilkProducing()).remove(id);
			if (maxProducerswithId.get(milkProduced.get(id).getMilkProducing()).size() == 0){
				maxProducerswithId.remove(milkProduced.get(id).getMilkProducing());
			}
			milkProduced.put(id , milkProduced.get(id).changeMilkProduce(milkProduced.get(id).getMilkProducing() +tmpIncrement));
			//System.out.println(milkProduced.get(id).getMilkProducing());
			if (maxProducerswithId.containsKey(milkProduced.get(id).getMilkProducing())){
				//System.out.println(maxProducerswithId.get(milkProduced.get(id).getMilkProducing()));
				maxProducerswithId.get(milkProduced.get(id).getMilkProducing()).add(id);
				//System.out.println(maxProducerswithId.get(milkProduced.get(id).getMilkProducing()));
			}
			else{
				HashSet<String> tmp = new HashSet<String>();
				tmp.add(id);
				maxProducerswithId.put(milkProduced.get(id).getMilkProducing(), tmp);
			}

			
			//for (String id: milkProduced.keySet()){
				//System.out.println(id);

			//}
			
			//for (int name: maxProducerswithId.keySet()){

	           // String key = "" + name;
	            //String value = maxProducerswithId.get(name).toString();  
	            //System.out.println(key + " " + value);  
				//} 
			
				String tmpStr = "";
				Entry<Integer, HashSet<String>> entry = maxProducerswithId.entrySet().iterator().next();
				Integer maxValue = entry.getKey();
				//System.out.println("maxvalue" + maxValue);
				//System.out.println(maxValue == 0);
				Iterator it = maxProducerswithId.entrySet().iterator();
				if (maxValue > 0){  
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry)it.next();
						tmpStr+= pair.getValue(); 	
						highestMilkProducers.add(tmpStr);
						break;
					}
				}
				else if (maxValue == 0){
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry)it.next();
						tmpStr+= pair.getValue(); 	
						break;
					}
					tmpStr += "x";
					//System.out.println("case 2");
					highestMilkProducers.add(tmpStr);
				}
				else{
					//System.out.println("case 3");
					highestMilkProducers.add("x");
				}
				//System.out.println("---------");
		}
		//System.out.println(highestMilkProducers);
		int total = 1;
		for (int i = 1; i < highestMilkProducers.size(); i++){
			if (!highestMilkProducers.get(i).equals(highestMilkProducers.get(i-1))){
				total ++;
			}
		}
		//System.out.println(total);
		pw.println(total);
		pw.close();
		System.exit(0);
	}
}
class CowIdandMilkChange{                            
	public String Id;
	public int change;
	public CowIdandMilkChange(String name, int change){
		this.Id = name;
		this.change = change;
	}
	public String getId(){
		return Id;
	}
	public int getIncrement(){
		return change;
	}
}      
class Cow {
	private String Id;
	private int milkProducing;
	private int previousProduce;
	public Cow(String id, int currMilkProducing){
		this.Id = id;
		this.milkProducing = currMilkProducing;
	}
	public String getId(){
		return Id;
	}
	public int getMilkProducing(){
		return milkProducing;
	}
	public int getPreviousMilkProducing(){
		return previousProduce;
	}
	public Cow changeMilkProduce(int n){
		previousProduce = milkProducing;
		milkProducing = n;
		
		return this;
	}
}


