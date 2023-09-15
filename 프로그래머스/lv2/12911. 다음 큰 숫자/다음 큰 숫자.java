import java.util.*;
//bitCount는 정수를 전달하면 그 정수의 이진수 1의 개수를 반환한다.
class Solution {
    public int solution(int n) {
        int cnt_One=Integer.bitCount(n);
        while(true){
            n++;
            if(cnt_One==Integer.bitCount(n)){
                return n;
            }
        }
    }
}