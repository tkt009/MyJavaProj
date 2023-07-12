public class MySlidingWindow {

  public static int maxSumKSize(int[] arr, int k){
    int maxSum = 0 ;
    int sum = 0;
    int start =0; int end = start;

    while(end<arr.length){
      if(end >= k){
        sum = sum - arr[start];
        start++;
        sum += arr[end];
        end++;
        maxSum = getMaxSum(sum,maxSum);
      }
      else {
        sum += arr[end];
        end++;
      }

    }



    return maxSum;
  }

  private static int getMaxSum(int sum, int maxSum){
    return maxSum>sum? maxSum:sum;
  }

  public static void main(String[] args){
    int k =2;
    int[] arr = {100, 200, 300, 400};
    System.out.println("Max sum of " + k +" size is :"+maxSumKSize(arr,k));

    int[] arr2 = {1, 4, 2, 10, 23, 3, 1, 0, 20}; k = 4;
    System.out.println("Max sum of " + k +" size is :"+maxSumKSize(arr2 ,k));
  }
}
