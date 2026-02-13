/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progra2.ahorcado;

import javax.swing.*;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public class Progra2Ahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdminPalabrasSecretas admin = new AdminPalabrasSecretas();

        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal(admin).setVisible(true);
        });
    }
    
}
