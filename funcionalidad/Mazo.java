package funcionalidad;

import java.util.ArrayList;

public class Mazo {

	   public static  ArrayList <Carta> mazo = new ArrayList <Carta>();
	
	public Mazo() {
	}
	
	public static void annadir(Carta carta) throws MazoCompletoException{
		if(mazo.size()>= 8)
			throw new MazoCompletoException("El mazo ya está completo, contiene las 8 cartas");
		mazo.add(carta);
	}

	public static void remove(Carta carta) throws MazoVacioException{
		if(isEmpty()){
			throw new MazoVacioException("El mazo se encuentra vacío");
		}
		mazo.remove(carta);
	}
	public static ArrayList<Carta> getMazo() throws MazoVacioException {
		if(mazo.isEmpty())
			throw new MazoVacioException("El mazo, esta vacío, no contiene ninguna carta");

		return mazo;
	}
	
	static boolean isEmpty(){
		if(mazo.isEmpty())
			return true;
		return false;
	}
	
	public static int  size(){
		return mazo.size();
	}
	
	
}
