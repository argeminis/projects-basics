package es.argenis.proyectofinal;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CLASS LISTACLIENTES: define atributos y metodos para el objeto listaClientes.
 * EXTIENDE a la clase CLIENTE porque guarda objetos de tipo CLIENTE.
 * IMPLEMENTA la interface ACCION porque, al ser una lista, existen acciones que
 * debe poder efectuar (tanto esta clase como cualquier otra que se pudiese añadir
 * del mismo tipo) de manera estandarizada
 * 
 */

public class listaClientes extends Cliente implements Accion {
	
	static Scanner teclado= new Scanner(System.in); 
	ArrayList<Cliente> listadoClientes=  new ArrayList<Cliente>();

	//Para pedir UN UNICO codigo
	@Override
	public int leeCodigo() {
		
		System.out.println("Codigo de cliente:");
		int codigoleido= teclado.nextInt();
		return codigoleido;		
	}
	
	//Para AÑADIR un objeto cliente VALIDO
	public void crear() {
		
		Cliente clienteValido= Cliente.leeDatos();
		
		if(clienteValido!=null)
			listadoClientes.add(clienteValido);	
		
	}

	//Para imprimir en pantalla los objetos cliente
	@Override
	public void listar() {
		
		System.out.println("");
		
		if (listadoClientes.isEmpty()) {
	 
			System.out.println("No existen clientes que mostrar.");
		
		} else { 
		
			for (int i = 0; i < listadoClientes.size(); i++) { 
				
				System.out.println(listadoClientes.get(i)); }
		}
		
		System.out.println(""); 
	
	}

	//Para eliminar UN unico objeto cliente y enseñar su informacion en pantalla
	@Override
	public Cliente eliminar(int codigo) {
		
		System.out.println("Eliminado el cliente con código "+codigo+" descrito a continuación:");
		
		for (int i = 0; i < listadoClientes.size(); i ++){
		   
			Cliente clienteselecto = listadoClientes.get(i);
		    
			if (clienteselecto.getCodigoCliente()==(codigo)) {
				
				System.out.println(clienteselecto);
				System.out.println("");
				
		        listadoClientes.remove(i);
		        
		        break;
		        
		    	}  		
			}
		
		return null;
	}

	//Para buscar UN unico objeto cliente
	@Override
	public Cliente buscar(int codigo) {
		
		for (int i = 0; i < listadoClientes.size(); i ++){
			   
			Cliente clienteselecto = listadoClientes.get(i);
		    
			if (clienteselecto.getCodigoCliente()==(codigo)) {
		        listadoClientes.get(i);
		        return clienteselecto;
		        
		    	}  		
			}
		
		return null;
	}

}