//제목:단어 수학
//그리디 알고리즘

//MAP을 이용한 풀이  MAP에 대해서 더 익히도록 하자.
//명코모 백준 자바 풀이 Beenu님꺼 이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		int number=9;
		int answer=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String line=br.readLine();
			for(int j=0; j<line.length(); j++) {
				int num = (int)Math.pow(10,line.length()-j-1);
				if(!map.containsKey(line.charAt(j))) {
					map.put(line.charAt(j), num);
					continue;
				}
				map.put(line.charAt(j),map.get(line.charAt(j))+num);
			}
		}
		/*
		List<Character> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<Character>() {
			public int compare(Character o1,Character o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		});
		*/
		//원래 ArrayList로 compare 메소드를 만들어 이용했으나, 결과가 다르게 나와서 고침.
		
		List<Character> keySet = new LinkedList<>(map.keySet());
		keySet.sort((o1,o2)-> map.get(o2) - map.get(o1)); //오름차순 사용
		
		for(char key:keySet) {
			answer += map.get(key)*number;
			number--;
		}
		System.out.println(answer);
	}
}
