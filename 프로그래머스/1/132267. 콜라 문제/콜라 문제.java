class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int na=0;
        int mo=0;
        while(n/a > 0){
            mo=(n/a)*b;
            na=(n%a);
            n=mo+na;
            answer+=mo;
        }
        return answer;
    }
}