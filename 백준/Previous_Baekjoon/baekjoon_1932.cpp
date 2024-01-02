//핸드폰으로 작성해서 공백이 늘었나봄...
//dp문제
//제목:정수 삼각형

#include <iostream>

#include <string>

#include <vector>

using namespace std;

long long dp[502][502];

int arr[502][502];

long long sum=0;

int main(){

	cin.tie(NULL);    cout.tie(NULL);

    int n;

    cin>>n;

    for(int i=1; i<=n; i++){

    	for(int j=1; j<=i;j++){

        	cin>>arr[i][j];

        }

    }

    dp[1][1]=arr[1][1];

    for(int i=2; i<=n; i++){

    	for(int j=1; j<=i; j++){

        	if(j==1){

            	dp[i][j]=dp[i-1][j]+arr[i][j];

            }

            else if(j==i){

            	dp[i][j]=dp[i-1][j-1]+arr[i][j];

            }

            else{

            	dp[i][j]=max(dp[i-1][j],dp[i-1][j-1])+arr[i][j];

            }

        }

    }

    for(int i=1;i<=n;i++){

    	sum=max(dp[n][i],sum);

    }

    cout<<sum<<endl;

}
