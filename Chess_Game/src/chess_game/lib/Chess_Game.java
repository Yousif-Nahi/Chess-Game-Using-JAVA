/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chess_game.lib;

/**
 *
 * @author Raid Nahi
 */

import java.util.HashMap;
import chess_game.ui.Board;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Chess_Game {
    public static HashMap<String,Square> Board_Data=new HashMap<>();
    public static HashMap<String,javax.swing.JButton> Board_UI=new HashMap<>();
    public static HashMap<String,ImageIcon> image=new HashMap<>();
    public static Board chess_board;
    public static boolean white_turn = true;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inserting the symbols for chess
         //peice name
         // - 
         //true means white
         //false means black
         image.put("pawn_true",  new ImageIcon("image\\pawn_white.png"));
         image.put("pawn_false",  new ImageIcon("image\\pawn_black.png"));
         
         image.put("rook_true",  new ImageIcon("image\\rook_white.png"));
         image.put("rook_false",  new ImageIcon("image\\rook_black.png"));
         
         image.put("knight_true",  new ImageIcon("image\\knight_white.png"));
         image.put("knight_false",  new ImageIcon("image\\knight_black.png"));
          
         image.put("bishop_true",  new ImageIcon("image\\bishop_white.png"));
         image.put("bishop_false",  new ImageIcon("image\\bishop_black.png"));
         
         image.put("queen_true",  new ImageIcon("image\\queen_white.png"));
         image.put("queen_false",  new ImageIcon("image\\queen_black.png"));
         
         image.put("king_true", new ImageIcon("image\\king_white.png"));
         image.put("king_false",  new ImageIcon("image\\king_black.png"));
         
         
         
        
      
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Chess_Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        new_game();
        
               
//        Board_Data.get(""+4+5).peice = new Peice(true, "knight");
//        Board_UI.get(""+4+5).setIcon(image.get("knight_true"));
//        
//        Board_Data.get(""+5+4).peice = new Peice(true, "queen");
//        Board_UI.get(""+5+4).setIcon(image.get("queen_true"));
//        
//        Board_Data.get(""+6+3).peice = new Peice(false, "pawn");
//        Board_UI.get(""+6+3).setIcon(image.get("pawn_false"));
//        
//        Board_Data.get(""+6+4).peice = new Peice(true, "rook");
//        Board_UI.get(""+6+4).setIcon(image.get("rook_true"));
           
    }
    public static void new_game(){
        white_turn = true;
        chess_board = new Board();
        Moves.reset_colors();
        chess_board.show();
        create_board_data();
    }
    public static void create_board_data(){
        //creating the Board and putting it in a map for later accses for when moving / attacking
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                Square square = new Square(i,j);
                Board_Data.put(""+i+j, square);
            }
        }
        
        
        //white pecies
        //creating white pawns on row 7
        
        for(int i=1;i<9;i++){
            Board_Data.get(""+7+i).peice = new Peice(true, "pawn");
            Board_UI.get(""+7+i).setIcon(image.get("pawn_true"));
        }
        
        //white rooks
        Board_Data.get(""+8+1).peice = new Peice(true, "rook");
        Board_UI.get(""+8+1).setIcon(image.get("rook_true"));
        
        Board_Data.get(""+8+8).peice = new Peice(true, "rook");
        Board_UI.get(""+8+8).setIcon(image.get("rook_true"));
        //white knights
        Board_Data.get(""+8+2).peice = new Peice(true, "knight");
        Board_UI.get(""+8+2).setIcon(image.get("knight_true"));
        
        Board_Data.get(""+8+7).peice = new Peice(true, "knight");
        Board_UI.get(""+8+7).setIcon(image.get("knight_true"));
        //white bishops
        Board_Data.get(""+8+3).peice = new Peice(true, "bishop");
        Board_UI.get(""+8+3).setIcon(image.get("bishop_true"));
        
        Board_Data.get(""+8+6).peice = new Peice(true, "bishop");
        Board_UI.get(""+8+6).setIcon(image.get("bishop_true"));
        //whiite king
        Board_Data.get(""+8+5).peice = new Peice(true, "king");
        Board_UI.get(""+8+5).setIcon(image.get("king_true"));
       
        //white queen
        Board_Data.get(""+8+4).peice = new Peice(true, "queen");
        Board_UI.get(""+8+4).setIcon(image.get("queen_true"));
        
        // black peices
        //creating black pawns on row 2
        for(int i=1;i<9;i++){
            Board_Data.get(""+2+i).peice = new Peice(false, "pawn");
            Board_UI.get(""+2+i).setIcon(image.get("pawn_false"));
        }
        
        //black rooks
        Board_Data.get(""+1+1).peice = new Peice(false, "rook");
        Board_UI.get(""+1+1).setIcon(image.get("rook_false"));
        
        Board_Data.get(""+1+8).peice = new Peice(false, "rook");
        Board_UI.get(""+1+8).setIcon(image.get("rook_false"));
        //black knights
        Board_Data.get(""+1+2).peice = new Peice(false, "knight");
        Board_UI.get(""+1+2).setIcon(image.get("knight_false"));
        
        Board_Data.get(""+1+7).peice = new Peice(false, "knight");
        Board_UI.get(""+1+7).setIcon(image.get("knight_false"));
         //black bishops
        Board_Data.get(""+1+3).peice = new Peice(false, "bishop");
        Board_UI.get(""+1+3).setIcon(image.get("bishop_false"));
        
        Board_Data.get(""+1+6).peice = new Peice(false, "bishop");
        Board_UI.get(""+1+6).setIcon(image.get("bishop_false"));
        //black king
        Board_Data.get(""+1+5).peice = new Peice(false, "king");
        Board_UI.get(""+1+5).setIcon(image.get("king_false"));
        
        //black queen
        Board_Data.get(""+1+4).peice = new Peice(false, "queen");
        Board_UI.get(""+1+4).setIcon(image.get("queen_false"));
    }
}