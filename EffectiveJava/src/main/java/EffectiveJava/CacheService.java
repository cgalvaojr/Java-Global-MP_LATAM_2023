package EffectiveJava;

import java.util.Hashtable;
import  java.util.Timer;
public class CacheService implements CacheInterface {
    public Hashtable<String, CacheEntry> cacheEntries = new Hashtable<>();
    public int cacheHits;
    public int cacheMisses;
    public int cacheEvictions;
    @Override
    public void put(String cacheKey, CacheEntry cacheObject) {
        //Max Size = 100 000
        int CACHE_MAX_SIZE = 100000;
        if(cacheEntries.size() == CACHE_MAX_SIZE) {
            cacheEntries.clear();
            System.out.println("All cache was cleared due to limit ");
        }

        if(!cacheEntries.containsKey(cacheKey)) {
            String putMessage = "Item %s added to cache";
            System.out.println(String.format(putMessage,cacheKey ));
            cacheEntries.put(cacheKey, cacheObject);
        }
    }

    @Override
    public CacheEntry get(String cacheKey) {
        if(cacheEntries.containsKey(cacheKey)) {
            CacheEntry entry = cacheEntries.get(cacheKey);
            cacheHits++;
            //Eviction policy;
            // Time-based on last access (5 seconds);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            cacheEntries.remove(cacheKey);
                            cacheEvictions++;
                            //Number of cache evictions;
                            String cacheEvictionsCounter = String.format("Cache evictions: %d", cacheEvictions);
                            System.out.println(cacheEvictionsCounter);
                            //Removal listener;
                            //Just add to log of removed entry;
                            String text = String.format("Item %s removed from the cache", cacheKey);
                            System.out.println(text);
                        }
                    },
                    5000
            );
            return entry;
        }
        cacheMisses++;
        System.out.println("Entry not found!");
        //Give statistic to user;
        int hitRatio = cacheHits / (cacheHits + cacheMisses);
        String hitRatioText = String.format("Rit Ratio: %d", hitRatio);
        System.out.println(hitRatioText);
        return null;
    }
}
