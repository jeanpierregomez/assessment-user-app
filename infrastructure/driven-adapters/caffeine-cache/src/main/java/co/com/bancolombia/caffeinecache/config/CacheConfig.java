package co.com.bancolombia.caffeinecache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheProperties getCacheProperties(@Value("${cache.ttl}") Long ttl) {
        return CacheProperties.builder()
                .ttl(ttl)
                .build();
    }

    @Bean
    public Caffeine caffeineConfig(CacheProperties cacheProperties) {
        return Caffeine.newBuilder().expireAfterWrite(cacheProperties.getTtl(), TimeUnit.SECONDS);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}
