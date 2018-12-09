package presentacion;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BarreraGUI {
	
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	private ArrayList<Integer[]> posiciones;
	private String image;
	
	public BarreraGUI(ArrayList<Integer[]> pos, char id) {
		posiciones = new ArrayList<Integer[]>();
		if(id == 'r') {
			image = "ImagenesBarrera/Roja.png";
		}else {
			image = "ImagenesBarrera/Verde.png";
		}
		for(int i = 0; i < pos.size(); i++) {
			Integer[] posi = new Integer[2];
			posi[0] = pos.get(i)[1] * cuadroX;
			posi[1] = pos.get(i)[0] * cuadroY;
			posiciones.add(posi);
		}
	}

	public ArrayList<Integer[]> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(ArrayList<Integer[]> posiciones) {
		this.posiciones = posiciones;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static int getCuadrox() {
		return cuadroX;
	}

	public static int getCuadroy() {
		return cuadroY;
	}


}
