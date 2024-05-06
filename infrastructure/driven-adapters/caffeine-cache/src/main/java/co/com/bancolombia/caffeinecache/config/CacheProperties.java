package co.com.bancolombia.caffeinecache.config;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CacheProperties {
    private Long ttl;
}
