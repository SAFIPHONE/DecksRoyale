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

public class Epicas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboBoxEpicas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Epicas dialog = new Epicas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Epicas() {
		setModal(true);
		setResizable(false);
		setTitle("Cartas Epicas");
		setBounds(100, 100, 450, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			comboBoxEpicas = new JComboBox <Carta> ();
			comboBoxEpicas.setBounds(132, 78, 187, 26);
			contentPanel.add(comboBoxEpicas);
		}
		{
			JLabel lblCartasEpicas = new JLabel("Cartas Epicas");
			lblCartasEpicas.setBounds(181, 43, 120, 17);
			contentPanel.add(lblCartasEpicas);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnVolver.setBounds(172, 126, 105, 27);
			contentPanel.add(btnVolver);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		obtenerEpicas();
	}
	
	/**
	 * Obtiene las cartas epicas del total de cartas
	 */
	void obtenerEpicas(){
		for (Carta carta : Carta.values()) {
			if(carta.getCalidad()==Calidad.EPICA)
				comboBoxEpicas.addItem(carta);
		}
	}

}
