public class FirstNonRepeat {

  public static void main(String[] args){
    String s = "cabcdcab";
    boolean found = false;
    int index = 0;
    String aa = String.format("LEFT OUTER JOIN INFONET.USERS UR1 ON %s.DECISION_MAKER_SR_USER_ID = UR1.ID ","ERC");
    System.out.println(aa);
    for(int i=0;i<s.length();i++){
      Character c = s.charAt(i);
      if(s.lastIndexOf(c)>i){
        found = true;
        index = i;
        break;
      }
    }
    if(found){
      System.out.println("found nrc: "+s.charAt(index));
    }else{
      System.out.println("not found nrc");
    }

    FirstNonRepeat fr = new FirstNonRepeat();
    fr.printAlternates(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    System.out.println();
    fr.printAlternates2(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
  }

  public void printAlternates(int[] arr){
    for(int currIndex = 1;
        currIndex < arr.length;
        currIndex++)
    {

      // If currIndex stores even index
      // or odd position
      if (currIndex % 2 == 0)
      {
        System.out.print(arr[currIndex] + " ");
      }
    }
  }

  public void printAlternates2(int[] arr){
    for(int currIndex = 1;
        currIndex < arr.length;
        currIndex = currIndex+2)
    {

      System.out.print(arr[currIndex] + " ");
    }
  }

}
