/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapDrawing;

import GameRules.GameCheckMapSolvable;
import GameRules.GameRules;
import javax.swing.JFrame;

/**
 *
 * @author tergv
 */
public class GameMap {
    private final JFrame thisFrame;
    public int [][] currentMap;
    public int level;
    public MapGenerator generateNewMap;
    
    
    public GameMap(JFrame fr){
        thisFrame = fr;
        level = 1;
        generateNewMap = new MapGenerator(level);
        currentMap = generateNewMap.newMap();
        checkIfMapSolvable();
    }
    
    public void checkIfMapSolvable(){
        GameRules solvabeRule = new GameCheckMapSolvable(this);
        if(!solvabeRule.checkRule()){
            generateNewMap = new MapGenerator(level);
            currentMap = generateNewMap.newMap();
        }
    }
    
    public void changeMapLevel(int newLevel){
        if(newLevelCheck(level + newLevel)){
            level += newLevel;
        }
    }
    
    public void generateNewMap(){
        checkIfMapSolvable();
        thisFrame.setSize(300+level*60,300+level*60);
        generateNewMap = new MapGenerator(level);
        currentMap = generateNewMap.newMap();
    }
    
    public boolean isGreenButton(int x, int y){
        return currentMap[x][y] == 0;
    }
    
    public int[] getGreenButtonPlace(){
        return generateNewMap.greenButtonPlace;
    }
    
    public void newGreenButtonPlace(int x, int y){
        generateNewMap.greenButtonPlace = new int[] {x, y};
    }
    
    public int getHeight() {
	return currentMap.length;
    }

    public int getWidth() {
        return currentMap[0].length;
    }
    
    public void changeGreenButton(int oldX, int oldY, int newX, int newY){
        MapChangeButtons changeButton = new MapChangeButtons(currentMap);
        changeButton.newButtonCliked(oldX, oldY, newX, newY);
    }

    private boolean newLevelCheck(int newLevel) {
        return newLevel < 10 && newLevel > 0;
    }
    
}