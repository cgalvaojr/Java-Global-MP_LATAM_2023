package EffectiveJava;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        CacheService service = new CacheService();
        CacheEntry[] cacheEntries = {
                new CacheEntry("Cache1"),
                new CacheEntry("Cache2"),
                new CacheEntry("Cache3"),
                new CacheEntry("Cache4"),
                new CacheEntry("Cache5"),
        };

        //Support concurrency.
        Stream.of(cacheEntries).parallel().forEach((CacheEntry cacheEntry) -> {
            service.put(cacheEntry.key, cacheEntry);
        });
    }
}