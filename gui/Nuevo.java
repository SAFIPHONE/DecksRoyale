package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Carta;
import funcionalidad.Mazo;
import funcionalidad.MazoCompletoException;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.util.concurrent.ForkJoinWorkerThread;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Nuevo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Object> comboCartas;
	private Mazo mazoNuevo;
	private JComboBox comboMazo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Nuevo dialog = new Nuevo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Contructor de la clase
	 */
	public Nuevo() {
		setResizable(false);
		setModal(true);
		setTitle("Crear nuevo mazo");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboCartas = new JComboBox<Object>();
		comboCartas.setBounds(79, 43, 221, 24);
		contentPanel.add(comboCartas);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirCarta();
			}
		});
		btnAadir.setBounds(312, 43, 107, 25);
		contentPanel.add(btnAadir);
		
		JLabel lblCarta = new JLabel("Carta :");
		lblCarta.setBounds(26, 46, 59, 19);
		contentPanel.add(lblCarta);
		
		JLabel lblMazo = new JLabel("Mazo : ");
		lblMazo.setBounds(26, 153, 66, 15);
		contentPanel.add(lblMazo);
		
		comboMazo = new JComboBox();
		comboMazo.setBounds(79, 148, 221, 24);
		contentPanel.add(comboMazo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		todasCarta();
	}

	/**
	 * Añade la carta seleccionada del comboBox al mazo
	 */
	private void annadirCarta() {
		comboCartas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Carta carta = (Carta)comboCartas.getSelectedItem();
				try {
					mazoNuevo.annadir(carta);
					JOptionPane.showMessageDialog(null, "Carta añadida correctamente");
				} catch (MazoCompletoException e) {
					JOptionPane.showMessageDialog(null, "La baraja ya dispone de 8 cartas");
				}
				
			}
		});
	}
	
	/**
	 * Carga todas las cartas en el comboBox
	 */
	void todasCarta(){
			for (Carta carta :Carta.values()) {
				comboCartas.addItem(carta);
			}
	}
	
	/**
	 * Carga las cartas elegidas para crear el mazo en el comboBox
	 */
	void cartasMazo(){
		for (Carta carta : mazoNuevo) {
			comboMazo.addItem(item);
		}
	}
}
