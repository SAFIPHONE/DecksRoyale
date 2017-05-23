package funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Fichero {

	private File fichero = new File("SinNombre.obj");
	
	Object leer(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			return in.readObject();
		}
	}
	
	void escribir(File fichero) throws FileNotFoundException, IOException{
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
			out.writeObject(fichero);
		}
	
	}
}
