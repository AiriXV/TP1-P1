package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logica.Central;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.Box;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyChangeEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


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
	private JButton btnNewButton_12;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel_0;
	private JPanel panel_2;
	private Central juego = new Central();
	private StringBuilder inPalabra; 
	private int contador5=4;
	private JPanel panel_3;
	private Map<String, JButton> teclado = new HashMap<>();

	

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
	
		inPalabra=new StringBuilder();
	            
	         
           

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
				///////
			}
		});
	
		

	
		
		
		panel_0 = new JPanel();
		panel_0.setBackground(new Color(255, 128, 192));
		panel_0.setBounds(287, 178, 385, 405);
		frame.getContentPane().add(panel_0);
		panel_0.setLayout(new GridLayout(6, 5, 5, 5));
		
		
		btnNewButton.setBounds(715, 188, 137, 41);
		frame.getContentPane().add(btnNewButton);
		
		
		panel_1 = new JPanel();
		panel_0.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 5, 5));
		panel_1.setBackground(new Color(244, 162, 205));
		

		
		
		
		txt1 = new JTextField();
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setBounds(287, 181, 69, 55);
		txt1.setColumns(10);
		panel_1.add(txt1);
		


		txt2 = new JTextField();
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setColumns(10);
		txt2.setBounds(366, 181, 69, 55);
		panel_1.add(txt2);

		txt3 = new JTextField();
		txt3.setHorizontalAlignment(SwingConstants.CENTER);
		txt3.setColumns(10);
		txt3.setBounds(445, 181, 69, 55);
		panel_1.add(txt3);
		
		txt4 = new JTextField();
		txt4.setHorizontalAlignment(SwingConstants.CENTER);
		txt4.setColumns(10);
		txt4.setBounds(524, 181, 69, 55);
		panel_1.add(txt4);
		
		txt5 = new JTextField();
		
		
		txt5.setHorizontalAlignment(SwingConstants.CENTER);
		txt5.setColumns(10);
		txt5.setBounds(603, 181, 69, 55);
		panel_1.add(txt5);

    	
		recorrerFila(panel_1);
	
			
		
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBounds(287, 252, 385, 55);
//		frame.getContentPane().add(panel_2);
		panel_0.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 5, 5, 5));
		panel_2.setBackground(new Color(244, 162, 205));
		
		
		txt6 = new JTextField();
		txt6.setHorizontalAlignment(SwingConstants.CENTER);
		txt6.setColumns(10);
		txt6.setBounds(287, 252, 69, 55);
		panel_2.add(txt6);
		
		txt7 = new JTextField();
		txt7.setHorizontalAlignment(SwingConstants.CENTER);
		txt7.setColumns(10);
		txt7.setBounds(366, 252, 69, 55);
		panel_2.add(txt7);
		
		txt8 = new JTextField();
		txt8.setHorizontalAlignment(SwingConstants.CENTER);
		txt8.setColumns(10);
		txt8.setBounds(445, 252, 69, 55);
		panel_2.add(txt8);
		
		txt9 = new JTextField();
		txt9.setHorizontalAlignment(SwingConstants.CENTER);
		txt9.setColumns(10);
		txt9.setBounds(524, 252, 69, 55);
		panel_2.add(txt9);
		
		txt10 = new JTextField();
		txt10.setHorizontalAlignment(SwingConstants.CENTER);
		txt10.setColumns(10);
		txt10.setBounds(603, 252, 69, 55);
		panel_2.add(txt10);
		
		
		
		
		
		panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBounds(287, 252, 385, 55);
		panel_0.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 5, 5, 5));
		
		
		
		txt11 = new JTextField();
		txt11.setHorizontalAlignment(SwingConstants.CENTER);
		txt11.setColumns(10);
		txt11.setBounds(287, 318, 69, 55);
		panel_3.add(txt11);
		
		txt12 = new JTextField();
		txt12.setHorizontalAlignment(SwingConstants.CENTER);
		txt12.setColumns(10);
		txt12.setBounds(366, 318, 69, 55);
		panel_3.add(txt12);
		
		txt13 = new JTextField();
		txt13.setHorizontalAlignment(SwingConstants.CENTER);
		txt13.setColumns(10);
		txt13.setBounds(445, 318, 69, 55);
		panel_3.add(txt13);
		
		txt14 = new JTextField();
		txt14.setHorizontalAlignment(SwingConstants.CENTER);
		txt14.setColumns(10);
		txt14.setBounds(524, 318, 69, 55);
		panel_3.add(txt14);
		
		txt15 = new JTextField();
		txt15.setHorizontalAlignment(SwingConstants.CENTER);
		txt15.setColumns(10);
		txt15.setBounds(603, 318, 69, 55);
		panel_3.add(txt15);
		
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
		
		
		for(Component com : panel_0.getComponents()) {
			recorrerFila(com);
			}
		
		
		
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
		lblNewLabel.setBounds(288, 108, 137, 14);
		frame.getContentPane().add(lblNewLabel);
		//TECLADO
		JPanel tecladoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tecladoPanel.setBackground(new Color(255, 128, 192));
		tecladoPanel.setBounds(268, 591, 510, 139);
		frame.getContentPane().add(tecladoPanel);
	
		
		
		
		
		
		
		
		
		
		
	
		
		
		String abecedario="qwertyuiopasdfghjklñzxcvbnm";
		
		for (int i=0; i<abecedario.length();i++) {
			String letra = String.valueOf(abecedario.charAt(i));
			JButton boton  = new JButton(String.valueOf(letra));
			boton.setBorder(new LineBorder(Color.WHITE));
			boton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			boton.setForeground(Color.WHITE);
			boton.setBackground(Color.PINK);
			boton.setPreferredSize(new Dimension(40, 40));
		
			teclado.put(letra,boton);
			tecladoPanel.add(boton);
			
			
		//aux.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//				}
//			});
		
			
			
		}
		
	
		
		
		
		
	}	
	
	private void mostrarUnicoCaracter (Component comp,char a) {
	
    	 if (!Character.isLetter(a)) {
    		  
	        //exception
	    }

	    // Convertir a mayúscula y dejar solo esa letra
      JTextField campo = (JTextField) comp;
      
      
	    campo.setText(String.valueOf(Character.toUpperCase(a)));
	    
	   
	   }
	private void recorrerFila(Component com) {
		JPanel m= (JPanel)com;
		for (Component comp : m.getComponents()) {
	    	comp.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					
					if (((JTextField) comp).getText().length() > 0) {
			            e.consume(); // para detectar un solo char
			            return;
			        }else {
					char letra=e.getKeyChar();
					
					 //limpia
					e.consume();
					mostrarUnicoCaracter(comp,letra);
					inPalabra.append(letra);
					
				
					if(contador5>0) {
						
						SwingUtilities.invokeLater(() -> comp.transferFocus());
						contador5--;
					}
						else {
							String palabra= inPalabra.toString();
					//		System.out.println(juego.recibirIntento(palabra)); 
							cambiarColoresLetras(juego.recibirIntento(palabra));
							SwingUtilities.invokeLater(() -> comp.transferFocus());
							inPalabra.setLength(0);
							contador5=4;	
						
								}		
			        }						
}
				
				});
	   ;
				}
				}



	protected void cambiarColoresLetras(Boolean[] colores) {
	
		for(int i =0;i<5;i++) {
			if(colores[i]!=null){
			if(colores[i]==true){
				
				String Let= String.valueOf(inPalabra.charAt(i));
				teclado.get(Let).setBackground(Color.green);
			}else{
				String Let= String.valueOf(inPalabra.charAt(i));
				teclado.get(Let).setBackground(Color.yellow);
			}
		}}
	}
}
