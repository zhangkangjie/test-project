package cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Collection;

/**
 * Springframework cache
 *
 * @author kangjie.zhang@ttpai.cn
 * @date 2020/10/28 13:56
 */

@Slf4j
public class CacheBootstrap {


    public static void main(String[] args) {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        final CacheService cacheService = context.getBean(CacheService.class);

        CacheManager cacheManager = context.getBean(CacheManager.class);
        log.info("cacheManager : "+cacheManager.getClass().getName());

        cacheable(cacheService,context);
        del(cacheService);


    }

    static void cacheable(CacheService cacheService,AnnotationConfigApplicationContext context){
        CacheManager cacheManager = context.getBean(CacheManager.class);
        Collection<String> cacheNames = cacheManager.getCacheNames();
        log.info("cacheNames "+ Arrays.toString(cacheNames.toArray()));

        cacheService.get("jack");

        cacheNames = cacheManager.getCacheNames();
        log.info("cacheNames "+ Arrays.toString(cacheNames.toArray()));

        cacheService.get("jack");
        cacheService.get2("jack");

        cacheNames = cacheManager.getCacheNames();
        log.info("cacheNames "+ Arrays.toString(cacheNames.toArray()));
    }

    static void del(CacheService cacheService){
        cacheService.get("jack");
        cacheService.del("jack");
        cacheService.del("jack");
        cacheService.get("jack");
    }

    static void mutiDel(CacheService cacheService){
        cacheService.get("jack");
        cacheService.get("tom");

        cacheService.evicts("jack","tom");

        cacheService.get("jack");
        cacheService.get("tom");
    }


}



