/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;

/**
 *
 * @author tergv
 */
public class Mygtukai {
    private JPanel panel;
    private ArrayList<JButton> gButton;
    private Label levelText;
    private JButton next;
    private JButton previous;
    private JButton reset;
    private int level;
    private String push;
    
    Mygtukai(JPanel jp, int lv){
        panel = jp;    
        level = lv;
        levelText = new Label("Current Level " + level);
        gButton = new ArrayList<JButton>();
        next = new JButton("Next Level");
        previous = new JButton("Previous Level");
        reset = new JButton("Reset");
        baseButton();
        push="";
    }
    
    private void baseButton(){;
        next.setSize(100, 30);
        previous.setSize(120, 30);
        reset.setSize(70, 30);
        levelText.setSize(100, 30);
        
        
        next.setLocation(10, panel.getHeight()-60);
        previous.setLocation(120, panel.getHeight()-60);
        reset.setLocation(250, panel.getHeight()-60);
        levelText.setLocation(5, 5);
        
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                labelUpdate();
            }
            
        });
        previous.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (level > 1){
                    level -= 1;
                    labelUpdate();
                }
            }
            
        });
        
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (level < 7){
                    level += 1;
                    labelUpdate();
                }
            }
        });
        
        levelText.setForeground(Color.blue);
        
        panel.add(next);
        panel.add(previous);
        panel.add(reset);
        panel.add(levelText);
    }
    private void gameButton(int[][] arr){
       for (int i=0; i<gButton.size(); i++){
           panel.remove(gButton.get(i));
       }
       gButton.clear();
       
        for (int i=0; i<arr.length; i++){
            for (int u=0; u<arr[1].length; u++){
                JButton gbutt = new JButton("");
                gbutt.setSize(60, 60);
                gbutt.setLocation(80+u*60, 40+i*60);
                
                if (PuzzleGame.map.zemelapis[i][u] == 0){
                    gbutt.setBackground(Color.green);
                    gbutt.setText("");
                }else{
                    gbutt.setText("" + PuzzleGame.map.zemelapis[i][u]);
                    gbutt.setBackground(Color.white);
                }
                gbutt.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    push = gbutt.getText();
                                    sendString();
                                }
                            });
                gButton.add(gbutt);
            }
        }
        for (int i=0; i<gButton.size(); i++){
           panel.add(gButton.get(i));
        }
    }
    public JPanel Update(int[][] array, int x){
        level = x;
        
        gameButton(array);
        return panel;
    }
    public void labelUpdate(){
        levelText.setText("Current Level " + level);
        
        PuzzleGame.map.changeLvl(level);
        gameButton(PuzzleGame.map.zemelapis);
    }
    public void upButton(){
        next.setLocation(10, panel.getHeight()-60);
        previous.setLocation(120, panel.getHeight()-60);
        reset.setLocation(250, panel.getHeight()-60);
        levelText.setLocation(5, 5);
    }
    public void sendString(){
        Rules rules = new Rules(gButton, push, PuzzleGame.map.zemelapis);
        
        PuzzleGame.map.zemelapis = rules.changeButton();        
        PuzzleGame.map.repaint();
        gameButton(PuzzleGame.map.zemelapis);
        if (this.level != rules.level){
            this.level = rules.level;
            showMessageDialog(null, "Level Completed!");
            labelUpdate();            
        }
    }
}
