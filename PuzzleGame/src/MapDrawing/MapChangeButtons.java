/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapDrawing;

/**
 *
 * @author tergv
 */
public class MapChangeButtons {
    private int[][] map;
    MapChangeButtons(int[][] currentMap) {
        map = currentMap;
    }
    
    private boolean sameColumn(int oldY, int newY){
        return oldY == newY;
    }
    
    private boolean sameRow(int oldX, int newX){
        return oldX == newX;
    }
    public void newButtonCliked(int oldX, int oldY, int newX, int newY) {
        if (sameColumn(oldY, newY)){
            for (int i=oldX; i<newX; i++){
                map[i][oldY]= map[i+1][oldY];
            }
            for (int i=oldX; i>newX; i--){
                map[i][oldY]= map[i-1][oldY];
            }
        }else if (sameRow(oldX, newX)){
            for (int i=oldY; i<newY; i++){
                map[oldX][i]= map[oldX][i+1];
            }
            for (int i=oldY; i>newY; i--){
                map[oldX][i]= map[oldX][i-1];
            }
        }
        map[newX][newY] = 0;
    }
    
}
