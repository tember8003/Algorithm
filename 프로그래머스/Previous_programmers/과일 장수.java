//https://school.programmers.co.kr/learn/courses/30/lessons/135808
//벡터,정렬 이용해서 해결

//소스 코드
import java.util.Arrays;
import java.util.Vector;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0; int temp=10;
        Arrays.sort(score);
        Vector<Integer> v = new Vector<Integer>();
        for(int i=score.length-1; i>=0; i--){
            v.add(score[i]);
            if(temp>score[i]){
                temp=score[i];
            }
            if(v.size()==m){
                answer+=temp*m;
                v.clear();
                temp=10;
            }
        }
        return answer;
    }
}
