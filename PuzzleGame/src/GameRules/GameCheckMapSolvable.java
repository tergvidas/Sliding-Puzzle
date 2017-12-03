/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameRules;

import MapDrawing.GameMap;
import java.util.ArrayList;

/**
 *
 * @author tergv
 */
public final class GameCheckMapSolvable implements GameRules{
    GameMap map;
    
    public GameCheckMapSolvable(GameMap map){
        this.map = map;
    }
    
    public boolean CheckLevelSolvable(){
        ArrayList<Integer> list = map.generateNewMap.checkList;
        int count=0;
        int x=-1;
        for(int i=0; i<list.size()-1; i++){
                if (list.get(i) == 0){
                    x = i/(map.level+2);
                }
            for (int u=i+1; u<list.size(); u++){
                if (list.get(i) > list.get(u) && list.get(u) != 0)
                    count++;
            }
        }
        return ((map.level % 2 != 0) && (count % 2 == 0)) || ((map.level % 2 == 0) && (count % 2 == 0) && (x%2 != 0)) ||
                ((map.level % 2 == 0) && (count % 2 != 0) && (x%2 == 0));
    }

    @Override
    public boolean checkRule() {
        return CheckLevelSolvable();
    }
}