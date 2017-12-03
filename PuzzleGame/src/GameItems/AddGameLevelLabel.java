/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameItems;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author tergv
 */
public class AddGameLevelLabel implements GameItems{
    String name;
    
    public AddGameLevelLabel(String name){
        this.name = name;
    }
    
    @Override
    public JButton addGameButton() {
        return null;
    }

    @Override
    public JLabel addGameLabel() {
        JLabel newLabel = new JLabel(name);
        newLabel.setLocation(20, 7);
        newLabel.setSize(150, 30);
        newLabel.setForeground(Color.blue);
        return newLabel;
    }
    
}
