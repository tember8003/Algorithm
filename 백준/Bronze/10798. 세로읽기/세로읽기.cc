#include <iostream>
using namespace std;

int main()
//2차원 배열 문제
{
    string word[5];
    for(int i=0; i<5; i++){
        cin>>word[i];
    }
    
    for(int j=0; j<15; j++){
        for(int i=0; i<5; i++){
            if(j<word[i].length()){
                cout<<word[i][j];
            }
        }
    }
    return 0;
}