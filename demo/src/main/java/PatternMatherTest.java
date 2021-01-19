import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatherTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(":(\\w+)");
        Matcher matcher = pattern.matcher("this a static :name :name :value :value");

        while (matcher.find()) {
            System.out.print(matcher.group() + " " + matcher.group(1));
            System.out.print(matcher.start() + "|" + matcher.end() + " ");

        }
    }
}
