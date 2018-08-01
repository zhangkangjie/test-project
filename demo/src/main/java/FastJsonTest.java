import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaLayer","bbbbb");
        jsonObject.put("include",0);
        array.add(jsonObject);
        System.out.println(array.toJSONString());

        JSONArray array2 = JSONArray.parseArray(array.toJSONString());
        System.out.println(array2);
        for (Object o : array2) {
            System.out.println(o);
            JSONObject jsonObj = ((JSONObject) o);
            System.out.println(jsonObj.get("include"));
        }

        User user = new User();
        user.setAge(20);
        //user.setName("xiaoming");

        System.out.println(JSON.toJSONString(user));
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(user);
        System.out.println(JSON.toJSONString(list1));

        //String json = "{\"name\":\"null\",}"



    }
    private static class User{
        private String name;
        // 不序列化
        //@JSONField(serialize = false)
        // transient
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
