package core.tile;

import com.google.gson.Gson;
import core.Objects.Tile;
import core.Store.CachedStore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by josef on 2016-12-20.
 */
public class TileLibrary extends CachedStore<GameTile>{

    private static final String tileJSONFilePath = "/files/tiles/tiles.json";

    private static class TileLibraryHolder {
        public final static TileLibrary instance = new TileLibrary();
    }

    public static TileLibrary get() {
        return TileLibrary.TileLibraryHolder.instance;
    }

    private TileLibrary() {
        super(tileJSONFilePath);
    }

    @Override
    public GameTile[] convertObjects(String discData) {
        return new Gson().fromJson(
                discData,
                GameTile[].class
        );
    }

}


