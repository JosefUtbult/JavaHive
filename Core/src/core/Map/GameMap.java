package core.Map;

import core.Graphic.Renderable;
import core.Map.jsonTemplates.MapCharacter;
import core.Objects.RenderableQueue;
import core.tile.GameTile;

import java.awt.*;
import java.util.Arrays;

import static core.Constants.Constants.PIXELSIZE;
import static core.Constants.Constants.TILESIZE;

/**
 * Created by josef on 2016-12-20.
 */
public class GameMap implements IGameMap, Renderable {

    private final GameTile[][] layers;
    private final int tilesInWidth;
    private final int tilesInHeight;

    public GameMap(int tilesInWidth, int tilesInHeight, int[][] layers) {
        this.tilesInWidth = tilesInWidth;
        this.tilesInHeight = tilesInHeight;
        this.layers = Arrays.stream(layers)
                .map(layer -> Arrays.stream(layer)
                        .mapToObj(GameTile::byId)
                        .toArray(GameTile[]::new)
                )
                .toArray(GameTile[][]::new);

        RenderableQueue.get().addObject(this);

    }

    @Override
    public int getTilesInWidth() {
        return this.tilesInWidth;
    }

    @Override
    public int getTilesInHeight() {
        return tilesInHeight;
    }

    @Override
    public GameTile[][] getTiles() {
        return layers;
    }

    @Override
    public IGameMap setTiles(int[][] layers) {
        return null;
    }

    @Override
    public IGameMap setCharacters(MapCharacter[] characters) {
        return null;
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < tilesInHeight; y++) {
            for (int x = 0; x < tilesInWidth; x++) {
                for (int l = 0; l < layers.length; l++) {
                    GameTile tile = layers[l][x + (y * tilesInWidth)];
                    try {
                        g.drawImage(tile.getTexture(), x * PIXELSIZE * TILESIZE, y * PIXELSIZE * TILESIZE, TILESIZE * PIXELSIZE, TILESIZE * PIXELSIZE, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
