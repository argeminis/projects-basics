package es.argenis.proyectofinal;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * CLASS CLIENTE: define atributos y metodos de cada objeto Cliente
 * 
 */

public class Cliente {
	
	//Atributo que permite conocer las compras que hace cada cliente
	ArrayList<CompraCliente> listaComprasdeCliente= new ArrayList<CompraCliente>();
	String nombre, apellido;	
	public static int numcliente= 0;//Codigo autoasignado (se incrementa al crear un nuevo objeto)  
	public int codigoCliente; 
	private static Scanner teclado;//Leer datos desde teclado

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setCodigoCliente(int codigo) {
		this.codigoCliente = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}
	
	//Para escribir (String) el valor de cada objeto CLIENTE
	@Override
	public String toString() {
		return "CLIENTE [Nombre:" + nombre + ", Apellido:" + apellido
				 + ", Codigo de Cliente:"
				+ codigoCliente + ", Número de Compras="
				+ listaComprasdeCliente.size() + "]";
	}
	
	//Para comprobar si una cadena es convertible a Integer
	//(en los campos NOMBRE y APELLIDO no deberían existir)
	private static boolean isNumeric(String cadena){
		
		try {
			Integer.parseInt(cadena);
			return true;
			
		} catch (NumberFormatException nfe){
			return false;
			
		}
	}
	
	//Para definir atributos especificos a cada Objeto Cliente
	public static Cliente leeDatos() {

		teclado = new Scanner(System.in);
		Cliente cliente = new Cliente();
		String mensajeError= ("Lo sentimos, pero no se permiten caracteres numéricos.");
		
			System.out.println("Nombre de cliente:");
			String nombre= teclado.nextLine();
			
			//Comprueba si hay caracteres numéricos...
			if (Cliente.isNumeric(nombre)==false)
				
				cliente.setNombre(nombre);//si no los hay...
			
				else {
					
					System.out.println(mensajeError);
					return null;
					
				}
			
			System.out.println("Apellido de cliente:");
			String apellido= teclado.nextLine();

			//Comprueba si hay caracteres numéricos...
			if (Cliente.isNumeric(apellido)==false)
				
				cliente.setApellido(apellido);//si no los hay...
			
				else {
					
					System.out.println(mensajeError);
					return null;
					
				}
				
			cliente.setCodigoCliente(numcliente);
			numcliente++;//autoincremento de codigoCliente
			teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
			
			System.out.println("Se ha creado al cliente ["+cliente.getNombre()+"] con el código ["+cliente.getCodigoCliente()+"]");
		
		return cliente;
		
			}	
	
	//Para asignar una compra a un Objeto Cliente en particular
	public void crearCompra(CompraCliente compracliente, Cliente cliente) {
		
		if(compracliente!=null)
			cliente.listaComprasdeCliente.add(compracliente);
			
	}
}
