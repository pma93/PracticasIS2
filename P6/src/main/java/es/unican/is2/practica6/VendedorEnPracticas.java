package es.unican.is2.practica6;


public class VendedorEnPracticas extends Vendedor{
	
	private static final double COMISION_PRACTICAS = 0.0;

	/**
	 * Retorna un nuevo vendedor en practicas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String dni) {
		super(nombre, dni, COMISION_PRACTICAS);
	}

}
