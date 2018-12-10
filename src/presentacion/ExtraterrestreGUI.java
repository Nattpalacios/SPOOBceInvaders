package presentacion;

public class ExtraterrestreGUI {
	
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	private int tamX;
	private int tamY;
	private int[] posiciones;
	private String image;
	private boolean vivo;

	public ExtraterrestreGUI(int[] pos, int estado, char id, boolean vivo) {
		this.vivo = vivo;
		posiciones = new int[2];
		posiciones[0] = pos[0] * cuadroX;
		posiciones[1] = pos[1] * cuadroY;
		tamX = cuadroX * 4;
		tamY = cuadroY * 2;
		String est = Integer.toString(estado);
		if(id == 'p') {
			image = "ImagenesPulpo/Pulpo" + est +".png";
		}else if(id == 'k') {
			image = "ImagenesCangrejo/Cangrejo" + est +".png";
		}else if(id == 'c') {
			image = "ImagenesCalamar/Calamar" + est +".png";
		}
	}

	public int getTamX() {
		return tamX;
	}

	public void setTamX(int tamX) {
		this.tamX = tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public void setTamY(int tamY) {
		this.tamY = tamY;
	}

	public int[] getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(int[] posiciones) {
		this.posiciones = posiciones;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isVivo() {
		return vivo;
	}
	
}
