#include<iostream>
using namespace std;

int n;
int st = 0;
int findmax(int arr[],int lim){
    int max=-999;
    for(int i=0; i<lim; i++){
        if(max<arr[i]){
            max= arr[i];
        }
    }
    return max;
}

int jump(int arr[],int val,int st){
    int subarr[val];
    for(int i=0; i<val; i++, st++){
        subarr[i] = arr[st+1];
    }
    int max = findmax(subarr,val);
    return max;
}

int main(){
    cout<<"Enter array size: ";
    cin>>n;
    cout<<"Enter array elements: ";
    int arr[n];
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }cout<<"your arr = ";
    for(int i=0; i<n; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;

    int count=0;
    int val= arr[0];
    cout<<arr[0]<<"-->";
    while(true){
        int ju = jump(arr,val,st);
        cout<<ju<<"-->";
        count++;
        if(ju==arr[n-1] || count>=n) {
            break;
        }
        val = ju;
    }

    return 0;
}