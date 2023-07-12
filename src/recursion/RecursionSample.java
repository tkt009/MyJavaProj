package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RecursionSample {

  static int[] arr = {0,6,8,2,9,5,7,1,3};
  static Stack<Integer> s = new Stack<Integer>();

  public static void main(String[] args){
    System.out.println("Sample Prog 1:Printing 1 to N recursively");
    print1ToN(5);
    System.out.println();
    System.out.println("Sample Prog 2:Printing N to 1 recursively");
    printNto1(5);
    System.out.println();
    System.out.println("Sample Prog 3:Factorial of n");
    System.out.println(factorial(10));
    System.out.println("Sample Prog 4:Sort an array using my technique");
    sort(arr.length);
    Arrays.stream(arr).forEach(System.out::print);
    System.out.println();
    System.out.println("Sample Prog 4:Sort an array using AV's technique-sort(n-1) array and insert in place");
    populateStack();
    sortAV(s);
    s.stream().forEach(System.out::print);
    System.out.println();
    System.out.println("Sample Program 5: Delete middle element when middle element is given");
    deleteKElem(s,(s.size()/2) + 1);
    while(s.size()>0){
      System.out.print(", "+s.pop());
    }
    System.out.println();
    System.out.println("Sample Program 6: Reverse stack");
    s.removeAll(s);
    s.push(0);
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);
    System.out.println("Stack before revering: ");
    s.stream().collect(Collectors.toList()).forEach(System.out::print);
    System.out.println();
    System.out.println("Stack after reversing: ");
    reverse(s,0);
    s.stream().collect(Collectors.toList()).forEach(System.out::print);
    s.removeAll(s);
    s.push(0);
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);
    reverse2(s);
    System.out.println();
    System.out.println("Stack after reversing2: ");
    s.stream().collect(Collectors.toList()).forEach(System.out::print);
    int[][] arr2 = new int[4][3];
    arr2[1] = new int[]{0};
    System.out.println();
    int n1 = 4;
    int k1 = 5;
    int[] arrn = KthSymbol(n1,k1, arr2);
    System.out.println("Kth grammar value: "+ arrn[k1-1]);


  }

  public static int[] KthSymbol(int n, int k, int[][] arr2){
    if(n==1){
      return arr2[1];
    }
    return fun(KthSymbol(n-1, k-1,arr2));
  }

  public static int[] fun(int[] fr){
    List<Integer> l = new ArrayList<Integer>();
    for(int a: fr){
      if(a == 0){
        l.add(0);
        l.add(1);
      }else if(a == 1){
        l.add(1);
        l.add(0);
      }
    }
    int[] ary = new int[l.size()];
    for(int i = 0; i< l.size();i++){
      ary[i] = l.get(i);
    }
    return ary;
  }





  public static void reverse2(Stack s){
    if(s.size()==0){
      return;
    }
    Integer t = (Integer)s.pop();
    reverse2(s);
    insertAtBottom(s,t);


  }

  public static void insertAtBottom(Stack s, Integer t){
    if(s.size()==0){
      s.push(t);
      return;
    }
    Integer t2 = (Integer)s.pop();
    insertAtBottom(s,t);
    s.push(t2);

  }

  public static void reverse(Stack s, int k) {
    if (k == s.size()-1) {
      return;
    }
    Integer t = (Integer) s.pop();
    insertAtK(s, t, k);
    reverse(s, k+1);
  }

  public static void insertAtK(Stack s, Integer t, int k){
    if (s.size() == k) {
      s.push(t);
      k++;
      return;
    }
    Integer t2 = (Integer) s.pop();
    insertAtK(s, t, k);
    s.push(t2);
  }

  public static void deleteKElem(Stack s, int k){
    if(k==1){
      s.pop();
      return;
    }
    Integer t = (Integer) s.pop();
    deleteKElem(s, k-1);
    s.push(t);
  }

  public static void populateStack(){
    s.push(0);
    s.push(1);
    s.push(5);
    s.push(8);
    s.push(3);
    s.push(4);
    s.push(9);
  }

  public static void sortAV(Stack s){
    if(s.size() == 0)
      return;
    Integer temp = (Integer)s.pop();
    sortAV(s);
    insert(s, temp);
  }

  public static void insert(Stack s, Integer temp){
    if(s.size() == 0 || (Integer)s.peek()<= temp) {
      s.push(temp);
      return;
    }
    Integer temp2 = (Integer) s.pop();
    insert(s,temp);
    s.push(temp2);
  }

  public static void sort(int n){
    if(n==0)
      return;
    int ind1 = 0; int ind2 = n-1;
    swapIfNeeded(ind1, ind2);
    sort(n-1);
  }

  private static void swapIfNeeded(int ind1, int ind2){
    if(ind1==ind2)
      return;
    if(arr[ind1]>arr[ind1+1]){
      swap(ind1,ind1+1);
    }
    swapIfNeeded(ind1+1, ind2);
  }

  private static void swap(int p1, int p2){
    int temp = arr[p1];
    arr[p1] = arr[p2];
    arr[p2] = temp;
  }

  public static void print1ToN(int n){
    if(n == 0){
      return;
    }
    print1ToN(n-1);
    System.out.print(" "+n);
  }

  public static void printNto1(int n){
    if(n==0){
      return;
    }
    System.out.print(" "+n);
    printNto1(n-1);
  }

  public static int factorial(int n){
    if(n==1){
      return 1;
    }
    return n * factorial(n-1);
  }


}
