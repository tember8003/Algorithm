import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x=0;
	static int y=0;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //크기
		int r = Integer.parseInt(st.nextToken()); //행
		int c = Integer.parseInt(st.nextToken()); //열
		int result =Z((int)Math.pow(2, n),r,c); //크기는 n*n
		System.out.println(result);

	}
	static int Z(int size,int r,int c) {
		size /=2;//분할 정복
		if(r<x+size && c<y+size) { //왼쪽 위
			count+=(size*size*0);
		}
		else if(r<x+size && c>=y+size) { //오른쪽 위
			count+=(size*size*1);
			y+=size;
		}
		else if(c<y+size) { //왼쪽 아래
			count+=(size*size*2);
			x+=size;
		}
		else { //오른쪽 아래
			count+=(size*size*3);
			x+=size;
			y+=size;
		}
		if(size==1) {//분할 정복 더 못할 경우
			return count;
		}
		return Z(size,r,c);
		
	}
}
