class Solution {
    static boolean[][][] visited = new boolean[11][11][4];
    static int[] dy = {1,0,-1,0};
    static int[] dx= {0,1,0,-1};
    public int solution(String dirs) {
        int answer = 0;
        int start_x=5;
        int start_y=5;
        for(int i=0; i<dirs.length(); i++){
            int temp=0;
            if(dirs.charAt(i)=='U'){
                temp=0;
            }
            if(dirs.charAt(i)=='D'){
                temp=2;
            }
            if(dirs.charAt(i)=='R'){
                temp=1;
            }
            if(dirs.charAt(i)=='L'){
                temp=3;
            }
            int temp_x=start_x+dx[temp];
            int temp_y=start_y+dy[temp];
            if(temp_x >10 || temp_x <0 || temp_y <0|| temp_y>10){
                continue;
            }
            if(!visited[temp_x][temp_y][temp]){
                visited[temp_x][temp_y][temp]=true;
                if(temp%2==0){
                    temp=2-temp;
                }
                else{
                    temp=4-temp;
                }
                visited[start_x][start_y][temp]=true;
                answer++;
            }
            start_x=temp_x;
            start_y=temp_y;
        }
        return answer;
    }
}