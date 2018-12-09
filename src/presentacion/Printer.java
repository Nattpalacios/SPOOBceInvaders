package presentacion;

import java.awt.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;

public class Printer extends Component{
	private ArrayList<BarreraGUI> barreras;
	private ArrayList<ExtraterrestreGUI> invasores;
	private ArrayList<CanonGUI> canones;
	private ArrayList<BalaGUI> balas;
	private URL fondoo = this.getClass().getResource("Tablero.jpg");
	private Image fondo = new ImageIcon(fondoo).getImage();
	private JPanel tablero;
	
	/**
	 * 
	 */
	public Printer(JPanel tablero) {
		this.tablero = tablero;
		barreras = new ArrayList<BarreraGUI>();
		invasores = new ArrayList<ExtraterrestreGUI>();
		canones = new ArrayList<CanonGUI>();
		balas = new ArrayList<BalaGUI>();
	}
	
	/**
	 * Hace visibles los elementos en el tablero
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(),tablero);
		for(int i = 0; i < canones.size();i++) {
			CanonGUI c = canones.get(i);
			g.setColor(c.getColor());
			g.fillRect(c.getPosXBase(), c.getPosYBase(), c.getwBase(), c.gethBase());
			g.fillRect(c.getPosXCanon(), c.getPosYCanon(), c.getwCanon(), c.gethCanon());
			g.setFont(new Font("Gill Sans Ultra Bold",0, 30));
			g.drawString("Score",30,30*(1+i));
			g.drawString(Integer.toString(c.getPuntaje()), 150, 30*(1+i));
			g.drawString("Lives", 500, 30*(1+i));
			for(int j = 0; j < c.getVida(); j++) {
				g.fillRect(650 + (50*j), 25+(25*i), 35, 10);
				g.fillRect(660 + (50*j), 17+(25*i) , 15, 8);
			}
		}
		for(int i = 0; i < barreras.size(); i ++) {
			BarreraGUI b = barreras.get(i);
			String barrera = b.getImage();
			ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource(barrera)).getImage());
			ArrayList<Integer[]> pos = b.getPosiciones();
			int tamX = b.getCuadrox();
			int tamY = b.getCuadroy();
			for(int j = 0; j < pos.size(); j++) {
				g.drawImage(image.getImage(), pos.get(j)[0], pos.get(j)[1], tamX, tamY, null);
			}
		}
		for(int i = 0; i < invasores.size(); i++) {
			ExtraterrestreGUI e = invasores.get(i);
			String invasor = e.getImage();
			int[] pos = e.getPosiciones();
			ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource(invasor)).getImage());
			int tamX = e.getTamX();
			int tamY = e.getTamY();
			g.drawImage(image.getImage(), pos[0], pos[1], tamX, tamY, null);
		}
		for(int i = 0; i < balas.size(); i++) {
			BalaGUI  b = balas.get(i);
			String bala = b.getImage();
			int[] pos = b.getPosi();
			ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource(bala)).getImage());
			int tamX = b.getCuadrox();
			int tamY = b.getCuadroy();
			g.drawImage(image.getImage(), pos[0], pos[1], tamX, tamY, null);
		}
	}

	public void agregarCanones(ArrayList<CanonGUI> canones) {
		this.canones = canones;
		
	}

	public void agregarBarreras(ArrayList<BarreraGUI> barreras) {
		this.barreras = barreras;
		
	}

	public void agregarInvasores(ArrayList<ExtraterrestreGUI> invasores) {
		this.invasores = invasores;
		
	}

	public void agregarBalas(ArrayList<BalaGUI> balas) {
		this.balas = balas;
		
	}
	
}
