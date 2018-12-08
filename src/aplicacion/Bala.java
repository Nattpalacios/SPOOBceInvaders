package aplicacion;

/**
 * Esta clase contiene toda la informacion necesaria de una bala
 * @author (Palacios)
 * @version (29/11/2018)
 */
public abstract class Bala implements Movible{
	
	protected int posX;
	protected int posY;
	protected char dir;
	protected int score;

	/**
	 * Constructor de la bala
	 * @param i, posicion en x de la bala
	 * @param j, posicion en y de la bala
	 * @param direccion, indica si la bala va hacia arriba 'u' o hacia abajo 'd'
	 */
	public Bala(int i, int j, char direccion) {
		score = 0;
		posX = i;
		posY = j;
		dir = direccion;
		
	}
	
	public abstract char getIdentificador();
	
	/**
	 * Indica la posicion en x de la bala
	 * @return la posicion en x de la bala
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Indica la posicion en y de la bala
	 * @return la posicion en y de la bala
	 */
	public int getPosY() {
		return posY;
	}



	public int getScore() {		
		return score;
	}
	
	

}
