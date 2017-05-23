package funcionalidad;

public enum Carta {


	MONTAPUERCOS(Calidad.ESPECIAL),
	VALQUIRIA(Calidad.ESPECIAL),
	ESPIRITUHIELO(Calidad.COMUN),
	VERDUGO(Calidad.EPICA),
	TRONCO(Calidad.LEGENDARIA);
	
	private Calidad calidad;
	
	private Carta(Calidad calidad) {
		this.calidad=calidad;
	}
	
	
	
}
