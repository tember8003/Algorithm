import java.util.*;
class Solution {
    static boolean[][] visited;
    static char[][] map;
    static int[] dy={0,0,-1,1};
    static int[] dx={-1,1,0,0};
    public List<Integer> solution(String[] maps) {
        List<Integer> answer=new ArrayList<Integer>();
        visited= new boolean[maps.length][maps[0].length()];
        map=new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            map[i]=maps[i].toCharArray();
        }
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(!visited[i][j]&&map[i][j]!='X'){
                    answer.add(bfs(i,j));
                }
            }
        }
        if(answer.size()==0){
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }
    static int bfs(int x,int y){
        int sum=0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;
        while(!queue.isEmpty()){
            int cnt[]=queue.poll();
            int cx=cnt[0];
            int cy=cnt[1];
            sum+=map[cx][cy]-'0';
            for(int i=0; i<4; i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length){
                    continue;
                }
                if(!visited[nx][ny]&&map[nx][ny]!='X'){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return sum;
    }
}