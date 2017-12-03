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
public class GameChangeGreenRule implements GameRules{
    private final GameMap map;
    private final int x;
    private final int y;
    
    public GameChangeGreenRule(GameMap map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
    }
    private boolean checkIfGreenSameRow(int x){
        return map.generateNewMap.greenButtonPlace[0] == x;
    }
    private boolean checkIfGreenSameColumn(int y){
        return map.generateNewMap.greenButtonPlace[1] == y;
    }
    public boolean checkNextMove(int x, int y) {
        return checkIfGreenSameRow(x) || checkIfGreenSameColumn(y);
    }

    @Override
    public boolean checkRule() {
        return checkNextMove(x, y);
    }
    
    
}
