package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
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

public class MainForm {

	private JFrame frame;
	private Central juego;
	private JTextField txt1;
	private JLabel lblNewLabel;
	private JLabel lblIntentos;
	private JPanel panel_0;
	private int cantIntentos, cantLetras;

	private Map<String, JButton> teclado = new HashMap<>();

	private int filaActual = 0;
	private JTextField[][] todasLasFilas;
	private String nivel;
	private String idioma;


	
	public MainForm(String nivel, String idioma) {
		this.idioma=idioma;
		this.nivel=nivel;
		juego= new Central(nivel,idioma);
		cantIntentos = juego.obteterCantIntentos();
		cantLetras = juego.obtenerCantLetras();
		todasLasFilas = new JTextField[cantIntentos][cantLetras];
		initialize();
	}

	
	private void initialize() {

		frame = new JFrame();

		frame.getContentPane().setPreferredSize(new Dimension(800, 600));
		frame.getContentPane().setMaximumSize(new Dimension(214748364, 214748364));
		frame.getContentPane().setBackground(new Color(244, 162, 205));
		frame.setBounds(0, 0, 1000, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuArchivo = new JMenu("Opciones");
		JMenuItem itemNuevo = new JMenuItem("Nuevo Juego");
		JMenuItem itemSalir = new JMenuItem("Salir");

		
		itemNuevo.addActionListener(e -> reiniciarJuego()); 
		itemSalir.addActionListener(e -> System.exit(0));

		
		menuArchivo.add(itemNuevo);
		menuArchivo.addSeparator();
		menuArchivo.add(itemSalir);
		menuBar.add(menuArchivo);

		
		frame.setJMenuBar(menuBar);
		
		
		
		
		

		JLabel titulo = new JLabel("W-UNGS-dle");
		titulo.setFont(new Font("Arial Rounded MT Bold", titulo.getFont().getStyle(), 30));
		titulo.setBounds(434, 11, 201, 86);
		frame.getContentPane().add(titulo);

		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarPalabra();
			}
		});

		panel_0 = new JPanel();
		panel_0.setBackground(new Color(255, 128, 192));
		panel_0.setBounds(287, 178, 485, 405);
		frame.getContentPane().add(panel_0);
		panel_0.setLayout(new GridLayout(cantIntentos, cantLetras, 5, 5));

		for (int f = 0; f < cantIntentos; f++) {
			for (int c = 0; c < cantLetras; c++) {
				txt1 = new JTextField();
				txt1.setHorizontalAlignment(SwingConstants.CENTER);
				txt1.setColumns(10);
				todasLasFilas[f][c] = txt1;
				panel_0.add(txt1);
			}
		}

		lblNewLabel = new JLabel("Palabra a adivinar: " + juego.obtenerPalabraSecreta());
		lblNewLabel.setBounds(288, 108, 226, 14);
		frame.getContentPane().add(lblNewLabel);

		lblIntentos = new JLabel("Intentos: " + juego.obtenerIntentosUsados());
		lblIntentos.setBounds(287, 133, 183, 14);
		frame.getContentPane().add(lblIntentos);

		// ------------ TECLADO ----------------
		JPanel tecladoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tecladoPanel.setBackground(new Color(255, 128, 192));
		tecladoPanel.setBounds(268, 591, 510, 139);
		frame.getContentPane().add(tecladoPanel);

		String abecedario = "qwertyuiopasdfghjklñzxcvbnm";

		for (int i = 0; i < abecedario.length(); i++) {
			String letra = String.valueOf(abecedario.charAt(i));
			JButton boton = new JButton(letra);
			boton.setBorder(new LineBorder(Color.WHITE));
			boton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			boton.setForeground(Color.WHITE);
			boton.setBackground(Color.PINK);
			boton.setPreferredSize(new Dimension(40, 40));

			teclado.put(letra, boton);
			tecladoPanel.add(boton);
		}

		recorrerFila();
	}

	private void reiniciarJuego() {

	    this.juego = new Central(this.nivel,this.idioma); 
	    this.filaActual = 0;
	    

	    for (JTextField[] fila : todasLasFilas) {
	        for (JTextField campo : fila) {
	            campo.setText("");
	            campo.setBackground(Color.WHITE);
	            campo.setEditable(true);
	        }
	    }
	    

	    for (JButton boton : teclado.values()) {
	        boton.setBackground(Color.PINK); 
	    }

	    lblNewLabel.setText("Palabra a adivinar: " + juego.obtenerPalabraSecreta());
	    solicitarFocoNuevaFila();
	    
	    javax.swing.JOptionPane.showMessageDialog(frame, "¡Nueva partida, mucha suerte!");
	}

	private void recorrerFila() {
		for (int i = 0; i < cantLetras; i++) {
			final int indiceLetra = i;
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

					if (indiceLetra < cantLetras - 1) {
						SwingUtilities.invokeLater(() -> campo.transferFocus());
					}
				}
			});
		}
	}

	private void enviarPalabra() {
		if (juego.termino() || filaActual >= cantIntentos) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		JTextField[] filaActualArray = todasLasFilas[filaActual];

		for (JTextField campo : filaActualArray) {
			sb.append(campo.getText());
		}

		String palabra = sb.toString();

		if (palabra.length() < cantLetras) {
			javax.swing.JOptionPane.showMessageDialog(frame,
					"La palabra debe tener " + cantLetras + " letras.");
			return;
		}

		Boolean[] resultado = juego.recibirIntento(palabra);

		lblIntentos.setText("Intentos: " + juego.obtenerIntentosUsados());

		if (resultado == null) {
			javax.swing.JOptionPane.showMessageDialog(frame,
					"La palabra no está en el diccionario.");
			return;
		}

		cambiarColorTecla(resultado, palabra);
		cambiarColorContenedor(resultado);

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

		for (int i = 0; i < cantLetras; i++) {
			String letra = String.valueOf(palabraEnviada.charAt(i));
			JButton botonTecla = teclado.get(letra);

			if (botonTecla != null) {
				if (resultadoFila[i] != null) {
					if (resultadoFila[i]) {
						botonTecla.setBackground(Color.GREEN);
					} else {
						if (botonTecla.getBackground() != Color.GREEN) {
							botonTecla.setBackground(Color.YELLOW);
						}
					}
				} else {
					if (botonTecla.getBackground() != Color.GREEN
							&& botonTecla.getBackground() != Color.YELLOW) {
						botonTecla.setBackground(Color.GRAY);
					}
				}
			}
		}
	}

	protected void cambiarColorContenedor(Boolean[] resultadoFila) {
		JTextField[] filaActualArray = todasLasFilas[filaActual];

		for (int i = 0; i < cantLetras; i++) {
			if (resultadoFila[i] != null) {
				if (resultadoFila[i]) {
					filaActualArray[i].setBackground(Color.GREEN);
				} else {
					filaActualArray[i].setBackground(Color.YELLOW);
				}
			} else {
				filaActualArray[i].setBackground(Color.GRAY);
			}
		}

		filaActual++;

		if (filaActual < cantIntentos) {
			recorrerFila();
		}
	}

	public void hacerVisible() {
		frame.setVisible(true);
		
	}
}