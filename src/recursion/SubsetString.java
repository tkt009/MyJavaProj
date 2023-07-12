package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetString {
  static List<String> arr = new ArrayList<>();
  public static void main(String[] args){
    String input = "abc";
    printSubset("",input);
    System.out.println(arr.stream().collect(Collectors.joining(",")));

  }
  public static void printSubset(String op, String ip){
    if(ip.equals("")){
      arr.add(op);
    }else{
      String ip2 = ip.substring(1);
      printSubset(op,ip2);
      String op2 = op + ip.charAt(0);
      printSubset(op2,ip2);
    }
  }

}
