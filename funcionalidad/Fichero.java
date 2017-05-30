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
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Fichero implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void escribir(File fichero, Mazo mazo) throws ErrorEscrituraException{
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
			out.writeObject(mazo);
		} catch (IOException e) {
			throw new ErrorEscrituraException("Error de escritura");
		}
	
	}
	
	public static Mazo leer(File fichero) throws ErrorLecturaException {
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
				return (Mazo)in.readObject();
			} catch (IOException | ClassNotFoundException e ) {
					throw new ErrorLecturaException("Error de escritura");
			} 
		
	}
	



	
	
}
