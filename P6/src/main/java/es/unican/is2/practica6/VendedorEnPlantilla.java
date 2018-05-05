package es.unican.is2.practica6;


public class VendedorEnPlantilla extends Vendedor {
	
	private static final double COMISION_SENIOR = 0.01;
	private static final double COMISION_JUNIOR = 0.005;
	private TipoVendedor tipo;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String dni, TipoVendedor tipo) {
		super(nombre, dni);
		this.tipo = tipo;
		if (tipo== TipoVendedor.JUNIOR)
			porcentajeComision(COMISION_JUNIOR);
		else 
			porcentajeComision(COMISION_SENIOR);
	}
	
	public TipoVendedor tipo() {
		return tipo;
	}
}
