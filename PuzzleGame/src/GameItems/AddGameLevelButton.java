/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameItems;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author tergv
 */
public class AddGameLevelButton implements GameItems{
    private final String buttonName;
    private final int buttonWidth;
    private final int buttonPlaceX;
    private final int buttonPlaceY;
    private final String value;
    
    public AddGameLevelButton(String name, int width, int placeX, int placeY, String value){
        buttonName = name;
        buttonWidth = width;
        buttonPlaceX = placeX;
        this.value = value;
        buttonPlaceY = placeY;
    }
    
    @Override
    public JButton addGameButton() {
        JButton button = new JButton(buttonName);
        button.setName(value);
        button.setSize(buttonWidth, 30);
        button.setLocation(buttonPlaceX, buttonPlaceY);
        return button;
    }

    @Override
    public JLabel addGameLabel() {
        return null;
    }
    
}
