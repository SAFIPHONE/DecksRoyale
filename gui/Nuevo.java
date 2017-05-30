package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Carta;
import funcionalidad.CartaYaExisteException;
import funcionalidad.ErrorEscrituraException;
import funcionalidad.Gestionar;
import funcionalidad.Mazo;
import funcionalidad.MazoCompletoException;
import funcionalidad.MazoVacioException;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Nuevo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox <Carta> comboCartas;
	private JComboBox <Carta> comboMazo;
	private JFileChooser jfilechooser = new JFileChooser();
	private Mazo mazo = new Mazo();
	private JLabel lblCartas;
	private int contador;
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
		setBounds(100, 100, 479, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboCartas = new JComboBox<Carta>();
		comboCartas.setBounds(143, 84, 185, 24);
		contentPanel.add(comboCartas);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirCarta();
			}
		});
		btnAadir.setBounds(340, 84, 107, 25);
		contentPanel.add(btnAadir);
		
		JLabel lblCarta = new JLabel("<html><b>Carta :</b></html>");
		lblCarta.setForeground(Color.WHITE);
		lblCarta.setBounds(204, 53, 59, 19);
		contentPanel.add(lblCarta);
		
		JLabel lblMazo = new JLabel("<html><b>Mazo :</b></html> ");
		lblMazo.setForeground(Color.WHITE);
		lblMazo.setBounds(204, 120, 66, 15);
		contentPanel.add(lblMazo);
		
		comboMazo = new JComboBox<Carta>();
		comboMazo.setBounds(143, 146, 185, 24);
		contentPanel.add(comboMazo);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					eliminarCarta();
			}
		});
		btnNewButton.setBounds(340, 146, 107, 25);
		contentPanel.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(244, 229, 114, 25);
		contentPanel.add(btnVolver);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				guardarMazo();
			}
		});
		btnNewButton_1.setBounds(118, 229, 114, 25);
		contentPanel.add(btnNewButton_1);
		lblCartas = new JLabel();
		lblCartas.setForeground(Color.WHITE);
		lblCartas.setBounds(12, 131, 114, 74);
		contentPanel.add(lblCartas);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Nuevo.class.getResource("/imagenes/royale.png")));
		fondo.setBounds(0, 0, 479, 304);
		contentPanel.add(fondo);
		todasCarta();//carga todas las cartas del juego en comboBox
	}

	/**
	 * Añade la carta seleccionada del comboBox al mazo
	 */
	private void annadirCarta() {

				Carta carta = (Carta)comboCartas.getSelectedItem();
				try { 
					mazo.annadir(carta);
					comboMazo.addItem(carta);
					lblCartas.setText("<html><b>Tu mazo <br></br> contiene " + comprobarCartasMazo() + " <br></br> carta.</b><html>");
					JOptionPane.showMessageDialog(null, "Carta añadida correctamente","Añadir carta",JOptionPane.INFORMATION_MESSAGE);
				} catch (MazoCompletoException | CartaYaExisteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Añadir carta",JOptionPane.ERROR_MESSAGE);
				}
				
	}
	
	private void eliminarCarta(){
		try {

			Carta carta = (Carta)comboMazo.getSelectedItem();
			mazo.remove(carta);
			comboMazo.removeItem(carta);
			JOptionPane.showMessageDialog(null, "Carta eliminada correctamente","Eliminar carta",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (MazoVacioException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar carta, el mazo esta vacío", "Eliminar carta", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Carga todas las cartas en el comboBox
	 */
	void todasCarta(){
			for (Carta carta :Carta.values()) {
				comboCartas.addItem(carta);
			}
			
	}
	
	void guardarMazo(){
		if(comprobarCartasMazo() < 8){
			try {
				throw new MazoNoCompletoException("El mazo no contiene las 8 cartas necearias");
			} catch (MazoNoCompletoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"Mazo no completo",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		if(jfilechooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION){
			return;
		}

		
			try {
				File archivo = jfilechooser.getSelectedFile();
				Gestionar.guardar(archivo, mazo);
			} catch (ErrorEscrituraException  e) {
				JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
			}
		
	}
	int comprobarCartasMazo(){
		if(comboMazo.getItemCount() >= 1){
			contador=comboMazo.getItemCount();
			return contador;
		}
		return contador;
		
	}
}
