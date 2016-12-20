package Graphic;

import Constants.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static Constants.Constants.PIXELSIZE;

/**
 * Created by josef on 2016-12-03.
 */
public class ImageStore {
    private static HashMap<String, Image> images = new HashMap<>();

    public static Image getImage(String path) throws Exception {
        if (!images.containsKey(path)) {
            Image tempImage = null;

            try {
                tempImage = ImageIO.read(ImageStore.class.getResource(path));

            } catch (IOException e) {
                System.out.println("ERROR: Can not find image \"" + path + "\"");
            }
            tempImage = tempImage.getScaledInstance(tempImage.getWidth(new JFrame()) * PIXELSIZE, tempImage.getHeight(new JFrame()) * PIXELSIZE, Image.SCALE_SMOOTH);

            images.put(path, tempImage);
        }
        return images.get(path);
    }
}
