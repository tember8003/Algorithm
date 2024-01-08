import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        boolean check=true;
        String str_x = Integer.toString(x);
        char[] arr=str_x.toCharArray();
        for(int i=0; i<arr.length/2; i++){
            if(arr[i]!=arr[arr.length-1-i]){
                check=false;
                break;
            }
        }
        return check;
    }
}