import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracDb {
int val = 10;
  public static void main(String[] args){
//    List<String> li = Arrays.asList("a","b","c","x","a","b","c");
   List<String> li = Arrays.asList("a","b","c","x","a","b");
    String s = li.stream().collect(Collectors.joining());
    int count = 0;
    for(int i = 0; i<s.length();i++){
      String a = li.get(i);
      int ind = s.indexOf(a);
      if(s.indexOf(li.get(i)) == s.lastIndexOf(li.get(i))){
        count++;
      }
    }
    if(count>1){
      System.out.println("Not Valid");
    }else
      System.out.println(s);
  }

}
