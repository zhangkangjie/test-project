package cache;


import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kangjie.zhang
 * @date 2020/10/28 16:25
 */
@Configuration
public class EhcaheConfig {

    @Bean
//    @Primary
    public EhCacheCacheManager ehCacheCacheManager(){
        //2.5+
//        final CacheManager cacheManager = new CacheManager();
        final CacheManager cacheManager1 = EhCacheManagerUtils.buildCacheManager();
        cacheManager1.addCacheIfAbsent("myCacheName");
        cacheManager1.addCacheIfAbsent("myCacheName2");
        return new EhCacheCacheManager(cacheManager1);
    }

}
