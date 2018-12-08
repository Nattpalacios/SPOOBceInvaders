package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;

public class Instrucciones extends JDialog{
	
	private Container contentPane;
	private MenuPrincipal menuP;
	private Dimension pantalla;
	private JPanel botones;
	private JButton volver;
	private Color colorFuente = Color.BLACK;
	private Color colorBoton = new Color(232, 232, 232);
	private URL fondoo = this.getClass().getResource("Instrucciones.png");
	private Image fondo = new ImageIcon(fondoo).getImage();
	
	/**
	 * Inicia la ventana del menu inicial.
	 * @param gui. Tablero de juego.
	 */
	public Instrucciones(MenuPrincipal menu) {
		menuP = menu;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		prepareElementos();
		prepareAcciones();
		
	}

	/**
	 * Prepara los elementos necesarios para mostrar el menu.
	 */
	private void prepareElementos() {
		setTitle("Instrucciones");
		setVisible(true);
		contentPane.setLayout(new BorderLayout());
		prepareElementosMenu();
	}
	
	
	/**
	 * Prepara y ajusta los botones a mostrar en el menu principal.
	 */
	private void prepareElementosMenu() {
		botones = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		botones.setLayout(null);
		volver = new JButton("Menu Principal");
		tamanoMenu();
		tamanoBotones();
		centre();
		diseno();
		contentPane.add(botones);
		botones.add(volver);
	}
	
	/**
	 * Ubica la ventana en el centro de la pantalla.
	 */
	private void centre() {
		int esquinaX = (pantalla.width - getSize().width)/2;
		int esquinaY = (pantalla.height - getSize().height)/2;
		this.setLocation(esquinaX,esquinaY);
	}

	/**
	 * Ajusta el tamano y la ubicacion de los botones del menu.
	 */
	private void tamanoBotones() {
		int y = this.getHeight();
		int x = this.getWidth();
		int j = (y - (y/70)) / 17;
		volver.setSize(x / 5 , y / 11);
		volver.setLocation((x - 1100)/2, j);
	}

	/**
	 * Ajusta el tamano de la ventana del menu principal.
	 */
	private void tamanoMenu() {
		int y = pantalla.height;
		int x = pantalla.width;
		setSize(x * 61/100, y * 41/50);
		
	}
	
	/**
	 * Arregla los botones del menu.
	 */
	private void diseno() {
		bordes();
		colorcitoBoton();
		fuente();
	}
	
	/**
	 * Ajusta la animaciones de los botones del menu.
	 */
	private void bordes() {
		volver.setBorder(null);
		volver.setFocusable(false);
	}
	
	/**
	 * Asigna el color a los botones del menu
	 */
	private void colorcitoBoton() {
		volver.setBackground(colorBoton);
	}
	
	/**
	 * Asigna el tipo de letra de los textos del menu.
	 */
	private void fuente() {
		int y = pantalla.height;
		Font fuente = new Font("Gill Sans Ultra Bold",0,y / 45);
		volver.setForeground(colorFuente); 	
		volver.setFont(fuente);
	}
	
	/**
	 * Asigna las funcionalidades a los botones del menu.
	 */
	private void prepareAcciones() {
		WindowAdapter cerrarVentana = new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				salir();
			}
		};
		
		ActionListener botonVolver = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				volver();
			}
		};
		
		
		
		addWindowListener(cerrarVentana);
		volver.addActionListener(botonVolver);
	}
	
	private void volver() {
		menuP.setVisible(true);
		this.setVisible(false);
	}
	
	/**
	 * Cierra el juego en caso de que el usuario lo indique.
	 */
	private void salir() {
		int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION) {
			menuP.setVisible(true);
			this.setVisible(false);
		}else {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}

}
