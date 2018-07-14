
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {
    public static void main(String[] args){
      String mm = new SimpleDateFormat("yyyyMMdd").format(new Date());
      System.out.println(mm);
    }
}
