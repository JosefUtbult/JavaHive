package core.Characters;

import java.awt.*;

/**
 * Created by August on 2016-12-21.
 */
public class Character {

    private static int nextId = 0;

    private final int id;
    private String name;
    private int tile;
    private Point position;

    private String dialog = "Hello, world!";

    public Character(){
        this.id = getNextId();
    }

    /**
     * Returns the id and then increases the value "nextId" by one!
     * So that the next one to "getNextId" gets a new and unique id.
     *
     * @return
     */
    private static int getNextId(){
        return nextId++;
    }

    public int getId(){
        return this.id;
    }
}
