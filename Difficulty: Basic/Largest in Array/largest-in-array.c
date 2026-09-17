int largest(int arr[], int n) {
    // Code Here
    for(int i=0; i<n; i++)
    {
      if(arr[i]>arr[0]){
          arr[0]=arr[i];
      }
    }
    return arr[0];
}