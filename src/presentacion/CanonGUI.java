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
		posXCanon = pos[0]*10;
		posXBase= pos[0]-2;
		posYCanon = pos[1]+100;
		posYBase= pos[0]+1;
		wBase = 5;
		wCanon = 3;
		hBase = 1;
		hCanon = 1;
		color = col;
		vida = vid;
		puntaje = pun;
		
	}


	public int getPosXCanon() {
		return posXCanon;
	}


	public void setPosXCanon(int posXCanon) {
		this.posXCanon = posXCanon;
	}


	public int getPosYCanon() {
		return posYCanon;
	}


	public void setPosYCanon(int posYCanon) {
		this.posYCanon = posYCanon;
	}


	public int getPosXBase() {
		return posXBase;
	}


	public void setPosXBase(int posXBase) {
		this.posXBase = posXBase;
	}


	public int getPosYBase() {
		return posYBase;
	}


	public void setPosYBase(int posYBase) {
		this.posYBase = posYBase;
	}


	public int getwBase() {
		return wBase;
	}


	public void setwBase(int wBase) {
		this.wBase = wBase;
	}


	public int gethBase() {
		return hBase;
	}


	public void sethBase(int hBase) {
		this.hBase = hBase;
	}


	public int getwCanon() {
		return wCanon;
	}


	public void setwCanon(int wCanon) {
		this.wCanon = wCanon;
	}


	public int gethCanon() {
		return hCanon;
	}


	public void sethCanon(int hCanon) {
		this.hCanon = hCanon;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public int getPuntaje() {
		return puntaje;
	}


	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public String getTipoBala() {
		return tipoBala;
	}


	public void setTipoBala(String tipoBala) {
		this.tipoBala = tipoBala;
	}
	
	

}
