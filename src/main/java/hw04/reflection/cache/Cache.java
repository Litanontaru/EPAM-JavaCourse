package hw04.reflection.cache;

import java.util.Map;

public interface Cache {
    void put(Integer key, String value);
    String get(Integer key);
    Map<Integer, String> getAll();
}
