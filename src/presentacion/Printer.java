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
			//544
			g.fillRect(1055, 808, 96, 28);
			g.fillRect(572, 700, 41, 28);
			g.setFont(new Font("Gill Sans Ultra Bold",0, 30));
			g.drawString("Score", 30, 50);
			g.drawString(Integer.toString(c.getPuntaje()), 150, 50);
		}
		
		
		g.drawString("Lives", 500, 50);
	}

	public void agregarCanones(ArrayList<CanonGUI> canones) {
		this.canones = canones;
		
	}
	
}
