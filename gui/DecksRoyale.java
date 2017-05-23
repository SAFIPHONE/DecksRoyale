package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DecksRoyale extends JFrame {

	private JPanel contentPane;

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
		menuBar.add(mnNuevo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nuevo nuevo = new Nuevo();
				nuevo.setVisible(true);
			}
		});
		mnNuevo.add(mntmNuevo);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mnNuevo.add(mntmCargar);
		
		JSeparator separator = new JSeparator();
		mnNuevo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnNuevo.add(mntmSalir);
		
		JMenu mnCartas = new JMenu("Cartas");
		menuBar.add(mnCartas);
		
		JMenuItem mntmTodas = new JMenuItem("Todas");
		mnCartas.add(mntmTodas);
		
		JSeparator separator_1 = new JSeparator();
		mnCartas.add(separator_1);
		
		JMenuItem mntmComunes = new JMenuItem("Comunes");
		mnCartas.add(mntmComunes);
		
		JMenuItem mntmEspeciales = new JMenuItem("Especiales");
		mnCartas.add(mntmEspeciales);
		
		JMenuItem mntmEpicas = new JMenuItem("Epicas");
		mnCartas.add(mntmEpicas);
		
		JMenuItem mntmLegendarias = new JMenuItem("Legendarias");
		mnCartas.add(mntmLegendarias);
		
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
	}
}
