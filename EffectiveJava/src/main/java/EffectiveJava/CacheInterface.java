package EffectiveJava;

public interface CacheInterface {
    public void put(String cacheName, CacheEntry cacheObject);
    public CacheEntry get(String cacheName) throws Exception;

}
