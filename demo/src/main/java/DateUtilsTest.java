import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {
    public static void main(String[] args) {
        System.out.println(DateUtils.truncate(new Date(), Calendar.DATE));
    }
}
