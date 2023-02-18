package cache;


import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

/**
 * @author kangjie.zhang
 * @date 2020/10/28 17:10
 */
@Configuration
public class JCacheConfig {

    @Bean
    public JCacheCacheManager jCacheCacheManager(){
        final CachingProvider cachingProvider = Caching.getCachingProvider();

        //EhcacheCachingProvider ehcacheCachingProvider = new EhcacheCachingProvider();
        final CacheManager cacheManager = cachingProvider.getCacheManager();

        //配置缓存
        MutableConfiguration<Object, Object> config = new MutableConfiguration<>();
        config.setStoreByValue(false)
            .setTypes(Object.class, Object.class)
            .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.TEN_MINUTES))
            ;

        //创建缓存
        cacheManager.createCache("myCacheName", config);
        cacheManager.createCache("myCacheName2", config);

        return new JCacheCacheManager(cacheManager);
    }


}
