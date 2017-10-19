package hw04.reflection.cluster;

import hw04.reflection.annotation.InjectCache;
import hw04.reflection.cache.Cache;

import java.util.Collections;
import java.util.Map;

public class ClusterOfThreeCaches extends ClusterOfCaches {
    @InjectCache(name="LinkedHashMapCache")
    protected Cache cacheThree;

    public String getFromCacheThree(Integer key) {
        return (cacheThree != null) ? cacheThree.get(key) : NULL_CACHE_MSG;
    }

    public Map<Integer, String> getAllFromCacheThree() {
        return (cacheThree != null) ? cacheThree.getAll() : Collections.EMPTY_MAP;
    }

    @Override
    public void put(Integer key, String value) {
        super.put(key, value);
        if (cacheThree != null) cacheThree.put(key, value);
    }
}
