package aplicacion;

public class Roja extends Barrera{
	
	public Roja(int i, int j) {
		super(i, j);
		vida = 1;
	}

	@Override
	public int impacto(int x, int y, char d) {
		int impacto = 0;
		if(estoy(x,y,d)) {
			if(d == 'u') {
				vida--;
				if(vida == 0) {
					vivo = false;	
				}
			}				
			impacto = -1;
		}else {
			impacto = 0;
		}
		return impacto;
	}

	@Override
	public boolean estoy(int i, int j, char d) {
		boolean flag = false;
		for(int k = 0; k < posiciones.size() && !flag; k++) {
			if(posiciones.get(k)[0] == i && posiciones.get(k)[1] == j) {
				flag = true;
				if(d =='u') {
					posiciones.clear();
				}
			}
		}
		return flag;
	}

	@Override
	public char getIdentificador() {
		return 'r';
	}

}
