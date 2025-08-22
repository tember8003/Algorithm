import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        StringBuilder originSb = new StringBuilder();
        for(int i = 0; i < n; i++){
            originSb.append(str[i]);
        }
        String origin = originSb.toString();

        String[] pstr = br.readLine().split(" ");
        StringBuilder patternSb = new StringBuilder();
        for(int i = 0; i < n; i++){
            patternSb.append(pstr[i]);
        }
        String pattern = patternSb.toString();
        
        String temp = origin + origin.substring(0, origin.length() - 1);
        kmp(temp, pattern);

        int bunmo = n;
        int bunja = cnt;
        int g = gcd(bunmo, bunja);
        bunmo /= g;
        bunja /= g;

        System.out.println(bunja + "/" + bunmo);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void kmp(String text, String pattern) {
        cnt = 0;
        int[] pi = createPiArray(pattern);
        int j = 0;

        for(int i = 0; i < text.length(); i++) {
            while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    cnt++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static int[] createPiArray(String pattern) {
        int length = pattern.length();
        int[] pi = new int[length];
        int j = 0;

        for(int i = 1; i < length; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
        return pi;
    }
}