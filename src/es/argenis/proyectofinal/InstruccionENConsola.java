package es.argenis.proyectofinal;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * CLASS INSTRUCCIONENCONSOLA: define atributos y metodos para el objeto INSTRUCCION
 * en PRINCIPAL; por encapsulacion decidí diseñar un programa que reaccionase de maneras
 * específicas ante los datos introducidos, que en este caso tambien serian las instrucciones.
 * Esta clase posee metodos que cambian el estado del objeto INSTRUCCION y dicho estado
 * dicta el comportamiento del programa en la clase PRINCIPAL.
 * 
 */

public class InstruccionENConsola {

	private static Scanner teclado;//Leer datos desde teclado
	String accion, entidad;// acccion: QUÉ se debe hacer - entidad: CON QUÉ se debe hacer
	Integer codigo;	// argumento que se puede introducir, o no, a determinadas instrucciones
					// ejemplo: eliminar cliente [1] (se pasa como argumento un numero [codigo] para eliminar)
	
	public void setAccion(String accion) {
		this.accion = accion;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}		

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getAccion() {
		return accion;
	}

	public String getEntidad() {
		return entidad;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	//Lee CUALQUIER tipo de cadena
	public String leerInstruccion () {
	
		teclado = new Scanner(System.in);
		System.out.println("");
		System.out.println("Esperando instrucción:(?)");
		String textoLeido= teclado.nextLine();
		
		textoLeido = textoLeido.toUpperCase();//Para evitar cargar el codigo con comprobaciones de mayusculas y minusculas
		teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
		
		return textoLeido; }
	
	//Lee instrucciones de tipo seleccion, entre S y N (SI, No)
	public boolean leerInstruccionSN(int opcionInstruccion) {		
					
		teclado = new Scanner(System.in);
		boolean test=true; boolean j= false;
		
		//opcionInstruccion define si la orden está en estado de: [1] repetir ; [2] reescribir
		if(opcionInstruccion==1)
			System.out.println("¿Desea repetir esta orden? ["+this.getAccion()+" "+this.getEntidad()+"] S/N");
		
			do {
				String txtR= teclado.nextLine();
			
				//El metodo equalsIgnoreCase facilita la lectura de un único caracter
				if (txtR.equalsIgnoreCase("N")) {
					test=false;
					j= true; }
				
				else if (txtR.equalsIgnoreCase("S")) {
					test=true;
					j=true; }
				
				else
					System.out.println("Solo se permiten los caracteres 'S' o 'N'.");		
					
				} while (j==false);		
			
		teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
		
		return test;
	}
	
	//Comprueba si un caracter es numérico
	public static boolean isNumber(String string) {
		
		if(string==null||string.isEmpty()) {
			return false;
		  }
		  
		int i=0;
		if(string.charAt(0)=='-') {
			if (string.length() > 1) {
				
				i++;
		    } else {
		    	
		    	return false;
		   }
		}
		
		for (; i < string.length(); i++) {
		   if (!Character.isDigit(string.charAt(i))) {
			return false;
		    
		   }
		   
		} return true;
	}
	
	//Analiza si la cadena introducida tiene el formato correcto para ser una instruccion
	public InstruccionENConsola analizarTextoLeido(String textoLeido) {

			InstruccionENConsola instruccionENConsola= new InstruccionENConsola();
		
			// Divide la cadena en 'señales', o 'pruebas' individuales separadas,
			// de forma predeterminada por el espacio en blanco (aunque esto se podria cambiar)
			StringTokenizer tmptxt= new StringTokenizer(textoLeido);
	    	
			//Cuenta el numero de 'palabras'
			int numPalabras = tmptxt.countTokens();
			int erroraccionentidad = 0;//informa del tipo de error con un int
			
			// COMPRUEBA QUE LAS PALABRAS COINCIDAN CON LAS INSTRUCCIONES POSIBLES
			// EN EL FORMATO ADECUADO
			if (numPalabras==1) {	
				
				switch (textoLeido) {			
					case "CERRAR": case "?":
	
						instruccionENConsola.setAccion(textoLeido);
						break;
					
					default:
						erroraccionentidad=4;
						instruccionENConsola.setAccion(null);
											
					}
				
			} else if ((numPalabras==2)||(numPalabras==3)) {
					
					//Guarda el valor de cada 'palabra' individualizada por StringTokenizer
					accion= tmptxt.nextToken();//palabra 1
					entidad= tmptxt.nextToken();//palabra 2	
					
					//Comprueba si se ha introducido una tercera 'palabra' (argumento para instrucciones)
					if (tmptxt.hasMoreTokens()) {
					
						String codigoString= tmptxt.nextToken();
						
						if (InstruccionENConsola.isNumber(codigoString)==true) { //si es un caracter numerico...
						
							codigo = Integer.parseInt(codigoString); //convierte a Integer
							instruccionENConsola.setCodigo(codigo); //asigna el codigo a la instruccion actual
							
							// (al haber pasado el numero como argumento de
							// la instruccion ejecutará DIRECTAMENTE la orden)
							
						} else if ((InstruccionENConsola.isNumber(codigoString)==false)) {//si no es un caracter numerico...
							
							codigo= null;
							erroraccionentidad=5;
							instruccionENConsola.setCodigo(null);
						}
					
					}
					
					//Comprueba que cada palabra COINCIDA con el valor que se busca que tenga su variable
					switch (accion) {     		
					case "CREAR": case "LISTAR": case "ELIMINAR": case "BUSCAR":    				    				
							
							instruccionENConsola.setAccion(accion);
							break;
							
						default:					
							erroraccionentidad= 1;
							instruccionENConsola.setAccion(null);
								
						}
					
					switch (entidad) {    		
						case "CLIENTE": case "MUSICA": case "VENTA":    				    				
		
							instruccionENConsola.setEntidad(entidad);
							break;
					
						default:
						
							if (erroraccionentidad==1) erroraccionentidad=3;
							else erroraccionentidad=2;
							instruccionENConsola.setEntidad(null);
					
					}					
					
				} else erroraccionentidad=4;
			
			//Informa en pantalla del tipo de error 
			switch (erroraccionentidad) {			
			case 1: 
				
				System.out.println("Por favor, revise la PRIMERA palabra en la orden.");			
				break;
	
			case 2:
				
				System.out.println("Por favor, revise la SEGUNDA palabra en la orden.");				
				break;
			
			case 3:    				
				
				System.out.println("Lo sentimos, pero las palabras introducidas NO SE RECONOCEN como órdenes válidas.");								
				break;
				
			case 4:
				
				System.out.println("Por favor, verifique que el formato de la instrucción es el correcto.");					
				break;
				
			case 5:
				
				System.out.println("Por favor, asegúrese de introducir un número entero como argumento.");					
				break;
				
				}

			return instruccionENConsola;
				
			}
		
}