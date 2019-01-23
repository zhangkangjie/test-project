import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class FormatterTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(FormatterTest.class);
        logger.warn("this is %s","xxx");
        //see more about class Formatter
        System.out.printf("this is %s", "format print");
        System.out.printf("unicode %c", 'c');
        System.out.printf(" %tF", new Date());
        System.out.printf(" %s %s", new Date() ,"ok");
        System.out.printf(" %2$5s %2$5s", "a" ,"b");

        System.out.printf(" %2$5d %2$5s", 1 ,2);

        System.out.printf("generate html %s id %d success", "xxx", 5);


    }
}
