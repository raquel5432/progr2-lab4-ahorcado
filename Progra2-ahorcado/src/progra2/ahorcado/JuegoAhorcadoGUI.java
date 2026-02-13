package progra2.ahorcado;


import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JuegoAhorcadoGUI extends JFrame {

    private JTextField campoLetra;
    private JLabel etiquetaPalabra;
    private JLabel etiquetaIntentos;
    private JLabel etiquetaInfo;
    private JTextArea areaDibujo;
    private JButton botonIntentar;
    private JButton botonMenu;

    public JuegoAhorcadoGUI() {
        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Ahorcado");
        setSize(520, 460);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void crearComponentes() {

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.gridx = 0;

        etiquetaPalabra = new JLabel("", SwingConstants.CENTER);
        etiquetaPalabra.setFont(new Font("Monospaced", Font.BOLD, 26));
        c.gridy = 0;
        panelPrincipal.add(etiquetaPalabra, c);

        etiquetaIntentos = new JLabel("Intentos restantes: 0", SwingConstants.CENTER);
        c.gridy = 1;
        panelPrincipal.add(etiquetaIntentos, c);

        etiquetaInfo = new JLabel("Escriba una letra:", SwingConstants.CENTER);
        c.gridy = 2;
        panelPrincipal.add(etiquetaInfo, c);

        areaDibujo = new JTextArea();
        areaDibujo.setEditable(false);
        areaDibujo.setFocusable(false);
        areaDibujo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        areaDibujo.setBackground(getBackground());
        areaDibujo.setMargin(new Insets(10, 10, 10, 40));
        areaDibujo.setPreferredSize(new Dimension(220, 150));

        c.gridy = 3;
        panelPrincipal.add(areaDibujo, c);

        campoLetra = new JTextField(1);
        campoLetra.setHorizontalAlignment(JTextField.CENTER);
        limitarEntradaUnaLetra(campoLetra);

        botonIntentar = new JButton("Intentar");
        botonMenu = new JButton("Menú");

        JPanel panelBotones = new JPanel();
        panelBotones.add(campoLetra);
        panelBotones.add(botonIntentar);
        panelBotones.add(botonMenu);

        botonIntentar.addActionListener(e -> jugarTurno());
        botonMenu.addActionListener(e -> dispose());

        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void limitarEntradaUnaLetra(JTextField campo) {

        ((AbstractDocument) campo.getDocument()).setDocumentFilter(new DocumentFilter() {

            @Override
            public void insertString(FilterBypass fb, int offset, String texto, AttributeSet attr)
                    throws BadLocationException {

                if (texto == null) return;
                if (fb.getDocument().getLength() >= 1) return;
                if (!texto.matches("[a-zA-Z]")) return;

                super.insertString(fb, offset, texto, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String texto, AttributeSet attrs)
                    throws BadLocationException {

                if (texto == null) return;
                if (texto.length() > 1) return;
                if (!texto.matches("[a-zA-Z]")) return;

                super.replace(fb, offset, length, texto, attrs);
            }
        });
    }

    private void jugarTurno() {
    }

    private void bloquearEntrada() {
        campoLetra.setEnabled(false);
        botonIntentar.setEnabled(false);
    }
}