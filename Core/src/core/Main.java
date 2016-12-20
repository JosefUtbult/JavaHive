package core;

import core.Graphic.GraphicPanel;
import core.Logic.Interception;
import core.Map.IGameMap;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


public class Main {

    private long lastFrame;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.run();
    }

    public int getDelta() {
        long time = System.currentTimeMillis();
        int delta = (int) (time - lastFrame);
        lastFrame = time;


        return delta;
    }

    public void run() throws IOException {

        lastFrame = System.currentTimeMillis();
        JFrame frame = new JFrame();    //Skapa ett fönster.
        GraphicPanel graphicPanel = new GraphicPanel();
        Interception interception = new Interception();

        InputStream temp = getClass().getResourceAsStream("/files/maps/firstMap.json");
        String tempString = new Scanner(temp).useDelimiter("\\Z").next();
        IGameMap map = IGameMap.fromJson(tempString);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Sätter på att det ska kunnas stängas
        frame.setContentPane(graphicPanel);   //Skapar en root-panel som alla frames defineras av. Typ.
        frame.pack();   //Skalar om fönstret efter panelens storlek.

        frame.setLocationRelativeTo(null);  //Sätter fönstret i mitten.
        frame.setVisible(true);
    }
}
