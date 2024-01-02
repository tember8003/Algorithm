//투 포인터 문제
//https://school.programmers.co.kr/learn/courses/30/lessons/178870
//2단계 문제

//내가 작성했던 코드
/*
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[2]; int flag=0;
        int left=0; int right=0; int sum=0; int line=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(k==arr[i]){
                flag=1;
                answer[0]=i;
                answer[1]=i;
            }
        }
        if(flag==1){
            return answer;
        }
        else{
        while(right<arr.length && left<=right){
            if(sum>=k){
                sum-=arr[left++];
            }
            else if(sum<k){
                sum+=arr[right++];
            }
            if(sum==k){
                if(line>right-left){
                    line=right-left;
                    answer[0]=left;
                    answer[1]=right-1;
                }
            }
        }
        }
        return answer;
    }
}
*/

//정답 코드 https://2minmin2.tistory.com/3 참고
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1,-1};
        int start=0;
        int end, num=0;

        for(int i=0;i<sequence.length;i++){
            end=i;
            num+=sequence[end];

            while(num>k){
                num-=sequence[start++];
            }

            if(num==k){
                if((answer[0]==-1 && answer[1]==-1) || end-start<answer[1]-answer[0]){
                    answer[0]=start;
                    answer[1]=end;
                }
            }
        }

        return answer;
    }
}
