import java.util.*;
class Solution {
    public int countKeyChanges(String s) {
        int ans=0;
        s=s.toLowerCase();
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                ans++;
            }
        }
        return ans;
    }
}