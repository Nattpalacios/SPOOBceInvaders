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
	private int filas;
	private ArrayList<ArrayList<Extraterrestre>> extraterrestres;
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
	public void iniciarJuego(Color col, ArrayList<ArrayList<Character>> tablero) {
		escudos = new ArrayList<Barrera>();
		extraterrestres = new ArrayList<ArrayList<Extraterrestre>>();
		filas = tablero.get(0).size();
		canones = new ArrayList<Canon>();
		Canon c = new Canon(27,41);
		c.setColor(col);
		canones.add(c);
		limpiarTablero();
		crearElementos(tablero);
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		
	}
	
	/**
	 * Llena el tablero segun los elementos indicados.
	 * @param modo, indica el modo de juego (un jugador o multijugador).
	 */
	public void iniciarJuego(char modo,Color col,Color col2,ArrayList<ArrayList<Character>> tablero) {
		escudos = new ArrayList<Barrera>();
		extraterrestres = new ArrayList<ArrayList<Extraterrestre>>();
		canones = new ArrayList<Canon>();
		filas = tablero.get(0).size();
		/*if(modo == 'm') {
			Canon c = new Canon(27,55);
			c.setColor(col);
			Canon c2 = new Canon(27,26);
			c2.setColor(col2);
		}else if(modo == 'm') {
			
		}*/
		Canon c = new Canon(27,55);
		c.setColor(col);
		Canon c2 = new Canon(27,26);
		c2.setColor(col2);
		canones.add(c);
		canones.add(c2);
		limpiarTablero();
		crearElementos(tablero); //arreglar
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		
	}
	
	/**
	 * Pinta los invasores en la matriz
	 */
	private void actualiceInvasores() {
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < 11; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				if(e.isVivo()) {
					char id = e.getIdentificador();
					int[][] pos = e.getPos();
					for(int k = 0; k < pos.length; k++) {
						tablero[pos[k][0]][pos[k][1]] = id;
					}
				}
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
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < 11; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				if(e.isVivo()) {
					ArrayList<Bala> balas = e.getBalas();
					for(int k = 0; k < balas.size(); k++) {
						Bala b = balas.get(k);
						if(b.getScore() == 0) {
							char id = b.getIdentificador();
							int posx = b.getPosX();
							int posy =b.getPosY();
							tablero[posx][posy]	= id;
						}
					}						
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
	
	public void crearElementos(ArrayList<ArrayList<Character>> tablero) {
		int[] barre = posicionesBarreras(tablero.get(1).size());
		int cont = 0;
		int[] inicial = {5,10,5,16,5,22,5,28,5,34,5,40,5,46,5,52,5,58,5,64,5,70};	
		int[] cangrejo = {8,10,8,16,8,22,8,28,8,34,8,40,8,46,8,52,8,58,8,64,8,70};
		int[] pulpo = {11,10,11,16,11,22,11,28,11,34,11,40,11,46,11,52,11,58,11,64,11,70};
		for(int i = 0; i < barre.length-1; i+=2) {
			if(tablero.get(1).get(cont) == 'r') {
				escudos.add(new Roja(barre[i],barre[i+1]));
			}else {
				escudos.add(new Verde(barre[i],barre[i+1]));
			}
			cont++;
		}
		for(int i = 0; i < filas; i++) {
			ArrayList<Extraterrestre> arreglo = new ArrayList<Extraterrestre>();
			for(int j = 0; j < 21; j+=2) {
				if(tablero.get(0).get(i) == 'c') {
					arreglo.add(new Calamar(inicial[j]+(3*i),inicial[j+1]));
				}else if(tablero.get(0).get(i) == 'k'){
					arreglo.add(new Cangrejo(inicial[j]+(3*i),inicial[j+1]));
				}else if(tablero.get(0).get(i) == 'p') {
					arreglo.add(new Pulpo(inicial[j]+(3*i),inicial[j+1]));
				}else {
					arreglo.add(new Platillo(inicial[j]+(3*i),inicial[j+1]));
				}				
			}
			extraterrestres.add(arreglo);
		}
	}
	
	private int[] posicionesBarreras(int cantidad) {
		if(cantidad == 1) {
			int[] barre = {21,39};
			return barre;
		}else if(cantidad == 2) {
			int[] barre = {21,23,21,54};
			return barre;
		}else if(cantidad == 3) {
			int[] barre = {21,16,21,39,21,62};
			return barre;
		}else if(cantidad == 4) {
			int[] barre = {21,7,21,28,21,49,21,70};
			return barre;
		}else if(cantidad == 5) {
			int[] barre = {21,9,21,24,21,39,21,54,21,69};
			return barre;
		}else if(cantidad == 6) {
			int[] barre = {21,7,21,20,21,33,21,46,21,59,21,72};
			return barre;
		}else if(cantidad == 7) {
			int[] barre = {21,4,21,16,21,28,21,40,21,52,21,64,21,76};
			return barre;
		}else {
			int[] barre = {21,0,21,10,21,21,21,32,21,43,21,54,21,65,21,75};
			return barre;
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
		for(int i = 0; i < filas;i++ ) {
			for(int j = 0; j < 11;j++ ) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				e.disparar(0, 0);
			}			
		}		
		for(int i = 0; i < canones.size(); i++) {
			ArrayList<Bala> balas = canones.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					balas.get(j).move(this);
				}				
			}
		}
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < 11; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				ArrayList<Bala> balas = e.getBalas();
				for(int k = 0; k < balas.size(); k++) {
					if(balas.get(k).getScore() == 0) {
						balas.get(k).move(this);
					}				
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
		for(int i = 0; i < filas && score == 0; i++) {
			for(int j = 0; j < 11 && score == 0; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				score = e.impacto(posX, posY,d);
				if(!e.isVivo()) {
					ext=i;
				}
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
		if(bar!=-1) {escudos.remove(bar);}
		
		return score;
	}

	public ArrayList<Integer> getTamanos() {
		ArrayList<Integer> tamanos = new ArrayList<Integer>();
		tamanos.add(canones.size());
		tamanos.add(escudos.size());
		tamanos.add(filas*11);
		return tamanos;
	}

	public int[] getPosicionesCanon(int i) {
		int[] a = new int[2];
		a[1] = canones.get(i).getPosX();
		a[0] = canones.get(i).getPosY();
		return a;
	}

	public Color getColorCanon(int i) {
		return canones.get(i).getColor();
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

	public int[] getPosicionInvasor(int n) {
		int x = 0;
		int[] pos = new int[2];
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					pos=extraterrestres.get(i).get(j).getPosIni();
				}
				x++;
			}
		}
		return pos;
	}

	public int getEstadoInvasor(int n) {
		int x = 0;
		int est = -1;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					est=extraterrestres.get(i).get(j).getEstado();
				}
				x++;
			}
		}
		return est;
	}

	public char getIdInvasor(int n) {
		int x = 0;
		char id = ' ';
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					id=extraterrestres.get(i).get(j).getIdentificador();
				}
				x++;
			}
		}
		return id;
	}
	
	public ArrayList<Character> getBalasCanon(int i) {
		return canones.get(i).getBal();
	}
	
	public ArrayList<Integer[]> getBalasCanonPos(int i){
		return canones.get(i).getBalPos();
	}
	
	public ArrayList<Character> getBalasInvasor(int n) {
		int x = 0;
		ArrayList<Character> bal = null;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					bal=extraterrestres.get(i).get(j).getBal();
				}
				x++;
			}
		}
		return bal;
	}
	
	public ArrayList<Integer[]> getBalasInvasorPos(int n){
		int x = 0;
		ArrayList<Integer[]> bal = null;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					bal=extraterrestres.get(i).get(j).getBalPos();
				}
				x++;
			}
		}
		return bal;
	}
	
	public boolean invasorIsVivo(int n) {
		int x = 0;
		boolean viv = false;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					viv=extraterrestres.get(i).get(j).isVivo();
				}
				x++;
			}
		}
		return viv;
	}
	
}
