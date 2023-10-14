import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
    public void dfs(int[] numbers,int target,int sum,int index){
        if(numbers.length==index){
            if(target==sum){
                answer++;
            }
            return;
        }
        dfs(numbers,target,sum+numbers[index],index+1);
        dfs(numbers,target,sum-numbers[index],index+1);
    }
}