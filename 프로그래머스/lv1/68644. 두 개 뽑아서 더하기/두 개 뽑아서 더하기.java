import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        int num=0;
        HashMap<Integer,Integer> maps=new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1;j<numbers.length; j++){
                int sum=numbers[i]+numbers[j];
                if(maps.containsKey(sum)){
                    continue;
                }
                else{
                    maps.put(sum,1);
                    num++;
                }
            }
        }
        int[] answer = new int[num]; int temp=0;
        for(int key:maps.keySet()){
            answer[temp]=key;
            temp++;
        }
        Arrays.sort(answer);
        return answer;
    }
}