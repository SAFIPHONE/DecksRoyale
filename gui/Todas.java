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
import javax.swing.ImageIcon;
import java.awt.Color;

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
		setResizable(false);
		setModal(true);
		setTitle("Cartas del juego");
		setBounds(100, 100, 550, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(132, 293, 114, 25);
		contentPanel.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(304, 293, 114, 25);
		contentPanel.add(btnVolver);
		
		comboBoxComunes = new JComboBox <Carta> ();
		comboBoxComunes.setBounds(212, 52, 226, 26);
		contentPanel.add(comboBoxComunes);
		
		JLabel lblComunes = new JLabel("Comunes");
		lblComunes.setForeground(Color.WHITE);
		lblComunes.setBounds(125, 57, 95, 17);
		contentPanel.add(lblComunes);
		
		JLabel lblEspeciales = new JLabel("Especiales");
		lblEspeciales.setForeground(Color.WHITE);
		lblEspeciales.setBounds(125, 106, 106, 17);
		contentPanel.add(lblEspeciales);
		
		comboBoxEspeciales = new JComboBox <Carta>();
		comboBoxEspeciales.setBounds(212, 101, 226, 26);
		contentPanel.add(comboBoxEspeciales);
		
		JLabel lblEpicas = new JLabel("Epicas");
		lblEpicas.setForeground(Color.WHITE);
		lblEpicas.setBounds(125, 158, 95, 17);
		contentPanel.add(lblEpicas);
		
		comboBoxEpicas = new JComboBox <Carta> ();
		comboBoxEpicas.setBounds(212, 153, 226, 26);
		contentPanel.add(comboBoxEpicas);
		
		JLabel lblLegendarias = new JLabel("Legendarias");
		lblLegendarias.setForeground(Color.WHITE);
		lblLegendarias.setBounds(125, 210, 95, 17);
		contentPanel.add(lblLegendarias);
		
		comboBoxLegendarias = new JComboBox <Carta> ();
		comboBoxLegendarias.setBounds(212, 205, 226, 26);
		contentPanel.add(comboBoxLegendarias);
		
		JLabel lblTotalDeCartas = new JLabel("Total de cartas del juego: " + contarCartasJuego());
		lblTotalDeCartas.setForeground(Color.WHITE);
		lblTotalDeCartas.setBounds(193, 256, 192, 17);
		contentPanel.add(lblTotalDeCartas);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Todas.class.getResource("/imagenes/todas.jpg")));
		fondo.setBounds(0, 0, 550, 362);
		contentPanel.add(fondo);
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
