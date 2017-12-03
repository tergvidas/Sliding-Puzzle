/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameItems;

import MapDrawing.GameMap;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author tergv
 */
public class AddGameButton implements GameItems{
    private final int i;
    private final int u;
    private final GameMap map;
    
    public AddGameButton(int i, int u, GameMap map){
        this.i = i;
        this.u = u;
        this.map = map;
    }

    @Override
    public JButton addGameButton() {
        JButton newButton = new JButton(String.valueOf(map.currentMap[i][u]));
        newButton.setSize(60, 60);
        newButton.setLocation(80+u*60, 40+i*60);
        newButton.setName(i+","+u);

        if (map.isGreenButton(i, u)){
            newButton.setBackground(Color.green);
            newButton.setText("");
        }else{
            newButton.setBackground(Color.white);
        }
        return newButton;
    }

    @Override
    public JLabel addGameLabel() {
        return null;
    }
    
}
