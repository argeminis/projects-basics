package es.argenis.proyectofinal;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CLASS LISTAMUSICA: define atributos y metodos para el objeto listaMusica.
 * EXTIENDE a la clase MUSICA porque guarda objetos de tipo MUSICA.
 * IMPLEMENTA la interface ACCION porque, al ser una lista, existen acciones que
 * debe poder efectuar (tanto esta clase como cualquier otra que se pudiese añadir
 * del mismo tipo) de manera estandarizada
 * 
 */

public class listaMusica extends Musica implements Accion {

	static Scanner teclado= new Scanner(System.in); 
	ArrayList<Musica> listadoMusica=  new ArrayList<Musica>();

	//Para pedir UN UNICO codigo
	@Override
	public int leeCodigo() {
		
		System.out.println("Codigo del artículo(música):");
		int codigoleido= teclado.nextInt();
		return codigoleido;
	}

	//Para AÑADIR un objeto musica VALIDO
	public void crear() {
		
		Musica musicaValida= Musica.leeDatos();
		
		if(musicaValida!=null)
			listadoMusica.add(musicaValida);
	 	
	}

	//Para imprimir en pantalla los objetos musica
	@Override
	public void listar() {
		
		System.out.println("");
		
		if (listadoMusica.isEmpty()) {
	 
			System.out.println("No existen productos de música que mostrar.");
		
		} else { 
		
			for (int j = 0; j < listadoMusica.size(); j++) { 
				
				System.out.println(listadoMusica.get(j)); }
		}
		
		System.out.println("");	
	}

	//Para eliminar UN unico objeto musica y enseñar su informacion en pantalla
	@Override
	public Musica eliminar(int codigo) {
		
		System.out.println("Eliminado el artículo de música con código "+codigo+" descrito a continuación:");
		
		for (int i = 0; i < listadoMusica.size(); i ++){
		   
			Musica musicaselecta = listadoMusica.get(i);
		    
			if (musicaselecta.getCodigoMusica()==(codigo)) {
				
				System.out.println(musicaselecta);
				System.out.println("");
				
		        listadoMusica.remove(i);
		        
			}
		}
		
		return null;
	}

	//Para buscar UN unico objeto musica
	@Override
	public Musica buscar(int codigo) {
		
		for (int i = 0; i<listadoMusica.size(); i ++){
			   
			Musica musicaselecta= listadoMusica.get(i);
		    
			if (musicaselecta.getCodigoMusica()==(codigo)) {
		        listadoMusica.get(i);		        
		        return musicaselecta;
		        
		    	} 		
			}
		
		return null;
	}
}