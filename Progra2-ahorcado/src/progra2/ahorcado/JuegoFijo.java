/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public class JuegoFijo extends JuegoBase {
 
    public JuegoFijo(String palabra){
        super();
        this.PalabraSecreta = palabra.toLowerCase();
        this.PalabraActual = "_".repeat(PalabraSecreta.length());
    }

    @Override
    public void inicializarPalabraSecreta() {
        this.PalabraActual = "_".repeat(PalabraSecreta.length());
        this.intentos = 0;
        this.LetrasUsadas.clear();
    }

    @Override
    protected boolean Verificar(char letra) {
        return PalabraSecreta.indexOf(letra) >= 0;   
    }

    @Override
    protected void actualizarPalabra(char letra) {
        String palabra = "";
        
        for (int i = 0; i < PalabraSecreta.length(); i++) {
            if (PalabraSecreta.charAt(i) == letra) {
                palabra += letra;
            } else {
                palabra += PalabraActual.charAt(i);
            }
        }
        PalabraActual = palabra;
    }

    @Override
    protected boolean Ganador() {
        return PalabraActual.equals(PalabraSecreta);
    }
}
