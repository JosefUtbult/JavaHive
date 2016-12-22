package core.characters;

import core.Map.jsonTemplates.MapCharacter;
import core.Store.Unique;
import core.tile.GameTile;

import java.awt.*;

/**
 * Created by August on 2016-12-21.
 */
public class Character implements Unique{

    private final int id;
    private String name;
    private int tile;
    private Point position;

    private String dialog = "Hello, world!";

    public Character(MapCharacter mapCharacter){
        this.id = mapCharacter.id;
        this.position = mapCharacter.position;

        Character loadedCharacter = CharacterStore.get().get(this.id);

        this
            .setDialog(loadedCharacter.getDialog())
            .setName(loadedCharacter.getName())
            .setTile(loadedCharacter.getTile());
    }

    public Character setName(String name){
        this.name = name;
        return this;
    }

    public Character setTile(GameTile tile){
        this.tile = tile.getId();
        return this;
    }

    public Character setPosition(Point position){
        this.position = position;
        return this;
    }

    public Character setDialog(String dialog){
        this.dialog = dialog;
        return this;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public GameTile getTile() {
        return GameTile.byId(this.tile);
    }

    public int getTileId(){
        return this.tile;
    }

    public Point getPosition() {
        return position;
    }

    public String getDialog() {
        return dialog;
    }
}
