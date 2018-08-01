import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        User user = new User();
        user.setAge(21);

        String mapJakcson = mapper.writeValueAsString(user);
        System.out.println(mapJakcson);

        User user3 = mapper.readValue(mapJakcson, User.class);
        System.out.println(user3.getName());

        //使用fast json 反序列化
        String json = "{\"name\":null,\"age\":21}";
        User user1 = JSONObject.parseObject(json, User.class);
        System.out.println(user1.getName());
    }

    private static class User{
        private String name ;
        private Integer age ;

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
