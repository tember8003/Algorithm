import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int[] tempB=new int[B.length];
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<B.length; i++){
            tempB[i]=B[B.length-i-1];
        }
        for(int i=0; i<A.length; i++){
            answer+=A[i]*tempB[i];
        }
        return answer;
    }
}