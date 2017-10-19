package hw04.reflection.cache;

import hw04.reflection.annotation.CacheDeclaration;

import java.util.TreeMap;

@CacheDeclaration(name = "TreeMapCache")
public class TreeMapCache extends AbstractCache {
    public TreeMapCache() {
        map = new TreeMap<>();
    }
}
