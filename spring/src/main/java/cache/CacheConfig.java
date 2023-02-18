package cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kangjie.zhang
 * @date 2020/10/28 13:41
 */
@Configuration
public class CacheConfig {

    @Bean
    @Primary
    public CacheManager mapCacheManager(){
        return new ConcurrentMapCacheManager();

    }


}
