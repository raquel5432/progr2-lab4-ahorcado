/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

import java.util.logging.Level;
import java.util.logging.Logger;
import progra2.ahorcado.Exceptions.SinIntentosException;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public abstract class JuegoAzar extends JuegoBase{
    
    private final AdminPalabrasSecretas admin;

    public JuegoAzar(AdminPalabrasSecretas admin) {
        this.admin = admin;
        inicializarPalabraSecreta();
    }

    @Override
    protected boolean Verificar(char letra) {
        
        return PalabraSecreta.indexOf(letra) >=0;
        
        }

    @Override
    protected void actualizarPalabra(char letra) {
        
        String palabra = "";
        
        for(int i=0 ; i<PalabraSecreta.length(); i++){
            if (PalabraSecreta.charAt(i)== letra){
                palabra += letra;
            }else {
                palabra +=PalabraActual.charAt(i);
            }
        }
        PalabraActual = palabra;
        
    }

    @Override
    protected boolean Ganador() {
        
        return PalabraActual.equals(PalabraSecreta);
        
    }

    @Override
    public void inicializarPalabraSecreta() {
        
        try {
            this.PalabraSecreta = admin.obtenerPalabraAleatoria().toLowerCase();
            
            this.PalabraActual = "_".repeat(PalabraSecreta.length());
            
            this.intentos = 0;
        } catch (SinIntentosException ex) {
            Logger.getLogger(JuegoAzar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
