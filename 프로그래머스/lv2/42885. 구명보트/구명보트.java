import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int right=0; int left=people.length-1;
        while(right<=left){
            if(people[right]+people[left]>limit){
                answer++;
                left--;
            }
            else{
                answer++;
                left--;
                right++;
            }
        }
        return answer;
    }
}