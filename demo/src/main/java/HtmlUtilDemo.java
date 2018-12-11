import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;

public class HtmlUtilDemo {
    public static void main(String[] args) {
        String s = HtmlUtils.htmlEscape("好早</script>javascript:alert(1)&lt;","utf-8");
        System.out.println(s);
        System.out.println(StringEscapeUtils.escapeHtml("<script>alert(2)</script>"));


    }
}
