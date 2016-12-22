package core.tile;

import core.Graphic.ImageStore;
import core.Store.Unique;

import java.awt.*;

/**
 * Created by josef on 2016-12-20.
 */
public class GameTile implements Unique{

    private int id;
    private String name;
    private String texture;

    public static GameTile byId(int tileId) {
        return TileLibrary.get().get(tileId);
    }

    public static GameTile from(GameTile template) {
        return new GameTile()
                .setName(template.name)
                .setId(template.id)
                .setTexturePath(template.texture);
    }

    public int getId() {
        return this.id;
    }

    private GameTile setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    private GameTile setName(String name) {
        this.name = name;
        return this;
    }

    public Image getTexture() throws Exception {
        return ImageStore.getImage(this.texture);
    }

    private GameTile setTexturePath(String texture) {
        this.texture = texture;
        return this;
    }
}
