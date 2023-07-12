public class ArrayPrac2 {
  public static void main(String[] args){
    ArrayPrac2 ap = new ArrayPrac2();
    System.out.println("ind is "+ap.search(new int[]{ 19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17  },5));
    int[][] A = new int[][] {
        {3, 3, 11, 12, 14},
        {16, 17, 30, 34, 35},
        {45, 48, 49, 50, 52},
        {56, 59, 63, 63, 65},
        {88, 91, 92, 93, 94}
//        {2, 3, 4, 6},
//        {16, 19, 33, 36},
//        {37, 38, 38, 41},
//        {47, 47, 50, 51},
//        {55, 57, 58, 62},
//        {63, 65, 66, 66},
//        {68, 70, 75, 77},
//        {78, 84, 84, 86},
//        {86, 87, 88, 92},
//        {94, 95, 96, 97},

    };
    System.out.println("mat ind "+ap.searchMatrix(A, 81));
  }
  public int searchMatrix(int[][] A, int B) {

    int row = 0; int col = A[0].length-1;
    if(A[0].length == 1 && A[0][0] == B){
      return 1;
    }
    while(row < A.length){
      if(A[row][col] >= B){
        return findElemInd(row,A,  B);
      }else{
        row++;
      }
    }
    return 0;
  }
  private int findElemInd(int row,int[][] A, int B){
    //System.out.println("here: "+row);
    int low = 0;
    int high = A[0].length-1;
    int mid = 0;
    if(A[row][0] > B){
      return 0;
    }
    if(A[row][0] == B || A[row][high] == B){
      return 1;
    }

    while(low < high){
      mid = (low + high)/2;
      if(A[row][mid] == B){
        return 1;
      }
      else if(A[row][mid] < B){
        low = mid + 1;
      }else{
        high = mid;
      }
    }
    return 0;
  }
  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int search(final int[] A, int b) {
    //first find min
    int ind = -1;
    int low = 0;
    int high = A.length-1;
    int mid = -1;
    while(low < high){
      mid = (low + high) /2;
      if(A[mid] > A[high]){
        low = mid + 1;

      }else{
        high = mid;
      }
    }
    System.out.println("lowest index is "+low);
    int targetInd = -1;
    int lowInd = -1;
    if(b == A[low]){
      return low;
    }

    if(b > A[A.length -1]){
      lowInd = findTarget(0, low-1, A,b);
    }else{
      lowInd = findTarget(low,A.length-1, A, b);
    }
    return lowInd;
  }

  private int findTarget(int low, int high, int[] a, int b){
    int targetInd = -1;
    int mid = -1;if(low == high){
      return low;
    }

    while(low < high){
      mid = (low + high) /2;
      if(b == a[mid]){
        return mid;
      }else if(b > a[mid]){
        low = mid + 1;
      }else{
        high = mid;
      }
    }

    return -1;
  }

}
