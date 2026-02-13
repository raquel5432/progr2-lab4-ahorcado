/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public abstract class JuegoFijo extends JuegoBase {
 
    public JuegoFijo(String palabra){
        this.PalabraSecreta = palabra.toLowerCase();
        this.PalabraActual = "_".repeat(PalabraSecreta.length());
    }

    @Override
    protected boolean Verificar(char letra) {
     
        return PalabraSecreta.indexOf(letra)>=0;   
    }

    @Override
    protected void actualizarPalabra(char letra) {
        
        System.out.println("Palabra secreta estableciada" + "*".repeat(PalabraSecreta.length()));
    }

    protected boolean Ganador(char letra) {
    
        return PalabraActual.equals(PalabraSecreta);
    }

    
    protected void inicializarPalabraSecreta(char letra) {
     
        String palabra ="";
        
        for (int i =0 ; i<PalabraSecreta.length(); i++){
            if (PalabraSecreta.charAt(i)== letra){
                palabra += letra;
            } else{
                palabra += PalabraActual.charAt(i);
            }
        }
        PalabraActual = palabra;
    }

   
}
