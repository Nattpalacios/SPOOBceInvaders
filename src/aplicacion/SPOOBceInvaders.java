package aplicacion;

import java.awt.Color;
import java.util.*;

/**
 * Clase principal de aplicacion
 * @version (2/12/2018)
 * @author (Natalia Palacios)
 */

public class SPOOBceInvaders {
	
	private ArrayList<Barrera> escudos;
	private ArrayList<Extraterrestre> extraterrestres;
	private ArrayList<Canon> canones;
	private char[][] tablero;
	private char[][] tableroVacio;
	
	/**
	 * Constructor de la clase
	 */
	public SPOOBceInvaders() {		
		tablero = new char[30][84];
		tableroInicial();
	}

	/**
	 * Llena el tablero inicialmente de asteriscos
	 */
	private void tableroInicial() {
		tableroVacio =  new char[30][84];
		for(int i = 0; i<30; i++) {
			for(int j=0; j<84; j++) {
				tableroVacio[i][j] = '*';
			}
		}
	}

	/**
	 * Llena el tablero segun los elementos indicados.
	 * @param modo, indica el modo de juego (un jugador o multijugador).
	 */
	public void iniciarJuego(char modo) {
		escudos = new ArrayList<Barrera>();
		extraterrestres = new ArrayList<Extraterrestre>();
		canones = new ArrayList<Canon>();
		if(modo == 'u') {
			canones.add(new Canon(27,41));
		}else if(modo == 'm') {
			canones.add(new Canon(27,26));
			canones.add(new Canon(27,55));
		}
		limpiarTablero();
		crearElementos();
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		
	}
	
	/**
	 * Pinta los invasores en la matriz
	 */
	private void actualiceInvasores() {
		for(int i = 0; i < extraterrestres.size(); i++) {
			char id = extraterrestres.get(i).getIdentificador();
			int[][] pos = extraterrestres.get(i).getPos();
			for(int j = 0; j < pos.length; j++) {
				tablero[pos[j][0]][pos[j][1]] = id;
			}
		}
	}
	
	/**
	 * Pinta las barreras en la matriz
	 */
	private void actualiceBarreras() {
		for(int i = 0; i < escudos.size(); i++) {
			char id = escudos.get(i).getIdentificador();
			ArrayList<Integer[]> pos = escudos.get(i).getPos();			
			for(int j = 0; j < pos.size(); j++) {
				tablero[pos.get(j)[0]][pos.get(j)[1]] = id;
			}
		}
	}
	
	/**
	 * Pinta los canones en la matriz
	 */
	private void actualiceCanones() {
		for(int i = 0; i < canones.size(); i++) {
			if(canones.get(i).isVivo()) {
				char id = canones.get(i).getIdentificador();
				int[][] pos = canones.get(i).getPos();
				for(int j = 0; j < pos.length; j++) {
					tablero[pos[j][0]][pos[j][1]] = id;
				}
			}
		}
	}
	
