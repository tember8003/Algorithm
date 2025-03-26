import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] FizzBuzz = new String[3];
		
		int count = 0;
		for(int i=0; i<3; i++) {
			FizzBuzz[i] = br.readLine();
			if(isNumeric(FizzBuzz[i])) {
				count=Integer.parseInt(FizzBuzz[i])+(3-i);
				break;
			}
		}
		if(count%3==0 && count%5==0) {
			System.out.println("FizzBuzz");
		}
		else if(count%3==0 && count%5!=0) {
			System.out.println("Fizz");
		}
		else if(count%3!=0 && count%5==0) {
			System.out.println("Buzz");
		}
		else {
			System.out.println(count);
		}
		
		
	}
	private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
