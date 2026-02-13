package progra2.ahorcado;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminGUI extends JFrame {

    private AdminPalabrasSecretas admin;
    private DefaultListModel<String> modelo;
    private JList<String> listaPalabras;
    private JTextField campoNueva;
    private JButton botonAgregar;
    private JButton botonRegresar;
    private JFrame ventanaMenu;

    public AdminGUI(JFrame menu, AdminPalabrasSecretas adminCompartido) {
        this.ventanaMenu = menu;
        this.admin = adminCompartido;

        configurarVentana();
        inicializarComponentes();
        cargarPalabras();
    }

    private void configurarVentana() {
        setTitle("Gestión de Palabras");
        setSize(420, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {

        modelo = new DefaultListModel<>();
        listaPalabras = new JList<>(modelo);
        JScrollPane panelScroll = new JScrollPane(listaPalabras);

        JPanel panelInferior = new JPanel(new FlowLayout());

        campoNueva = new JTextField(12);
        botonAgregar = new JButton("Añadir");
        botonRegresar = new JButton("Regresar");

        botonAgregar.addActionListener(e -> agregarNuevaPalabra());
        botonRegresar.addActionListener(e -> volverAlMenu());

        panelInferior.add(new JLabel("Palabra:"));
        panelInferior.add(campoNueva);
        panelInferior.add(botonAgregar);
        panelInferior.add(botonRegresar);

        add(panelScroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void agregarNuevaPalabra() {

        String texto = campoNueva.getText().trim().toLowerCase();

        if (!texto.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Solo se permiten letras.",
                    "Entrada inválida",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            admin.agregarPalabra(texto);
            campoNueva.setText("");
            cargarPalabras();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void cargarPalabras() {
        modelo.clear();
        List<String> lista = admin.getPalabras();
        for (String p : lista) {
            modelo.addElement(p);
        }
    }

    private void volverAlMenu() {
        ventanaMenu.setVisible(true);
        dispose();
    }
}
