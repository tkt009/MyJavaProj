import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeList {

  public static void main(String[] args){

    List<Integer> a = Arrays.asList(2,4,7,8,10);
    List<Integer> b = Arrays.asList(1,3,6,9,11,15);
    List<Integer> c = new ArrayList<>(a.size()+b.size());

    for(int i =0,  j=0, k=0;k<a.size()+b.size()-1;){
      if(i==b.size()){
        while(j<a.size()){
          c.add(a.get(i));
          j++;
        }
        break;
      }
      if(j==a.size()){
        while(i<b.size()){
          c.add(b.get(i));
          i++;
        }
        break;
      }
      if(b.get(i)<a.get(j)){
        c.add(b.get(i));
        k++;
        i++;
        continue;
      }
      c.add(a.get(j));
      //c.add(b.get(i));
      k+=1;
      j++;
    }
    c.stream().forEach(System.out::println);
  }

}
