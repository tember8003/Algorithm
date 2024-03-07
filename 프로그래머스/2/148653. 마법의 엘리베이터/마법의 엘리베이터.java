class Solution {
    public int solution(int storey) {
        int answer = 0;
        int rest;
        while(storey >0){
            rest= storey % 10;
            storey/=10;
            if (rest==5){
                if(storey %10 >=5){
                    answer+=(10-rest);
                    storey++;
                }
                else{
                    answer+=rest;
                }
            }
            else if(rest >5){
                answer+= (10-rest);
                storey++;
            }
            else{
                answer+=rest;
            }
            
        }
        return answer;
    }
}