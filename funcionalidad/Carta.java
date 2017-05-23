package funcionalidad;

public enum Carta {


	MONTAPUERCOS(Calidad.ESPECIAL),
	VALQUIRIA(Calidad.ESPECIAL),
	ESPIRITU_HIELO(Calidad.COMUN),
	VERDUGO(Calidad.EPICA),
	TRONCO(Calidad.LEGENDARIA),
	CABALLERO(Calidad.COMUN),
	ARQUERAS(Calidad.COMUN),
	MORTERO(Calidad.COMUN),
	FLECHAS(Calidad.COMUN),
	PANDILLA_DUENDES(Calidad.COMUN),
	COHETE(Calidad.ESPECIAL),
	DUENDES(Calidad.COMUN),
	DUENDES_LANZA(Calidad.COMUN);
	
	
	private Calidad calidad;
	
	private Carta(Calidad calidad) {
		this.calidad=calidad;
	}

	public Calidad getCalidad() {
		return calidad;
	}
	
	
}
