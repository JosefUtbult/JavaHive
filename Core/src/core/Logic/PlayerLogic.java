package core.Logic;

import core.Objects.Characters;
import core.Objects.Player;
import core.Objects.RenderableQueue;

/**
 * Created by josef on 2016-12-16.
 */
public class PlayerLogic {
    Player player;

    PlayerLogic(Interception interception, RenderableQueue renderableQueue) throws Exception {

        String tempList = "forest_gnome.png";
        Characters character = new Characters(interception, tempList, 3, 3, true);
        // renderableQueue.addObject(1, character);
        this.player = new Player(character);
    }

    public void moveUp(int delta) {
        player.movePlayerUp(delta);
    }

    public void moveDown(int delta) {
        player.movePlayerDown(delta);
    }

    public void moveLeft(int delta) {
        player.movePlayerLeft(delta);
    }

    public void moveRight(int delta) {
        player.movePlayerRight(delta);
    }
}
