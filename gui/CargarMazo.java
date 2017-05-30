package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Carta;
import funcionalidad.ErrorLecturaException;
import funcionalidad.Gestionar;
import funcionalidad.Mazo;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CargarMazo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboBoxMazo;
	private JFileChooser jfilechooser= new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CargarMazo dialog = new CargarMazo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CargarMazo() {
		setTitle("Mazo");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			comboBoxMazo = new JComboBox <Carta>();
			comboBoxMazo.setBounds(140, 133, 186, 26);
			contentPanel.add(comboBoxMazo);
		}
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(171, 171, 120, 27);
		contentPanel.add(btnAceptar);
		
		JLabel lblMazo = new JLabel("Mazo :");
		lblMazo.setForeground(Color.WHITE);
		lblMazo.setBounds(210, 116, 60, 17);
		contentPanel.add(lblMazo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CargarMazo.class.getResource("/imagenes/cargaMazo.jpg")));
		lblNewLabel.setBounds(0, 0, 450, 272);
		contentPanel.add(lblNewLabel);
		cargar();
	}
	
	void cargar(){
		if(jfilechooser.showOpenDialog(null)!= JFileChooser.APPROVE_OPTION){
			return;
		}

		
			try {
				File fichero = jfilechooser.getSelectedFile();
				
				Mazo mazo = Gestionar.abrir(fichero);
		
		
				for (Carta carta :mazo ) {
					comboBoxMazo.addItem(carta);
				}
				
			} catch (ErrorLecturaException | IOException |ClassNotFoundException  e) {

				JOptionPane.showMessageDialog(null, "Error al cargar el mazo");
			}
	}
}
