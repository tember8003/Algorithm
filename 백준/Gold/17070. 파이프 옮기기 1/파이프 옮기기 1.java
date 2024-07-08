import java.io.*;
import java.util.*;

public class Main {
    static int n; //배열 크기
    static int cnt; //답
    static int[][] map; //배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n]; //크기 입력
        cnt = 0;
        StringTokenizer st;
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);

        System.out.println(cnt);
    }


    static void dfs(int x, int y, int ptype) {
        if (x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }

        if(ptype == 0){ //가로
            if(y+1 < n && map[x][y+1] == 0){
                dfs(x, y + 1, 0);
            }
        }else if(ptype == 1){ //세로
            if(x+1 < n && map[x+1][y] == 0){
                dfs(x+1, y, 1);
            }
        }else if(ptype == 2){ //대각선
            if(y+1 < n && map[x][y+1] == 0){
                dfs(x, y + 1, 0);
            }
            if(x+1 < n && map[x+1][y] == 0){
                dfs(x+1, y , 1);
            }
        }
        
        //대각선으로 이동은 가로, 세로, 대각선 모두 해당되기에 따로 처리한다.
        if (x + 1 < n && y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}