package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.Carta;
import funcionalidad.Gestionar;
import funcionalidad.Mazo;
import imagenes.PanelImagen;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DecksRoyale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JFileChooser jfilechooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecksRoyale frame = new DecksRoyale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DecksRoyale() {
		setTitle("Decks Clash Royale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Mazo");
		mnNuevo.setMnemonic('M');
		menuBar.add(mnNuevo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setMnemonic('N');
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nuevo nuevo = new Nuevo();
				nuevo.setVisible(true);
			}
		});
		mnNuevo.add(mntmNuevo);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mntmCargar.setMnemonic('C');
		mntmCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CargarMazo carga = new CargarMazo();
				carga.setVisible(true);
			}
		});
		mnNuevo.add(mntmCargar);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setMnemonic('G');
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnNuevo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setMnemonic('C');
		mnNuevo.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnNuevo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setMnemonic('S');
		mnNuevo.add(mntmSalir);
		
		JMenu mnCartas = new JMenu("Cartas");
		mnCartas.setMnemonic('C');
		menuBar.add(mnCartas);
		
		JMenuItem mntmTodas = new JMenuItem("Todas");
		mntmTodas.setMnemonic('T');
		mntmTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Todas todas = new Todas();
				todas.setVisible(true);
			}
		});
		mnCartas.add(mntmTodas);
		
		JSeparator separator_1 = new JSeparator();
		mnCartas.add(separator_1);
		
		JMenu mnCalidad = new JMenu("Calidad");
		mnCartas.add(mnCalidad);
		
		JMenuItem mntmComunes = new JMenuItem("Comunes");
		mnCalidad.add(mntmComunes);
		mntmComunes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comunes comunes = new Comunes();
				comunes.setVisible(true);
			}
		});
		mntmComunes.setMnemonic('C');
		
		JMenuItem mntmEspeciales = new JMenuItem("Especiales");
		mnCalidad.add(mntmEspeciales);
		mntmEspeciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especiales especiales = new Especiales();
				especiales.setVisible(true);
			}
		});
		mntmEspeciales.setMnemonic('E');
		
		JMenuItem mntmEpicas = new JMenuItem("Epicas");
		mnCalidad.add(mntmEpicas);
		mntmEpicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Epicas espicas = new Epicas();
				espicas.setVisible(true);
			}
		});
		mntmEpicas.setMnemonic('P');
		
		JMenuItem mntmLegendarias = new JMenuItem("Legendarias");
		mnCalidad.add(mntmLegendarias);
		mntmLegendarias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Legendarias legendarias = new Legendarias();
				legendarias.setVisible(true);
			}
		});
		mntmLegendarias.setMnemonic('L');
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acerca = new AcercaDe();
				acerca.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevoMazo = new JButton("Nuevo Mazo");
		btnNuevoMazo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevo nuevo = new Nuevo();
				nuevo.setVisible(true);
				
			}
		});
		btnNuevoMazo.setBounds(63, 94, 123, 27);
		contentPane.add(btnNuevoMazo);
		
		JButton btnCargarMazo = new JButton("Cargar Mazo");
		btnCargarMazo.setBounds(247, 94, 128, 27);
		contentPane.add(btnCargarMazo);
		

	}
	
	void guardar(){
//		if(jfilechooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
//			File file = jfilechooser.getSelectedFile();
//			if(!file.exists()){
				try {
					Gestionar.guardar();
					JOptionPane.showMessageDialog(null, "Los cambios se guardaron con exito");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
				}
//			}
//		}
	}
}

