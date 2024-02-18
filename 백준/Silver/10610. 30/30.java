/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str=new StringBuilder(); //https://onlyfor-me-blog.tistory.com/317
		String input = br.readLine();
		String boom=br.readLine();
		for(int i=0; i<input.length(); i++) {
			str.append(input.charAt(i));
		
		if(str.length() >= boom.length()) {
			boolean check = true;
			for(int j=0; j<boom.length(); j++) {
				char in=str.charAt(str.length() - boom.length()+j);
				char boomc=str.charAt(j);
				if(in != boomc) {
					check=false;
					break;
				}
			}
			if(check) {
				str.delete(str.length()- boom.length(), str.length());
			}
		}
	}
		if(str.toString().isEmpty()) {
			str.append("FRULA");
		}
		
		System.out.println(str);
	}
}
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
		boolean check=false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num=br.readLine();
		char[] arr=num.toCharArray();
		int[] num_arr=new int[arr.length];
		int hap=0;
		for(int i=0; i<arr.length; i++) {
			num_arr[i]=arr[i]-'0';
			hap+=num_arr[i];
			if(num_arr[i]==0) {
				check=true;
			}
		}
		if(!check || hap%3!=0) {
			System.out.println(-1);
		}
		else {
			Arrays.sort(num_arr);
			for(int i=num_arr.length-1; i>=0; i--) {
				System.out.print(num_arr[i]);
			}
			System.out.println();
		}
	}
}

