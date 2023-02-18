package demo.cache;

import cache.CacheService;
import cache.ContextConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Springframework cache
 *
 * @author kangjie.zhang
 * @date 2020/10/28 13:56
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextConfig.class)
public class CacheTest {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private RedisCacheManager redisCacheManager;


    @Test
    public void cacheable(){
        cacheService.get("jack");
        final Cache myCacheName = cacheManager.getCache("myCacheName");
        final Object nativeCache = myCacheName.getNativeCache();

        cacheService.get("jack");
    }

    @Test
    public void cacheable2(){
        cacheService.getWithMyAnnotation("jack");
        cacheService.getWithMyAnnotation("jack");
    }

    @Test
    public void cacheableWithDiffCacheName(){
        cacheService.get("jack");
        cacheService.get2("jack");
        System.out.println(cacheManager.getCacheNames());
    }

    @Test
    public void cacheableWithDiffCacheNameUseRedis(){
        cacheService.getWithRedisCacheManager("jack");
        cacheService.getWithRedisCacheManager2("jack");

        System.out.println(redisCacheManager.getClass().getName());
        System.out.println(cacheManager.getCacheNames());
        System.out.println(redisCacheManager.getCacheNames());
    }


    @Test
    public void getWithDefaultKeyGenerator(){
        //to debug
        cacheService.getWithDefaultKeyGenerator("jack");
//        cacheService.getWithDefaultKeyGenerator(new Person());


        final Cache myCacheName = cacheManager.getCache("myCacheName");
        final Object nativeCache = myCacheName.getNativeCache();
        System.out.println(nativeCache);
    }

    @Test
    public void getWithKeyGenerator(){
        cacheService.getWithKeyGenerator("jack");
    }


    @Test
    public void evict(){
        cacheService.get("jack");
        cacheService.del("jack");
        cacheService.get("jack");
    }

    @Test
    public void put(){
        System.out.println(cacheService.get("jack"));
        cacheService.update("jack");
        System.out.println(cacheService.get("jack"));
    }

    @Test
    public void mutiDel(){
        cacheService.get("jack");
        cacheService.get("tom");
        //cacheService.evicts("jack","tom");
        cacheService.get("jack");
        cacheService.get("tom");
    }






}



