/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameRules;

import MapDrawing.GameMap;

/**
 *
 * @author tergv
 */
public class GameCheckIfWon implements GameRules{
    private final GameMap map;
    
    public GameCheckIfWon(GameMap map){
        this.map = map;
    }
    
    public boolean checkMap(){
        for (int i=0; i<map.getHeight(); i++){
            for (int u=0; u<map.getWidth(); u++){
                if (!(map.currentMap[i][u] == i*map.getWidth() + u + 1)){
                    if (!map.isGreenButton(i, u)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Override
    public boolean checkRule() {
        return checkMap();
    }
    
}
