package funcionalidad;

public class CartaYaExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CartaYaExisteException(String cadena) {
		super(cadena);
	}

}
