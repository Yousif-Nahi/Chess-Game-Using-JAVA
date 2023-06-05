/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess_game.lib;

/**
 *
 * @author Raid Nahi
 */
public class Peice {
    boolean White;
    boolean first_move = true;
    String  type;
    
    public Peice(boolean White, String type) {
        this.White = White;
        this.type = type;
    }

    
    
    
    
    
    
    
    
    
    public boolean isWhite(){
        return this.White;
    }
     
    public String getType(){
        return type;
    }
}
