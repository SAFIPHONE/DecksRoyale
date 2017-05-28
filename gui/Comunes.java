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
import java.awt.Color;

public class Comunes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboBoxComunes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Comunes dialog = new Comunes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Comunes() {
		setModal(true);
		setResizable(false);
		setForeground(Color.BLUE);
		setTitle("Cartas Comunes");
		setBounds(100, 100, 450, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBoxComunes = new JComboBox <Carta>();
		comboBoxComunes.setBounds(132, 66, 199, 26);
		contentPanel.add(comboBoxComunes);
		{
			JLabel lblCartasComunes = new JLabel("Cartas Comunes");
			lblCartasComunes.setBounds(179, 36, 122, 17);
			contentPanel.add(lblCartasComunes);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnVolver.setBounds(179, 119, 105, 27);
			contentPanel.add(btnVolver);
		}
		obtenerComunes();
	}
	
	/**
	 * Obtiene las cartas comunes del total de cartas
	 */
	void obtenerComunes(){
		for (Carta carta: Carta.values()) {
			if(carta.getCalidad()==Calidad.COMUN){
				comboBoxComunes.addItem(carta);
			}
			
		}
	}
}
