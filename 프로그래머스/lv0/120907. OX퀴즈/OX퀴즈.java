class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            String[] line=quiz[i].split(" ");
            int x=Integer.parseInt(line[0]); int y=Integer.parseInt(line[2]);
            int result=Integer.parseInt(line[4]);
            if(line[1].equals("+")){
                if((x+y)==result){
                    answer[i]="O";
                }
                else{
                    answer[i]="X";
                }
            }
            else if(line[1].equals("-")){
                if((x-y)==result){
                    answer[i]="O";
                }
                else{
                    answer[i]="X";
                }
            }
        }
        return answer;
    }
}