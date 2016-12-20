package core.Graphic;

import java.awt.*;

/**
 * Created by josef on 2016-12-03.
 */
public class ColorRenderable implements Renderable {
    private int width;
    private int height;
    private int posX;
    private int posY;
    private Color color = new Color(0, 0, 0);

    public ColorRenderable(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
