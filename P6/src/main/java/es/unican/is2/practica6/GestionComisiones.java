package es.unican.is2.practica6;

import java.util.List;

import fundamentos.*;

/**
 * Gestion de las comisiones de vendedores de una tienda
 * @author MP
 * @version mayo-18
 */
public class GestionComisiones {

	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) {
		// opciones del menu
		final int NUEVA_VENTA = 0;
		final int VENDEDOR_DEL_MES = 1;
		final int VENDEDOR_MAX_COMISION = 2;
		final int SALIR = -1;

		// variables auxiliares
		String dni;
		Lectura lect;
		List<Vendedor> resultado;
		StringBuilder bld = new StringBuilder();

		// crea la tienda
		Tienda tienda = new Tienda();
		tienda.vendedores();
		
		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("Anadir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedor con mas comision", VENDEDOR_MAX_COMISION);
		int opcion = 0;

		// lazo de espera de comandos del usuario
		while(opcion != SALIR) {
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			switch (opcion) {
			case NUEVA_VENTA:
				lect = new Lectura("Datos Venta");
				lect.creaEntrada("DNI Vendedor", "");
				lect.creaEntrada("Importe", "");
				lect.esperaYCierra();
				dni = lect.leeString("DNI Vendedor");
				double importe = lect.leeDouble("Importe");
				if (!tienda.anhadeVenta(dni, importe)) {
					mensaje("ERROR", "El vendedor no existe");
				}
				break;

			case VENDEDOR_DEL_MES:
				resultado = tienda.vendedorDelMes();
				bld.delete(0, bld.length());
				for (Vendedor vn : resultado) {
					bld.append(vn.getNombre());
					bld.append("\n");
				}
				mensaje("VENDEDORES DEL MES", bld.toString());
				break;
			
			case VENDEDOR_MAX_COMISION:
				resultado = tienda.vendedorMaxComision();
				bld.delete(0, bld.length());
				for (Vendedor v : resultado) {
					bld.append(v.getNombre());
					bld.append("\n");
				}
				mensaje("VENDEDORES MAXIMA COMISION", bld.toString());
				break;
			
			default:
				opcion = SALIR;
				break;
			}
		}
	}

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * @param titulo titulo de la ventana
	 * @param txt texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) {
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}

}
