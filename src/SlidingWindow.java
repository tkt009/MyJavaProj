public class SlidingWindow
{
    public static void main(String[] args){
        int[] arr = {2,9,1,5,3,8,6};
        //int[] arr = {2, 1, 5, 1, 3, 2};
        SlidingWindow sw = new SlidingWindow();
        int mx = sw.findMaxSumInSlidingWindow(3,arr);
        System.out.println("Max sum is: "+mx);


    }

    public int findMaxSumInSlidingWindow(int windowSize,int[] arr){
        int max = 0;

        int i =0; int j=0;
        int k = windowSize;
        int sum =0;
//        for(; j<arr.length;j++){
//            sum = sum + arr[j];
//            if(j-i+1 == k){
//                max = max(sum,max);
//                sum = sum - arr[i];
//                i++;
//            }
//        }
//        while(j<arr.length){
//            while(j-i+1 <= k){
//                sum = sum + arr[j];
//                j++;
//            }
//            max = max(sum,max);
//            sum = sum - arr[i];
//            i++;
//        }
        //aditya verma algo
        sum= 0; j=0;
        i=0;
        while(j<arr.length){
                sum = sum + arr[j];
                if(j-i+1 < k){//windowSize < k
                    j++;
                }

              else if(j-i+1 == k){//winsowSize == k
                max = max(sum, max);
                sum = sum-arr[i];
                i++;
                j++;
            }
        }

        return max;

    }

    public int max(int sum, int prevMax){
        return sum>prevMax? sum:prevMax;
    }
}
