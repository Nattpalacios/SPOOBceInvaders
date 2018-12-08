package aplicacion;

public class Pulpo extends Extraterrestre{
	
	public Pulpo(int i, int j) {
		super(i,j);
		vida = 1;
		score = 10;
	}
	
	public char getIdentificador() {
		return 'p';
	}

	

	@Override
	public void move(SPOOBceInvaders app) {
		// TODO Auto-generated method stub
		
	}

}
