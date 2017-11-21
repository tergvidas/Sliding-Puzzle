/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author tergv
 */
public class Rules {
    public int level;
    private ArrayList<JButton> buttons;
    private String s;
    private int newButt;
    private int[][] changedButt;
    private int changeX;
    private int changeY;
    
    Rules(ArrayList<JButton> jb, String x, int[][] ss){
        buttons = jb;
        s = x;
        level = PuzzleGame.map.lvl;
        changedButt = ss;
    }
    public int[][] changeButton(){
        int tarp;
        if (checkGreen() == 1){
            
            tarp = changedButt[changeX][changeY];
            changedButt[changeX][changeY] = changedButt[changeX-1][changeY];
            changedButt[changeX-1][changeY] = tarp;
        }else if (checkGreen() == 2){
            tarp = changedButt[changeX][changeY];
            changedButt[changeX][changeY] = changedButt[changeX+1][changeY];
            changedButt[changeX+1][changeY] = tarp;
        }else if (checkGreen() == 3){
            tarp = changedButt[changeX][changeY];
            changedButt[changeX][changeY] = changedButt[changeX][changeY-1];
            changedButt[changeX][changeY-1] = tarp;
        }else if (checkGreen() == 4){
            tarp = changedButt[changeX][changeY];
            changedButt[changeX][changeY] = changedButt[changeX][changeY+1];
            changedButt[changeX][changeY+1] = tarp;
        }
        
        if (checkWin()){
            level++;
            if (level > 7) level = 1;
        }
        return changedButt;
    }
    public int checkGreen(){
        int clicked = -1;
        int minus = PuzzleGame.map.zemelapis[0].length;
        newButt = -1;
        changeX = -1;
        changeY = -1;
        
        for (int i=0; i<buttons.size(); i++)
            if (buttons.get(i).getText() == s){
                   clicked = i;
                   changeX = clicked / PuzzleGame.map.zemelapis.length;
                   changeY = clicked % PuzzleGame.map.zemelapis.length;
            }
        newButt = clicked;
        if (clicked > PuzzleGame.map.zemelapis.length-1){
            //jei virsuj zalias
            if (buttons.get(clicked-minus).getText() == "")
                return 1;
        }
            
        if (clicked < PuzzleGame.map.zemelapis.length*(PuzzleGame.map.zemelapis.length-1)){
            //jei apacioj zalias
            if (buttons.get(clicked+minus).getText() == ""){
                return 2;
            }
        }
            
        if (clicked%PuzzleGame.map.zemelapis.length != 0){
            //jei kairej zalias
            if (buttons.get(clicked-1).getText() == ""){
                return 3;
            }
        }
            
        if ((clicked-minus+1)%PuzzleGame.map.zemelapis.length != 0){
            //jei desinej zalias
            if (buttons.get(clicked+1).getText() == "")
                return 4;
        }
        return -1;
    } 
    
    private boolean checkWin(){
        int check=0;
        for (int i=0; i<PuzzleGame.map.zemelapis.length; i++){
            for (int u=0; u<PuzzleGame.map.zemelapis[0].length; u++){
                check++;
                if (i+1==PuzzleGame.map.zemelapis.length && u+1 == PuzzleGame.map.zemelapis[0].length 
                        && PuzzleGame.map.zemelapis[i][u] == 0){
                    return true;
                }
                else if (PuzzleGame.map.zemelapis[i][u] != check){
                    return false;
                }
            }
        }
        return true;
    }
}
