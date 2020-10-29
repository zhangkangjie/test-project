package cache.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.impl.serialization.CompactJavaSerializer;
import org.ehcache.impl.serialization.StringSerializer;
import org.ehcache.spi.serialization.Serializer;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author kangjie.zhang@ttpai.cn
 * @date 2019/11/20 16:25
 */
public class EhcacheDemo {

    public static void main(String[] args) throws InterruptedException {
        CacheConfiguration<String, Object> configuration = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(300L, EntryUnit.ENTRIES)
                .offheap(20L, MemoryUnit.MB))
            .withExpiry(Expirations.timeToLiveExpiration(Duration.of(2, TimeUnit.SECONDS)))
            .withKeySerializer(StringSerializer.class)
            .withValueSerializer(new CompactJavaSerializer<>(ClassLoader.getSystemClassLoader()))
            .build();

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
            .withCache("mycache", configuration)

            .build(true);
        Cache<String, Object> cache = cacheManager.getCache("mycache", String.class, Object.class);

        final HashMap<String, Object> map = new HashMap<>();
        map.put("key", "value");
        cache.put("test", "testvalue");

        while (true) {
            final Object test = cache.get("test");
            System.out.println(test);

            Thread.sleep(1000L);

        }

    }


}
