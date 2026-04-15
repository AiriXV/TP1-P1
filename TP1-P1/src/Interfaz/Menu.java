package Interfaz;


	import javax.swing.*;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

	public class Menu extends JFrame {
	    private JComboBox<String> dificultad;
	    private JComboBox<String> idioma;
	    private JButton btnIniciar;
	    private JLabel lblNewLabel;

	    public Menu() {
	        setTitle("DIFICULTAD");
	        setSize(452, 251);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        dificultad = new JComboBox<>(new String[]{"MEDIA", "ALTA"});
	        dificultad.setBounds(112, 54, 103, 21);
	        dificultad.setMaximumRowCount(15);
	        dificultad.setFont(new Font("Verdana", Font.BOLD, 11));
	        
	        idioma = new JComboBox<>(new String[]{"español", "english"});
	        idioma.setBounds(245, 54, 127, 21);
	        idioma.setFont(new Font("Verdana", Font.BOLD, 11));
	        btnIniciar = new JButton("Iniciar Juego");
	       
	        btnIniciar.setBounds(130, 122, 208, 33);
	        btnIniciar.setFont(new Font("Verdana", Font.BOLD, 11));

	        btnIniciar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String nivelSeleccionado = (String) dificultad.getSelectedItem();
	                String idiomaSeleccionado = (String) idioma.getSelectedItem();
	                iniciarJuego(nivelSeleccionado,idiomaSeleccionado);
	            }
	        });

	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 128, 192));
	        panel.setForeground(new Color(128, 128, 255));
	        panel.setLayout(null);
	        
	        lblNewLabel = new JLabel("DIFICULTAD");
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setBounds(122, 26, 93, 15);
	        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 11));
	        panel.add(lblNewLabel);
	        panel.add(dificultad);
	        panel.add(idioma);
	        panel.add(btnIniciar);

	        getContentPane().add(panel);
	        
	        JLabel lblNewLabel_1 = new JLabel("IDIOMA");
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 11));
	        lblNewLabel_1.setBounds(280, 26, 92, 14);
	        panel.add(lblNewLabel_1);
	    }

	    private void iniciarJuego(String nivel, String idioma) {
	    	MainForm window = new MainForm(nivel,idioma);
			window.hacerVisible();
			
	       
	        dispose();
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
	    }
	}


