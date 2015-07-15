package es.argenis.proyectofinal;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CLASS COMPRACLIENTE: define atributos y metodos de cada objeto CompraCliente;
 * EXTIENDE a listaMusica porque solo se podrán añadir articulos que se hayan creado
 * anteriormente (no se pueden añadir objetos Musica que no existan en la PRINCIPAL)
 * 
 */

public class CompraCliente extends listaMusica implements Accion{

	ArrayList<Musica> listaCompraCliente= new ArrayList<Musica>();
	static listaMusica listaMusica;//la listaMusica que se haya creado desde la clase Principal
	private static Scanner teclado;//Leer datos desde teclado
	boolean cancelOK, compraOK;//Confirmar la cancelacion o aceptacion de una Compra
	
	public boolean isCancelOK() {
		return cancelOK; }

	public boolean isCompraOK() {
		return compraOK; }

	public void setCancelOK(boolean cancelOK) {
		this.cancelOK = cancelOK; }

	public void setCompraOK(boolean compraOK) {
		this.compraOK = compraOK; }

	public listaMusica getListaMusica() {
		return listaMusica;	}

	public void setListaMusica(listaMusica listaMusica) {
		CompraCliente.listaMusica = listaMusica; }

	//Devuelve un objeto Musica segun codigo DESDE lista CompraCliente
	public Musica buscar(int codigobusqueda) {		
		
		for (int i = 0; i< listaCompraCliente.size(); i ++){
			   
			Musica musicaselecta= listaCompraCliente.get(i);
		    
			if (musicaselecta.getCodigoMusica()==(codigobusqueda)) {
				listaCompraCliente.get(i);		        
		        return musicaselecta;
		        
		    	} 		
			}
		
		return null; }

	// Crea un objeto Musica en lista de CompraCliente
	// (no permite crear objetos que no existan en la listaMusica
	// principal)
	public void crear(Musica musica) {
		
		if(musica!=null)
			
			listaCompraCliente.add(musica);
			
	}
	
	// Elimina un objeto Musica de lista de CompraCliente 
	public Musica eliminar(int codigo) {
		
	System.out.println("Eliminado el artículo de música con código "+codigo+" descrito a continuación:");
		
	for (int i= 0; i < listaCompraCliente.size(); i++){ 
	
		if (listaCompraCliente.isEmpty()) {
			System.out.println("La lista está vacía.");
		
		} else if (i!= listaCompraCliente.size()) { 
				   
			Musica musicaselecta = listaCompraCliente.get(i);
		    if (musicaselecta.getCodigoMusica()==(codigo)) {
		    	
		    	System.out.println(musicaselecta);
				System.out.println("");		    	
		    	
		        listaCompraCliente.remove(musicaselecta);	
		        
		    	} else 
		    		
		    		System.out.println("No tiene artículos con ese código en su lista de compra.");
			}  
		}
	
	return null; 	
	
	}
	
	// Lista los objetos Musica de lista de CompraCliente
	public void listar() {
		
		if (listaCompraCliente.isEmpty())
			System.out.println("(Lista de compra vacía)");
		else 
			for (int i = 0; i < listaCompraCliente.size(); i++) {
				
				System.out.println(listaCompraCliente.get(i)); }
	}
	
	//Para definir atributos especificos a cada Objeto CompraCliente
	public static CompraCliente leeDatos(listaMusica listaMusicaTemp) {
				
		teclado = new Scanner(System.in);
		CompraCliente compratemp= new CompraCliente();
		
		//Asigna la listaMusica que haya creado el usuario desde la clase PRINCIPAL
		compratemp.setListaMusica(listaMusicaTemp);
		
		//Confirmar-Cancelar un Objeto CompraCLiente
		boolean compraOK = false, cancelOK = false;		
		
	do {
		CompraCliente.pintarMenu();//Impresion en pantalla de opciones		
		int seleccion= teclado.nextInt();
		
		switch (seleccion) {
			
			case 1://añadir objeto musica a lista CompraCliente
				
				//Objetos Musica desde listaMusica en clase PRINCIPAL
				System.out.println("MUSICA DISPONIBLE (codigo):");
				listaMusicaTemp.listar();
				
				//Añade objeto Musica si encuentra que existe al indicarle según código
				Musica musica= listaMusica.buscar(listaMusica.leeCodigo());
				compratemp.crear(musica);
				
				System.out.println("Se ha añadido "+musica.artista+" - "+musica.album+" a la lista de compra actual.");
				
				break;
			
			case 2://eliminar objeto musica de lista CompraCliente					
				
				compratemp.eliminar(listaMusica.leeCodigo());
				break;
				
			case 3://confirmar compra
				
				if(compratemp.listaCompraCliente.isEmpty()) {
					
					System.out.println("No se puede confirmar una venta vacía.");
					return null;
				
				} else { 
				
					compratemp.setCompraOK(true);
				
					return compratemp;
				}
					
			case 4://cancelar compra					
				
				compratemp.setCancelOK(true);
				
				return null;
				
			default:
				System.out.println("Solo se permiten las opciones representadas por los números.");
				
			} 
		
		CompraCliente.pintarListaCompraCliente();
		compratemp.listar();//Imprime en pantalla lo que hay en la lista CompraCliente
		
		} while ((compraOK!=true)||(cancelOK!=true));  
			
		teclado.reset();////"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
		
	return compratemp; 
	
	}
	
	private static void pintarMenu() {//MENU de opciones para CompraCliente
		
		System.out.println("COMPRA DE CLIENTE:");
		System.out.println("");
		System.out.println("1. Añadir musica a la lista actual.");
		System.out.println("2. Eliminar musica de la lista actual.");
		System.out.println("3. CONFIRMAR VENTA");
		System.out.println("4. CANCELAR VENTA");
		System.out.println("");
		System.out.println("Escriba el número de la opción elegida():");
				
	}
	
	private static void pintarListaCompraCliente() {//LISTA de COMPRACLIENTE
		
		System.out.println("");
		System.out.println("*Lista de compra:");
		
	}
	
}