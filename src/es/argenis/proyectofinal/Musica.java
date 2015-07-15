package es.argenis.proyectofinal;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * CLASS MUSICA: define atributos y metodos de cada objeto Musica
 * 
 */

public class Musica extends Formato{
																			
	String artista, album;
	Formato soporte;									
	float precio; //puede cambiar segun el formato
	public static int numMusica= 0;//codigo de autoincremento (al crear el objeto)
	int ano, codigoMusica; 
	private static Scanner teclado;
	
	public int getCodigoMusica() {
		return codigoMusica;
	}
	public String getArtista() {
		return artista;
	}
	public String getAlbum() {
		return album;
	}
	public int getAno() {
		return ano;
	}		
	public float getPrecio() {
		return precio;
	}
	
	public Formato getSoporte() {
		return soporte;
	}
	public void setSoporte(Formato soporte) {
		this.soporte = soporte;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public void setCodigoMusica(int codigoMusica) {
		this.codigoMusica = codigoMusica;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	//Para escribir (String) el valor de cada objeto MUSICA
	@Override
	public String toString() {
		return "Musica [C�d:" + codigoMusica + ", artista=" + artista
				+ ", album=" + album + ", a�o=" + ano + ", precio=" + precio
				+ ", " + soporte + "";
	}
	
	//Para definir atributos especificos a cada Objeto Musica	
	public static Musica leeDatos() {
		
		teclado = new Scanner(System.in);
		Musica musica= new Musica();
		
	try {	
			System.out.println("Nombre del artista:");
			musica.setArtista(teclado.nextLine());
			System.out.println("T�tulo del �lbum:");
			musica.setAlbum(teclado.nextLine());
	
			teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
			
			System.out.println("A�o de publicaci�n:");
			musica.setAno(teclado.nextInt()); 
			
			teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
			
			System.out.println("PRECIO:");
			musica.setPrecio(teclado.nextFloat());	
			teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
	
			musica.PintarMenuSoporte();
			String eleccion= musica.SeleccionMenuSoporte(musica.leerOpcion());
			
				if(eleccion!=null) {
					
					musica.setSoporteFISICO(eleccion);
					
					musica.setSoporte(musica.leeFormato(eleccion));
				
				}
			

		} catch (InputMismatchException error) {//si se introducen datos que no coinciden en TIPO con los que se solicitan...
			
			System.out.println("Error en la inserci�n seg�n tipo de datos");
			System.out.println("(Por favor, aseg�rese de introducir los datos seg�n el tipo v�lido que se solicita).");
			System.out.println(" ");
			
			return null;
			
		}
	
		musica.setCodigoMusica(numMusica);
		numMusica++;
		
		teclado.reset();//"Limpia" el estado del teclado (ventajoso porque hemos de introducir diferentes tipos de datos)
		
		System.out.println("Se ha creado el art�culo de m�sica ["+musica.artista+" - "+musica.album+"] con el c�digo ["+musica.codigoMusica+"]");
		
		return musica; 
		
	}
	
}