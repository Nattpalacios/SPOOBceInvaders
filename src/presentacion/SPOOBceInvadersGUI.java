package presentacion;

import aplicacion.SPOOBceInvaders;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import javax.swing.event.*;

/**
 * @version (29/11/2018)
 * @author (Natalia Palacios)
 */

public class SPOOBceInvadersGUI extends JFrame{
	
	private Container contentPane;
	private MenuPrincipal menu;
	private SPOOBceInvaders juego;
	private JPanel tablero;
	private Dimension pantalla;
	private URL fondoo = this.getClass().getResource("Tablero.jpg");
	private Image fondo = new ImageIcon(fondoo).getImage();
	private Printer dibujante;
	private Timer tiempoJuego;
	
	/**
	 * Constructor
	 */
	private SPOOBceInvadersGUI(){
		juego = new SPOOBceInvaders();
		prepareElementos();		
	}
	
	/**
	 * Activa el modo Un Jugador
	 */
	public void empieceUnJugador() {
		setTitle("Un Jugador");
		prepareTablero();
		prepareAcciones();
		prepareAccionesUnJugador();
		juego.iniciarJuego('u');
		this.setVisible(true);
		tablero.setVisible(true);
		iniciarJuego();
	}
	
	private void prepareTablero() {
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		tablero = new JPanel();
		int y = pantalla.height;
		int x = pantalla.width;
		this.setSize(x * 61/100, y * 41/50);
		centreTablero();
		dibujante = new Printer(tablero);
		dibujante.setVisible(true);
		tablero.add(dibujante);
		this.add(tablero);
	}

	private void iniciarJuego() {
		tiempoJuego = new Timer();
		TimerTask task = new TimerTask() {
			
			public void run() {
				char[][] tablero = juego.actualice();
				for(int i = 0; i < tablero.length; i++) {
					System.out.println(tablero[i]);
				}
				muestreTablero();
			}
		};		
		tiempoJuego.schedule(task,1,200);
		
	}

	private void muestreTablero() {
		ArrayList<CanonGUI> canones = new ArrayList<CanonGUI>();
		ArrayList<BarreraGUI> barreras = new ArrayList<BarreraGUI>();
		ArrayList<ExtraterrestreGUI> invasores = new ArrayList<ExtraterrestreGUI>();
		ArrayList<BalaGUI> balas = new ArrayList<BalaGUI>();
		ArrayList<Integer> tamanos = juego.getTamanos();
		//construir canones
		for(int i=0;i<tamanos.get(0);i++) {
			int[]  pos = juego.getPosicionesCanon(i);
			Color col = juego.getColorCanon(i);
			int vid = juego.getVidaCanon(i);
			int pun = juego.getPuntajeCanon(i);
			CanonGUI c = new CanonGUI(pos,col,vid,pun);
		}
		dibujante.paint(tablero.getGraphics());
	}

	/**
	 * Activa el modo Multijugador de jugador vs jugador
	 */
	public void empieceMultijugadorJJ() {
		this.setTitle("Jugador VS Jugador");
		prepareTablero();
		prepareAcciones();
		prepareAccionesMultiJJ();
		juego.iniciarJuego('m');
		this.setVisible(true);
		tablero.setVisible(true);
		iniciarJuego();
	}
	
	/**
	 * Activa el modo Multijugador de jugador vs maquina
	 */
	public void empieceMultijugadorJM() {
		tablero = new JPanel();
		prepareAcciones();
		prepareAccionesUnJugador();
		juego.iniciarJuego('m');
		tablero.setVisible(true);
		iniciarJuego();
	}
	
	/**
	 * Prepara los elementos que se van a mostrar
	 */
	private void prepareElementos(){	
		contentPane = getContentPane();
		setTitle("sPOOBceInvaders");
		setResizable(false);
		menu = new MenuPrincipal(this);
	}
	
	 /**
	  * Prepara los listeners necesarios para el funcionamiento
	  */
	public void prepareAcciones(){
		WindowAdapter cerrarVentana = new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				salir();
			}
		};
		
		this.addWindowListener(cerrarVentana);
		
	}
	
	/**
	 * Prepara los listeners necesarios para el modo Un Jugador
	 */
	public void prepareAccionesUnJugador() {
		
		KeyListener mover = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					disparar(1);
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					moverIzquierda(1);
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moverDerecha(1);
				}
			}
		};
		
		this.addKeyListener(mover);
		
	}
	
	/**
	 * Da la  orden de disparar
	 * @param jugador, indica el jugador que ha disparado
	 */
	protected void disparar(int jugador) {
		juego.dispare(jugador);
	}

	/**
	 * Da la  orden de moverse a la derecha
	 * @param jugador, indica el jugador que se va a mover a la derecha
	 */
	protected void moverDerecha(int jugador) {
		juego.derecha(jugador);
	}

	/**
	 * Da la  orden de moverse a la izquierda
	 * @param jugador, indica el jugador que se va a mover a la izquierda
	 */
	protected void moverIzquierda(int jugador) {
		juego.izquierda(jugador);
	}
	
	/**
	 * Prepara los listeners del modo Multijugador
	 */
	public void prepareAccionesMultiJJ() {
		KeyListener moverJ1 = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					disparar(1);
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					moverIzquierda(1);
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moverDerecha(1);
				}
			}
		};
		
		KeyListener moverJ2 = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W) {
					disparar(2);
				}else if(e.getKeyCode() == KeyEvent.VK_A) {
					moverIzquierda(2);
				}else if(e.getKeyCode() == KeyEvent.VK_D) {
					moverDerecha(2);
				}
			}
		};
		
		this.addKeyListener(moverJ1);
		this.addKeyListener(moverJ2);
	}	
	
	/**
	 * Da la orden de que se cierre una ventana
	 */
	private void salir() {
		int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION) {
			tiempoJuego.cancel();
			this.setVisible(false);
			menu.setVisible(true);
			
			
			
		}else {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	
	/**
	 * Ubica la ventana en el centro de la pantalla.
	 */
	private void centreTablero() {
		int esquinaX = (pantalla.width - this.getSize().width)/2;
		int esquinaY = (pantalla.height - this.getSize().height)/2;
		this.setLocation(esquinaX,esquinaY);
	}
	
	/**
	 * Metodo principal de la clase SPOOBceInvadersGUI
	 * @param args
	 */
	public static void main(String[] args){
		SPOOBceInvadersGUI invaders = new SPOOBceInvadersGUI();
		/**Timer time = new Timer();
		TimerTask task = new TimerTask() {
			
			public void run() {
				System.out.println("bada presente");
				
			}
		};		
		time.schedule(task,1,1000);*/
		
	}
	
}



