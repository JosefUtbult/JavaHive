package tile;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by josef on 2016-12-20.
 */
public class TileLibrary {

    private static class TileLibraryHolder {
        public final static TileLibrary instance = new TileLibrary();
    }

    public static TileLibrary get() {
        return TileLibrary.TileLibraryHolder.instance;
    }

    private TileLibrary() {
        String tempString = new Scanner(getClass().getResourceAsStream("/files/tiles/tiles.json")).useDelimiter("\\Z").next();
        GameTile[] tiles = new Gson().fromJson(tempString, GameTile[].class);

        Arrays.stream(tiles)
                .forEach(gameTile -> this.tiles.put(gameTile.getId(), gameTile));
    }

    public static GameTile getTileById(int id) {
        return get().newTileFromTileId(id);
    }

    private Map<Integer, GameTile> tiles = new HashMap<>();

    public GameTile newTileFromTileId(int id) {
        return GameTile.from(tiles.get(id));
    }

}


