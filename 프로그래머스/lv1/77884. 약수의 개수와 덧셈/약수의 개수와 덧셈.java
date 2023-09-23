
class Solution {
    public static boolean yacsu(int temp){
    int ans=0;
    for(int i=1; i<=temp; i++){
        if(temp%i==0){
            ans++;
        }
    }
    if(ans%2==0){
        return true;
    }
    else{
        return false;
    }
}
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            if(yacsu(i)){
                answer+=i;
            }
            else{
                answer-=i;
            }
        }
        return answer;
    }
}