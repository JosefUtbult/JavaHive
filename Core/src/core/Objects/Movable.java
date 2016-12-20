package core.Objects;

import core.Logic.Interception;

import static core.Constants.Constants.BASESPEED;

/**
 * Created by josef on 2016-12-10.
 */
public class Movable extends Solid {

    private float baseSpeed;
    private Interception interception;

    public Movable(Interception interceptions, String imageNames, int posX, int posY, boolean solid, float baseSpeed) throws Exception {
        super(imageNames, posX, posY, solid);
        this.baseSpeed = baseSpeed;
        this.interception = interceptions;
    }

    public Movable(Interception interceptions, String imageNames, int posX, int posY, boolean solid) throws Exception {
        super(imageNames, posX, posY, solid);
        this.baseSpeed = BASESPEED;
        this.interception = interceptions;
    }

    public void setBaseSpeed(float baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void moveRight(int delta) {
        this.setPosX(this.getPosX() + baseSpeed * delta);

        for (int i = 0; i < interception.getNrOfObjects(); i++) {
            if (interception.intercepts(this, interception.getObject(i))) {
                this.setPosX(this.getPosX() - baseSpeed * delta);
            }
        }
    }

    public void moveLeft(int delta) {
        this.setPosX(this.getPosX() - baseSpeed * delta);

        for (int i = 0; i < interception.getNrOfObjects(); i++) {
            if (interception.intercepts(this, interception.getObject(i))) {
                this.setPosX(this.getPosX() + baseSpeed * delta);
            }
        }
    }

    public void moveDown(int delta) {
        this.setPosY(this.getPosY() + baseSpeed * delta);

        for (int i = 0; i < interception.getNrOfObjects(); i++) {
            if (interception.intercepts(this, interception.getObject(i))) {
                this.setPosX(this.getPosY() - baseSpeed * delta);
            }
        }
    }

    public void moveUp(int delta) {
        this.setPosY(this.getPosY() - baseSpeed * delta);

        for (int i = 0; i < interception.getNrOfObjects(); i++) {
            if (interception.intercepts(this, interception.getObject(i))) {
                this.setPosX(this.getPosY() + baseSpeed * delta);
            }
        }
    }


}
