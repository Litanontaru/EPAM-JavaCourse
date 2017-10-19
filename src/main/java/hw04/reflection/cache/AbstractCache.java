package hw04.reflection.cache;

import java.util.Collections;
import java.util.Map;

public class AbstractCache implements Cache {
    protected Map<Integer, String> map;

    @Override
    public void put(Integer key, String value) {
        map.put(key, value);
    }

    @Override
    public String get(Integer key) {
        return map.getOrDefault(key, "There is no value for this key in the cache!");
    }

    public Map<Integer, String> getAll(){
        return Collections.unmodifiableMap(map);
    }
}
