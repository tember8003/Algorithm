import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Stack<String> stacks = new Stack<>();
        int num=0; int man=0;
        int[] answer = new int[2];
        stacks.push(words[0]);
        for(int i=1; i<words.length; i++){
            if((words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)) 
               || (stacks.contains(words[i]))){
                num=(i+1)%n;
                if(num==0){
                    num=n;
                }
                man=i/n+1;
                answer[0]=num;
                answer[1]=man;
                break;
            }
            else{
                stacks.push(words[i]);
            }
        }
        return answer;
    }
}