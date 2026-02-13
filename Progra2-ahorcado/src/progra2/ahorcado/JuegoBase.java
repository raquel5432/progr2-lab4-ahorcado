/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

import java.util.ArrayList;
import progra2.ahorcado.Exceptions.LetraInvalidaException;
import progra2.ahorcado.Exceptions.LetraRepetidaException;
import progra2.ahorcado.Exceptions.SinIntentosException;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public abstract class JuegoBase implements Ahorcable {
 protected String PalabraSecreta;
 protected String PalabraActual;
 protected int intentos;
 protected final int Limites = 6;
 protected ArrayList<Character> LetrasUsadas;
 
 public JuegoBase(){
     
  this.LetrasUsadas = new ArrayList<>();
  this.intentos = 0;
 }
 
 public String PrintFigura(int intentos){
     
     return switch (intentos) {
         case 0 -> """
                    +---+
                    |   |
                        |
                        |
                        |
                        |
                   ========""";
         case 1 -> """
                    +---+
                    |   |
                    O   |
                        |
                        |
                        |
                   ========""";
         case 2 -> """
                    +---+
                    |   |
                    O   |
                    |   |
                        |
                        |
                   ========""";
         case 3 -> """
                    +---+
                    |   |
                    O   |
                   /|   |
                        |
                        |
                   ========""";
         case 4 -> """
                    +---+
                    |   |
                    O   |
                   /|\\ |
                        |
                        |
                   ========""";
         case 5 -> """
                    +---+
                    |   |
                    O   |
                   /|\\ |
                   /    |
                        |
                   ========""";
         case 6 -> """
                    +---+
                    |   |
                    O   |
                   /|\\ |
                   / \\ |
                        |
                   ========""";
         default -> """
                    +---+
                    |   |
                    O   |
                   /|\\ |
                   / \\ |
                        |
                   ========""";
     };     

 }
 
    public String getPalabraActual(){
    
        return PalabraActual;
} 
    public String getPalabraSecreta(){
        
        return PalabraSecreta;
 }
    
    public int getIntentos(){
        return intentos;
    }
    
    public int getLimiteIntentos(){
        return Limites;
    }
    
   public void Validar(char letra) throws LetraInvalidaException, LetraRepetidaException {

    letra = Character.toLowerCase(letra);

    if (!Character.isLetter(letra)) {
        throw new LetraInvalidaException("SOLO LETRAS DEL ALFABETO");
    }

    if (LetrasUsadas.contains(letra)) {
        throw new LetraRepetidaException("La letra " + letra + " ya fue usada");
    }
}

   
   @Override
   public boolean jugar(char letra)throws LetraRepetidaException, LetraInvalidaException, SinIntentosException{
       
       Validar(letra);
       
       LetrasUsadas.add(letra);
       
       if (Verificar(letra)){
           
           actualizarPalabra(letra);
           return true;
       } else{
           intentos++;
           if(intentos >= Limites){
               throw new SinIntentosException("Has perdido. La palabra era: " + PalabraSecreta);
           
           } return false;
       }
       
   }
    protected abstract boolean Verificar(char letra);
         
    protected abstract void actualizarPalabra(char letra);
    
    protected abstract boolean Ganador();
    
        
}
