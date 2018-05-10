package es.unican.is2.practica6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Clase que representa una tienda con un conjunto de vendedores y
 * que permite llevar la gestion de las ventas realizadas y las
 * comisiones asignadas a cada vendedor.
 * Los datos de la tienda se almacenan en un fichero de texto denominado
 * datosTienda.txt.
 *
 * @author MP
 * @version mayo-18
 *
 */
public class Tienda {

	private LinkedList<Vendedor> vendedores = new LinkedList<Vendedor>();
	private List<Vendedor> resultado = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	/**
	 * Crea la tienda sin ningun vendedor asociado
	 *
	 * @param direccion Direccion de la tienda
	 * @param nombre Nombre de la tienda
	 */
	public Tienda(String nombre, String direccion) {
		this.direccion = direccion;
		this.nombre = nombre;
		vendedores();
	}

	public Tienda() {
		vendedores();
	}

	/**
	 * Retorna la direccion de la tienda
	 *
	 * @return Direccion de la tienda
	 */
	public String direccion() {
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 *
	 */
	public String nombre() {
		return nombre;
	}

	/**
	 * Anade un nuevo vendedor a la tienda
	 *
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido
	 *         false si ya habra un vendedor con el mismo dni
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) {
		Vendedor v = buscaVendedor(nuevoVendedor.getDni());
		if (v != null) {
			return false;
		}
		vendedores.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parametro
	 *
	 * @param dni
	 * @return true si se elimina el vendedor
	 *         false si no existe ningun vendedor con el dni indicado
	 */
	public boolean eliminaVendedor(String dni) {
		Vendedor v = buscaVendedor(dni);
		if (v == null) {
			return false;
		}
		vendedores.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Anade una venta a un vendedor
	 *
	 * @param dni DNI del vendedor
	 * @param importe Importe de la venta
	 * @return true si se anade la venta
	 *         false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String dni, double importe) {
		Vendedor v = buscaVendedor(dni);
		if (v == null) {
			return false;
		}
		v.anhadeVenta(importe);
		vuelcaDatos();
		return true;
	}
	
	/**
	 * Retorna el vendedor con el DNI indicado
	 *
	 * @param dni CNI del vendedor
	 * @return vendedor con ese DNI o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String dni) {
		
		for (Vendedor v : vendedores) { 
			if (v.getDni().equals(dni)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * @return La lista de vendedores
	 */
	public void vendedores() {

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader("datosTienda.txt"));
			// configura el formato de numeros
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			String nombretmp;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) {

				nombretmp = in.next();
				in.next();
				String dniIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombretmp, dniIn, TipoVendedor.JUNIOR);
				ven.setTotalVentas(totalVentas);
				vendedores.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Practicas")) {
				nombretmp = in.next();
				in.next();
				String dniIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPracticas(nombretmp, dniIn);
				ven.setTotalVentas(totalVentas);
				vendedores.add(ven);
			}
			while (in.hasNext()) {
				in.next();
				nombretmp = in.next();
				in.next();
				String dniIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombretmp, dniIn, TipoVendedor.SENIOR);
				ven.setTotalVentas(totalVentas);
				vendedores.add(ven);
			}
			
		} catch (FileNotFoundException e) {
			Logger.getLogger("No se puede abrir el fichero");
		} finally {
			if (in != null) {
				in.close();
			}
		} // try

	}
	
	/**
	 * Metodo que genera el fichero datosTienda.txt con los datos actualizados
	 * de los vendedores
	 */
	private void vuelcaDatos() {
		//Este metodo no hay que hacerle
	}
	
	public List<Vendedor> vendedorMaxComision() {
		
		double maxComision= 0.0;
		for (Vendedor v : vendedores) {
			if (v.getComisionAcumulada() > maxComision) {
				maxComision = v.getComisionAcumulada();
				resultado.clear();
				resultado.add(v);
			} else if (v.getComisionAcumulada() == maxComision) {
				resultado.add(v);
			}
		}
		 
		return resultado;
	}
	
	public List<Vendedor> vendedorDelMes() {
		
		double maxVentas = 0.0;
		for (Vendedor v : vendedores) {
			if (v.getTotalVentas() > maxVentas) {
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) {
				resultado.add(v);
			}
		}
		
		return resultado;
	}

}
