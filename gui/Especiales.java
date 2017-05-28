package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Calidad;
import funcionalidad.Carta;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Especiales extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboBoxEspeciales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Especiales dialog = new Especiales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Especiales() {
		setModal(true);
		setResizable(false);
		setTitle("Cartas Especiales");
		setBounds(100, 100, 450, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			comboBoxEspeciales = new JComboBox <Carta>();
			comboBoxEspeciales.setBounds(122, 69, 195, 26);
			contentPanel.add(comboBoxEspeciales);
		}
		{
			JLabel lblCartasEspeciales = new JLabel("Cartas Especiales");
			lblCartasEspeciales.setBounds(168, 38, 114, 17);
			contentPanel.add(lblCartasEspeciales);
		}
		{
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(168, 130, 105, 27);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		obtenerEspeciales();
	}
	
	/**
	 * Obtiene las cartas especiales del total de cartas
	 */
	void obtenerEspeciales(){
		for (Carta carta : Carta.values()) {
			if(carta.getCalidad()==Calidad.ESPECIAL)
				comboBoxEspeciales.addItem(carta);
		}
	}

}
