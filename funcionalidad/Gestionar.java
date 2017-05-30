package funcionalidad;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;



public class Gestionar implements Serializable{

	static File fichero = new File("SinNombre.obj");
	
	
	public static File getFichero() {
		return fichero;
	}

	private static void setFichero(File fichero) {
		Gestionar.fichero = fichero;
	}

	public static void guardar(File fichero, Mazo mazo) throws ErrorEscrituraException{
			Fichero.escribir(fichero, mazo);
			setFichero(fichero);
	
	}
	
	public static void guardar(Mazo mazo) throws ErrorEscrituraException {
		Fichero.escribir(fichero,mazo);
	}
	
	public static Mazo abrir(File fichero) throws ErrorLecturaException, ClassNotFoundException, IOException{
			return (Mazo)Fichero.leer(fichero);
	}
	
}
