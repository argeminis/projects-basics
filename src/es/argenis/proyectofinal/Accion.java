package es.argenis.proyectofinal;

/* 
 * La interface la dise�� para unificar qu� acciones exist�an en com�n que pudiesen ser sobreescritas.
 * No incluyo la accion "CREAR" pues la forma en que se crean los objetos difiere.
 * La uso para saber qu� aplicaciones puede tener una interface, as� como entender su uso, ventajas y desventajas.
 *
 */

public interface Accion {

	int leeCodigo();
	
	void listar();
	
	Object eliminar(int codigo);
	
	Object buscar(int codigo);
	
}
