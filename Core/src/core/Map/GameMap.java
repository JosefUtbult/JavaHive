package core.Map;

import core.Graphic.Renderable;
import core.Map.jsonTemplates.MapCharacter;
import core.Map.jsonTemplates.TileLayerTemplate;
import core.Objects.RenderableQueue;
import core.characters.Character;
import core.characters.CharacterStore;
import core.tile.GameTile;
import core.tile.TileLayer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by josef on 2016-12-20.
 */
public class GameMap implements IGameMap, Renderable {

    private final int tilesInWidth;
    private final int tilesInHeight;
    private Character[] characters;

    private List<TileLayer> layers;
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
    public IGameMap setTiles(TileLayerTemplate[] layers) {
        List<TileLayer> finalLayers = new ArrayList<>();

        for(TileLayerTemplate tileLayerTemplate : layers){
            TileLayer newLayer = new TileLayer(tileLayerTemplate.zIndex);
            for(int tileIndex = 0; tileIndex < tileLayerTemplate.tiles.length; tileIndex++){
                Point point =
                        new Point(
                                tileIndex%tilesInWidth,
                                (int)Math.floor(tileIndex/tilesInWidth)
                        );


                System.out.print("[index:"+tileIndex+", tileIndex: " + tileLayerTemplate.tiles[tileIndex] + ", x:"+point.x+", y:"+point.y+"]");
                newLayer.add(
                        GameTile
                                .byId(tileLayerTemplate.tiles[tileIndex])
                                .setPosition(point)
                );
            }

            finalLayers.add(newLayer);
        }

        this.layers = finalLayers;

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

        List<GameTile> renderQueue = new ArrayList<>();

        for(int layerIndex = 0; layerIndex < layers.size(); layerIndex++){
            for(int tileIndex = 0; tileIndex < layers.get(layerIndex).size(); tileIndex++){
                int x = tileIndex%tilesInWidth;
                int y = (int)Math.floor(tileIndex/tilesInWidth);

                for(Character character : characters){
                    System.out.println(character.getPosition());
                    if(character.getPosition().x == x && character.getPosition().y == y) {
                        renderQueue.add(character.getTile());
                        System.out.println("Adding character to queue.");
                    }
                    else
                        renderQueue.add(layers.get(layerIndex).get(tileIndex));
                }
            }
        }

        for(GameTile tile : renderQueue)
            tile.render(g);
        //Arrays.stream(characters).forEach(character -> character.getTile().render(g));
    }
}
