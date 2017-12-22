import java.io.*;
import java.util.*;
public class billboard {
	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		StringTokenizer st = new StringTokenizer(file.readLine());	
		int bx1 = Integer.parseInt(st.nextToken());
		int by1 = Integer.parseInt(st.nextToken());
		int tx1 = Integer.parseInt(st.nextToken()); 
		int ty1 = Integer.parseInt(st.nextToken());
		
		StringTokenizer st1 = new StringTokenizer(file.readLine());	
		int bx2 = Integer.parseInt(st1.nextToken());
		int by2 = Integer.parseInt(st1.nextToken());
		int tx2 = Integer.parseInt(st1.nextToken()); 
		int ty2 = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(file.readLine());	
		int bxboard = Integer.parseInt(st2.nextToken());
		int byboard = Integer.parseInt(st2.nextToken());
		int txboard = Integer.parseInt(st2.nextToken()); 
		int tyboard = Integer.parseInt(st2.nextToken());
		
		int area1 = calcOverLap(bx1,by1, tx1,ty1,bxboard,byboard,txboard,tyboard);
		int area2 = calcOverLap(bx2,by2, tx2,ty2,bxboard,byboard,txboard,tyboard);
		
		outfile.println(((tx1-bx1) * (ty1-by1))+ ((tx2-bx2)* (ty2-by2)) - area1-area2);
		outfile.close();
		System.exit(0);
	} 
	public static int calcOverLap(int corx1, int corx2, int cory3, int cory4, int corx5, int corx6, int cory7, int cory8) {
		if ( (corx5>=cory3) || (corx6>= cory4) || (corx1>=cory7) || (corx2 >= cory8) ){
			return 0;		
		}
		return (Math.min(cory3, cory7) -  Math.max(corx1, corx5)) * ( Math.min(cory4, cory8) - Math.max(corx2, corx6));
	}	
}

