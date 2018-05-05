package es.unican.is2.practica6;


/**
 * Vendedor de la tienda, con sus datos personales y datos de ventas y comisiones
 */
public abstract class Vendedor {
	
	private String dni;
	private String nombre;
	
	// Porcentaje para el calculo de la comision 
	// por ventas que se lleva el vendedor
	private double porcentajeComision;
	
	// Comision mensual acumulada por el trabajador
	private double comisionAcumulada;
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double totalVentas;
	
	public Vendedor(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public Vendedor (String nombre, String dni, double comision) {
		this.nombre = nombre;
		this.dni = dni;
		this.porcentajeComision = comision;
	}

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Retorna la comision acumulada por el vendedor
	 * @return comision Comision acumulada por ventas
	 */
	public double getComisionAcumulada() {
		return comisionAcumulada;
	}
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {
		return totalVentas;
	}
	
	/**
	 * Modifica el porcentaje de comision 
	 * @param porcentajeComision Nuevo valor del porcentaje
	 */
	public void porcentajeComision(double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	/** Metodo que asigna el total de ventas mensual de un vendedor
	 *  y calcula su correspondiente comision
	 * @param totalVentas
	 */

	public void setTotalVentas (double totalVentas) {
		this.totalVentas = totalVentas;
		this.comisionAcumulada = totalVentas * porcentajeComision;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhadeVenta(double importe){
		totalVentas += importe;
		comisionAcumulada = comisionAcumulada + importe*porcentajeComision;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vendedor)) 
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.dni.equals(dni) && v.nombre.equals(nombre));
	}
	
}
