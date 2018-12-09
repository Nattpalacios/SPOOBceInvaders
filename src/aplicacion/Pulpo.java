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
		if(estado == 1) {
			estado = 2;
		}else {
			estado = 1;
		}
		
	}

}
