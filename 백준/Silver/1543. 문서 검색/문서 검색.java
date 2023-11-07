import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringBuilder 사용은 구글 검색을 통해 + delete 사용
		sb.append(br.readLine());
		String temp = br.readLine();
		int count=0;
		int first=0;
		int find_index=0;
		int length = temp.length();
		while(true) {
			find_index = sb.toString().indexOf(temp);
			if(find_index==-1) {
				break;
			}
			else {
				sb.delete(0, length+find_index);
				count++;
			}
		}
		System.out.println(count);
	}
}