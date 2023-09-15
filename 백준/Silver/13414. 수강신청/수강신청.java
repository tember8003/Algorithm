import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main{
	public static void main(String[] args) throws IOException {
	LinkedHashSet<String> set = new LinkedHashSet();
	String str;
	int count=0;
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n=Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	for(int i=0; i<m; i++) {
		str=br.readLine();
		if(!set.contains(str)) {
			set.add(str);
		}
		else {
			set.remove(str);
			set.add(str);
		}
	}
	Iterator iter = set.iterator();
	while(iter.hasNext()) {
		if(count==n) {
			break;
		}
		System.out.println(iter.next());
		count++;
		}
	}
}