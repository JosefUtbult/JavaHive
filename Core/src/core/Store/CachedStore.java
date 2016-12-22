package core.Store;

import core.utils.ObjectCache;

import java.util.Scanner;

/**
 * Loads objects from disc and caches them for further use.
 *
 * All objects loaded and stored must implement the Interface
 * "Unique" that demands each object to contain an ID.
 * @param <T>
 */
public abstract class CachedStore<T extends Unique> implements Store<T>{

    private final ObjectCache<T> objects = new ObjectCache<>();
    private final String filePath;

    public CachedStore(String filePath){
        this.filePath = filePath;
    }

    /**
     * Returns (as implicitly stated by the name) an object stored
     * from cache, and if not available from the cache, the object is loaded
     * from disc (and also stored in the cache).
     * @param id
     * @return
     */
    @Override
    public T get(int id) {
        if(objects.isCached(id))
            return objects.load(id);
        else
            return getFromDisc(id);
    }

    /**
     * If the object was not in cache then this method will
     * load (at least) that object into the cache from
     * the disc. Note that more than one object may be loaded
     * into the cache as the object might not naturally be loaded
     * as a single items from a file, but rather in bulk.
     * @param characterId
     * @return
     */
    private T getFromDisc(int characterId){
        loadObjectsIntoCache(filePath);
        return objects.load(characterId);
    }

    /**
     * Loads objects from disc into cache.
     * @param filePath
     */
    private void loadObjectsIntoCache(String filePath){
        for (T object : convertObjects(loadData(filePath)))
            this.objects.cache(object, object.getId());
    }

    /**
     * Loads and returns an array of objects from disc.
     * The data on disc is stored as JSON and this method
     * converts that JSON data into an array of actual
     * objects.
     * @param discData
     * @return
     */
    public abstract T[] convertObjects(String discData);

    /**
     * Reads data from a place on disc and returns data
     * as a String.
     * @param path
     * @return
     */
    private String loadData(String path){
        return new Scanner(getClass().getResourceAsStream(path))
                .useDelimiter("\\Z")
                .next();
    }
}
