package aplicacion;

public class Especial extends Bala{

	public Especial(int i, int j, char direccion) {
		super(i, j, direccion);
	}
	
	/**
	 * Indica el identificador de la bala en la matriz
	 * @return el identificador de la bala en la matriz
	 */
	public char getIdentificador() {
		return ':';
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
				int sc2 = app.impacto(posX-1, posY-6, dir);
				int sc3 = app.impacto(posX-1, posY+6, dir);
				if(sc2 != -1) {
					score += sc2;
				}
				if(sc3 != -1) {
					score += sc3;
				}
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
