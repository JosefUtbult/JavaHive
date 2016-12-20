package Objects;

import Constants.Constants;
import Graphic.ImageRenderable;

import java.awt.image.ImageObserver;
import java.util.ArrayList;

import static Constants.Constants.IMAGEFOLDERPATH;
import static Constants.Constants.TILESIZE;

/**
 * Created by josef on 2016-12-07.
 */
public class Tile extends ImageRenderable {
    protected boolean solid;

    public Tile(String path, int posX, int posY) throws Exception {

        super(path, posX, posY);

        if (this.getWidth() != TILESIZE || this.getHeight() != TILESIZE) {
            System.out.println("ERROR: Image \"" + path + "\" is not the right size, which is " + TILESIZE + " x " + TILESIZE + ".");
        }
        //this.solid = solid;
    }


}
