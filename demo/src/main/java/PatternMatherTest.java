import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatherTest {
    private final static Pattern decorateStoreUrlPattern = Pattern.compile("369\\.com/(\\d+)/index\\.html");
    public static void main(String[] args) {
        String url = "http://www.i369.com/s/30.html";
        url ="http://www.i369.com/63/index.html";

        Matcher matcher = decorateStoreUrlPattern.matcher(url);
        if (matcher.find()) {
            int i = matcher.groupCount();
            for (int j = 0; j <= i; j++) {
                System.out.println(j+" - "+matcher.group(j));
            }
        }

        System.out.println("http://111.1".matches("http://\\w*\\.\\w*"));
    }
}
