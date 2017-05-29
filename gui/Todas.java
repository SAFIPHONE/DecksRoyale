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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox <Carta> comboBoxLegendarias;
	private JComboBox <Carta> comboBoxEpicas;
	private JComboBox <Carta> comboBoxEspeciales;
	private JComboBox <Carta> comboBoxComunes;

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
		setTitle("Cartas del juego");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(98, 225, 114, 25);
		contentPanel.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(245, 225, 114, 25);
		contentPanel.add(btnVolver);
		
		comboBoxComunes = new JComboBox <Carta> ();
		comboBoxComunes.setBounds(224, 33, 168, 26);
		contentPanel.add(comboBoxComunes);
		
		JLabel lblComunes = new JLabel("Comunes");
		lblComunes.setBounds(34, 38, 95, 17);
		contentPanel.add(lblComunes);
		
		JLabel lblEspeciales = new JLabel("Especiales");
		lblEspeciales.setBounds(34, 77, 106, 17);
		contentPanel.add(lblEspeciales);
		
		comboBoxEspeciales = new JComboBox <Carta>();
		comboBoxEspeciales.setBounds(224, 72, 168, 26);
		contentPanel.add(comboBoxEspeciales);
		
		JLabel lblEpicas = new JLabel("Epicas");
		lblEpicas.setBounds(34, 115, 95, 17);
		contentPanel.add(lblEpicas);
		
		comboBoxEpicas = new JComboBox <Carta> ();
		comboBoxEpicas.setBounds(224, 110, 168, 26);
		contentPanel.add(comboBoxEpicas);
		
		JLabel lblLegendarias = new JLabel("Legendarias");
		lblLegendarias.setBounds(34, 153, 95, 17);
		contentPanel.add(lblLegendarias);
		
		comboBoxLegendarias = new JComboBox <Carta> ();
		comboBoxLegendarias.setBounds(224, 148, 168, 26);
		contentPanel.add(comboBoxLegendarias);
		
		JLabel lblTotalDeCartas = new JLabel("Total de cartas del juego: " + contarCartasJuego());
		lblTotalDeCartas.setBounds(129, 196, 192, 17);
		contentPanel.add(lblTotalDeCartas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		obtenerCalidad();
	}

	void obtenerCalidad(){
	
		for (Carta carta: Carta.values()) {
			if(carta.getCalidad()==Calidad.COMUN)
				comboBoxComunes.addItem(carta);
			else if (carta.getCalidad()==Calidad.ESPECIAL)
				comboBoxEspeciales.addItem(carta);
			else if (carta.getCalidad()==Calidad.EPICA)
				comboBoxEpicas.addItem(carta);
			else
				comboBoxLegendarias.addItem(carta);
		}
	}
	
	int contarCartasJuego(){
		int contador = 0;
		for (Carta carta: Carta.values()) {
			contador++;
		}
		return contador;
		
	}
}
