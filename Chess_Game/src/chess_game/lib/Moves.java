/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess_game.lib;

import static chess_game.lib.Chess_Game.Board_Data;
import static chess_game.lib.Chess_Game.Board_UI;
import static chess_game.lib.Chess_Game.image;
import static chess_game.lib.Chess_Game.white_turn;
import java.awt.Color;
import java.util.Objects;
import java.util.Vector;
/**
 *
 * @author Raid Nahi
 */
 public class Moves {
     public static Vector<String> Valid_Moves = new Vector();
     public static Vector<String> Check_Moves = new Vector();
     static int sel_row;
     static int sel_col;
     static boolean selected = false;
     static int king_white_i = 8;
     static int king_white_j = 5;
     
     static int king_black_i = 1;
     static int king_black_j = 5;      
    /*
     
     king
     queen
     rock
     bishop
     pawn 
     knight
     
     
     check peice function{
     if king()
     
     if   rock()
     
     if
     
     if
     
     }
     */
     static public void check_mate(){
     for(int i=1;i<9;i++){
         for(int j=1;j<9;j++){
             show_moves(j, j);
         }
     }
     
     
     }
     static public void show_moves(int row,int col){
         reset_colors();
         if(selected){
             if(Valid_Moves.contains(""+row+col) || Valid_Moves.contains("E"+row+col)){
             Peice peice = Board_Data.get(""+sel_row+sel_col).peice;
             peice.first_move = false;
                 Board_Data.get(""+row+col).peice = peice; 
                 Board_UI.get(""+row+col).setIcon(image.get(peice.getType()+"_"+peice.isWhite()));
                 Board_Data.get(""+sel_row+sel_col).peice = null;
                 Board_UI.get(""+sel_row+sel_col).setIcon(null);
                 white_turn = !white_turn;
                 selected = false;
                 return;
             }
         }
         Peice peice = Board_Data.get(""+row+col).peice;
         if(Objects.isNull(peice))return;
         if(peice.isWhite() != white_turn)return;
         Valid_Moves.clear();
         boolean isWhite = peice.isWhite();
         Board_UI.get(""+row+col).setBackground(Color.YELLOW);
         if(peice.getType().equals("king")){
             moves_king(row,col,isWhite);
         }
         if(peice.getType().equals("queen")){
             moves_bishop(row,col,isWhite);
             moves_rook(row, col,isWhite);
         }
         if(peice.getType().equals("knight")){
             moves_knight(row,col,isWhite);
         }
         if(peice.getType().equals("bishop")){
             moves_bishop(row,col,isWhite);
         }
         if(peice.getType().equals("rook")){
             moves_rook(row,col,isWhite);
         }
         if(peice.getType().equals("pawn")){
             moves_pawn(row,col,isWhite,peice.first_move);
         }
         selected = true;
         sel_row = row;
         sel_col = col;
         
         show_valid_moves();
         
     }
     public static void moves_king(int row,int col,boolean isWhite){
         Valid_Moves.add(valid_move(row+1, col+1, isWhite));
         Valid_Moves.add(valid_move(row+1, col-1, isWhite));
         Valid_Moves.add(valid_move(row-1, col+1, isWhite));
         Valid_Moves.add(valid_move(row-1, col-1, isWhite));
         Valid_Moves.add(valid_move(row+1, col  , isWhite));
         Valid_Moves.add(valid_move(row-1, col  , isWhite));
         Valid_Moves.add(valid_move(row  , col+1, isWhite));
         Valid_Moves.add(valid_move(row  , col-1, isWhite));
     }
     //for the queen we just call bishop and rook 
     public static void moves_knight(int row,int col,boolean isWhite){
         Valid_Moves.add(valid_move(row+2, col+1, isWhite));
         Valid_Moves.add(valid_move(row+2, col-1, isWhite));
         Valid_Moves.add(valid_move(row-2, col+1, isWhite));
         Valid_Moves.add(valid_move(row-2, col-1, isWhite));
         
         Valid_Moves.add(valid_move(row+1, col+2, isWhite));
         Valid_Moves.add(valid_move(row+1, col-2, isWhite));
         Valid_Moves.add(valid_move(row-1, col+2, isWhite));
         Valid_Moves.add(valid_move(row-1, col-2, isWhite));
     }
     public static void moves_bishop(int row,int col,boolean isWhite){
         for(int i=row+1,j=col+1;i<9 && j<9;i++,j++){
             Valid_Moves.add(valid_move(i, j, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         for(int i=row+1,j=col-1;i<9 && j>0;i++,j--){
             Valid_Moves.add(valid_move(i, j, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         for(int i=row-1,j=col+1;i>0 && j<9;i--,j++){
             Valid_Moves.add(valid_move(i, j, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         for(int i=row-1,j=col-1;i>0 && j>0;i--,j--){
             Valid_Moves.add(valid_move(i, j, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
     }
     public static void moves_rook(int row,int col,boolean isWhite){
         for(int i=row+1;i<9;i++){
             Valid_Moves.add(valid_move(i, col, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         for(int i=row-1;i>0;i--){
             Valid_Moves.add(valid_move(i, col, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         for(int i=col+1;i<9;i++){
             Valid_Moves.add(valid_move(row, i, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         for(int i=col-1;i>0;i--){
             Valid_Moves.add(valid_move(row, i, isWhite));
             if(Valid_Moves.lastElement().equals("") || Valid_Moves.lastElement().charAt(0)=='E')
                 break;
         }
         
     }
     public static void moves_pawn(int row,int col,boolean isWhite,boolean first_move){
         int dir=1;
         if(isWhite)dir = -1;
         int row1 = row + dir;
         if(valid_coords(row1, col) && Objects.isNull(Board_Data.get(""+row1+col).peice))
             Valid_Moves.add(valid_move(row1, col, isWhite));
         else Valid_Moves.add("");
         if(first_move){
           if(!Valid_Moves.lastElement().equals("") && Valid_Moves.lastElement().charAt(0) != 'E')
                 Valid_Moves.add(valid_move(row + dir + dir, col, isWhite));
          }
                 
         //special case attack for pawns
         int col1 = col + dir;
         int col2 = col - dir;
         if(valid_coords(row1, col1)){
            if(!Objects.isNull(Board_Data.get(""+row1+col1).peice)){
               if(Board_Data.get(""+row1+col1).peice.isWhite() != isWhite ){
                  Valid_Moves.add("E"+row1+col1);
               }
           }
         }
            
         
         if(valid_coords(row1, col2)){
            if(!Objects.isNull(Board_Data.get(""+row1+col2).peice)){
               if(Board_Data.get(""+row1+col2).peice.isWhite() != isWhite ){
                  Valid_Moves.add("E"+row1+col2);
               }
           }
         }
    }
     public static boolean valid_coords(int row,int col){
         if(row > 8 || row < 1)return false;
         if(col > 8 || col < 1)return false;
         return true;
     }
     
     
     
     public static String valid_move(int row,int col,boolean isWhite){
         if(!valid_coords(row, col))return "";
         if(Objects.isNull(Board_Data.get(""+row+col).peice))return ""+row+col;
         if(Board_Data.get(""+row+col).peice.isWhite() == isWhite)return "";
         return "E"+row+col;
     }
     public static void show_valid_moves(){
         for(String ss:Valid_Moves){
             if(ss.equals(""))continue;
             if(ss.charAt(0) == 'E')Board_UI.get(ss.substring(1)).setBackground(Color.RED);
             else Board_UI.get(ss).setBackground(Color.GREEN);
         }
     }
     public static void reset_colors(){
         boolean white = true;
         for(int i=1;i<9;i++){
             for(int j=1;j<9;j++){
                 if(white)Board_UI.get(""+i+j).setBackground(Color.WHITE);
                 else Board_UI.get(""+i+j).setBackground(Color.GRAY);
                 white = !white;
             }
             white = !white;
         }
         
         
     }
}
