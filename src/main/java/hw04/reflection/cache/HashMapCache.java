package hw04.reflection.cache;

import hw04.reflection.annotation.CacheDeclaration;

import java.util.HashMap;

@CacheDeclaration(name = "HashMapCache")
public class HashMapCache extends AbstractCache {
    public HashMapCache() {
        map = new HashMap<>();
    }
}
