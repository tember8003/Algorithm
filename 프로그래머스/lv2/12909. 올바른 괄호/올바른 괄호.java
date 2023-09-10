import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else{
                if(!stack.empty()){
                    stack.pop();
                }
                else{
                    stack.push(')');
                }
            }
        }
        if(stack.size()!=0){
            answer=false;
        }
        else{
            answer=true;
        }
        return answer;
    }
}