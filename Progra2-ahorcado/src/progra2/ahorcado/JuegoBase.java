/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

import java.util.ArrayList;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public abstract class JuegoBase implements Ahorcable {
 protected String Secreta;
 protected String Actual;
 protected int intentos;
 protected final int Limites = 6;
 protected ArrayList<Character> LetrasUsadas;
 
 public JuegoBase(){
     
  this.LetrasUsadas = new ArrayList<>();
  this.intentos = 0;
 }
 
 public String PrintFigura(int intentos){
     
     switch(intentos){
         
         case 0: return " +---+"
                    +    "\n |   |"
                    +    "\n     |"
                    +    "\n     |"
                    +    "\n     |"
                    +    "\n     |"
                    +    "\n=========";
         
         case 1: return " +---+"
                    +    "\n  |   |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n=========";
             
         case 2: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n=========";
         
         case 3: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n  |   |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n=========";
         
         case 4: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n /|   |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n=========";
         
         case 5: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n /|\\ |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n=========";
         
         case 6: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n /|\\ |"
                    +    "\n      |"
                    +    "\n      |"
                    +    "\n=========";
         
         case 7: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n /|\\ |"
                    +    "\n /    |"
                    +    "\n      |"
                    +    "\n=========";
       
         case 8: return " +---+"
                    +    "\n  |   |"
                    +    "\n  O   |"
                    +    "\n /|\\ |"
                    +    "\n / \\ |"
                    +    "\n      |"
                    +    "\n=========";
         
         case 9: return 
             
     }
 }
}
