#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0; int paint=0;
    for(int i=0; i<section.size(); i++){
        if(paint > section[i]){
            continue;
        }
        else{
            answer++;
            paint=section[i]+m;
        }
    }
    return answer;
}