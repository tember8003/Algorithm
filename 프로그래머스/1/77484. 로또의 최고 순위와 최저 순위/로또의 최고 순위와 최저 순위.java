class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6,6,5,4,3,2,1};
        int zero_count=0; //lottos 배열 속 0 개수
        int count=0; //똑같은 숫자 개수
        for(int i=0;i<6; i++){
            if(lottos[i]==0){
                zero_count++;
                continue;
            }
            for(int j=0; j<6; j++){
                if(lottos[i]==win_nums[j]){
                    count++;
                    break;
                }
            }
        }
        
        answer[0]=rank[count+zero_count];
        answer[1]=rank[count];
        
        return answer;
    }
}
