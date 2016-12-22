package core.Objects;

import core.Graphic.ImageRenderable;
import core.Graphic.Renderable;
import core.Store.Unique;

import java.awt.*;

import static core.Constants.Constants.TILESIZE;

/**
 * Created by josef on 2016-12-07.
 */
public class Tile extends ImageRenderable implements Renderable {
    protected boolean solid;

    public Tile(String path, int posX, int posY) throws Exception {
        super(path, posX, posY);

        if (this.getWidth() != TILESIZE || this.getHeight() != TILESIZE) {
            System.out.println("ERROR: Image \"" + path + "\" is not the right size, which is " + TILESIZE + " x " + TILESIZE + ".");
        }
        //this.solid = solid;
    }
}
