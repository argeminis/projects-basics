package es.argenis.proyectofinal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * CLASS LISTAVENTAS: define atributos y metodos para el objeto listaVentas.
 * EXTIENDE a la clase VENTA porque guarda objetos de tipo VENTA.
 * IMPLEMENTA la interface ACCION porque, al ser una lista, existen acciones que
 * debe poder efectuar (tanto esta clase como cualquier otra que se pudiese añadir
 * del mismo tipo) de manera estandarizada
 * 
 */

public class listaVentas extends Venta implements Accion{

	static Scanner teclado= new Scanner(System.in); 
	Date fecha= new Date();//devuelve la fecha de sistema
	String archivoventas= "VENTAS";//nombre archivo en /src
	ArrayList<Venta> listaVentas= new ArrayList<Venta>();
	FileReader reader;//lector (abrir)
	FileWriter writer;//escritor (abrir)
	BufferedWriter buffwriter;
	BufferedReader buffreader;	

	//Para pedir UN UNICO codigo
	@Override
	public int leeCodigo() {
		
		System.out.println("Codigo de venta:");
		int codigoleido= teclado.nextInt();
		
		return codigoleido;
	}

	//Para AÑADIR un objeto venta VALIDO
	public void crear(Cliente clienteVentaActual, CompraCliente compraClienteVentaActual) {
		
			if((clienteVentaActual!=null)&&(compraClienteVentaActual!=null))
				listaVentas.add(Venta.leerDatos(clienteVentaActual, compraClienteVentaActual));

	}

	//Para imprimir en pantalla los objetos venta
	@Override
	public void listar() {
		
		System.out.println("");
		
		if (listaVentas.isEmpty())
			System.out.println("No existen ventas registradas.");
		
		for (int i = 0; i < listaVentas.size(); i++) {
			
			System.out.println(listaVentas.get(i)); 
			
        } 
		
		System.out.println("");
	}

	//Para eliminar UN unico objeto venta y enseñar su informacion en pantalla antes de dicha accion
	@Override
	public Venta eliminar(int codigo) {
		
		System.out.println("Eliminada la venta con código "+codigo+" descrita a continuación:");
		
		for (int i = 0; i < listaVentas.size(); i ++){
		   
			Venta ventaselecta = listaVentas.get(i);
		    
			if (ventaselecta.getCodigoventa()==(codigo)) {
				
				System.out.println(ventaselecta);
				System.out.println("");
				
		        listaVentas.remove(i);
		        
			}
		}
		
		return null;
	}

	//Para buscar UN unico objeto venta
	@Override
	public Venta buscar(int codigo) {
		
		for (int i = 0; i<listaVentas.size(); i ++){
			   
			Venta ventaselecta= listaVentas.get(i);
		    
			if (ventaselecta.getCodigoventa()==(codigo)) {
		        listaVentas.get(i);		        
		        return ventaselecta;
		        
		    	} 		
			}
		
		return null;
	}
	
	//Para abrir y leer el archivo 
	public void abrirLeerArchivo() throws IOException {
		
		try {
			
			reader = new FileReader(archivoventas);//lector (abrir)			
			buffreader = new BufferedReader(reader);//buffer de lectura
			
			//Lee las lineas que no esten en blanco
			String linea;
			while ((linea = buffreader.readLine())!=null)	
				// (no es igual asignar la operacion a una variable
				// a hacer la misma dentro de la comprobacion)
			
				System.out.println(linea);
				
			
		} catch (FileNotFoundException e) {//si no encuentra el archivo...
			
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		
		} finally {//cierra el archivo y el buffer de lectura del mismo
				
			reader.close();  
			buffreader.close();
		
		}
	}
	
	//Para abrir y escribir en el archivo
	public void escribeVENTAS() throws IOException {
		
	try {
			reader = new FileReader(archivoventas);//lector (abrir)		
			writer = new FileWriter(archivoventas);//buffer de escritura
			
			writer.write(fecha.toString()); //Añade fecha y hora en que se realiza la accion (Venta)
				
				// Selecciona cada venta existente...
				for (int i = 0; i < this.listaVentas.size(); i++) {
					
					Venta ventaselecta = this.listaVentas.get(i);
					
					//... y escribe los datos devueltos
					writer.write(ventaselecta.getCodigoventa());
					writer.write("\n");
					writer.write(ventaselecta.getClienteVentaActual().toString());
					writer.write("\n");
					writer.write(ventaselecta.getCompratemp().listaCompraCliente.toString());
					writer.write("\n");
					
				}
				
				System.out.println("Información añadida al archivo de texto.");
			
		} catch (FileNotFoundException e) {//si no encuentra el archivo
			
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		
		} finally {//cierra el archivo y el buffer de escritura del mismo
				
			reader.close();  
			writer.close();
		
		}
		
	}

}