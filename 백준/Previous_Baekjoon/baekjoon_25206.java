//제목: 너의 평점은
//문자열 , 수학
import java.io.*;
import java.util.*;
class test{
	String name;
	double point;
	String line;
	test(String name,double point,String line){
		this.name=name;
		this.point=point;
		this.line=line;
	}
}
public class Main {
	public static void main(String[] args){
		//BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		//String s=br.readLine();
		Scanner scan=new Scanner(System.in);
		test[] list = new test[21];
		String name;
		double point;
		String line;
		for(int i=0; i<20; i++) {
			name=scan.next();
			point=scan.nextDouble();
			line=scan.next();
			test mem=new test(name,point,line);
			list[i]=mem;
		}
		double all=0;
		double temp=0;
		for(int i=0; i<20; i++) {
			if(list[i].line.equals("P")) {
				continue;
			}
			else {
				if(list[i].line.equals("A+")) {
					all+=list[i].point*4.5;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("A0")) {
					all+=list[i].point*4.0;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("A0")) {
					all+=list[i].point*4.0;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("B+")) {
					all+=list[i].point*3.5;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("B0")) {
					all+=list[i].point*3.0;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("C+")) {
					all+=list[i].point*2.5;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("C0")) {
					all+=list[i].point*2.0;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("D+")) {
					all+=list[i].point*1.5;
					temp+=list[i].point;
				}
				else if(list[i].line.equals("D0")) {
					all+=list[i].point*1.0;
					temp+=list[i].point;
				}
				else {
					temp+=list[i].point;
				}
			}
		}
		System.out.println(all/temp);
	}
}
