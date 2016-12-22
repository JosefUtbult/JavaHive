package core.characters;

import com.google.gson.Gson;
import core.Store.CachedStore;

/**
 * Loads and caches characters stored on disc.
 */
public class CharacterStore extends CachedStore<Character>{

    /**
     * A constant string that denotes where the characters are stored
     * on disc.
     */
    private final static String characterJSONPath = "/files/characters/characters.json";

    private CharacterStore(String filePath) {
        super(filePath);
    }

    private static class CharacterStoreHolder {
        public static final CharacterStore instance = new CharacterStore(characterJSONPath);
    }

    /**
     * Returns the Singleton object that is the CharacterStore.
     * (As there is no need for more than one CharacterStore in the
     * application).
     * @return
     */
    public static CharacterStore get(){
        return CharacterStoreHolder.instance;
    }

    /**
     * Loads and returns an array of characters from disc.
     * The data on disc is stored as JSON and this method
     * converts that JSON data into an array of actual
     * Character objects.
     * @param discData
     * @return
     */
    @Override
    public Character[] convertObjects(String discData) {
        return new Gson().fromJson(
                discData,
                Character[].class
        );
    }
}
