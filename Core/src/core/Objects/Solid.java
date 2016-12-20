package core.Objects;

import core.Graphic.ImageRenderable;

/**
 * Created by josef on 2016-12-10.
 */
public class Solid extends ImageRenderable {
    private boolean solid;

    public Solid(String imageNames, int posX, int posY, boolean solide) throws Exception {
        super(imageNames, posX, posY);
        this.solid = solide;
    }
}
