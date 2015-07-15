package es.argenis.proyectofinal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Formato {
	
	/*
	 * CLASS FORMATO: define atributos y metodos de cada objeto Formato
	 * 
	 * Decid� crear esta clase teniendo presente los siguientes conceptos:
	 * 
	 *  - Formato: DISPOSICI�N de los datos para su almacenamiento, visualizaci�n o impresi�n.
	 *  - Soporte: DISPOSITIVO destinado a registrar o grabar informaci�n, im�genes o sonido.
	 * 
	 * Puesto que la m�sica no puede ser un objeto EN LA REALIDAD, hemos de definir EL MEDIO F�SICO
	 * que contendr�, en todo caso, UNA GRABACION de la misma. De ah� que definiese esta clase, pues
	 * hoy d�a existen diferentes SOPORTES que difieren en su FORMATO
	 * 
	 */
	
	private static Scanner teclado;
	boolean analogico, digital;	
	Vinilo formatoVinilo;//Soporte espec�fico
	
	String soporteFISICO,ESanalogico,ESdigital, 
	//Lineas para mensajes de error
	inputErrorLinea1="Error en la inserci�n de datos.",
	inputErrorLinea2="Por favor, aseg�rese de introducir SEGUN el tipo de datos requeridos.",
	inputErrorLinea3=" ";
	Integer MB, duracionMINUTOS;

	@Override
	public String toString() {
		return "["
				+ (soporteFISICO != null ? "soporte=" + soporteFISICO
						+ ", " : "")
				+ (ESanalogico != null ? "" + ESanalogico + ", "
						: "")
				+ (ESdigital != null ? "" + ESdigital + ", " : "")
				+ (formatoVinilo != null ? "Descripci�n de " + formatoVinilo
						+ ", " : "")
				+ (MB != null ? "MB=" + MB + ", " : "")
				+ (duracionMINUTOS != null ? "duracion(min)="
						+ duracionMINUTOS : "") + "]";
	}

	public String getESanalogico() {
		return ESanalogico;
	}

	public String getESdigital() {
		return ESdigital;
	}

	public void setESanalogico(String eSanalogico) {
		ESanalogico = eSanalogico;
	}

	public void setESdigital(String eSdigital) {
		ESdigital = eSdigital;
	}

	public Vinilo getFormatoVinilo() {
		return formatoVinilo;
	}

	public Integer getMB() {
		return MB;
	}

	public Integer getDuracionMINUTOS() {
		return duracionMINUTOS;
	}

	public void setFormatoVinilo(Vinilo formatoVinilo) {
		this.formatoVinilo = formatoVinilo;
	}

	public void setMB(Integer mB) {
		MB = mB;
	}

	public void setDuracionMINUTOS(Integer duracionMINUTOS) {
		this.duracionMINUTOS = duracionMINUTOS;
	}

	public boolean isAnalogico() {
		return analogico;
	}

	public boolean isDigital() {
		return digital;
	}

	public void setAnalogico(boolean analogico) {
		this.analogico = analogico;
	}

	public void setDigital(boolean digital) {
		this.digital = digital;
	}

	public String getSoporteFISICO() {
		return soporteFISICO;
	}

	public void setSoporteFISICO(String soporte) {
		this.soporteFISICO = soporte;
	}

	public void PintarMenuSoporte() {
	
		System.out.println("SOPORTE:");
		System.out.println(" ");
		System.out.println("1. CD");
		System.out.println("2. Vinilo");
		System.out.println("3. Casete");
		System.out.println("4. Archivo Digital");
		System.out.println(" ");
		System.out.println("(introduzca su elecci�n [1,2,3,4])");
		System.out.println(" ");
		
	}
	
	//Para leer opcion (num�rica)
	public Integer leerOpcion() {
		
		teclado = new Scanner(System.in);
		Integer opcionLeida;
		
	try{		
		opcionLeida= teclado.nextInt();
	
	} catch(InputMismatchException e) {
		
		System.out.println(inputErrorLinea1);
		System.out.println(inputErrorLinea2);
		System.out.println(inputErrorLinea3);
		
		return null;
	
		}	
		
		return opcionLeida;
	
	}
	
	//Para asignar un String a cada opcion num�rica 
	public String SeleccionMenuSoporte(int opcionSoporte) {

		String opcionSelecta = null;
	
		switch (opcionSoporte) {
		
		case 1:
			
			opcionSelecta="CD";
			break;
			
		case 2:

			opcionSelecta="VINILO";
			break;
			
		case 3:
			
			opcionSelecta="CASETE";
			break;
			
		case 4:
			
			opcionSelecta="ARCHIVO DIGITAL";
			break;			
		
		default:

			System.out.println("Por favor, seleccione una de las opciones V�LIDAS.");
			System.out.println("");
			break;
		
		
		}
		
		return opcionSelecta;
		
	}
	
	//Para definir atributos especificos de formato
	public Formato leeFormato(String opcionSoporte) {
		
	teclado = new Scanner(System.in);
	Formato formato= new Formato();
	
	String mensajeDatosMB="Cantidad MB (en megabyte):";
	String mensajeDatosMinutos="Duraci�n total (en minutos):";
	String a="anal�gico";
	String d="digital";
	
try {
		String eleccion= opcionSoporte;
		
		switch (eleccion) {	
			
			case "CD":
				 
				formato.setDigital(true);
				formato.setESdigital("digital");
				formato.setESanalogico(null);
				formato.setSoporteFISICO("CD");
				
			break;
		
			case "VINILO":
				
				//Es la unica opci�n que tiene diferentes formas 
				Vinilo formatoVinilo= Vinilo.leeDatos();
				
					if(formatoVinilo!=null)
						formato.setFormatoVinilo(formatoVinilo);
						
				formato.setAnalogico(true);
				formato.setESanalogico(a);
				formato.setESdigital(null);
				formato.setSoporteFISICO("VINILO");
				
			break;
			
			case "CASETE":
				
				System.out.println("Cinta anal�gica/digital (a/d):");
				String seleccion= teclado.nextLine();
				seleccion.toUpperCase();
				
				do {
					if (seleccion.equals("A")) {
						formato.setAnalogico(true);
					
						formato.setESanalogico(a);
						formato.setESdigital(null);
						
						}
						
					else if (seleccion.equals("D")) {
						formato.setDigital(true);

						formato.setESdigital(d);
						formato.setESanalogico(null);
						
						}
					
					} while ((seleccion!="A")||(seleccion!="D"));
				
				formato.setSoporteFISICO("CASETE");
				
			break;
			
			case "ARCHIVO DIGITAL":
	
				formato.setDigital(true);
				
				formato.setESdigital(d);
				formato.setESanalogico(null);
				
				formato.setSoporteFISICO("ARCHIVO DIGITAL");
				
			break;
				
			default:
				
				System.out.println("Solo se permiten las opciones propuestas.");
					
		} 

		//EL formato anal�gico no es finito, como el digital
		if(formato.isDigital()==true) {
			
			System.out.println(mensajeDatosMB);
			formato.setMB(teclado.nextInt());
			
		}
		
	System.out.println(mensajeDatosMinutos);
	formato.setDuracionMINUTOS(teclado.nextInt());
	
} catch (InputMismatchException e) {//si no se introduce el tipo de datos solicitado...
		
		System.out.println(inputErrorLinea1);
		System.out.println(inputErrorLinea2);
		System.out.println(inputErrorLinea3);
		
		return null;
		
	}
	
	return formato;
	
	}
	
}
