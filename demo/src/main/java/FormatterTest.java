import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class FormatterTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(FormatterTest.class);
        logger.warn("this is %s","xxx");
        //TODO learn more about printf
        System.out.printf("this is %s", "format print");
        System.out.printf("unicode %c", 'c');
        System.out.printf(" %tF", new Date());
        System.out.printf(" %s %s", new Date() ,"ok");
        System.out.printf(" %2$5s%2$5s", "a" ,"b");


    }
}
