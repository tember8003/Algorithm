import java.io.*;

public class Main {
    public static int[] failure;
    public static int n;
    public static char[] pattern;
    public static char[] target;
    
    // 올바른 KMP 알고리즘
    public static int kmp() {
        int i = 0, j = 0;
        int lent = target.length;
        int lenp = pattern.length;
        int count = 0;
        
        while(i < lent) {
            if(target[i] == pattern[j]) {
                i++;
                j++;
                if(j == lenp) { // 매칭 완료
                    if(i - j < n) count++; // 첫번째 N칸 내에서만 카운트
                    j = failure[j - 1]; // 올바른 점프
                }
            }
            else if(j == 0) {
                i++;
            }
            else {
                j = failure[j - 1]; // 올바른 점프
            }
        }
        return count;
    }
    
    // 올바른 실패 함수 생성
    public static void makeFailure() {
        int j = 0;
        for(int i = 1; i < pattern.length; i++){
            while(j > 0 && pattern[i] != pattern[j]) {
                j = failure[j - 1];
            }
            if(pattern[i] == pattern[j]) {
                failure[i] = ++j;
            }
        }
    }
    
    // 기약분수 계산을 위해 gcd를 계산하는 메소드
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        String[] patternStr = br.readLine().split(" ");
        String[] targetStr = br.readLine().split(" ");
        
        pattern = new char[n];
        target = new char[2 * n - 1]; // 올바른 크기
        
        for(int i = 0; i < n; i++) {
            pattern[i] = patternStr[i].charAt(0);
            target[i] = targetStr[i].charAt(0);
        }
        
        // 원형 문자열 처리: 마지막 문자 제외하고 앞부분 복사
        for(int i = 0; i < n - 1; i++) {
            target[i + n] = targetStr[i].charAt(0);
        }
        
        failure = new int[n]; // 자동으로 0으로 초기화됨
        makeFailure();
        
        int matchCount = kmp();
        int g = gcd(matchCount, n);
        String result = (matchCount / g) + "/" + (n / g);
        
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}