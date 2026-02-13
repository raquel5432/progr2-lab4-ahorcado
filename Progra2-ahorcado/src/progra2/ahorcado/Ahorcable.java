/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package progra2.ahorcado;

import progra2.ahorcado.Exceptions.LetraInvalidaException;
import progra2.ahorcado.Exceptions.LetraRepetidaException;
import progra2.ahorcado.Exceptions.SinIntentosException;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */

public interface Ahorcable {
    void inicializarPalabraSecreta();
    boolean jugar(char letra) throws LetraRepetidaException, LetraInvalidaException, SinIntentosException;
}
