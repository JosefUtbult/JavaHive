package core.Objects;

/**
 * Created by josef on 2016-12-16.
 */
public class Player {
    Characters character;

    public Player(Characters character) {
        this.character = character;
    }

    public void movePlayerUp(int delta) {
        character.moveUp(delta);
    }

    public void movePlayerDown(int delta) {
        character.moveDown(delta);
    }

    public void movePlayerLeft(int delta) {
        character.moveLeft(delta);
    }

    public void movePlayerRight(int delta) {
        character.moveRight(delta);
    }
}
