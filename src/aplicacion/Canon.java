package aplicacion;

import java.util.ArrayList;
import java.util.Arrays;

public class Canon implements Impactable, Movible, Dispara{
	
	private int[][] posiciones;
	private int x;
	private int y;
	private ArrayList<Bala> municiones;
	private int vida;
	private boolean vivo;
	
	public Canon(int i, int j) {
		vivo = true;
		vida = 3;
		x = i; y = j;
		posiciones = new int[10][2];
		municiones = new ArrayList<Bala>();
		asignePosiciones(x, y);
	}
	
	protected void asignePosiciones(int i, int j) {
		int[] pos = new int[2];
		pos[0] = i; pos[1] = j; posiciones[0] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[1] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[2] = Arrays.copyOfRange(pos, 0, 2);
		pos[0] = i+1; pos[1] = j-2; posiciones[3] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j-1; posiciones[4] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j; posiciones[5] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[6] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[7] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+3; posiciones[8] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+4; posiciones[9] = Arrays.copyOfRange(pos, 0, 2);
		
	}

	public char getIdentificador() {
		return 'j';
	}
	
	public int[][] getPos(){
		return posiciones;
	}
	
	public void izquierda() {
		if(y-3 >= 0) {
			y--;
			asignePosiciones(x, y);
		}
	}

	public void derecha() {
		if(y+5 <= 83) {
			y++;
			asignePosiciones(x, y);
		}
	}

	@Override
	public void disparar(int posX, int posY) {
		if(vivo) {
			Bala balita = new Normal(posX,posY, 'u');
			municiones.add(balita);
		}
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}

	public Bala getUltimoDisparo() {
		return municiones.get(municiones.size()-1);
	}
	
	public ArrayList<Bala> getBalas(){
		return municiones;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	@Override
	public void move(SPOOBceInvaders app) {		
	}

	public boolean estoy(int i, int j, char d) {
		boolean flag = false;
		for(int k = 0; k < posiciones.length && !flag; k++) {
			if(posiciones[k][0] == i && posiciones[k][1] == j) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public int impacto(int x, int y, char d) {
		if(estoy(x,y,d) && d == 'd') {
			vida--;
			if(vida == 0) {
				vivo = false;
				return -1;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}

	public int getVida() {
		return vida;
	}

	public int getPuntaje() {
		int pun = 0;
		for(int i = 0; i < municiones.size(); i++) {
			Bala b = municiones.get(i);
			if(b.getScore() != -1) {
				pun += b.getScore();
			}
		}
		return pun;
	}

	public ArrayList<Character> getBal() {
		ArrayList<Character> bal = new ArrayList<Character>();
		for(int i = 0; i < municiones.size(); i++) {
			if(municiones.get(i).getScore() == 0) {
				bal.add(municiones.get(i).getIdentificador());
			}
		}
		return bal;
	}
	
	public ArrayList<Integer[]> getBalPos() {
		ArrayList<Integer[]> bal = new ArrayList<Integer[]>();
		for(int i = 0; i < municiones.size(); i++) {
			if(municiones.get(i).getScore() == 0) {
				Integer[] pos = new Integer[2];
				pos[1] = municiones.get(i).getPosX();
				pos[0] = municiones.get(i).getPosY();
				bal.add(pos);
			}
		}
		return bal;
	}

}
