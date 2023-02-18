package cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author kangjie.zhang
 * @date 2019/8/30 14:31
 */
@Slf4j
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        final String s = Arrays.toString(params);
        log.info("generate key {}", s);
        return s;
    }
}
