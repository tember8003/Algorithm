class Solution {
    public int[] solution(int n, int s) {
        int result=s/n;
        int rest=s%n;
        if(result==0){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        for(int i=answer.length-1; i>=0; i--){
            answer[i]=result;
            if(rest>0){
                answer[i]++;
                rest--;
            }
        }
        return answer;
    }
}