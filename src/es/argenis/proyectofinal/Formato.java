package es.argenis.proyectofinal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Formato {
	
	/*
	 * CLASS FORMATO: define atributos y metodos de cada objeto Formato
	 * 
	 * Decidí crear esta clase teniendo presente los siguientes conceptos:
	 * 
	 *  - Formato: DISPOSICIÓN de los datos para su almacenamiento, visualización o impresión.
	 *  - Soporte: DISPOSITIVO destinado a registrar o grabar información, imágenes o sonido.
	 * 
	 * Puesto que la música no puede ser un objeto EN LA REALIDAD, hemos de definir EL MEDIO FÍSICO
	 * que contendrá, en todo caso, UNA GRABACION de la misma. De ahí que definiese esta clase, pues
	 * hoy día existen diferentes SOPORTES que difieren en su FORMATO
	 * 
	 */
	
	private static Scanner teclado;
	boolean analogico, digital;	
	Vinilo formatoVinilo;//Soporte específico
	
	String soporteFISICO,ESanalogico,ESdigital, 
	//Lineas para mensajes de error
	inputErrorLinea1="Error en la inserción de datos.",
	inputErrorLinea2="Por favor, asegúrese de introducir SEGUN el tipo de datos requeridos.",
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
				+ (formatoVinilo != null ? "Descripción de " + formatoVinilo
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
		System.out.println("(introduzca su elección [1,2,3,4])");
		System.out.println(" ");
		
	}
	
	//Para leer opcion (numérica)
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
	
	//Para asignar un String a cada opcion numérica 
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

			System.out.println("Por favor, seleccione una de las opciones VÁLIDAS.");
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
	String mensajeDatosMinutos="Duración total (en minutos):";
	String a="analógico";
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
				
				//Es la unica opción que tiene diferentes formas 
				Vinilo formatoVinilo= Vinilo.leeDatos();
				
					if(formatoVinilo!=null)
						formato.setFormatoVinilo(formatoVinilo);
						
				formato.setAnalogico(true);
				formato.setESanalogico(a);
				formato.setESdigital(null);
				formato.setSoporteFISICO("VINILO");
				
			break;
			
			case "CASETE":
				
				System.out.println("Cinta analógica/digital (a/d):");
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

		//EL formato analógico no es finito, como el digital
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
