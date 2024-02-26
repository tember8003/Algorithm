class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] triangle = new int[n][n];
        
        int x=-1,y=0;
        int num=1;
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    x++;
                }
                else if(i%3==1){
                    y++;
                }
                else if(i%3==2){
                    x--;
                    y--;
                }
                triangle[x][y]=num++;
            }
        }
        int k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(triangle[i][j]==0){
                    break;
                }
                answer[k++]= triangle[i][j];
            }
        }
        return answer;
    }
}