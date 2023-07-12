import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TImes
{
    public static void main(String[] args) throws ParseException
    {
        Date d1 = new SimpleDateFormat("yyyy/mm/dd").parse("2022/04/04");
        Date d2 = new SimpleDateFormat("yyyy/mm/dd").parse("2022/04/03");
        System.out.println("Diff: "+(d1.getTime()-d2.getTime()));
    }
}
