class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int paint = section[0]+m;
        for(int i=1; i<section.length; i++){
            if(paint>section[i]){
                continue;
            }
            else{
                answer++;
                paint=section[i]+m;
            }
        }
        return answer;
    }
}