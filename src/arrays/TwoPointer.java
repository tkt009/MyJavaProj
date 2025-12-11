package arrays;

public class TwoPointer {

  public static void main(String[] args){
    findTargetSumIndexes();
  }

  public static void findTargetSumIndexes(){
    int[] arr = {-5, -2, 3,4,6};
    int target = 7;
    int p1 = 0;
    int p2= arr.length-1;
    while(p1<p2){
      if(arr[p1]+arr[p2] == target){
        System.out.println(p1+", "+p2);
        break;
      }
      if(arr[p1]+arr[p2] < target){
        p1++;
      }
      if(arr[p1]+arr[p2] > target){
        p2--;
      }
    }
  }

}
