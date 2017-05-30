package funcionalidad;

import java.io.Serializable;

public enum Carta implements Serializable {


	//CARTAS COMUNES
	
	CABALLERO(Calidad.COMUN),
	ARQUERAS(Calidad.COMUN),
	MORTERO(Calidad.COMUN),
	FLECHAS(Calidad.COMUN),
	ESPIRITU_HIELO(Calidad.COMUN),
	DUENDES(Calidad.COMUN),
	DUENDES_LANZA(Calidad.COMUN),
	PANDILLA_DUENDES(Calidad.COMUN),
	ESQUELETOS(Calidad.COMUN),
	DESCARGA(Calidad.COMUN),
	ESPIRITUS_FUEGO(Calidad.COMUN),
	CAÑON(Calidad.COMUN),
	BOMBARDERO(Calidad.COMUN),
	TORRE_TESLA(Calidad.COMUN),
	BARBAROS(Calidad.COMUN),
	HORDA_ESBIRROS(Calidad.COMUN),
	BARBAROS_ELITE(Calidad.COMUN),
	GIGANTE_NOBLE(Calidad.COMUN),
	ESBIRROS(Calidad.COMUN),
	
	
	//CARTAS ESPECIALES
	
	MONTAPUERCOS(Calidad.ESPECIAL),
	COHETE(Calidad.ESPECIAL),
	GOLEM_HIELO(Calidad.ESPECIAL),
	CURACION(Calidad.ESPECIAL),
	MEGAESBIRRO(Calidad.ESPECIAL),
	LAPIDA(Calidad.ESPECIAL),
	DUENDE_LANZADARDOS(Calidad.ESPECIAL),
	BOLA_FUEGO(Calidad.ESPECIAL),
	HORNO(Calidad.ESPECIAL),
	VALQUIRIA(Calidad.ESPECIAL),
	ARIETE_BATALLA(Calidad.ESPECIAL),
	MINIPEKKA(Calidad.ESPECIAL),
	MOSQUETERA(Calidad.ESPECIAL),
	MAGO(Calidad.ESPECIAL),
	GIGANTE(Calidad.ESPECIAL),
	CHOZA_DUENDE(Calidad.ESPECIAL),
	TORRE_BOMBARDERA(Calidad.ESPECIAL),
	RECOLECTOR_ELIXIR(Calidad.ESPECIAL),
	CHOZA_BARBAROS(Calidad.ESPECIAL),
	TRIO_MOSQUETERAS(Calidad.ESPECIAL),
	TORRE_INFERNO(Calidad.ESPECIAL),
	
	
	
	//CARTAS EPICAS
	
	VERDUGO(Calidad.EPICA),
	ESPEJO(Calidad.EPICA),
	FURIA(Calidad.EPICA),
	TORNADO(Calidad.EPICA),
	EJERCITO_ESQUELETOS(Calidad.EPICA),
	GUARDIAS(Calidad.EPICA),
	BARRIL_DUENDES(Calidad.EPICA),
	CLON(Calidad.EPICA),
	PRINCIPE_OSCURO(Calidad.EPICA),
	HIELO(Calidad.EPICA),
	VENENO(Calidad.EPICA),
	BEBE_DRAGON(Calidad.EPICA),
	LANZARROCAS(Calidad.EPICA),
	BRUJA(Calidad.EPICA),
	GLOBO_BOMBASTICO(Calidad.EPICA),
	PRINCIPE(Calidad.EPICA),
	BALLESTA(Calidad.EPICA),
	GIGANTE_ESQUELETO(Calidad.EPICA),
	PEKKA(Calidad.EPICA),
	GOLEM(Calidad.EPICA),
	RAYO(Calidad.EPICA),
	
	
	
	
	//CARTAS LEGENDARIAS
	
	BANDIDA(Calidad.LEGENDARIA),
	MINERO(Calidad.LEGENDARIA),
	TRONCO(Calidad.LEGENDARIA),
	PRINCESA(Calidad.LEGENDARIA),
	MAGO_HIELO(Calidad.LEGENDARIA),
	DRAGON_INFERNAL(Calidad.LEGENDARIA),
	LEÑADOR(Calidad.LEGENDARIA),
	CEMENTERIO(Calidad.LEGENDARIA),
	CHISPITAS(Calidad.LEGENDARIA),
	SABUESO_LAVA(Calidad.LEGENDARIA),
	MAGO_ELECTRICO(Calidad.LEGENDARIA),
	BRUJA_NOCTURNA(Calidad.LEGENDARIA);
	




	
	
	private Calidad calidad;
	
	private Carta(Calidad calidad) {
		this.calidad=calidad;
	}

	public Calidad getCalidad() {
		return calidad;
	}
	
	
	
}
