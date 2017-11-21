/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tergv
 */
//public class MAP extends JFrame implements KeyListener, MouseListener {
public class MAP extends JFrame {
    public int [][] zemelapis;
    private ArrayList<Integer> skaiciai = new ArrayList<Integer>();
    public int lvl;
    private JPanel panel;
    private Mygtukai button;
    private JFrame outFrame;
    
    
    MAP(JPanel jp, JFrame x){
        panel = jp;
        lvl = 1;
        arrayFill();
        zemelapis = new int[lvl+2][lvl+2];
        zemelapis = mapFill();
        button = new Mygtukai(panel, lvl);
        outFrame = x;
    };
    
    private void arrayFill(){
        skaiciai.clear();
        for (int i=0; i<(lvl+2)*(lvl+2); i++){
            skaiciai.add(i);
        }
    }
    private int[][] mapFill(){
        int[][] zemel = new int[lvl+2][lvl+2];
        ArrayList<Integer> checkList = new ArrayList<Integer>();
        
        for (int i=0; i<lvl+2; i++){
            for (int u=0; u<lvl+2; u++){
                int x = (int)(Math.random() * (skaiciai.size()));
                zemel[i][u] = skaiciai.get(x);
                checkList.add(skaiciai.get(x));
                skaiciai.remove(x);
            }
        }
        
          if (solvable(checkList)) 
            return zemel;
          else{
              arrayFill();
              return mapFill();
          }
            
    }
    
    
    public void changeLvl(int x){
        lvl = x;
        outFrame.setSize(300+60*lvl, 300+60*lvl);
        repaint();
        panel.setSize(300+60*lvl, 300+60*lvl);
        zemelapis = new int[lvl+2][lvl+2];
        arrayFill();
        zemelapis = mapFill();
        button.upButton();
    }
    
    public JPanel printLevel(int x){
        lvl = x;
        button.Update(zemelapis, lvl);
        arrayFill();
        mapFill();
        
        return panel;
    }
    public void repaint(){
        outFrame.repaint();
    }
    //
    public boolean solvable(ArrayList<Integer> list){
        int count=0;
        int x=-1;
        for(int i=0; i<list.size()-1; i++){
                if (list.get(i) == 0){
                    x = i/(lvl+2);
                }
            for (int u=i+1; u<list.size(); u++){
                if (list.get(i) > list.get(u) && list.get(u) != 0)
                    count++;
            }
        }
        if ((lvl % 2 != 0) && (count % 2 == 0))
            return true;
        else if ((lvl % 2 == 0) && (count % 2 == 0) && (x%2 != 0))
            return true;
        else if ((lvl % 2 == 0) && (count % 2 != 0) && (x%2 == 0))
            return true;
        else
            return false;
    }
}                                     