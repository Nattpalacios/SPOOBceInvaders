package presentacion;

import java.util.*;
import java.io.*;

public class Persistencia {
	
	private String rutaTablero;
	
	public Persistencia() {
		rutaTablero = "tableros";
	}
	
	public ArrayList<Character> interpretaTablero(File tablero) throws IOException {
		if(tablero != null) {
	    	FileReader fis = new FileReader(tablero);
	    	BufferedReader is = new BufferedReader(fis);
	    	String s = is.readLine();
	    	
	    	fis.close();
    	}else {
    	
    	}
	}

}
