import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Palindrome {

  public static void main(String[] args){
    String inputString = "zzzazzazz";
    Palindrome p = new Palindrome();
    p.solution(inputString);

    String dateString = "1681333200735";

    Map<String, String> m = new HashMap<>();
    m.put("k1","v1");
    m.put("k2","v2");
    m.put("k3","v3");
    System.out.println("Map is: "+m);

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    LocalDateTime cvDate =
        Instant.ofEpochMilli(Long.parseLong(dateString)).atZone(ZoneId.systemDefault()).toLocalDateTime();
    //String date = cvDate.format(FORMATTER);
    System.out.println(" localDateTime 1: "+cvDate);
    //System.out.println("formatted localDateTime: "+date);

    String dateString2 = "2023-06-09T00:00:00.000Z";
    LocalDateTime cvDate2 = LocalDateTime.parse(dateString2, FORMATTER);

    System.out.println(" localDateTime 2: "+cvDate2);

    String ff = String.format(
        "handleERArchive started: %s | realm: %s | " + "Timestamp: %s |"
            + "EngagementRequestStatus: %s | " + "Assessments To Cancel: %s |"
            + "partial stack: %s",
        "getInternalId()",
        "Base.getSession().getRealm().getName()",
        "System.currentTimeMillis()",
        "getEngagementRequestStatus()",
        3,
        "RiskUtil.getPartialStackTrace()");
    System.out.println(ff);
  }

  public boolean solution(String inputString) {
    if(inputString.length()==1){
      return true;
    }
    int i =0;
    int j=inputString.length()-1;
    for(; i<j;i++,j--){
      char c1 = inputString.charAt(i);
      char c2 = inputString.charAt(j);
      if(c1 != c2){
        return false;
      }
    }
    return true;


  }

}
