package core.Map;

import core.Graphic.Renderable;
import core.Map.jsonTemplates.MapCharacter;
import core.Objects.RenderableQueue;
import core.characters.Character;
import core.characters.CharacterStore;
import core.tile.GameTile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static core.Constants.Constants.PIXELSIZE;
import static core.Constants.Constants.TILESIZE;

/**
 * Created by josef on 2016-12-20.
 */
public class GameMap implements IGameMap, Renderable {

    private final int tilesInWidth;
    private final int tilesInHeight;
    private Character[] characters;

    private List<List<GameTile>> tileLayers;

    public GameMap(int tilesInWidth, int tilesInHeight) {
        this.tilesInWidth = tilesInWidth;
        this.tilesInHeight = tilesInHeight;

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
        System.out.println("\n\tRETURNED TILES\n");
        return tileLayers.stream().toArray(GameTile[][]::new);
    }

    @Override
    public IGameMap setTiles(int[][] layers) {
        List<List<GameTile>> finalLayers = new ArrayList<>();

        for(int layer = 0; layer < layers.length; layer++){
            List<GameTile> tiles = new ArrayList<>();
            System.out.println("\nLayer " + layer);
            for(int tileIndex = 0; tileIndex < layers[layer].length; tileIndex++){
                Point point =
                        new Point(
                                tileIndex%tilesInWidth,
                                (int)Math.floor(tileIndex/tilesInWidth)
                        );


                System.out.print("[index:"+tileIndex+", tileIndex: " + layers[layer][tileIndex] + ", x:"+point.x+", y:"+point.y+"]");
                tiles.add(
                        GameTile
                            .byId(layers[layer][tileIndex])
                            .setPosition(point)
                );
            }

            finalLayers.add(tiles);
        }

        this.tileLayers = finalLayers;
        return this;
    }

    @Override
    public IGameMap setCharacters(MapCharacter[] characters) {
        this.characters = Arrays.stream(characters)
                .map(mapCharacter -> CharacterStore.get()
                        .get(mapCharacter.id)
                        .setPosition(mapCharacter.position))
                .toArray(Character[]::new);

        return this;
    }

    @Override
    public void render(Graphics g) {
        System.out.println("hello");

        for (List<GameTile> tileLayer : tileLayers) {
            System.out.println("NEW LAYER");
            for (GameTile gameTile : tileLayer) {
                gameTile.render(g);
            }
        }

       //Arrays.stream(characters).forEach(character -> character.getTile().render(g));
    }
}
