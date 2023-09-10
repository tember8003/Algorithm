import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException {
		HashMap<String,Integer> map = new HashMap<>();
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++){
		    int m=Integer.parseInt(br.readLine());
		    for(int j=0; j<m; j++){
		        str = br.readLine();
		        String[] arr = str.split(" ");
		        if(map.containsKey(arr[1])) {
		        	map.put(arr[1], map.get(arr[1])+1);
		        }
		        else {
		        	map.put(arr[1], 1);
		        }
		    }
			int result=1;
			for(int temp:map.values()) {
				result *=(temp+1);
			}
			result--;
			System.out.println(result);
			map.clear();
		}

	}
}
	
