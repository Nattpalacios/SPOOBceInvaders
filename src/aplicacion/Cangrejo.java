package aplicacion;

public class Cangrejo extends Extraterrestre{
	
	public Cangrejo(int i, int j) {
		super(i, j);
		vida = 2;
		score = 30;
	}
	
	public char getIdentificador() {
		return 'k';
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
