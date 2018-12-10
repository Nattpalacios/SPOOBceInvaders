package aplicacion;

import java.util.Random;

/**
 * Clase que contiene toda la informacion del invasor de tipo calamar
 * @author (Palacios)
 * @version (29/11/2018)
 */
public class Calamar extends Extraterrestre{
	
	/**
	 * Constructor de un calamar
	 * @param i, primera posicion en x del calamar en la matriz.
	 * @param j, primera posicion en y del calamar en la matriz.
	 */
	public Calamar(int i, int j) {
		super(i, j);
		Random r = new Random();
		vida = r.nextInt(3);
		while(vida == 0) {
			vida = r.nextInt(3);
		}
		score = 50;
	}
	
	/**
	 * Indica el identificador del calamar en la matriz
	 * @return el identificador
	 */
	public char getIdentificador() {
		return 'c';
	}

	

	@Override
	public void move(SPOOBceInvaders app) {
		if(vivo) {
			if(estado == 1) {
				estado = 2;
			}else {
				estado = 1;
			}
		}
		
		
	}

	

}
