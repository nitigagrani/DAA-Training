int missingNum(int *arr, int size) {
    // code here
    int expectedsum=0;
    int n = size+1;
    for(int i=0; i<=n; i++){
        expectedsum+=i;
    }
    int actualsum=0;
    for(int i=0; i<size; i++){
        actualsum += arr[i];
    }
    int missing=expectedsum-actualsum;
    return missing;
}