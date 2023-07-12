import com.sun.tools.javac.comp.Lower;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leets {

  public static void main(String[] args){
    int[] arr = {1,2,3,4};
    Leets s = new Leets();
    System.out.println(s.containsDuplicate(arr));
    int[] nums = { -2,1,-3,4,-1,2,1,-5,4};
    System.out.println("max sub array sum: "+ s.maxSubArray(nums));
    int[] nums2 = {5,4,-1,7,8};
    System.out.println("max sub array sum2: "+s.maxSubArray(nums2));
    int[] arr2 = {9,4,2,10,7,8,8,1,9};
    System.out.println("1.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr2));
    int[] arr3 = {4,8,12,16};
    System.out.println("2.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr3));
    int[] arr4 = {100};
    System.out.println("3.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr4));
    int[] arr5 = {0,1,1,0,1,0,1,1,0,0};
    System.out.println("4.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr5));
    int[] arr6 = {2,0,2,4,2,5,0,1,2,3};
    System.out.println("5.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr6));
    int[] arr7 = {9,4,2,10,7,8,8,1,9};
    System.out.println("5.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr7));
    int[] arr8 = {10, 10, 10};
    System.out.println("6.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr8));
    int[] arr9 = {4,5};
    System.out.println("7.max turbulent sub array size : "+s.maxTurbulentArraySizeInLeetCode(arr9));
  }

  public int maxTurbulentArraySizeInLeetCode(int[] arr){
    int maxSize = 1;
    int i=0;
    int j = 1;
    int prevSign = 0; int currSign = 0;
    while(j<arr.length){
      prevSign = Integer.compare(arr[j-1],arr[j]);
      if(prevSign == 0){
        i = j;
        j++;
        continue;
      }
      if(j==arr.length-1 || prevSign * Integer.compare(arr[j],arr[j+1]) !=-1){
        i = j;
      }
      j++;
      maxSize = Math.max(maxSize,j-i+1);
    }
    return maxSize;
  }

  public enum Sign {
    High,
    Lower;
  }

  public int maxTurbulentArraySize(int[] arr){
    int maxSize = 1;
    int i = 0; int j=0; int k=0;
    boolean moveWindow = false; Sign currSign = Sign.High;
    Sign prevSign = Sign.Lower;
    while(j<arr.length-1){
      currSign = arr[j]>arr[j+1]? Sign.High: Sign.Lower;
      if(Integer.compare(arr[j],arr[j+1])==0){
        moveWindow = true;
      }
      if(j==0){
        prevSign = currSign.compareTo(Sign.High) == 0? Sign.Lower: Sign.High;
      }
      if(!moveWindow && !prevSign.equals(currSign)){
        j++;
        prevSign = currSign;
      }else {
        maxSize = Math.max(maxSize,j-i+1);
        i = j;
        prevSign = currSign.compareTo(Sign.High) == 0? Sign.Lower: Sign.High;
      }
    }
    return maxSize;
  }

  public int maxSubArray(int[] nums) {
    int i= 0; int j=0;
    int sum=0; int maxSum = 0;
    while(j<nums.length){
      sum = sum + nums[j];
      if(j==0){
        maxSum = sum;
      }
      if(sum < maxSum ){
        j++;
      }
      else if(sum == maxSum){
        j++;
      }
      else if(sum > maxSum){
        while((sum >=maxSum) && i<j){
          sum = sum - nums[i];
          i++;
        }
        if(sum < maxSum){
          i--;
          sum = sum + nums[i];
          maxSum = sum;
        }else{
          maxSum = sum;
        }

        j++;
      }
    }


    return maxSum;

  }

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> s = new HashSet();
    for(int a: nums){
      s.add(a);
    }

    return s.size() != nums.length;

  }

}
