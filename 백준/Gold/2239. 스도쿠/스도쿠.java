import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[][] map = new int[9][9];
    static boolean solved = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int idx) {
        if (idx == 81) {
            for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]+"");
				}
				sb.append("\n");
			}
            solved = true;
            return;
        }

        int x = idx / 9;
        int y = idx % 9;

        if (map[x][y] != 0) {
            dfs(idx + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isValid(x, y, num)) {
                    map[x][y] = num;
                    dfs(idx + 1);
                    if (solved) return; // 정답 찾았으면 종료
                    map[x][y] = 0;
                }
            }
        }
    }

    public static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num || map[i][y] == num) return false;
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }
}
