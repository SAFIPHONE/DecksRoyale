package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Carta;
import funcionalidad.Gestionar;
import funcionalidad.Mazo;

import javax.swing.JComboBox;

public class CargarMazo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboBox;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			comboBox = new JComboBox <Carta>();
			comboBox.setBounds(127, 88, 186, 26);
			contentPanel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargar();
	}
	
	void cargar(){
//		if(jfilechooser.showOpenDialog(this)!= JFileChooser.APPROVE_OPTION){
//			return;
//		}

		File fichero = Gestionar.getFichero();
			try {
				Mazo mazoCargado = Gestionar.abrir(fichero);
				
				for (Carta carta : mazoCargado) {
					comboBox.addItem(carta);
				}
				
			} catch (ClassNotFoundException | IOException e) {

				JOptionPane.showMessageDialog(null, "Error al cargar el mazo");
			}
	}

}
