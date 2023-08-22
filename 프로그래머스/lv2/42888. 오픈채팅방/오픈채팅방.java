import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> maps=new HashMap<>();
        int temp=0;
        for(int i=0; i<record.length; i++){
            String[] mem=record[i].split(" ");
            if(mem[0].equals("Enter")){
                maps.put(mem[1],mem[2]);
            }
            else if(mem[0].equals("Change")){
                maps.put(mem[1],mem[2]);
                temp++;
            }
            else{
                continue;
            }
        }
        String[] answer = new String[record.length-temp];
        int count=0;
        for(int i=0; i<record.length; i++){
            String[] check=record[i].split(" ");
            if(check[0].equals("Enter")){
                answer[count++]=maps.get(check[1]) + "님이 들어왔습니다.";
            }
            else if(check[0].equals("Leave")){
                answer[count++]=maps.get(check[1])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}