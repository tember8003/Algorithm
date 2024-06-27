import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
class Car{
	int num;
	int m;
	Car(int num, int m){
		this.num = num;
		this.m= m;
	}
}
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int input = Integer.parseInt(br.readLine());
		HashMap<Integer, Car> maps = new HashMap<Integer, Car>();
		int result=0;
		for(int i= 1; i<=input; i++) {
			st=new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(!maps.containsKey(v)) {
				maps.put(v, new Car(i,m));
			}
			else if(maps.containsKey(v) && maps.get(v).m == m){
				if(i > maps.get(v).num){
					maps.replace(v,new Car(i,m));
				}
			}
			else{
				if(m > maps.get(v).m) {
					maps.replace(v, new Car(i,m));
				}
			}
		}
		for(int v : maps.keySet()) {
			result += maps.get(v).num;
		}
		
		System.out.println(result);
	}


}