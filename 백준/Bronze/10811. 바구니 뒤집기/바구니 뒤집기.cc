#include <iostream>
using namespace std;


int main()
{
    int N,M;
    cin>>N>>M;
    
    int* arr = new int[N+1];
    for(int x=1; x<=N; x++){
        arr[x]=x;
    }
    
    int i,j;
    for(int x=0; x<M; x++){
        cin>>i>>j;
        for(i; i<j; i++){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
        }
        /*해당 for문 대신 swap을 사용해도 된다!
        for(int y=0; y <= (j-i)/2; y++){
            swap(arr[i+y],arr[j-y]);
        }
        */
    }
    
    for(int x=1; x<=N; x++){
        cout<<arr[x]<<" ";
    }

    return 0;
}