import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;

public class FastJsonTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Object object = new Object();
        list.add(object);
        list.add(object);
        //重复引用 可能 会出$ref
        String jsonString = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);

        System.out.println("jsonString = " + jsonString);
    }
}
