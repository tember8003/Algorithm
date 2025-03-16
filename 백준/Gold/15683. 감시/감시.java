import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class CCTV{
		int x;
		int y;
		int type;
	}
	static CCTV[] cctv;
	static int N,M;
	static int result=Integer.MAX_VALUE;
	static int allCCTV=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		cctv = new CCTV[64];
		int count=0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]!=6) {
					cctv[count] = new CCTV();
					cctv[count].x=i;
					cctv[count].y=j;
					cctv[count].type=map[i][j];
					count++;
				}
			}
		}
		allCCTV = count;
		check(map,0);
		System.out.println(result);
	}
	public static void check(int[][] map,int count) {
		if(count == allCCTV) {
			result = Math.min(result, calculate(map));
			return;
		}
		
		int[][] mapTemp = new int[N][M];
		
		int i = cctv[count].x;
		int j = cctv[count].y;
		int type = cctv[count].type;
		
		if(type==1) {
			Copy(map, mapTemp);
			findUp(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findDown(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
		}
		else if(type==2) {
			Copy(map, mapTemp);
			findUp(i,j,mapTemp);
			findDown(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findUp(i,j,mapTemp);
			findDown(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
		}
		else if(type==3) {
			Copy(map, mapTemp);
			findUp(i,j,mapTemp);
			findRight(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findDown(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findDown(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findUp(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
		}
		else if(type==4) {
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findUp(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findUp(i,j,mapTemp);
			findDown(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findDown(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
			
			Copy(map, mapTemp);
			findDown(i,j,mapTemp);
			findUp(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			check(mapTemp,count+1);
		}
		else if(type==5) {
			Copy(map, mapTemp);
			findRight(i,j,mapTemp);
			findUp(i,j,mapTemp);
			findLeft(i,j,mapTemp);
			findDown(i,j,mapTemp);
			check(mapTemp,count+1);
		}
	}
	
	public static void Copy(int[][] map, int[][] mapTemp) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				mapTemp[i][j] = map[i][j];
			}
		}
	}
	
	public static int calculate(int[][] map) {
		int count=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void findDown(int x,int y, int[][] map) {
		for(int i=x; i>=0; i--) {
			if(map[i][y]==0) {
				map[i][y]=9;
			}
			else if(map[i][y]==6) {
				break;
			}
		}
	}
	
	public static void findUp(int x,int y, int[][] map) {
		for(int i=x; i<N; i++) {
			if(map[i][y]==0) {
				map[i][y]=9;
			}
			else if(map[i][y]==6) {
				break;
			}
		}
	}
	
	public static void findLeft(int x,int y,int[][] map) {
		for(int i=y; i>=0; i--) {
			if(map[x][i]==0) {
				map[x][i]=9;
			}
			else if(map[x][i]==6) {
				break;
			}
		}
	}
	
	public static void findRight(int x,int y, int[][] map) {
		for(int i=y; i<M; i++) {
			if(map[x][i]==0) {
				map[x][i]=9;
			}
			else if(map[x][i]==6) {
				break;
			}
		}
	}
}
