package hw04.reflection.cluster;

import hw04.reflection.annotation.InjectCache;
import hw04.reflection.annotation.Test;
import hw04.reflection.cache.Cache;

import java.util.Collections;
import java.util.Map;

public abstract class ClusterOfCaches {
    protected final String NULL_CACHE_MSG = "The cache hasn't been initialized!";
    @Test
    @InjectCache(name="HashMapCache")
    protected Cache cacheOne;

    @InjectCache(name="TreeMapCache")
    protected Cache cacheTwo;

    public String getFromCacheOne(Integer key) {
        return (cacheOne != null) ? cacheOne.get(key) : NULL_CACHE_MSG;
    }

    public Map<Integer, String> getAllFromCacheOne() {
        return (cacheOne != null) ? cacheOne.getAll() : Collections.EMPTY_MAP;
    }

    public String getFromCacheTwo(Integer key) {
        return (cacheTwo != null) ? cacheTwo.get(key) : NULL_CACHE_MSG;
    }

    public Map<Integer, String> getAllFromCacheTwo() {
        return (cacheTwo != null) ? cacheTwo.getAll() : Collections.EMPTY_MAP;
    }

    public void put(Integer key, String value) {
        if (cacheOne != null) cacheOne.put(key, value);
        if (cacheTwo != null) cacheTwo.put(key, value);
    }
}
