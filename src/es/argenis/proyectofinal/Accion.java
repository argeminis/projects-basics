package es.argenis.proyectofinal;

/* 
 * La interface la diseñé para unificar qué acciones existían en común que pudiesen ser sobreescritas.
 * No incluyo la accion "CREAR" pues la forma en que se crean los objetos difiere.
 * La uso para saber qué aplicaciones puede tener una interface, así como entender su uso, ventajas y desventajas.
 *
 */

public interface Accion {

	int leeCodigo();
	
	void listar();
	
	Object eliminar(int codigo);
	
	Object buscar(int codigo);
	
}
