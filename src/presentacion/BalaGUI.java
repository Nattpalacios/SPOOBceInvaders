package presentacion;

import java.util.*;

public class BalaGUI {
	
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	private int[] posi;
	private String image;

	public BalaGUI(Character id, Integer[] pos) {
		posi = new int[2];
		posi[0] = pos[0] * cuadroX;
		posi[1] = pos[1] * cuadroY;	
		if(id == '|') {
			image = "ImagenesBalas/Normal.png";
		}else if(id == ':'){
			image = "ImagenesBalas/Especial.png";
		}
	}

	public int[] getPosi() {
		return posi;
	}

	public void setPosi(int[] posi) {
		this.posi = posi;
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
