class Solution {
    public String solution(int a, int b) {
        String[] dayweek={"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] month=new int[12];
        month[0]=31; month[1]=29; month[2]=31; month[3]=30; month[4]=31; month[5]=30;
        month[6]=31; month[7]=31; month[8]=30; month[9]=31; month[10]=30; month[11]=31;
        int temp=0;
        for(int i=0; i<a-1; i++){
            temp+=month[i];
        }
        temp+=b-1;
        temp %=7;
        String answer = dayweek[temp];
        return answer;
    }
}