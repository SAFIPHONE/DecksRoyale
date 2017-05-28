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
	
	public static Mazo leer(File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			return (Mazo) in.readObject();
		}
	}
	
	public static void escribir(File fichero) throws FileNotFoundException, IOException{
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
			out.writeObject(fichero);
		}
	
	}



	
	
}
