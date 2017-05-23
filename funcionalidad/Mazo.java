package funcionalidad;

import java.util.ArrayList;

public class Mazo {

	  private ArrayList <Carta> mazo;
	
	public Mazo() {
		mazo=new ArrayList <Carta>();
	}
	
	public void annadir(Carta carta) throws MazoCompletoException{
		if(mazo.size()>= 8)
			throw new MazoCompletoException("El mazo ya está completo, contiene las 8 cartas");
		mazo.add(carta);
	}

	public ArrayList<Carta> getMazo() throws MazoVacioException {
		if(mazo.isEmpty())
			throw new MazoVacioException("El mazo, esta vacío, no contiene ninguna carta");

		return mazo;
	}
	
	boolean isEmpty(){
		if(mazo.isEmpty())
			return true;
		return false;
	}
	
	
}
