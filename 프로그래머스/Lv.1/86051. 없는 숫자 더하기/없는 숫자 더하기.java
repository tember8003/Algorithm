import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int ans[] = new int[10];
        for(int i=0; i<numbers.length; i++){
            ans[numbers[i]]=1;
        }
        for(int i=0; i<10; i++){
            if(ans[i]==0){
                answer+=i;
            }
        }
        return answer;
    }
}