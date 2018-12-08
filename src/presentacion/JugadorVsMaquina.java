package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;

public class JugadorVsMaquina extends JDialog{
	
	private Container contentPane;
	private Multijugador juego;
	private Dimension pantalla;
	private JPanel botones;
	private JButton cuidadoso;
	private JButton ofensivo;
	private JButton nervioso;
	private JButton volver;
	private Cuidadoso opcionCuidadoso;
	private Ofensivo opcionOfensivo;
	private Nervioso opcionNervioso;
	private Color colorFuente = Color.BLACK;
	private Color colorBoton = new Color(232, 232, 232);
	private URL fondoo = this.getClass().getResource("MenuJugar.png");
	private Image fondo = new ImageIcon(fondoo).getImage();
	
	/**
	 * Inicia la ventana del menu inicial.
	 * @param gui. Tablero de juego.
	 */
	public JugadorVsMaquina(Multijugador multi) {
		juego = multi;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		prepareElementos();
		prepareAcciones();
		
	}

	/**
	 * Prepara los elementos necesarios para mostrar el menu.
	 */
	private void prepareElementos() {
		setTitle("Tipo Maquina");
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
		cuidadoso = new JButton("Cuidadoso");
		ofensivo = new JButton("Ofensivo");
		nervioso = new JButton("Nervioso");
		volver = new JButton("Regresar");
		tamanoMenu();
		tamanoBotones();
		centre();
		diseno();
		contentPane.add(botones);
		botones.add(cuidadoso);
		botones.add(ofensivo);
		botones.add(nervioso);
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
		int j = (y - (y/70)) / 3;
		int i = j + y/9 + y/17;
		int h = i + y/9 + y/17;
		int k = (y - (y/70)) / 17;
		cuidadoso.setSize(x / 4 + 10 , y / 11);
		ofensivo.setSize(x / 4 + 10, y / 11);
		nervioso.setSize(x / 4 + 10, y / 11);
		volver.setSize(x / 6 , y / 11);
		cuidadoso.setLocation((x - (x / 4 + 50))/2, j - 70);
		ofensivo.setLocation((x - (x / 4 + 50))/2,i - 70);
		nervioso.setLocation((x - (x / 4 + 50))/2, h - 70);
		volver.setLocation((x - 1100)/2, k);
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
		cuidadoso.setBorder(null);
		ofensivo.setBorder(null);
		nervioso.setBorder(null);
		volver.setBorder(null);
		cuidadoso.setFocusable(false);
		ofensivo.setFocusable(false);
		nervioso.setFocusable(false);
		volver.setFocusable(false);
	}
	
	/**
	 * Asigna el color a los botones del menu
	 */
	private void colorcitoBoton() {
		cuidadoso.setBackground(colorBoton);
		ofensivo.setBackground(colorBoton);
		nervioso.setBackground(colorBoton);
		volver.setBackground(colorBoton);
	}
	
	/**
	 * Asigna el tipo de letra de los textos del menu.
	 */
	private void fuente() {
		int y = pantalla.height;
		Font fuente = new Font("Gill Sans Ultra Bold",0,y / 23);
		Font fuenteVolver = new Font("Gill Sans Ultra Bold",0,y / 35);
		cuidadoso.setForeground(colorFuente); 
		ofensivo.setForeground(colorFuente);
		nervioso.setForeground(colorFuente);
		volver.setForeground(colorFuente);
		cuidadoso.setFont(fuente); 
		ofensivo.setFont(fuente);
		nervioso.setFont(fuente); 
		volver.setFont(fuenteVolver); 
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
		
		ActionListener botonCuidadoso = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				cuidadoso();
			}
		};
		
		ActionListener botonOfensivo = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				ofensivo();
			}
		};
		
		ActionListener botonNervioso = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				nervioso();
			}
		};
		
		ActionListener botonVolver = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				volver();
			}
		};
		
		addWindowListener(cerrarVentana);
		cuidadoso.addActionListener(botonCuidadoso);
		ofensivo.addActionListener(botonOfensivo);
		nervioso.addActionListener(botonNervioso);
		volver.addActionListener(botonVolver);
	}
	
	/**
	 * Abre una ventana con las instrucciones
	 */
	private void cuidadoso() {
		opcionCuidadoso = new Cuidadoso(this);
		this.setVisible(false);
	}
	
	/**
	 * Abre una ventanas con otras opciones.
	 */
	private void ofensivo() {
		opcionOfensivo = new Ofensivo(this);
		this.setVisible(false);
	}
	
	private void nervioso() {
		opcionNervioso = new Nervioso(this);
		this.setVisible(false);
	}
	
	private void volver() {
		juego.setVisible(true);
		this.setVisible(false);
	}
	
	/**
	 * Cierra el juego en caso de que el usuario lo indique.
	 */
	private void salir() {
		int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION) {
			juego.setVisible(true);
			this.setVisible(false);
		}else {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}

}
