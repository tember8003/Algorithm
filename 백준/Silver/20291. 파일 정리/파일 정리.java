import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Map<String,Integer> maps = new TreeMap<>();
		String temp;
		for(int i=0; i<n; i++) {
			temp=scan.next();
			String index = temp.substring(temp.indexOf(".")+1);
			if(maps.containsKey(index)) {
				maps.replace(index,maps.get(index)+1);
			}
			else {
				maps.put(index, 1);
			}
		}


		for(String key : maps.keySet()) {
		    System.out.println(key+" "+maps.get(key));
		}   
	}
}