import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr={"aya","ye","woo","ma"};
        for(int i=0; i<babbling.length; i++){
            babbling[i] = babbling[i].replace("ayaaya", "1");
            babbling[i] = babbling[i].replace("yeye", "1");
            babbling[i] = babbling[i].replace("woowoo", "1");
            babbling[i] = babbling[i].replace("mama", "1");
            for(int j=0; j<4; j++){
                babbling[i]=babbling[i].replace(arr[j]," ");
            }
            babbling[i] = babbling[i].replaceAll(" ","");
            if(babbling[i].equals("")){
                answer++;
            }
        }
        
        return answer;
    }
}
