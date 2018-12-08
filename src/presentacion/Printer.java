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
		//System.out.println("entrooooo");
		for(int i = 0; i < barreras.size(); i++) {
			BarreraGUI b = barreras.get(i);
			
		}
		//ImageIcon imgBarrera = new ImageIcon(new ImageIcon(getClass().getResource("Especial.png")).getImage());
		//g.drawImage(imgBarrera.getImage(), 100, 300, 10, 30, null);
		//ImageIcon imgInvasor = new ImageIcon(new ImageIcon(getClass().getResource("ImagenesCalamar/Calamar1.png")).getImage());
		//g.drawImage(imgInvasor.getImage(), 500, 300, 70, 30, null);
		g.setColor(Color.black);
		g.setFont(new Font("Gill Sans Ultra Bold",0, 30));
		g.drawString("Score", 30, 50);
		g.drawString("Lives", 500, 50);
	}

	public void agregarCanones(ArrayList<CanonGUI> canones) {
		this.canones = canones;
		
	}
	
	/**@Override
	public void paint(Graphics g) {
		for(int i = 0; i < canones.size();i++) {
			g.fillRect(1000, 1000, 500, 500);
		}
		g.setColor(Color.BLUE);
		g.drawRect(50, 80, 150, 100);
		g.setColor(Color.MAGENTA);
		g.fillRect(230, 80, 150, 100);
	}*/
	
}
