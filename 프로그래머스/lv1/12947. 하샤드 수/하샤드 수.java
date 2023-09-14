class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int cnt=0;
        int temp=x;
        while(temp>0){
            cnt+=temp%10;
            temp/=10;
        }
        if(x%cnt==0){
            answer=true;
        }
        else{
            answer=false;
        }
        return answer;
    }
}