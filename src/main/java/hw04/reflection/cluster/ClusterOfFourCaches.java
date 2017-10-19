package hw04.reflection.cluster;

import hw04.reflection.annotation.InjectCache;
import hw04.reflection.cache.Cache;

import java.util.Collections;
import java.util.Map;

public class ClusterOfFourCaches extends ClusterOfThreeCaches {
    @InjectCache(name="HashMapCache")
    private Cache cacheFour;

    private int test;

    public String getFromCacheFour(Integer key) {
        return (cacheFour != null) ? cacheFour.get(key) : NULL_CACHE_MSG;
    }

    public Map<Integer, String> getAllFromCacheFour() {
        return (cacheFour != null) ? cacheFour.getAll() : Collections.EMPTY_MAP;
    }

    @Override
    public void put(Integer key, String value) {
        super.put(key, value);
        if (cacheFour != null) cacheFour.put(key, value);
    }
}
