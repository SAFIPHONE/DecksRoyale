package funcionalidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Mazo implements Serializable, Iterable<Carta>{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList <Carta> mazo;



	public Mazo() {
		mazo = new ArrayList <Carta>();
	}
	
	public static void annadir(Carta carta) throws MazoCompletoException, CartaYaExisteException{
		if(mazo.size()>= 8)
			throw new MazoCompletoException("El mazo ya está completo, contiene las 8 cartas");
		else if(!mazo.equals(carta))
		mazo.add(carta);
		else{
			throw new CartaYaExisteException("La carta ya existe en el mazo");
		}
	}

	public static void remove(Carta carta) throws MazoVacioException{
		if(estaVacio()){
			throw new MazoVacioException("El mazo se encuentra vacío");
		}
		mazo.remove(carta);
	}
	public static ArrayList<Carta> getMazo() throws MazoVacioException {
		if(mazo.isEmpty())
			throw new MazoVacioException("El mazo, esta vacío, no contiene ninguna carta");

		return mazo;
	}
	
	static boolean estaVacio(){
		return mazo.isEmpty();
	}


	
	public static void setMazo(ArrayList<Carta> mazo) {
		Mazo.mazo = mazo;
	}

	public static int size(){
		return mazo.size();
	}

	@Override
	public Iterator<Carta> iterator() {
		return mazo.iterator();
	}
	
	
}
