package core.tile;

import core.Graphic.ImageStore;
import core.Graphic.Renderable;
import core.Store.Unique;

import java.awt.*;

import static core.Constants.Constants.PIXELSIZE;
import static core.Constants.Constants.TILESIZE;

/**
 * Created by josef on 2016-12-20.
 */
public class GameTile implements Unique, Renderable{

    private int id;
    private String name;
    private String texture;
    private Point position = new Point(0,0);

    public static GameTile byId(int tileId) {
        return TileLibrary.get().get(tileId);
    }

    public static GameTile from(GameTile template) {
        return new GameTile()
                .setName(template.name)
                .setId(template.id)
                .setTexturePath(template.texture)
                .setPosition(template.getPosition());
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

    public Point getPosition(){
        return this.position;
    }

    public GameTile setPosition(Point position){
        this.position = position;
        System.out.println("SET NEW POSITION[X: "+ this.position.x + ", Y: " + this.position.y + "]");

        return this;
    }

    @Override
    public void render(Graphics g) {
        try {
            System.out.println("Drawn " + this.getPosition() + " with tile " + this.id);
            g.drawImage(this.getTexture(), this.getPosition().x * PIXELSIZE * TILESIZE, this.getPosition().y * PIXELSIZE * TILESIZE, TILESIZE * PIXELSIZE, TILESIZE * PIXELSIZE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
