/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

/**
 *
 * @author riche
 */
import java.util.ArrayList;
import java.util.Random;

import progra2.ahorcado.Exceptions.LetraInvalidaException;
import progra2.ahorcado.Exceptions.LetraRepetidaException;
import progra2.ahorcado.Exceptions.SinIntentosException;

public class AdminPalabrasSecretas {

    private final ArrayList<String> palabras;

    public AdminPalabrasSecretas() {
        palabras = new ArrayList<>();

        palabras.add("interfaz");
        palabras.add("pokemon");
        palabras.add("viabilidad");
        palabras.add("enumeracion");
        palabras.add("excepcion");
        palabras.add("superheroe");
        palabras.add("alienigena");
        palabras.add("misterio");
        palabras.add("fantasma");
    }

    public void agregarPalabra(String palabra)
            throws LetraInvalidaException, LetraRepetidaException {

        if (palabra == null || palabra.trim().isEmpty()) {
            throw new LetraInvalidaException("La palabra no puede estar vacía.");
        }

        palabra = palabra.toLowerCase().trim();

        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                throw new LetraRepetidaException("La palabra ya existe en la lista.");
            }
        }

        palabras.add(palabra);
    }

   
    public String obtenerPalabraAleatoria() throws SinIntentosException {

        if (palabras.isEmpty()) {
            throw new SinIntentosException("No hay palabras disponibles.");
        }

        Random rand = new Random();
        return palabras.get(rand.nextInt(palabras.size()));
    }

    public ArrayList<String> getPalabras() {
        return new ArrayList<>(palabras);
    }
}
