class Solution {
    public String solution(String s) {
        String answer = "";
        int num=0;
        String[] arr=s.split("");
        for(String s1:arr){
            if(s1.contains(" ")){
                num=0;
            }
            else{
                num++;
            }
            if(num%2==0){
                answer+=s1.toLowerCase();
            }
            else{
                answer+=s1.toUpperCase();
            }
        }
        
        return answer;
    }
}