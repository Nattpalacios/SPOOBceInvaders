package presentacion;

import java.awt.Color;
import java.awt.Component;

public class CanonGUI extends Component{
	private int posXCanon;
	private int posYCanon;
	private int posXBase;
	private int posYBase;
	private int wBase;
	private int hBase;
	private int wCanon;
	private int hCanon;
	private int vida;
	private int puntaje;
	private Color color;
	private String tipoBala;
	
	
	public CanonGUI(int[] pos,Color col,int vid,int pun) {
		posXCanon = pos[0];
		posXBase= pos[0]-2;
		posYCanon = pos[1];
		posYBase= pos[0]+1;
		wBase = 5;
		wCanon = 3;
		hBase = 1;
		hCanon = 1;
		color = col;
		vida = vid;
		puntaje = pun;
		
	}
	
	

}
