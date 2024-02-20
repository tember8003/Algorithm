class Solution {
    public long solution(int price, int money, int count) {
        long price_max=0;
        for(int i=1; i<=count; i++){
            price_max += price*i;
        }
        if(price_max <= money){
            return 0;
        }
        else{
            return price_max - money;
        }
    }
}