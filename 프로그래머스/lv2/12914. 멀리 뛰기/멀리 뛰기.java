class Solution {
    public long solution(int n) {
        long[] arr= new long[2001];
        arr[1]=1; arr[2]=2; arr[3]=3;
        if(n<=3){
            return arr[n];
            }
        else{
            for(int i=4; i<=n; i++){
                arr[i]=(arr[i-1]+arr[i-2])%1234567;
            }
            return arr[n];
        }
        
    }
}