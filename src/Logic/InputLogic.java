package Logic;

import Graphic.GraphicPanel;
import Objects.Player;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

/**
 * Created by josef on 2016-12-16.
 */
public class InputLogic {

    Player player;
    GraphicPanel graphicPanel;

    public InputLogic(GraphicPanel graphicPanel) {
        this.graphicPanel = graphicPanel;
        graphicPanel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {

            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });
    }

    public void readInputs(int delta) {
        KeyStroke[] keyStrokes = graphicPanel.getRegisteredKeyStrokes();
        for (int i = 0; i < keyStrokes.length; i++) {
            if (player != null) {
                //if (keyStrokes[i] == )
            }
        }
    }

    public void addPlayer(Player player) {
        this.player = player;
    }
}
