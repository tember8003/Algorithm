class Solution {
    public int solution(int num) {
        int answer = 0;
        while(num!=1){
            if(num%2==0){
                num/=2;
                answer++;
            }
            else if(num%2==1){
                num=num*3+1;
                answer++;
            }
            else{
                answer=-1;
                break;
            }
            
            if(answer>500){
                answer=-1;
                break;
            }
        }
        return answer;
    }
}