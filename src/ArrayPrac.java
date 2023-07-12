import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayPrac {
  public static void main(String[] args){
    ArrayPrac p = new ArrayPrac();
    String out = Arrays.asList(p.twoSum(17, new int[]{11,3,7,9,14,2})).stream().map(a-> a+"").collect(Collectors.joining(" "));

    int a[] = p.twoSum(17, new int[]{11,3,7,9,14,2});
  System.out.println(a[0]+" "+a[1]);
  p.threeSum(6, new int[]{-1, -1, 1, 2,2,2,2,3,3,4,4,6});
  p.SmallestNumber(81000);
  p.findMajorityElement(new int[]{4,4,3,4,7,3,4,4,7,4,4,7,4,4});
  //matrix input
    //      1 2  3  4
  //        5 6  7  8
  //        9 10 11 12
  //        13 14 15 16
    int[][] arr = new int[4][4];
    arr[0] = new int[]{1,2,3,4};
    arr[1] = new int[]{5,6,7,8};
    arr[2] = new int[]{9,10,11,12};
    arr[3] = new int[]{13,14,15,16};
    p.rotateMatrixBy90Deg(arr);
    arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    p.printSpiralMatrix(arr);     //output 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
    int[][] arr2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
    //arr2
    // 1   2 3  4  5
    // 6   7 8  9  10
    // 11 12 13 14 15
    p.printSpiralMatrix(arr2);//output 1,2,3,4,5,10,15, 14,12,12,11,6,7,8,9
    int[] a4 = new int[]{1, 0, -1, 0,-2, 2};
    p.printFourSum(a4,0);
    p.generateA2Matrix(5);

    //binary search
    p.findFirstAndLastPositionOf(new int[]{2,3,3,4,5,5,5,5,5,8},5);
    p.findMinimumInSortedAndRotatedArray(new int[] {7,8,10,15, 16,2, 4, 6});
    p.searchInSortedAndRotatedArray(new int[]{7,8,10,15, 16,2, 4, 6},6);
    int[][] m = new int[][] {{1,4,6,8,10},{2,7,9,12,15},{3,11,20,22,24},{5,16,25,30,40}};
    System.out.println("elem "+ 11+" " +"is present: "+p.findElementInSortedMatrix(m,11));
    System.out.println("elem "+ 9+" " +"is present: "+p.findElementInSortedMatrix(m,9));
    System.out.println("elem "+ 32+" " +"is present: "+p.findElementInSortedMatrix(m,32));

  }

  public boolean findElementInSortedMatrix(int[][] a,int target){
    boolean isPresent = false;
    //matrix, target =11 , ret: true
    //1 4  6  8   10
    //2 7  9  12  15
    //3 11 20 22  24
    //5 16 25 30  40
    int i =0;int j=a[0].length-1;

    while(i<a.length && j<a[0].length){
      if(a[i][j]== target){
        return true;
      }else if(a[i][j]< target){
        //e.g. 11
        i++;
        /*if(j==a[0].length-1){
          i++;
        }else{
          i++;
        }*/
      }else{
        //e.g. 9
        j = j-1;
      }

    }
    return isPresent;
  }

  public void searchInSortedAndRotatedArray(int[] arr,int target){
    //i/p: {7,8,10,15, 16,2, 4, 6}, 10 o/p: 2
    int min = findMinInRotatedSortedArray(arr);
    int ind = -1;
    if(arr[arr.length-1] < target ){
      ind = binarySearch(arr, 0, min,target);
    }else{
      ind = binarySearch(arr, min,arr.length-1,target);
    }
    System.out.println();
    System.out.println("Index of target in sorted rotated array: "+ind);

  }

  public int binarySearch(int[] arr, int low, int high, int target){
    int mid = -1;
    while(low <= high){
      mid = (low + high)/2;
      if(arr[mid]== target){
        return mid;
      } else if(arr[mid]> target){
        high = mid -1;
      }else{
        low = mid + 1;
      }
    }
    return -1;
  }

  public int findMinInRotatedSortedArray(int[] arr){
    int low = 0;
    int high = arr.length-1;
    int mid = -1;
    while(low < high){
      mid = (low + high) / 2;
      if(arr[mid] > arr[high]){
        low = mid+1;
      }else {
        high = mid;
      }
    }
    return low;
  }

  public void findMinimumInSortedAndRotatedArray(int[] a){
    //i/p: {7,8,10,15, 16,2, 4, 6} o/p: 2
    System.out.println();
    System.out.println("Finding min in sorted and rotated array: ");
    int low = 0;
    int high = a.length-1;
    int mid =-1;
    int targetInd = -1;
    while(low < high){
      mid = (low+high)/2;
      if(a[mid] > a[high]){
        low = mid+1;
      }else{
        high = mid;
      }
    }

    System.out.print(a[high]);


  }

  //first and last position of x
  //{2,3,3,4,5,5,5,5,5,8} , target =5, o/p 4 8
  public void findFirstAndLastPositionOf(int[] a, int target){
    //since it is sorted array and we need to saerch, apply binary search
    System.out.println();
    System.out.println("Printing first and last index: ");
    //find first index
    int low = 0;
    int high = a.length-1;
    int mid = (low+high)/2;
    int first = -1;
    while(low<=high){
      if(a[mid] == target){
        first = mid;
        high = mid-1;
      }
      else if(a[mid] > target){
        high = mid-1;
      }else{
        low = mid+1;
      }
      mid = (low+high)/2;
    }

    int last = -1; low =0;
    high = a.length-1;
    mid = (low+high)/2;
    while(low<=high){
      if(a[mid] == target){
        last = mid;
        low = mid+1;
      }
      else if(a[mid] > target){
        high = mid-1;
      }else{
        low = mid+1;
      }
      mid = (low+high)/2;
    }

    System.out.print(first+" "+last);
  }


  public void generateA2Matrix(int a){
    //e.g. a = 1 op: [1] ,
    //e.g a =2 , op: [[1,2],[4,3]

    int count = 1;
    int[][] ar = new int[a][a];
    int rmin = 0, rmax = ar.length-1;
    int cmin = 0,cmax = ar[0].length-1;
    while(count<=a*a){
      //fill top frame
      for(int col=cmin;col<=cmax;col++){
        ar[rmin][col] = count++;
      }
      rmin++;

      //fill right frame
      for(int row = rmin;row<=rmax;row++){
        ar[row][cmax] = count++;
      }
      cmax--;

      //fill bottom frame
      for(int col=cmax;col>=cmin;col--){
        ar[rmax][col] = count++;
      }
      rmax--;

      //fill left frame
      for(int row = rmax;row>=rmin;row--){
        ar[row][cmin] = count++;
      }
      cmin++;


    }
    System.out.println("Spiral of Asquare matrix: ");
    System.out.print("[ ");
    for(int i =0;i<ar.length;i++){
      System.out.print("[");
      for(int j=0;j<ar[0].length;j++){
        System.out.print(ar[i][j]+ (j==ar[0].length-1?"":", "));
      }
      System.out.print("],");
    }
    System.out.print(" ]");

  }

  public void printFourSum(int[] a, int target){
    //a = {1, 0, -1, 0,-2, 2} output {-2 -1 1 2}, {-2 0 0 2} {-1 0 0 1}
    System.out.println("Printing 4sum:-");
    Arrays.sort(a);
    for(int outer =0;outer<a.length;outer++){
      int t1 = target - a[outer];
      //3sum
      for(int i = outer+1;i<a.length;i++){
        int t2 = t1 - a[i];
        int j = i+1;
        int k = a.length-1;
        if(i == 1 || a[i]!=a[i-1]){
          while(j<k){
            while(a[j]==a[j+1])
              j++;
            while(a[k]==a[k-1])
              k--;
            if(a[j]+a[k]== t2){
              System.out.println("{ "+a[outer]+" "+a[i]+" "+a[j]+" "+a[k]+" }");
              j++;
              k--;
            }else if(a[j]+a[k]<t2){
              j++;
            }else{
              k--;
            }
          }
        }
      }

    }
  }

  public void printSpiralMatrix(int[][] a){
    System.out.println("Printing spiral matrix:-");
    int frames = a.length % 2 ==0 ? a.length/2: a.length+1;
    int rmin = 0;
    int cmax = a[0].length -1;
    int cmin = 0;
    int rmax = a.length-1;
    int count =0;
    int n = a.length; int m = a[0].length;

    while(count<n * m){
      //print top
      for(int j=cmin;j<=cmax && count<n * m;j++){
        System.out.print(a[rmin][j]+", ");
        count++;
      }
      rmin++;

      //print right
      for(int i=rmin;i<=rmax && count<n * m;i++){
        System.out.print(a[i][cmax]+", ");
        count++;
      }
      cmax--;

      //print bottom
      for(int j=cmax;j>=cmin && count<n * m;j--){
        System.out.print(a[rmax][j]+", ");
        count++;
      }
      rmax--;

      //print left
      for(int j=rmax;j>=rmin && count<n * m;j--){
        System.out.print(a[j][cmin]+", ");
        count++;
      }
      cmin++;
      frames--;
    }
  }



  public void rotateMatrixBy90Deg(int[][] a){
    System.out.println();
    //print input array
    printMatrix(a);
    //transpose
    for(int i =0;i<a.length;i++){
      for(int j = i+1;j<a[i].length;j++){
        int swap = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = swap;
      }
    }

    printMatrix(a);

    //swap the columns
    for(int i=0;i<a.length;i++){
      int j = 0; int k=a[i].length-1;
      while(j<k){
        int swap = a[i][j];
        a[i][j] = a[i][k];
        a[i][k] = swap;
        j++;
        k--;
      }
    }
    System.out.println("Rotated matrix:");
    printMatrix(a);
  }

  private void printMatrix(int[][] a) {
    for(int i = 0; i< a.length;i++){
      for(int j =0;j< a[0].length;j++){
        System.out.print(a[i][j]+" ");
      }
      System.out.println();
    }
  }

  public void SmallestNumber(int num){
    //100 input, find smallest number whose product is input. answer is 455
    int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0};

    int q = num;
    while(q>1){
      for(int i =9;i>1;i--){
        if(q % i== 0){
          arr[i] = arr[i]+1;
          q = q/i;
          break;
        }
      }
    }
    for(int i = 0;i<arr.length;i++){
      if(arr[i]>0){
        while(arr[i]>0){
          System.out.println("Smallest Number : "+i);
          arr[i] = arr[i]-1;
        }
      }
    }
  }

  public void findMajorityElement(int[] arr){
    //e.g. {4,4,3,4,7,3,4,4,7,4,4,7,4,4}//Moore's voting algo
    int count = 1;
    int i =1; int elem = arr[0];
    while(i< arr.length){
      if(elem == arr[i]){
        count ++;
      }else{
        count --;
      }
      if(count == 0){
        elem = arr[i];
        count = 1;
      }
      i++;
    }
    count = 0;
    for(int j = 0;j<arr.length;j++){
      if(arr[j]==elem){
        count++;
      }
    }
    if(count > arr.length/2){
      System.out.println("Majority elemtn: "+elem);
    }else{
      System.out.println("Majority elemtn: -1");
    }

  }

  public void threeSum(int target, int[] a){
    List<Set<Integer>> l = new ArrayList<>();
    //e.g. {-1, -1, 1, 2,2,2,2,3,3,4,4,6}, target = 6
    for(int i =0; i < a.length;i++){
      int tar = target - a[i];
      int j = i+1, k = a.length-1;
      if(i==0 || a[i]!=a[i-1]) {
        while (j < k) {
          while (a[j] == a[j + 1])
            j++;
          while (a[k] == a[k - 1])
            k--;
          if (a[j] + a[k] == tar) {
            System.out.println(a[i] + " " + a[j] + " " + a[k]);
            j++;
            k--;
          } else if (a[j] + a[k] < tar) {
            j++;
          } else {
            k--;
          }
        }
      }
    }


  }

  //2 sum
  public int[] twoSum(int num, int[] arr){
    int[] ret = new int[2];
    //put into map
    Map<Integer, Integer> m = new HashMap<>();
    int comp = 0;
    for(int i =0; i < arr.length;i++){
      comp = num-arr[i];
      if(!m.containsKey(comp)){
        m.put(arr[i],i);
      }else{
        ret[0] = i;
        ret[1] = m.get(comp);
        break;
      }

    }
    return ret;
  }

}
