package aplicacion;

public class Normal extends Bala{

	public Normal(int i, int j, char direccion) {
		super(i, j, direccion);
	}
	
	/**
	 * Indica el identificador de la bala en la matriz
	 * @return el identificador de la bala en la matriz
	 */
	public char getIdentificador() {
		return '|';
	}

	@Override
	public void move(SPOOBceInvaders app) {
		if(dir == 'u') {
			int sc = app.impacto(posX-1,posY,dir);
			if(sc == 0) {
				if(posX > 0) {
					posX--;
				}else {
					score = -1;
				}				
			}else {
				score = sc;	
			}			
		}else {
			int p = app.impacto(posX+1, posY, dir);
			if(p == 0) {
				if(posX < 29) {
					posX++;
				}else {
					score = -1;
				}
			}else {
				score = p;
			}
		}
		
	}
	
}
