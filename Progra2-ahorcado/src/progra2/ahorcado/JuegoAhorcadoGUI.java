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
    private JuegoBase juego;
    private JFrame ventanaMenu;

    public JuegoAhorcadoGUI(JFrame menu, JuegoBase juego) {
        this.ventanaMenu = menu;
        this.juego = juego;
        configurarVentana();
        crearComponentes();
        actualizarInterfaz();
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
        botonMenu.addActionListener(e -> {
            if (ventanaMenu != null) {
                ventanaMenu.setVisible(true);
            }
            dispose();
        });

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
                super.insertString(fb, offset, texto, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String texto, AttributeSet attrs)
                    throws BadLocationException {
                if (texto == null) return;
                if (fb.getDocument().getLength() - length + texto.length() > 1) return;
                super.replace(fb, offset, length, texto, attrs);
            }
        });
    }

    private void jugarTurno() {
        String texto = campoLetra.getText().trim();
        
        if (texto.isEmpty()) {
            etiquetaInfo.setText("Por favor ingrese una letra");
            return;
        }
        
        char letra = texto.charAt(0);
        campoLetra.setText("");
        
        try {
            boolean acerto = juego.jugar(letra);
            
            if (acerto) {
                etiquetaInfo.setText("¡Letra correcta!");
            } else {
                etiquetaInfo.setText("Letra incorrecta. Intentos restantes: " + (juego.getLimiteIntentos() - juego.getIntentos()));
            }
            
            actualizarInterfaz();
            
            // Verificar si ganó
            if (juego.Ganador()) {
                JOptionPane.showMessageDialog(this, 
                    "¡Felicidades! Has ganado. La palabra era: " + juego.getPalabraSecreta(),
                    "¡Victoria!",
                    JOptionPane.INFORMATION_MESSAGE);
                bloquearEntrada();
            }
            
        } catch (progra2.ahorcado.Exceptions.LetraRepetidaException ex) {
            etiquetaInfo.setText("Letra repetida: " + ex.getMessage());
        } catch (progra2.ahorcado.Exceptions.LetraInvalidaException ex) {
            etiquetaInfo.setText("Letra inválida: " + ex.getMessage());
        } catch (progra2.ahorcado.Exceptions.SinIntentosException ex) {
            etiquetaInfo.setText("¡Has perdido!");
            JOptionPane.showMessageDialog(this, 
                ex.getMessage(),
                "Juego Terminado",
                JOptionPane.ERROR_MESSAGE);
            bloquearEntrada();
        }
    }
    
    private void actualizarInterfaz() {
        String palabraMostrar = juego.getPalabraActual().replace("", " ").trim();
        etiquetaPalabra.setText(palabraMostrar);
        
        int intentosRestantes = juego.getLimiteIntentos() - juego.getIntentos();
        etiquetaIntentos.setText("Intentos restantes: " + intentosRestantes);
        
        areaDibujo.setText(juego.PrintFigura(juego.getIntentos()));
    }

    private void bloquearEntrada() {
        campoLetra.setEnabled(false);
        botonIntentar.setEnabled(false);
    }
}