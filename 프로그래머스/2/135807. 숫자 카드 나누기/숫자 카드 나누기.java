class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcd_a=arrayA[0];
        int gcd_b=arrayB[0];
        for(int i =1; i< arrayA.length;i++){
            gcd_a = gcd(gcd_a, arrayA[i]);
            gcd_b = gcd(gcd_b, arrayB[i]);
        }
        if(check(arrayA,arrayB,gcd_a)){
            if(gcd_a>answer){
                answer=gcd_a;
            }
        }
        if(check(arrayB,arrayA,gcd_b)){
            if(gcd_b>answer){
                answer=gcd_b;
            }
        }
        return answer;
    }
    public int gcd(int a, int b){
        if(a % b == 0)return b;
        return gcd(b, a % b);
    }
    public boolean check(int[] a,int[] b,int cnt){
        int check_num=1;
        for(int i=0; i<a.length; i++){
            if(a[i]%cnt!=0 || b[i]%cnt==0){
                check_num=0;
                break;
            }
        }
        if(check_num==1){
            return true;
        }
        else{
            return false;
        }
    }
}