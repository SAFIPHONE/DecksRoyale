package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Calidad;
import funcionalidad.Carta;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Todas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboTodas;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnComunes;
	private JRadioButton rdbtnEspeciales;
	private JRadioButton rdbtnEpicas;
	private JRadioButton rdbtnLegendarias;

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
		comboTodas.setBounds(97, 65, 240, 24);
		contentPanel.add(comboTodas);
		
		JLabel lblCartasActualesDel = new JLabel("Cartas actuales del juego");
		lblCartasActualesDel.setBounds(112, 23, 199, 30);
		contentPanel.add(lblCartasActualesDel);
		
		rdbtnComunes = new JRadioButton("Comunes");
		buttonGroup.add(rdbtnComunes);
		rdbtnComunes.setBounds(27, 176, 101, 23);
		contentPanel.add(rdbtnComunes);
		
		rdbtnEspeciales = new JRadioButton("Especiales");
		buttonGroup.add(rdbtnEspeciales);
		rdbtnEspeciales.setBounds(131, 176, 109, 23);
		contentPanel.add(rdbtnEspeciales);
		
		rdbtnEpicas = new JRadioButton("Epicas");
		buttonGroup.add(rdbtnEpicas);
		rdbtnEpicas.setBounds(239, 176, 83, 23);
		contentPanel.add(rdbtnEpicas);
		
		rdbtnLegendarias = new JRadioButton("Legendarias");
		buttonGroup.add(rdbtnLegendarias);
		rdbtnLegendarias.setBounds(321, 176, 119, 23);
		contentPanel.add(rdbtnLegendarias);
		
		JLabel lblFiltrarPorCalidad = new JLabel("Filtrar por calidad :");
		lblFiltrarPorCalidad.setBounds(138, 124, 173, 24);
		contentPanel.add(lblFiltrarPorCalidad);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(123, 228, 114, 25);
		contentPanel.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(249, 228, 114, 25);
		contentPanel.add(btnVolver);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	
//	Calidad obtenerCalidad(){
//		if(rdbtnComunes.isSelected())
//			return Calidad.COMUN;
//		else if(rdbtnEspeciales.isSelected())
//			return Calidad.ESPECIAL;
//		else if(rdbtnEpicas.isSelected())
//			return Calidad.EPICA;
//		else if(rdbtnLegendarias.isSelected())
//			return Calidad.LEGENDARIA;
//		else
//			
//	}
}
