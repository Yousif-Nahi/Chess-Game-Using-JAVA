/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess_game.lib;

/**
 *
 * @author Raid Nahi
 */
public class Square {
    int row;
    int col;
    String symbol;
    public Peice peice;
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
    }
     
}
