package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import aplicacion.*;

/**
 * The test class SPOOBceInvadersTest.
 * 
 * @author (Palacios Natalia)
 * @version (7/12/2018)
 *
 */
class SPOOBceInvadersTest {

	@Test
	void deberianCrearseVivosLosCalamares() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>(); 
		Extraterrestre ca = new Calamar(1000, 1000);
		extraterrestres.add(ca);
		Extraterrestre pu = new Calamar(800,1000);
		extraterrestres.add(pu);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).isVivo());
			assertFalse(!extraterrestres.get(i).isVivo());
		}
	}
	
	@Test
	void deberianCrearseVivosLosPulpos() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>(); 
		Extraterrestre ca = new Pulpo(1000, 1000);
		extraterrestres.add(ca);
		Extraterrestre pu = new Pulpo(800,1000);
		extraterrestres.add(pu);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).isVivo());
			assertFalse(!extraterrestres.get(i).isVivo());
		}
	}
	
	@Test
	void deberianCrearseVivosLosCangrejos() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>(); 
		Extraterrestre ca = new Cangrejo(1000, 1000);
		extraterrestres.add(ca);
		Extraterrestre pu = new Cangrejo(800,1000);
		extraterrestres.add(pu);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).isVivo());
			assertFalse(!extraterrestres.get(i).isVivo());
		}
	}
	
	@Test
	void deberianCrearseVivosLosCanones() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador1 = new Canon(1000, 1000);
		canones.add(jugador1);
		Canon jugador2 = new Canon(600, 1000);
		canones.add(jugador2);
		Canon jugador3 = new Canon(1000, 600);
		canones.add(jugador3);
		for(int i = 0; i < canones.size(); i++) {
			assertTrue(canones.get(i).isVivo());
			assertFalse(!canones.get(i).isVivo());
		}
	}
	
	@Test
	void noDeberiaUnPulpoTenerMasDeUnaVida() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>();
		Extraterrestre invasor1 = new Pulpo(1000, 1000);
		extraterrestres.add(invasor1);
		Extraterrestre invasor2 = new Pulpo(500, 1000);
		extraterrestres.add(invasor2);
		Extraterrestre invasor3 = new Pulpo(1000, 500);
		extraterrestres.add(invasor3);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).getVida() == 1);
			assertFalse(extraterrestres.get(i).getVida() > 1);
			assertEquals(extraterrestres.get(i).getVida(), 1);
		}
	}
	
	@Test
	void noDeberiaUnCangrejoTenerMasDeDosVidas() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>();
		Extraterrestre invasor1 = new Cangrejo(1000, 1000);
		extraterrestres.add(invasor1);
		Extraterrestre invasor2 = new Cangrejo(500, 1000);
		extraterrestres.add(invasor2);
		Extraterrestre invasor3 = new Cangrejo(1000, 500);
		extraterrestres.add(invasor3);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).getVida() == 2);
			assertFalse(extraterrestres.get(i).getVida() > 2);
			assertEquals(extraterrestres.get(i).getVida(), 2);
		}
	}
	
	@Test
	void noDeberiaUnCangrejoNacerConMenosDeDosVidas() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>();
		Extraterrestre invasor1 = new Cangrejo(1000, 1000);
		extraterrestres.add(invasor1);
		Extraterrestre invasor2 = new Cangrejo(500, 1000);
		extraterrestres.add(invasor2);
		Extraterrestre invasor3 = new Cangrejo(1000, 500);
		extraterrestres.add(invasor3);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).getVida() == 2);
			assertFalse(extraterrestres.get(i).getVida() < 2);
			assertEquals(extraterrestres.get(i).getVida(), 2);
		}
	}
	
	@Test
	void noDeberiaUnCanonTenerMasDeTresVidas() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(1000, 1000);
		canones.add(jugador);
		assertTrue(canones.get(0).getVida() == 3);
		assertFalse(canones.get(0).getVida() > 3);
	}
	
	@Test
	void noDeberiaUnCanonCrearseConMenosDeTresVidas() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(1000, 1000);
		canones.add(jugador);
		assertTrue(canones.get(0).getVida() == 3);
		assertFalse(canones.get(0).getVida() < 3);
	}
	
	@Test
	void deberiaElCanonMoverseHaciaLaDerecha() {
		
	}
	
	@Test
	void deberiaElCanonMoverseHaciaLaIzquierda() {
		
	}
	
	@Test
	void deberiaElCanonDisparar() {
		
	}
	
	@Test
	void deberiaMorirUnInvasorPulpoLuegoDeUnDisparo() {
		
	}
	
	@Test
	void deberiaMorirUnInvasorCangrejoLuegoDeDosDisparos() {
		
	}
	
	@Test
	void noDeberiaCrearseMasDeUnCanonEnModoUnJugador() {
		
	}
	
	@Test
	void deberianCrearseDosCanonesEnModoMultijugador() {
		
	}
	
	@Test
	void noDeberianCrearseMasDeDosCanonesEnModoMultijugador() {
		
	}

}
