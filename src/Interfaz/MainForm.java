package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logica.Central;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainForm {

	private JFrame frame;
	private Central juego = new Central();
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JTextField txt11;
	private JTextField txt12;
	private JTextField txt13;
	private JTextField txt14;
	private JTextField txt15;
	private JTextField txt16;
	private JTextField txt17;
	private JTextField txt18;
	private JTextField txt19;
	private JTextField txt20;
	private JTextField txt21;
	private JTextField txt22;
	private JTextField txt23;
	private JTextField txt24;
	private JTextField txt25;
	private JTextField txt26;
	private JTextField txt27;
	private JTextField txt28;
	private JTextField txt29;
	private JTextField txt30;
	private JLabel lblNewLabel;
	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private int cantIntentos,cantLetras;
	

	private StringBuilder palabraIngresada;

	private Map<String, JButton> teclado = new HashMap<>();
	
	private int filaActual = 0;
	private JTextField[][] todasLasFilas;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		
		palabraIngresada = new StringBuilder();
		cantIntentos=juego.obteterCantIntentos();
		cantLetras=juego.obtenerCantLetras();
		todasLasFilas=new JTextField[cantIntentos][cantLetras];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();

		frame.getContentPane().setPreferredSize(new Dimension(800, 600));
		frame.getContentPane().setMaximumSize(new Dimension(214748364, 214748364));
		frame.getContentPane().setBackground(new Color(244, 162, 205));
		frame.setBounds(0, 0, 1000, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Titulo = new JLabel("W-UNGS-dle");
		Titulo.setFont(new Font("Arial Rounded MT Bold", Titulo.getFont().getStyle(), 30));
		Titulo.setBounds(434, 11, 201, 86);
		frame.getContentPane().add(Titulo);

		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		panel_0 = new JPanel();
		panel_0.setBackground(new Color(255, 128, 192));
		panel_0.setBounds(287, 178, 485, 405);
		frame.getContentPane().add(panel_0);
		panel_0.setLayout(new GridLayout(cantIntentos, cantLetras, 5, 5));
	
		for(int f =0;f<cantIntentos;f++) {
			for(int c =0;c<cantLetras;c++) {
			 
			    txt1 = new JTextField();
				txt1.setHorizontalAlignment(SwingConstants.CENTER);
//				txt1.setBounds(287, 181, 59, 45);
				txt1.setColumns(10);
				todasLasFilas[f][c]=txt1;
				panel_0.add(txt1);
				
				
		}
	}
	


		// ------------ BOTONES DE COMPROBAR ----------------
		
		

		lblNewLabel = new JLabel("Palabra a adivinar:" + juego.obtenerPalabraSecreta());
		lblNewLabel.setBounds(288, 108, 226, 14);
		frame.getContentPane().add(lblNewLabel);
		
		// ------------ TECLADO ----------------
		JPanel tecladoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tecladoPanel.setBackground(new Color(255, 128, 192));
		tecladoPanel.setBounds(268, 591, 510, 139);
		frame.getContentPane().add(tecladoPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Intentos: " + juego.obtenerIntentosUsados());
		lblNewLabel_1.setBounds(287, 133, 183, 14);
		frame.getContentPane().add(lblNewLabel_1);

		String abecedario = "qwertyuiopasdfghjklñzxcvbnm";

		for (int i = 0; i < abecedario.length(); i++) {
			String letra = String.valueOf(abecedario.charAt(i));
			JButton boton = new JButton(String.valueOf(letra));
			boton.setBorder(new LineBorder(Color.WHITE));
			boton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			boton.setForeground(Color.WHITE);
			boton.setBackground(Color.PINK);
			boton.setPreferredSize(new Dimension(40, 40));

			teclado.put(letra, boton);
			tecladoPanel.add(boton);

			// aux.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//				}
//			});
		}
		
		recorrerFila();
		
	}

	private void mostrarUnicoCaracter(Component comp, char a) {
		if (!Character.isLetter(a)) {
//			throw new IllegalArgumentException("El carácter debe ser una letra.");
		}
		// Convertir a mayúscula y dejar solo esa letra
		JTextField campo = (JTextField) comp;
		campo.setText(String.valueOf(Character.toUpperCase(a)));
	}

	private void recorrerFila() {
	
	    
	    for (int i = 0; i < cantLetras; i++) {
	        final int indiceLetra = i; // Guardamos el índice (0 a 4)
	        JTextField contenedor = todasLasFilas[filaActual][i];
	        
	        contenedor.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    enviarPalabra();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	                   
	                    if (contenedor.getText().isEmpty()) {
	                        contenedor.transferFocusBackward();
	                    } else {
	                        contenedor.setText("");
	                    }
	                }
	            }

	            @Override
	            public void keyTyped(KeyEvent e) {
	                char letraaa = e.getKeyChar();
	                JTextField campo = (JTextField) contenedor;

	                if (!Character.isLetter(letraaa) || !campo.getText().isEmpty()) {
	                    e.consume();
	                    return;
	                }

	                e.setKeyChar(Character.toUpperCase(letraaa));

	                // SOLO movemos el foco si NO es la última letra (índice 4)
	                if (indiceLetra < cantLetras-1) {
	                    SwingUtilities.invokeLater(() -> campo.transferFocus());
	                }
	            }
	        });
	    }
	}
	
	private void enviarPalabra() {
	    if (juego.termino() || filaActual > cantIntentos) return;

	    StringBuilder sb = new StringBuilder();
	    JTextField[] filaActualArray = todasLasFilas[filaActual];
	    
	    for (JTextField campo : filaActualArray) {
	        sb.append(campo.getText());
	    }

	    String palabra = sb.toString();

	    if (palabra.length() < cantLetras) {
	        javax.swing.JOptionPane.showMessageDialog(frame, "La palabra debe tener "+ cantLetras+" letras.");
	        return;
	    }

	    Boolean[] resultado = juego.recibirIntento(palabra);
	    cambiarColorTecla(resultado, palabra); 
	    cambiarColorContenedor(resultado);     

	    // Verificamos victoria o derrota
	    if (juego.termino()) {
	        String mensaje;
	        if (palabra.equalsIgnoreCase(juego.obtenerPalabraSecreta())) {
	            mensaje = "¡GANASTE! " + palabra + " era la palabra.";
	        } else {
	            mensaje = "PERDISTE. La palabra era: " + juego.obtenerPalabraSecreta();
	        }
	        javax.swing.JOptionPane.showMessageDialog(frame, mensaje);
	    } else {
	        solicitarFocoNuevaFila();
	    }
	}

	private void solicitarFocoNuevaFila() {
	    if (filaActual < cantIntentos) {
	        todasLasFilas[filaActual][0].requestFocus();
	    }
	}
	

	protected void cambiarColorTecla(Boolean[] resultadoFila, String palabraEnviada) {
	    palabraEnviada = palabraEnviada.toLowerCase(); 

	    for (int i = 0; i < 5; i++) {
	        String letra = String.valueOf(palabraEnviada.charAt(i));
	        JButton botonTecla = teclado.get(letra);

	        if (botonTecla != null) {
	            if (resultadoFila[i] != null) {
	                if (resultadoFila[i] == true) {
	                    botonTecla.setBackground(Color.green);
	                } else {
	                    botonTecla.setBackground(Color.yellow);
	                }
	            } else {
	            	if (botonTecla.getBackground() != Color.green && 
	                        botonTecla.getBackground() != Color.yellow) {
	                        botonTecla.setBackground(Color.gray);
	                    }
	            }
	        }
	    }
	}
	protected void cambiarColorContenedor(Boolean[] resultadoFila) {
	    JTextField[] filaActualArray = todasLasFilas[filaActual];

	    for (int i = 0; i < 5; i++) {
	        if (resultadoFila[i] != null) {
	            if (resultadoFila[i] == true) {
	                filaActualArray[i].setBackground(Color.green);
	            } else {
	                filaActualArray[i].setBackground(Color.decode("#C9B458"));
	            }
	        } else {
	            filaActualArray[i].setBackground(Color.GRAY);
	        }
	    }

	    filaActual++;
	    recorrerFila();
	}
}

//comentario para testear ah