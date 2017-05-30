package funcionalidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Mazo implements Serializable, Iterable<Carta>{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList <Carta> mazo = new ArrayList<Carta>();



	

	public  void annadir(Carta carta) throws MazoCompletoException, CartaYaExisteException{
		if(mazo.size()>= 8){
			throw new MazoCompletoException("El mazo ya está completo, contiene las 8 cartas");
		}
		
		if(mazo.contains(carta)){
			throw new CartaYaExisteException("La carta ya esta en el mazo");
		}
		mazo.add(carta);

	}

	public  void remove(Carta carta) throws MazoVacioException{
		if(estaVacio()){
			throw new MazoVacioException("El mazo se encuentra vacío");
		}
		mazo.remove(carta);
	}
	public  ArrayList<Carta> getMazo() throws MazoVacioException {
		if(mazo.isEmpty())
			throw new MazoVacioException("El mazo, esta vacío, no contiene ninguna carta");

		return mazo;
	}
	
	 boolean estaVacio(){
		return mazo.isEmpty();
	}




	public  int tamanno(){
		return mazo.size();
	}

	@Override
	public Iterator<Carta> iterator() {
		return mazo.iterator();
	}
	
	
}
