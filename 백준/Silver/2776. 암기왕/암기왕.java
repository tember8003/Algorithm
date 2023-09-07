import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringBuilder sb= new StringBuilder();
	       int n=Integer.parseInt(br.readLine());
	       StringTokenizer st;
	       for(int i=0; i<n; i++) {
	    	   Set<Integer> note = new HashSet<>();
	    	   int a=Integer.parseInt(br.readLine());
	    	   st = new StringTokenizer(br.readLine());
	    	   for(int j=0; j<a; j++) {
	    		   note.add(Integer.parseInt(st.nextToken()));
	    	   }
	    	   int b=Integer.parseInt(br.readLine());
	    	   st = new StringTokenizer(br.readLine());
	    	   for(int k=0; k<b; k++) {
	    		   int temp = Integer.parseInt(st.nextToken());
	    		   if(note.contains(temp)) {
	    			   sb.append(1).append("\n");
	    		   }
	    		   else {
	    			   sb.append(0).append("\n");
	    		   }
	    	   }
	       }
	       System.out.print(sb);
	}
	
}