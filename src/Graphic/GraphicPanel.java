package Graphic;

import Constants.Constants;
import Objects.RenderableQueue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by josef on 2016-12-03.
 */
public class GraphicPanel extends JPanel {

    @Override
    public Dimension getPreferredSize() {    //Gör Magi
        return new Dimension(Constants.WINDOWWIDTH, Constants.WINDOWHEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Paints background black.
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, Constants.WINDOWWIDTH, Constants.WINDOWHEIGHT);

        RenderableQueue.get().renderQueue(g);
    }
}

