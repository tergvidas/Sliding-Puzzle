/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tergv
 */
public class PuzzleGame {    
  public static MAP map;
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleGame");
        JPanel base = new JPanel();
        
        if (frame.getHeight() == 0)
             base.setSize(360, 360);
        else
             base.setSize(frame.getWidth(), frame.getHeight());
        base.setLayout(null);
        map = new MAP(base, frame);
         
        frame.setSize(360,360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        
        base = map.printLevel(1);
        frame.add(base);
        
        
       
    }
}

