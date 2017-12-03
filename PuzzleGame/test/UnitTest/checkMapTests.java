/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import GameRules.GameCheckMapSolvable;
import GameRules.GameRules;
import MapDrawing.GameMap;
import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tergv
 */
public class checkMapTests {
    @Test
    public void checkIfMapIsSolvable(){
        GameMap map = new GameMap(new JFrame());
        
        GameRules solvabeRule = new GameCheckMapSolvable(map);
        Assert.assertTrue(solvabeRule.checkRule());
    }
    
    @Test
    public void checkIfPosibleNewLevel(){
        GameMap map = new GameMap(new JFrame());
        map.level = 9;
        Assert.assertTrue(!map.newLevelCheck(map.level+1));
    }
    
    @Test
    public void checkIfCorrectLevel(){
        GameMap map = new GameMap(new JFrame());
        Assert.assertTrue(map.currentMap.length == map.level+2);
    }
}
