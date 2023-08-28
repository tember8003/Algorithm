class Solution {
    public String solution(String s) {
        String answer="";
        if(s.length()%2==1){
            int temp=s.length()/2;
            answer = s.substring(temp,temp+1);
        }
        else{
            int temp=s.length()/2-1;
            answer=s.substring(temp,temp+2);
        }
        return answer;
    }
}