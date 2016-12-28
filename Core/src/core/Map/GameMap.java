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
import java.util.stream.Collectors;

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
        List<TileLayer> renderLayers = new ArrayList<>();
        renderLayers.addAll(layers);
        renderLayers.add(
                new TileLayer(
                        2,
                        Arrays.stream(characters)
                                .map(character -> character.getTile())
                                .collect(Collectors.toList())
                )
        );

        renderLayers.sort((o1, o2) -> o1.getZIndex() - o2.getZIndex());

        for(TileLayer layer : renderLayers)
            layer.forEach(gameTile -> gameTile.render(g));
    }
}