	/**
	 * Pinta las balas en la matriz
	 */
	private void actualiceBalas() {
		for(int i = 0; i < canones.size(); i++) {
			ArrayList<Bala> balas = canones.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					char id = balas.get(j).getIdentificador();
					int posx = balas.get(j).getPosX();
					int posy = balas.get(j).getPosY();
					tablero[posx][posy]	= id;
				}
				
			}
		}
		for(int i = 0; i < extraterrestres.size(); i++) {
			ArrayList<Bala> balas = extraterrestres.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					char id = balas.get(j).getIdentificador();
					int posx = balas.get(j).getPosX();
					int posy = balas.get(j).getPosY();
					tablero[posx][posy]	= id;
				}
				
			}
		}
	}
	
	/**
	 * Llena el tablero del juego con lo que tenga el tablero inicial
	 */
	public void limpiarTablero() {
		for(int i = 0; i < 30; i++) {
			tablero[i] = Arrays.copyOfRange(tableroVacio[i], 0, 84);
		}
	}
	
	public void crearElementos() {
		int[] barre = {21,7,21,28,21,49,21,70};
		int[] calamar = {5,10,5,16,5,22,5,28,5,34,5,40,5,46,5,52,5,58,5,64,5,70};	
		int[] cangrejo = {8,10,8,16,8,22,8,28,8,34,8,40,8,46,8,52,8,58,8,64,8,70};
		int[] pulpo = {11,10,11,16,11,22,11,28,11,34,11,40,11,46,11,52,11,58,11,64,11,70};
		for(int i = 0; i < 7; i+=2) {
			escudos.add(new Roja(barre[i],barre[i+1]));
		}
		for(int i = 0; i < 21; i+=2) {
			extraterrestres.add(new Calamar(calamar[i],calamar[i+1]));
			extraterrestres.add(new Cangrejo(cangrejo[i],cangrejo[i+1]));
			extraterrestres.add(new Pulpo(pulpo[i],pulpo[i+1]));
		}
	}
	
	/**
	 * Mueve el canon a la derecha
	 * @param jugador, indica cual jugador hizo el movimiento
	 */
	public void derecha(int jugador) {
		canones.get(jugador-1).derecha();
		limpiarTablero();
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		actualiceBalas();
	}
	
	/**
	 * Mueve el canon a la izquierda
	 * @param jugador, indica cual jugador hizo el movimiento
	 */
	public void izquierda(int jugador) {
		canones.get(jugador-1).izquierda();
		limpiarTablero();
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		actualiceBalas();
	}

	/**
	 * Realiza un disparo
	 * @param jugador, indica cual jugador disparo
	 */
	public void dispare(int jugador) {
		int posX = canones.get(jugador-1).getPosX();
		int posY = canones.get(jugador-1).getPosY();
		canones.get(jugador-1).disparar(posX-1, posY+1);		
	}
	
	/**
	 * Actualiza la matriz
	 * @return el tablero
	 */
	public char[][] actualice() {
		for(int i = 0; i < extraterrestres.size();i++ ) {
			extraterrestres.get(i).disparar(0, 0);
		}		
		for(int i = 0; i < canones.size(); i++) {
			ArrayList<Bala> balas = canones.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					balas.get(j).move(this);
				}				
			}
		}
		for(int i = 0; i < extraterrestres.size(); i++) {
			ArrayList<Bala> balas = extraterrestres.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					balas.get(j).move(this);
				}				
			}
		}
		limpiarTablero();
		actualiceBarreras();
		actualiceBalas();
		actualiceInvasores();
		actualiceCanones();
		
		return tablero;
	}

	/**
	 * Indica cuantos puntos se ganan al chocar una bala
	 * @param posX, posicion x del impacto
	 * @param posY, posicion y del impacto
	 * @param d, indica la direccion de la bala 
	 * @return puntaje
	 */
	public int impacto(int posX, int posY, char d) {
		int score = 0;
		int ext=-1;int bar=-1;int can=-1;
		for(int i = 0; i < extraterrestres.size() && score == 0; i++) {
			Extraterrestre e = extraterrestres.get(i);
			score = e.impacto(posX, posY,d);
			if(!e.isVivo()) {
				ext=i;
			}
		}
		for(int i = 0; i < escudos.size() && score == 0; i++) {
			Barrera b = escudos.get(i);
			score = b.impacto(posX, posY,d);
			if(!b.isVivo()) {
				bar=i;
			}
			
		}
		for(int i = 0; i < canones.size() && score == 0; i++) {
			Canon c = canones.get(i);
			score = c.impacto(posX, posY,d);
			if(!c.isVivo()) {
				can=i;
			}
		}
		//if(ext!=-1) {extraterrestres.remove(ext);}
		if(bar!=-1) {escudos.remove(bar);}
		//if(can!=-1) {canones.remove(can);}
		
		return score;
	}

	public ArrayList<Integer> getTamanos() {
		ArrayList<Integer> tamanos = new ArrayList<Integer>();
		tamanos.add(canones.size());
		tamanos.add(escudos.size());
		tamanos.add(extraterrestres.size());
		//tamanos.add(balinas)
		return tamanos;
	}

	public int[] getPosicionesCanon(int i) {
		int[] a = new int[2];
		a[1] = canones.get(i).getPosX();
		a[0] = canones.get(i).getPosY();
		return a;
	}

	public Color getColorCanon(int i) {
		//return canones.get(i).getColor();
		return Color.BLACK;
	}

	public int getVidaCanon(int i) {
		return canones.get(i).getVida();
	}

	public int getPuntajeCanon(int i) {
		return canones.get(i).getPuntaje();
	}
	
	public ArrayList<Integer[]> getPosicionesBarrera(int i) {
		return escudos.get(i).getPos();
	}

	public char getIdBarrera(int i) {
		return escudos.get(i).getIdentificador();
	}

	public int[] getPosicionInvasor(int i) {
		return extraterrestres.get(i).getPosIni();
	}

	public int getEstadoInvasor(int i) {
		return extraterrestres.get(i).getEstado();
	}

	public char getIdInvasor(int i) {
		return extraterrestres.get(i).getIdentificador();
	}
	
	public ArrayList<Character> getBalasCanon(int i) {
		return canones.get(i).getBal();
	}
	
	public ArrayList<Integer[]> getBalasCanonPos(int i){
		return canones.get(i).getBalPos();
	}
	
	public ArrayList<Character> getBalasInvasor(int i) {
		return extraterrestres.get(i).getBal();
	}
	
	public ArrayList<Integer[]> getBalasInvasorPos(int i){
		return extraterrestres.get(i).getBalPos();
	}
	
	public boolean invasorIsVivo(int i) {
		return extraterrestres.get(i).isVivo();
	}
	
}
