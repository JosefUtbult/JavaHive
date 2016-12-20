package Logic;

import Objects.Solid;

import java.util.ArrayList;

/**
 * Created by josef on 2016-12-10.
 */
public class Interception {
    protected ArrayList<Solid> solidObjects = new ArrayList<>();

    public boolean intercepts(Solid primaryObject, Solid secondaryObject) {
        if (primaryObject.getPosX() + primaryObject.getWidth() >= secondaryObject.getPosX() &&
                primaryObject.getPosX() < secondaryObject.getPosX() + secondaryObject.getWidth() &&
                primaryObject.getPosY() + primaryObject.getHeight() >= secondaryObject.getPosY() &&
                primaryObject.getPosY() < secondaryObject.getPosY() + secondaryObject.getHeight()) {
            return true;
        } else
            return false;
    }

    public void addObject(Solid solid) {
        boolean existing = false;
        for (int i = 0; i < solidObjects.size(); i++) {
            if (solidObjects.get(i) == solid) {
                existing = true;
                break;
            }
        }

        if (!existing) {
            solidObjects.add(solid);
        }
    }

    public void removeObject(Solid solid) {
        solidObjects.remove(solid);
    }

    public Solid getObject(int i) {
        return solidObjects.get(i);
    }

    public int getNrOfObjects() {
        return solidObjects.size();
    }
}
