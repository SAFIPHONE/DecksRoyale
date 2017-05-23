package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Carta;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Todas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboTodas;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Todas dialog = new Todas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Todas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboTodas = new JComboBox  <Carta>();
		comboTodas.setBounds(103, 82, 240, 24);
		contentPanel.add(comboTodas);
		
		JLabel lblCartasActualesDel = new JLabel("Cartas actuales del juego");
		lblCartasActualesDel.setBounds(123, 40, 199, 30);
		contentPanel.add(lblCartasActualesDel);
		
		JRadioButton rdbtnComunes = new JRadioButton("Comunes");
		buttonGroup.add(rdbtnComunes);
		rdbtnComunes.setBounds(27, 176, 101, 23);
		contentPanel.add(rdbtnComunes);
		
		JRadioButton rdbtnEspeciales = new JRadioButton("Especiales");
		buttonGroup.add(rdbtnEspeciales);
		rdbtnEspeciales.setBounds(131, 176, 109, 23);
		contentPanel.add(rdbtnEspeciales);
		
		JRadioButton rdbtnE = new JRadioButton("Epicas");
		buttonGroup.add(rdbtnE);
		rdbtnE.setBounds(239, 176, 83, 23);
		contentPanel.add(rdbtnE);
		
		JRadioButton rdbtnLegendarias = new JRadioButton("Legendarias");
		buttonGroup.add(rdbtnLegendarias);
		rdbtnLegendarias.setBounds(321, 176, 119, 23);
		contentPanel.add(rdbtnLegendarias);
		
		JLabel lblFiltrarPorCalidad = new JLabel("Filtrar por calidad :");
		lblFiltrarPorCalidad.setBounds(163, 134, 130, 24);
		contentPanel.add(lblFiltrarPorCalidad);
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
		
		todasCarta();
	}
	/**
	 * Carga todas las cartas en el comboBox
	 */
	void todasCarta(){
			for (Carta carta :Carta.values()) {
				comboTodas.addItem(carta);
			}
	}
	
//	void obtenerCalidad(){
//		if()
//		
//	}
}
