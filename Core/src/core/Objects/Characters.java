package core.Objects;

import core.Logic.Interception;

/**
 * Created by josef on 2016-12-16.
 */
public class Characters extends Movable {

    public Characters(Interception interceptions, String imageNames, int posX, int posY, boolean solid, float baseSpeed) throws Exception {
        super(interceptions, imageNames, posX, posY, solid, baseSpeed);

    }

    public Characters(Interception interceptions, String imageNames, int posX, int posY, boolean solid) throws Exception {
        super(interceptions, imageNames, posX, posY, solid);
    }
}
