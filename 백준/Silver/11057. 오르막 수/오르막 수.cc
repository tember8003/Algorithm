#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
long long sum=0;
long long dp[1002][11];

int main(){
    int n;
    cin>>n;
    for(int i=0; i<10; i++){
    	dp[1][i]=1;        dp[2][i]=i+1;
    }
    if(n==1){
    	cout<<10<<endl;
        }
    else if(n==2){
    	cout<<55<<endl;
    }
    else{
    	long long result=0;
    	for(int i=3; i<=n;i++){
        	for(int j=0; j<10;j++){
            	if(j==0){
                	dp[i][j]=1;
                }
                 else{
                	dp[i][j]=(dp[i-1][j]+dp[i][j-1])%10007;
                }
            }
        }
        for(int i=0; i<10; i++){
        	result+=dp[n][i];
        }
        cout<<result%10007<<endl;      
    }
}