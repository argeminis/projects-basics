package es.argenis.proyectofinal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vinilo {
	
	/*
	 * CLASS VINILO: define características propias de formato vinilo
	 * 
	 * Los datos que definen un tipo de vinilo (revoluciones por minuto,
	 * diametro) varían; por eso decidí crear un atributo "vinilo" que fuese
	 * definido como objeto vinilo
	 * Las opciones para DIAMETRO y RPM son las que he encontrado de referencia
	 * 	 
	 */
	
	private static Scanner teclado;
	String diametro, rpm;
	
	public String getDiametro() {
		return diametro;
	}

	public String getRpm() {
		return rpm;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public void setRpm(String rpm) {
		this.rpm = rpm;
	}
	
	@Override
	public String toString() {
		return "Vinilo [diametro=" + diametro + ", rpm=" + rpm + "]";
	}

	//Para leer los datos del vinilo
	public static Vinilo leeDatos() {
	
		Vinilo vinilo= new Vinilo();	
			
		teclado=  new Scanner(System.in);
		
	try{
		
		//Seleccionnado diametro...
		String error= "Por favor, seleccione una opción válida.";
		
		String opc1= "7\"(17.5cm)";
		String opc2= "10\"(25cm)";
		String opc3= "12\"(30cm)";
		
		System.out.println("Diámetro:");
		System.out.println("");
		System.out.println("1. ["+opc1+"] 2. ["+opc2+"] 3. ["+opc3+"]");
		int selecciondiametro= teclado.nextInt();
		
		switch(selecciondiametro) {//...seleccionando RPM (segun diametro (cada 'case')
		
		case 1:
	
			vinilo.setDiametro(opc1);
			
			String opc11="16 r.p.m";
			String opc12="33 1/3 r.p.m";
			String opc13="45 r.p.m";
			
			System.out.println("R.P.M para "+opc1+"(diámetro):");
			System.out.println("");
			System.out.println("1. ["+opc11+"] 2. ["+opc12+"] 3. ["+opc13+"]");
			
			int seleccionRPM1= teclado.nextInt();
				
				switch (seleccionRPM1) {
				case 1:
					
					vinilo.setRpm(opc11);
					break;
					
				case 2:
					
					vinilo.setRpm(opc12);					
					break;
					
				case 3:
					
					vinilo.setRpm(opc13);
					break;
					
				default:
					
					System.out.println(error);
					System.out.println("");
					
					break;
				
				}
			
			break;
			
		case 2:
			
			vinilo.setDiametro(opc2);
			
			String opc21="78 r.p.m";
			String opc22="33 1/3 r.p.m";
			
			System.out.println("R.P.M para "+opc2+"(diámetro):");
			System.out.println("");
			System.out.println("1. ["+opc21+"] 2. ["+opc22+"]");
			
			int seleccionRPM2= teclado.nextInt();
			
			switch (seleccionRPM2) {
			case 1:
				
				vinilo.setRpm(opc21);
				break;
				
			case 2:
				
				vinilo.setRpm(opc22);					
				break;
				
			default:
				
				System.out.println(error);
				System.out.println("");
				
				break;
			}
			
			break;
			
		case 3:
			
			vinilo.setDiametro(opc3);
			
			String opc31="78 r.p.pm";
			String opc32="16 r.p.m";
			String opc33="45 r.p.m";
			String opc34="33 1/3 r.p.m";
			
			System.out.println("R.P.M para "+opc3+"(diámetro):");
			System.out.println("");
			System.out.println("1. ["+opc31+"] 2. ["+opc32+"] 3. ["+opc33+"] 4. ["+opc34+"]");
			
			int seleccionRPM3= teclado.nextInt();
			
			switch (seleccionRPM3) {
			case 1:
				
				vinilo.setRpm(opc31);
				break;
				
			case 2:
				
				vinilo.setRpm(opc32);					
				break;
				
			case 3:
				
				vinilo.setRpm(opc33);
				break;
	
			case 4:
				
				vinilo.setRpm(opc34);
				break;
				
			default:
				
				System.out.println(error);
				System.out.println("");
				
				break;
				
			}
			
			break;
		
		default:
			
			System.out.println(error);
			System.out.println("");
			
			break;
			
		}
		
	} catch (InputMismatchException e) {//...vigila que no haya error de inserción según el dato solicitado
		
		System.out.println("Error en la inserción de datos.");
		System.out.println("Por favor, asegúrese de introducir SEGUN el tipo de datos requeridos.");
		System.out.println("");
		return null;
		
	}
		
	return vinilo;
	
	}
	
}