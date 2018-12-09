package aplicacion;

import java.util.*;
import java.math.*;

public abstract class Extraterrestre implements Impactable, Movible, Dispara{
	
	protected int[][] posiciones;
	protected int x;
	protected int y;
	protected boolean vivo;
	protected int vida;
	protected int score;
	protected ArrayList<Bala> municiones;
	protected int estado;
	
	public Extraterrestre(int i, int j) {
		estado = 1;
		municiones = new ArrayList<Bala>();
		vivo = true;
		x = i; y = j;
		posiciones = new int[8][2];
		asignePosiciones(i, j);
	}
	
	public void asignePosiciones(int i, int j) {
		int[] pos = new int[2];
		pos[0] = i; pos[1] = j; posiciones[0] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[1] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[2] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+3; posiciones[3] = Arrays.copyOfRange(pos, 0, 2);
		pos[0] = i+1; pos[1] = j; posiciones[4] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[5] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[6] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+3; posiciones[7] = Arrays.copyOfRange(pos, 0, 2);
	}
	
	public abstract char getIdentificador();
	
	public int[][] getPos(){
		return posiciones;
	}
	
	@Override
	public void disparar(int posX, int posY) {
		Random r = new Random();
		boolean prob;
		int val = Math.abs(r.nextInt(1000));		
		if(val <= 5) {
			prob = true;
		}else {
			prob = false;
		}
		if(prob) {
			dispare();
		}
	}	
	
	protected void dispare() {
		Random r = new Random();
		int suma = r.nextInt(4);
		int posX = x+2; 
		int posY = y + suma;
		Bala b = new Normal(posX, posY, 'd');
		municiones.add(b);
		
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
		if(estoy(x,y,d) && d == 'u') {
			vida--;
			if(vida == 0) {
				vivo = false;
				return score;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
		
	}
	
	public boolean isVivo() {
		return vivo;
	}
	
	public int getVida() {
		return vida;
	}
	
	public Bala getUltimoDisparo() {
		return municiones.get(municiones.size()-1);
	}

	public ArrayList<Bala> getBalas() {
		return municiones;
	}

	public int[] getPosIni() {
		int[] pos = new int[2];
		pos[1] = x;
		pos[0] = y;
		return pos;
	}

	public int getEstado() {
		return estado;
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
