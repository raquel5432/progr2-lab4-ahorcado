/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.ahorcado;

/**
 *
 * @author riche
 */
import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private JButton btnAdmin, btnFijo, btnAzar;
    private AdminPalabrasSecretas admin;

    public MenuPrincipal(AdminPalabrasSecretas admin) {
        this.admin = admin;

        setTitle("Menú Principal - Ahorcado");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 15, 15));
        setResizable(false);

        btnAdmin = new JButton("Administrar Palabras");
        btnFijo = new JButton("Jugar - Palabra Fija");
        btnAzar = new JButton("Jugar - Palabra al Azar");

        btnAdmin.addActionListener(e -> {
            new AdminGUI(this, admin).setVisible(true);
            setVisible(false);
        });

        btnFijo.addActionListener(e -> {
            String palabra = JOptionPane.showInputDialog(this, "Ingrese la palabra secreta:");

            if (palabra != null && !palabra.trim().isEmpty()) {
                JuegoFijo juegoFijo = new JuegoFijo(palabra.toLowerCase().trim());
                juegoFijo.inicializarPalabraSecreta();

                new JuegoAhorcadoGUI(this, juegoFijo).setVisible(true);
                setVisible(false);
            }
        });

        btnAzar.addActionListener(e -> {
            try {
                JuegoAzar juegoAzar = new JuegoAzar(admin);
                juegoAzar.inicializarPalabraSecreta();

                new JuegoAhorcadoGUI(this, juegoAzar).setVisible(true);
                setVisible(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        add(btnAdmin);
        add(btnFijo);
        add(btnAzar);
    }

    public AdminPalabrasSecretas getAdmin() {
        return admin;
    }
}