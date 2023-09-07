import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();//TreeSet 사용.

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<B; j++) {
            int Bnum = Integer.parseInt(st.nextToken());
            set.remove(Bnum);
        }
        sb.append(set.size()+"\n");
        for (Integer num : set) {
            sb.append(num+ " ");
        }
        System.out.println(sb);
    }
}