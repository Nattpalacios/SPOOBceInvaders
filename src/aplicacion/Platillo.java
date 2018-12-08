package aplicacion;

public class Platillo extends Extraterrestre{
	
	public Platillo(int i, int j) {
		super(i, j);
		vida = 1;
		score = 200;
	}
	
	public char getIdentificador() {
		return 'v';
	}

	@Override
	public void disparar(int posX, int posY) {
		
	}

	@Override
	public void move(SPOOBceInvaders app) {
		// TODO Auto-generated method stub
		
	}

}
