package funcionalidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Gestionar {

	static File fichero = new File("SinNombre.obj");
	
	public static void guardar(File file) throws FileNotFoundException, IOException{
			Fichero.escribir(file);
	
	}
	
	public static void guardar() throws FileNotFoundException, IOException {
		Fichero.escribir(fichero);
	}
	
	public static void abrir(File file) throws FileNotFoundException, ClassNotFoundException, IOException{
			Fichero.leer(file);
	}
	
}
