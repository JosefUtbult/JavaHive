package core.Graphic;

import java.awt.*;

import static core.Constants.Constants.PIXELSIZE;

/**
 * Created by josef on 2016-12-03.
 */
public class ImageRenderable implements Renderable {
    private int width;
    private int height;
    private float posX;
    private float posY;
    private int currentFrame;
    private Image image;

    public ImageRenderable(String path, int posX, int posY) throws Exception {
        image = ImageStore.getImage(path);

        this.posX = posX;
        this.posY = posY;

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        currentFrame = 0;
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) posX * PIXELSIZE, (int) posY * PIXELSIZE, null);
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

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public Image getImage() {
        return image;
    }
}
