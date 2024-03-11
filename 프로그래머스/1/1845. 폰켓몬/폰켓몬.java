import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int max_size=nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        if(set.size() >= max_size){
            return max_size;
        }
        else{
            return set.size();
        }
        

    }
}