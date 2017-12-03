/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBase;

import GameItems.AddGameButton;
import GameItems.AddGameLevelButton;
import GameItems.AddGameLevelLabel;
import GameItems.GameItems;
import GameRules.GameChangeGreenRule;
import GameRules.GameCheckIfWon;
import GameRules.GameRules;
import MapDrawing.GameMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tergv
 */
public final class GameWindowItems extends JPanel{
    private final GameMap map; 
    private final JPanel thisPanel;
    
    public GameWindowItems(GameMap currentMap, JPanel thisPanel){
        map = currentMap;
        this.thisPanel = thisPanel;
        gameButton();
        
    }
    
    private void gameButton(){
        thisPanel.removeAll();
        levelControlMenu();
        levelLabel();
        
        for (int i=0; i<map.getHeight(); i++){
            for (int u=0; u<map.getWidth(); u++){
                GameItems gameButton = new AddGameButton(i, u, map);
                JButton newButton = gameButton.addGameButton();
                setGameButtonAction(newButton);
                thisPanel.add(newButton);
            }
        }
        thisPanel.repaint();
    }
    
    private void levelLabel() {
        JLabel currentLevelText = new AddGameLevelLabel("Current level: " + map.level).addGameLabel();
        thisPanel.add(currentLevelText);  
    }
    
    private void levelControlMenu(){
        JButton nextLevel = new AddGameLevelButton("Next Level", 100, 10, 240+map.level*60, "1").addGameButton();
        JButton previousLevel = new AddGameLevelButton("Previous Level", 120, 120, 240+map.level*60, "-1").addGameButton();
        JButton resetLevel = new AddGameLevelButton("Reset", 70, 250, 240+map.level*60, "0").addGameButton();
        
        ArrayList<JButton> controlButtons = new ArrayList<JButton>();
        controlButtons.add(nextLevel);
        controlButtons.add(previousLevel);
        controlButtons.add(resetLevel);
        
        for (int i=0; i<controlButtons.size(); i++){
            thisPanel.add(controlButtons.get(i));
            setControlButtonAction(controlButtons.get(i));
        }
    }
    private void setGameButtonAction(JButton newButton){
        newButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                map.generateNewMap.findGreenButtonPlace(map.currentMap);
                String[] splitValues = ((JButton)e.getSource()).getName().split(",");
                if(checkNextMove(Integer.valueOf(splitValues[0]), Integer.valueOf(splitValues[1]))){
                    map.changeGreenButton(map.getGreenButtonPlace()[0], map.getGreenButtonPlace()[1],
                            Integer.valueOf(splitValues[0]), Integer.valueOf(splitValues[1]));
                    map.newGreenButtonPlace(Integer.valueOf(splitValues[0]), Integer.valueOf(splitValues[1]));
                    gameButton();
                    checkIfWin();
                }
            }
        });
    }
    
    private void setControlButtonAction(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.changeMapLevel(Integer.valueOf(((JButton)e.getSource()).getName()));
                map.generateNewMap();
                gameButton();
            }
        });
    }
    private void checkIfWin() {
        GameRules gameWon = new GameCheckIfWon(map);
        if (gameWon.checkRule()){
            JOptionPane.showMessageDialog(this, "Level completed!");
            map.changeMapLevel(1);
            map.generateNewMap();
            gameButton();
        }
    }
    
    public boolean checkNextMove(int x, int y){
        GameRules greenMoveRule = new GameChangeGreenRule(map, x, y);
        return greenMoveRule.checkRule();
    }
}
