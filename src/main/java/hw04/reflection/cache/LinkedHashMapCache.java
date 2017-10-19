package hw04.reflection.cache;

import hw04.reflection.annotation.CacheDeclaration;
import hw04.reflection.annotation.Test;

import java.util.LinkedHashMap;

@Test
@CacheDeclaration(name = "LinkedHashMapCache")
public class LinkedHashMapCache extends AbstractCache{
    public LinkedHashMapCache() {
        map = new LinkedHashMap<>();
    }
}
