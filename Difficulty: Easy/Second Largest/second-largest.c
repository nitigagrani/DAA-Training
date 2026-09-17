int getSecondLargest(int *arr, int n) {
    // code here
    int largest=arr[0];
    for(int i=1; i<n; i++){
        if(arr[i]>largest){
           largest=arr[i];}
        }
        int second=-1;
        for(int i=0;i<n;i++){
            if(arr[i]!=largest && arr[i]>second)
            second=arr[i];
        }
        return second;
    }