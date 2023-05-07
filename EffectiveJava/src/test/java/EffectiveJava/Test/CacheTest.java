package EffectiveJava.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import EffectiveJava.CacheEntry;
import EffectiveJava.CacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class CacheTest {

    CacheService service;
    CacheEntry entry;
    @BeforeEach
    void setUp() {
        service = new CacheService();
        entry = new CacheEntry("TestEntry");
    }
    @Test
    @DisplayName("Verify if our cache list is empty when just instantiating it.")
    void testCacheIsEmpty() {
        assertTrue(service.cacheEntries.isEmpty(), "Cache is empty");
        assertEquals(service.cacheEntries.size(), 0, "Cache size equals zero");
    }

    @Test
    @DisplayName("Verify if cache entries are inserted correctly")
    void testCacheEntryAddition() {
        assertTrue(service.cacheEntries.isEmpty(), "Cache is empty");
        service.put("TestEntry1", entry);
        assertEquals(service.cacheEntries.size(), 1, "Cache has one entry");
    }

    @Test
    @DisplayName("Verify it cache entry will be returnet correctly")
    void testCacheEntryIsReturnedCorreclty() {
        service.put("TestEntry1", entry);
        assertEquals(service.get("TestEntry1").key, "TestEntry");
    }
}
