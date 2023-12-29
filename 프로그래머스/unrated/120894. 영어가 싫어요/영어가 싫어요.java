import java.util.*;

class Solution {
    public long solution(String numbers) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++){
            numbers=numbers.replace(num[i],Integer.toString(i));
        }
        long answer = Long.parseLong(numbers);
        return answer;
    }
}