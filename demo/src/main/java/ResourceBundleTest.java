import java.util.Enumeration;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("t.test");
        String url = resourceBundle.getString("url");
        System.out.println(url);
        Enumeration<String> keys = resourceBundle.getKeys();
        while (keys.hasMoreElements()){
            System.out.println(resourceBundle.getString(keys.nextElement()));
        }
    }
}
