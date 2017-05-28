package gui;

import java.awt.BorderLayout;

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

public class Legendarias extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboBoxLegendarias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Legendarias dialog = new Legendarias();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Legendarias() {
		setModal(true);
		setResizable(false);
		setTitle("Cartas Legendarias");
		setBounds(100, 100, 450, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			comboBoxLegendarias = new JComboBox <Carta>();
			comboBoxLegendarias.setBounds(120, 72, 212, 26);
			contentPanel.add(comboBoxLegendarias);
		}
		{
			JLabel lblCartasLegendarias = new JLabel("Cartas Legendarias");
			lblCartasLegendarias.setBounds(154, 43, 165, 17);
			contentPanel.add(lblCartasLegendarias);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnVolver.setBounds(179, 121, 105, 27);
			contentPanel.add(btnVolver);
		}
		obtenerLegendarias();
	}
	
	/**
	 * Obtiene las cartas legendarias del total de cartas
	 */
	void obtenerLegendarias(){
		for (Carta carta: Carta.values()) {
			if(carta.getCalidad()==Calidad.LEGENDARIA)
				comboBoxLegendarias.addItem(carta);
		}
	}

}
