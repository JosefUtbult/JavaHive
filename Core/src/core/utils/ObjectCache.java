package core.utils;

import javafx.beans.property.ObjectProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * A cache for storing values that should rather not be loaded
 * more than once.
 *
 * The cache is not timed and will not expire.
 *
 * Abstracts the method of caching away from HashMap, LinkedList or any other.
 * Though this class uses a HashMap for caching.
 * @param <T>
 */
public class ObjectCache<T> {

    private Map<Integer, T> cache = new HashMap<>();

    /**
     * Compares the objects stored in the cache to see
     * if the object passed in as an argument, is already
     * cached.
     * @param object
     * @return
     */
    public boolean isCached(T object){
        return cache.values().contains(object);
    }

    /**
     * Checks to see if the cache contains any object
     * with the object ID given as an argument.
     * @param objectId
     * @return
     */
    public boolean isCached(int objectId){
        return cache.containsKey(objectId);
    }

    /**
     * Given an object and an id uniquely identifying
     * that object, caches it.
     * @param object
     * @param objectId
     * @return
     */
    public ObjectCache<T> cache(T object, int objectId){
        cache.put(objectId, object);
        return this;
    }

    /**
     * Returns a cached object given an id that
     * identifies that object in the cache.
     * @param objectId
     * @return
     */
    public T load(int objectId){
        return cache.get(objectId);
    }


}
