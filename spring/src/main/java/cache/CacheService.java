package cache;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author kangjie.zhang
 * @date 2019/8/29 12:10
 */
@Service
@Slf4j
public class CacheService {


    @Cacheable(value = "myCacheName", key = "#name")
    public String get(String name) {
        log.info("invoke method get() -- " + name);
        return name;
    }

    @NameCacheable
    public String getWithMyAnnotation(String name) {
        log.info("invoke method get() -- " + name);
        return name;
    }

    @Cacheable(value = "myCacheName2", key = "#name")
    public String get2(String name) {
        log.info("invoke method get2() -- " + name);
        return name;
    }

    @CacheEvict(value = "myCacheName", key = "#name")
    public void del(String name) {
        log.info("invoke method del() -- " + name);
    }

    @CachePut(value = "myCacheName", key = "#name")
    public String update(String name) {
        final String s = name + "-" + new Random().nextInt(10);
        log.info("invoke method update() , update cache '"+ name+"'  --> "+s);
        return s;
    }

    /**
     *
     * @see org.springframework.cache.interceptor.SimpleKeyGenerator
     */
    @Cacheable(value = "myCacheName")
    public String getWithDefaultKeyGenerator(String name) {
        log.info("invoke method getWithDefaultKeyGenerator() -- " + name);
        return name;
    }

    @Cacheable(value = "myCacheName")
    public Person getWithDefaultKeyGenerator(Person name) {
        log.info("invoke method getWithDefaultKeyGenerator() -- " + name);
        return name;
    }


    @Cacheable(value = "myCacheName", key = "#name",cacheManager = "redisCacheManager")
    public String getWithRedisCacheManager(String name) {
        log.info("invoke method getWithRedisCacheManager() -- " + name);
        return name;
    }

    /**
     * redis 中的key 与keyPrefix 和 name 有关
     * @see RedisCache#createCacheKey(java.lang.Object)
     * @see CacheKeyPrefix#simple()
     * @see RedisCacheConfiguration#defaultCacheConfig(java.lang.ClassLoader)
     * @see RedisCacheConfiguration#prefixKeysWith(java.lang.String)
     */
    @Cacheable(value = "myCacheName2", key = "#name",cacheManager = "redisCacheManager")
    public String getWithRedisCacheManager2(String name) {
        log.info("invoke method getWithRedisCacheManager2() -- " + name);
        return name+"--1";
    }


    @Cacheable(value = "myCacheName", keyGenerator = "myKeyGenerator")
    public String getWithKeyGenerator(String name) {
        log.info("invoke method getWithKeyGenerator() -- " + name);
        return name;
    }


    @Caching(evict = {@CacheEvict(value = "myCacheName",key = "#name") ,@CacheEvict(value = "myCacheName",key = "#a1") })
    public String evicts(String name, String name2) {
        log.info("invoke method evicts() -- ");
        return name;
    }





}
