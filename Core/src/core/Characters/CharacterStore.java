package core.Characters;

import com.google.gson.Gson;
import core.utils.ObjectCache;

import java.util.Scanner;

/**
 * Loads and caches characters stored on disc.
 */
public class CharacterStore {

    /**
     * A constant string that denotes where the characters are stored
     * on disc.
     */
    private final static String characterJSONPath = "/files/characters/characters.json";

    /**
     * A cache for Characters.
     */
    private final ObjectCache<Character> characters = new ObjectCache<>();

    private static class CharacterJSONLoaderHolder{
        public static final CharacterStore instance = new CharacterStore();
    }

    /**
     * Returns the Singleton object that is the CharacterStore.
     * (As there is no need for more than one CharacterStore in the
     * application).
     * @return
     */
    public static CharacterStore get(){
        return CharacterJSONLoaderHolder.instance;
    }

    /**
     * Returns (as implicitly stated by the name) a Character stored
     * from cache, and if not available from the cache, the object is loaded
     * from disc (and also stored in the cache).
     * @param characterId
     * @return
     */
    public Character get(int characterId){
        if(characters.isCached(characterId))
            return characters.load(characterId);
        else
            return getFromDisc(characterId);
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
    private Character getFromDisc(int characterId){
        loadCharactersIntoCache(characterJSONPath);
        return characters.load(characterId);
    }

    /**
     * Loads characters from disc into cache.
     * @param filePath
     */
    private void loadCharactersIntoCache(String filePath){
        for (Character character : loadCharacters(filePath))
            this.characters.cache(character, character.getId());
    }

    /**
     * Loads and returns an array of characters from disc.
     * The data on disc is stored as JSON and this method
     * converts that JSON data into an array of actual
     * Character objects.
     * @param path
     * @return
     */
    private Character[] loadCharacters(String path){
        return new Gson().fromJson(
                loadData(path),
                Character[].class
        );
    }

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
