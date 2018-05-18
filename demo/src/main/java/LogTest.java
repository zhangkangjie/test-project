import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.warn("this is %s","xxx");
        //TODO learn more about printf
        System.out.printf("this is %s", "format print");
    }
}
