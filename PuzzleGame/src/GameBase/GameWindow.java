/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBase;

import MapDrawing.GameMap;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author tergv
 */
public class GameWindow extends JFrame implements Game {
    private final JFrame thisFrame = new JFrame("PuzzleGame");
    private final JPanel windowPanel = new JPanel();
    
    private final GameMap map = new GameMap(thisFrame);
    private final GameWindowItems windowItems;
    public GameWindow() throws IOException{
        windowPanel.setSize(360, 360);
        windowPanel.setLayout(null);

        thisFrame.setSize(360,360);
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.setVisible(false);
        thisFrame.setResizable(false);
        
	windowItems = new GameWindowItems(map, windowPanel);
        thisFrame.add(windowPanel);
    }
    
    @Override
    public void start() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable(){
            public void run(){
                    thisFrame.setVisible(true);
            }
        });
    }
    
}
