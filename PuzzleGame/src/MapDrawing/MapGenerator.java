/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapDrawing;

import java.util.ArrayList;

/**
 *
 * @author tergv
 */
public class MapGenerator {
    private ArrayList<Integer> numbers;
    private final int currentLevel;
    public ArrayList<Integer> checkList;
    public int[] greenButtonPlace; 
    
    public MapGenerator(int level){
        currentLevel = level;
        greenButtonPlace = new int[3];
    }
    
    private void GenerateNewNumbers(){
        numbers = new ArrayList<Integer>();
        for (int i=0; i<(currentLevel+2)*(currentLevel+2); i++){
            numbers.add(i);
        }
    }
    
    public void findGreenButtonPlace(int[][] map){
        for (int i=0; i<map.length; i++){
            for (int u=0; u<map[0].length; u++){
                if(isGreenButton(map[i][u])){
                    greenButtonPlace[0] = i;
                    greenButtonPlace[1] = u;
                }
            }
        }
    }
    public boolean isGreenButton(int x){
        return x == 0;
    }
    
    public int[][] newMap(){
        GenerateNewNumbers();
        checkList = new ArrayList<Integer>();
        int[][] map = new int[currentLevel+2][currentLevel+2];
        
        for (int i=0; i<currentLevel+2; i++){
            for(int u=0; u<currentLevel+2; u++){
                int x = (int)(Math.random() * (numbers.size()));
                map[i][u] = numbers.get(x);
                checkList.add(numbers.get(x));
                numbers.remove(x);
            }
            findGreenButtonPlace(map);
        }
        return map;
    }
}
