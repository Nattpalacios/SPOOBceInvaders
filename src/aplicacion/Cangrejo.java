package aplicacion;

/**
 * Clase que contiene toda la informacion del invasor de tipo cangrejo.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Cangrejo extends Extraterrestre{
	
	/**
	 * Constructor de un cangrejo
	 * @param i, primera posicion en x del cangrejo en la matriz.
	 * @param j, primera posicion en y del cangrejo en la matriz.
	 */
	public Cangrejo(int i, int j) {
		super(i, j);
		vida = 2;
		score = 30;
	}
	
	/**
	 * Indica el identificador del cangrejo en la matriz
	 * @return el identificador
	 */
	public char getIdentificador() {
		return 'k';
	}

	/**
	 * Hace que el invasor se mueva.
	 * @param app, clase principal de la aplicacion.
	 */
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
