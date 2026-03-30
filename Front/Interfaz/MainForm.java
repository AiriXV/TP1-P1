package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.Central;


public class MainForm {

	private JFrame frame;
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
	private Central central = new Central();
	private JLabel lblNewLabel;

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
		initialize();

		JTextField[] campos = new JTextField[]{txt1, txt2, txt3, txt4, txt5};

		for (int i = 0; i < campos.length; i++) {
		    final int indice = i;
		    
		    campos[i].addKeyListener(new KeyAdapter() {
		        public void keyTyped(KeyEvent e) {
		            char letra = e.getKeyChar();
		            central.comprobarPalabra(letra); // Llamamos al método de lógica para comprobar la letra
		            
		            // Solo permitir letras del alfabeto
		            if (!Character.isLetter(letra)) {
		                e.consume(); // cancela cualquier otro carácter (números, símbolos)
		                return;
		            }
		            
		            // Limpiar el campo antes de escribir (para que solo haya 1 letra)
		            campos[indice].setText("");
		            
		            // Convertir a mayúscula
		            e.setKeyChar(Character.toUpperCase(letra));
		            
		            // Si no es el último campo, saltar al siguiente
		            if (indice < campos.length - 1) {
		                SwingUtilities.invokeLater(() -> campos[indice + 1].requestFocus());
		            }
		        }
		   });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(244, 162, 205));
		frame.setBounds(100, 100, 1116, 805);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Titulo = new JLabel("W-UNGS-dle");
		Titulo.setFont(new Font("Arial Rounded MT Bold", Titulo.getFont().getStyle(), 30));
		Titulo.setBounds(434, 11, 201, 86);
		frame.getContentPane().add(Titulo);

		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.setBounds(715, 188, 137, 41);
		frame.getContentPane().add(btnNewButton);

		txt1 = new JTextField();
		txt1.setBounds(287, 181, 69, 55);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(366, 181, 69, 55);
		frame.getContentPane().add(txt2);

		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(445, 181, 69, 55);
		frame.getContentPane().add(txt3);

		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(524, 181, 69, 55);
		frame.getContentPane().add(txt4);

		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(603, 181, 69, 55);
		frame.getContentPane().add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(287, 252, 69, 55);
		frame.getContentPane().add(txt6);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(366, 252, 69, 55);
		frame.getContentPane().add(txt7);
		
		txt8 = new JTextField();
		txt8.setColumns(10);
		txt8.setBounds(445, 252, 69, 55);
		frame.getContentPane().add(txt8);
		
		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(524, 252, 69, 55);
		frame.getContentPane().add(txt9);
		
		txt10 = new JTextField();
		txt10.setColumns(10);
		txt10.setBounds(603, 252, 69, 55);
		frame.getContentPane().add(txt10);
		
		txt11 = new JTextField();
		txt11.setColumns(10);
		txt11.setBounds(287, 318, 69, 55);
		frame.getContentPane().add(txt11);
		
		txt12 = new JTextField();
		txt12.setColumns(10);
		txt12.setBounds(366, 318, 69, 55);
		frame.getContentPane().add(txt12);
		
		txt13 = new JTextField();
		txt13.setColumns(10);
		txt13.setBounds(445, 318, 69, 55);
		frame.getContentPane().add(txt13);
		
		txt14 = new JTextField();
		txt14.setColumns(10);
		txt14.setBounds(524, 318, 69, 55);
		frame.getContentPane().add(txt14);
		
		txt15 = new JTextField();
		txt15.setColumns(10);
		txt15.setBounds(603, 318, 69, 55);
		frame.getContentPane().add(txt15);
		
		txt16 = new JTextField();
		txt16.setColumns(10);
		txt16.setBounds(287, 384, 69, 55);
		frame.getContentPane().add(txt16);
		
		txt17 = new JTextField();
		txt17.setColumns(10);
		txt17.setBounds(366, 384, 69, 55);
		frame.getContentPane().add(txt17);
		
		txt18 = new JTextField();
		txt18.setColumns(10);
		txt18.setBounds(445, 384, 69, 55);
		frame.getContentPane().add(txt18);
		
		txt19 = new JTextField();
		txt19.setColumns(10);
		txt19.setBounds(524, 384, 69, 55);
		frame.getContentPane().add(txt19);
		
		txt20 = new JTextField();
		txt20.setColumns(10);
		txt20.setBounds(603, 384, 69, 55);
		frame.getContentPane().add(txt20);
		
		txt21 = new JTextField();
		txt21.setColumns(10);
		txt21.setBounds(287, 450, 69, 55);
		frame.getContentPane().add(txt21);
		
		txt22 = new JTextField();
		txt22.setColumns(10);
		txt22.setBounds(366, 450, 69, 55);
		frame.getContentPane().add(txt22);
		
		txt23 = new JTextField();
		txt23.setColumns(10);
		txt23.setBounds(445, 450, 69, 55);
		frame.getContentPane().add(txt23);
		
		txt24 = new JTextField();
		txt24.setColumns(10);
		txt24.setBounds(524, 450, 69, 55);
		frame.getContentPane().add(txt24);
		
		txt25 = new JTextField();
		txt25.setColumns(10);
		txt25.setBounds(603, 450, 69, 55);
		frame.getContentPane().add(txt25);
		
		txt26 = new JTextField();
		txt26.setColumns(10);
		txt26.setBounds(287, 516, 69, 55);
		frame.getContentPane().add(txt26);
		
		txt27 = new JTextField();
		txt27.setColumns(10);
		txt27.setBounds(366, 516, 69, 55);
		frame.getContentPane().add(txt27);
		
		txt28 = new JTextField();
		txt28.setColumns(10);
		txt28.setBounds(445, 516, 69, 55);
		frame.getContentPane().add(txt28);
		
		txt29 = new JTextField();
		txt29.setColumns(10);
		txt29.setBounds(524, 516, 69, 55);
		frame.getContentPane().add(txt29);
		
		txt30 = new JTextField();
		txt30.setColumns(10);
		txt30.setBounds(603, 516, 69, 55);
		frame.getContentPane().add(txt30);
		
		JLabel acertado = new JLabel("New label");
		acertado.setBounds(287, 180, 69, 56);
		frame.getContentPane().add(acertado);
		
		JButton btnComprobar1 = new JButton("Comprobar");
		btnComprobar1.setBounds(715, 259, 137, 41);
		frame.getContentPane().add(btnComprobar1);
		
		JButton btnComprobar2 = new JButton("Comprobar");
		btnComprobar2.setBounds(715, 325, 137, 41);
		frame.getContentPane().add(btnComprobar2);
		
		JButton btnComprobar3 = new JButton("Comprobar");
		btnComprobar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprobar3.setBounds(715, 391, 137, 41);
		frame.getContentPane().add(btnComprobar3);
		
		JButton btnComprobar4 = new JButton("Comprobar");
		btnComprobar4.setBounds(715, 457, 137, 41);
		frame.getContentPane().add(btnComprobar4);
		
		JButton btnComprobar5 = new JButton("Comprobar");
		btnComprobar5.setBounds(715, 523, 137, 41);
		frame.getContentPane().add(btnComprobar5);
		
		lblNewLabel = new JLabel("Palabra a adivinar:" + central.getPalabraSecreta());
		lblNewLabel.setBounds(288, 108, 319, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
