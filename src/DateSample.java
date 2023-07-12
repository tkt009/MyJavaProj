import java.util.Calendar;
import java.util.Date;
import sun.lwawt.macosx.CSystemTray;

public class DateSample {

  public static void main(String[] args){
    Calendar cal = Calendar.getInstance();
    Date d1 = new Date(System.currentTimeMillis());
    cal.setTime(d1);
    cal.add(Calendar.DAY_OF_WEEK, 1);

    Date d = cal.getTime();
    System.out.println(d1);
    System.out.println(d);
  }

}
