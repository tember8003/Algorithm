import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        Set<Integer> sum = new HashSet<>();
        for(int i=0; i<length; i++){
            int temp = elements[i];
            sum.add(temp);
            for(int j=i+1; j<length+i; j++){
                temp+=elements[j%length];
                sum.add(temp);
            }
        }
        return sum.size();
    }
}