import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String b_str= br.readLine();
		
		int[] hap = new int[str.length()+1];
		int[] min_hap = new int[str.length()+1];
		for(int i=1; i<=str.length(); i++) {
			if(str.charAt(i-1)=='(') {
				hap[i]+=hap[i-1]+1;
			}
			else {
				hap[i]+=hap[i-1]-1;
			}
			
			min_hap[i] = Math.min(min_hap[i-1], hap[i]);
		}
		
		
		int b = 0;
		int min_b=0;
		for(int i=0; i<b_str.length(); i++) {
			if(b_str.charAt(i)=='(') {
				b++;
			}
			else {
				b--;
			}
			min_b = Math.min(b, min_b);
		}
		
		int[] section_min = new int[str.length()+1];
		int min_num = Integer.MAX_VALUE;
		for(int i=str.length(); i>=0; i--){
		  min_num = Math.min(min_num, hap[i]);
		  section_min[i] = min_num;
		}
		
		boolean check=false;
		for(int i=1; i<str.length(); i++) {
			if(hap[i] + b < 0) {
				continue;
			}
			
			if(min_hap[i] < 0) {
				continue;
			}
			
			if(hap[i] + min_b < 0) {
				continue;
			}
			
			if(section_min[i] + b<0) {
				continue;
			}
			
			check=true;
			
		}
		
		if(hap[str.length()] + b !=0) {
			check=false;
		}
		
		if(str.charAt(str.length()-1)=='(') {
			check=false;
		}
		
		if(!check) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}
	}

}
