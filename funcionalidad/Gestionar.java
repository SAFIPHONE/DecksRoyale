package funcionalidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Gestionar {

	static File fichero = new File("SinNombre.obj");
	
	
	public static File getFichero() {
		return fichero;
	}

	private static void setFichero(File fichero) {
		Gestionar.fichero = fichero;
	}

	public static void guardar(File file) throws FileNotFoundException, IOException{
			Fichero.escribir(file);
			setFichero(file);
	
	}
	
	public static void guardar() throws FileNotFoundException, IOException {
		Fichero.escribir(fichero);
	}
	
	public static Mazo abrir(File file) throws FileNotFoundException, ClassNotFoundException, IOException{
			return Fichero.leer(file);
	}
	
}
