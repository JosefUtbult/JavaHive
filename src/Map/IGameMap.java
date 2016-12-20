package Map;

import Map.jsonTemplates.GameMapTemplate;
import com.google.gson.Gson;
import gnome.Gnome;
import tile.GameTile;

/**
 * Created by josef on 2016-12-20.
 */
public interface IGameMap {

    static IGameMap fromJson(String json) {
        GameMapTemplate template = new Gson().fromJson(json, GameMapTemplate.class);
        return new GameMap(template.tilesInWidth, template.tilesInHeight, template.layers)
                .setTiles(template.layers)
                .setCharacters(template.characters);
    }

    int getTilesInWidth();

    int getTilesInHeight();

    GameTile[][] getTiles();

    IGameMap setTiles(GameTile[][] layers);

    IGameMap setCharacters(Gnome[] gnomes);
}
