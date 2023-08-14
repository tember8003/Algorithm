class Solution {
    public int solution(int n) {
        int answer = 0;
        /*
        int right=0; int left=n-1;
        while(right<=left){
            int mid=(right+left)/2;
            if(n%mid==1){
                answer=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        */
        for(int i=n-1; i>0; i--){
            if(n%i==1){
                answer=i;
            }
        }
        return answer;
    }
}