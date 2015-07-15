package es.argenis.proyectofinal;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		//Bandera para la instruccion CERRAR, que finaliza la aplicación
		boolean programa= true;
		//Bandera para re-escribir la instruccion o no
		boolean instruccionAuxiliar=false;
		
		listaClientes listaClientesTemp = new listaClientes();
		listaVentas listaVentasTemp = new listaVentas();
		listaMusica listaMusicaTemp = new listaMusica();
		
		InstruccionENConsola instruccion= new InstruccionENConsola();
				
	do {
		//Si el estado de la instruccion es NULL...
		if (instruccion.getAccion()==null) {
			
			//...leer una nueva instruccion
			instruccion= instruccion.analizarTextoLeido(instruccion.leerInstruccion());
		
		}
		
		//Si la instruccion ha sido re-escrita de forma auxiliar o el análisis de los componentes de instruccion no devuelven NULL...
		else if ((instruccionAuxiliar==true)||(instruccion.getAccion()!=null)||(instruccion.getEntidad()!=null)){

			//Se revisa el valor del argumento que se puede añadir a ciertas ordenes, se haya introducido o no
			Integer codigoConvertido = (Integer)instruccion.getCodigo();
			
			//Se ejecutan las acciones asignadas al objeto "instruccion" sobre las entidades escogidas
			//
			//SWITCH_MAESTRO:
			//
			
		try{	
			switch (instruccion.getAccion()) {

			/*
			 
			Cada bloque de accion tiene indicado "INICIO" y "FIN" dentro del SWITCH_MAESTRO
			Para añadir nuevas ACCIONES:(¡CUIDADO CON LAS LLAVES!)
			
			case "NOMBRE_ACCION":
				
				instrucciones;
															 
				break;
			
			*/
			
			case "CERRAR":
				
				System.out.println("Aplicación Terminada por el usuario.");
				programa= false;
				
				break;
				
			case "?":
				
				//Menu de ayuda: Instrucciones posibles
				System.out.println("Instrucciones posibles:");
				System.out.println("CREAR CLIENTE||MUSICA||VENTA");
				System.out.println("(crea una entidad según los parámetros que se determinen)");
				System.out.println("(NO se permite añadir un código como argumento [crear (entidad)])");
				System.out.println("");
				System.out.println("LISTAR CLIENTE||MUSICA||VENTA");
				System.out.println("(muestra las entidades creadas)");
				System.out.println("");
				System.out.println("ELIMINAR CLIENTE||MUSICA||VENTA");
				System.out.println("(elimina una entidad determinada)");
				System.out.println("(se puede añadir un código como argumento [eliminar (entidad) 1])");
				System.out.println("");
				System.out.println("?");
				System.out.println("(muestra este Menú de ayuda)");
				System.out.println("CERRAR");
				System.out.println("(finaliza la aplicación)");
				System.out.println("");
				
				instruccion.setAccion(null);
				
				break; 			 	
			
			default:
			
			//Para REPETIR y SOBREESCRIBIR la orden segun el estado del objeto "instruccion" si el usuario lo desea...	
			boolean repetirorden= false; 
			boolean ordenauxiliar=false;
			
			switch (instruccion.getAccion()) {
				case "CREAR": // INICIO --------------------------------------------------------------------------

				/*Para añadir nuevas ACCIONES sobre ENTIDADES:(¡CUIDADO CON LAS LLAVES!)
					
				case "NOMBRE_ACCION":
						
					instrucciones;
																	 
					break;
				*/
					
				//Guardará la Lista de Compra de cada Cliente...
				CompraCliente compraTemp = null;
				
				switch (instruccion.getEntidad()) {
					
					case "CLIENTE":						 
						
							listaClientesTemp.crear();
							repetirorden= instruccion.leerInstruccionSN(1);//1 - repetir
							
							if(repetirorden==true) {
							
								instruccionAuxiliar=true;
								instruccion.setEntidad("CLIENTE");
							} else
								
								instruccion.setAccion(null);//"reset" de instruccion
							
						break;
													
					case "MUSICA":	
						
							listaMusicaTemp.crear();
							repetirorden= instruccion.leerInstruccionSN(1);//1 - repetir
						
							if(repetirorden==true) {
								
								instruccionAuxiliar=true;
								instruccion.setEntidad("MUSICA");
								
							} else
								
								instruccion.setAccion(null);//"reset" de instruccion
							
						break;
						
					case "VENTA": 
						
						//Comprueba si las listas estan vacías...						
						if(listaClientesTemp.listadoClientes.isEmpty()) {
						
							System.out.println("No existen clientes actualmente.");
							System.out.println("");
							System.out.println("¿Desea CREAR un nuevo CLIENTE ahora? S/N:");
							
							ordenauxiliar=instruccion.leerInstruccionSN(2);//2 - auxiliar---false
							 
									if(ordenauxiliar==true) { 
									
										//Hace que el objeto instruccion se modifique 
										//para ejecutar DIRECTAMENTE la orden CREAR CLIENTE
										instruccionAuxiliar=true;
										instruccion.setEntidad("CLIENTE"); 
							
									} else
										
										instruccion.setAccion(null);//"reset" de instruccion
									
						} else if (listaMusicaTemp.listadoMusica.isEmpty()) {
							
							System.out.println("No existen artículos de música actualmente.");
							System.out.println("");
							System.out.println("¿Desea CREAR un nuevo artículo de MÚSICA ahora? S/N:");
							
							do{
								ordenauxiliar=instruccion.leerInstruccionSN(2);//2 - auxiliar---false
							 
										if(ordenauxiliar==true) { 
										
										//Hace que el objeto instruccion se modifique 
										//para ejecutar DIRECTAMENTE la orden CREAR MUSICA
										instruccionAuxiliar=true;
										instruccion.setEntidad("MUSICA");
										
										} else
											
											instruccion.setAccion(null);//"reset" de instruccion
										
								} while (ordenauxiliar==false);
															
						} else {// *********
							
						//Si no se ha pasado el codigo del cliente a quien se desea asignar la venta
						//Y LOS VALORES DE ACCION Y ENTIDAD NO SON NULL... 
						if ((codigoConvertido==null)&&(instruccion.getAccion()!=null)&&(instruccion.getEntidad()!=null))
								
							codigoConvertido= listaClientesTemp.leeCodigo();//se pide...
							
						//Comprueba si existe el cliente
						Cliente clienteExiste= listaClientesTemp.buscar(codigoConvertido);
						
						if (clienteExiste!=null) {//Si el cliente existe...
						
							System.out.println(clienteExiste);
							
							compraTemp= CompraCliente.leeDatos(listaMusicaTemp);
							
							}
							
							if (compraTemp!=null) {//Si se confirma la compra...								
								
								listaVentasTemp.crear(clienteExiste, compraTemp);							
								
								//Guarda la compra del cliente individualmente
								clienteExiste.crearCompra(compraTemp, clienteExiste);
								
								//Escritura en VENTAS (archivo de texto)								
								try {
									
									listaVentasTemp.escribeVENTAS();
									
								} catch (IOException e) {
									
									e.printStackTrace();
								}
																						
							} else if (clienteExiste==null) {//Si el cliente no existe...
							
							System.out.println("No existe un cliente con ese código.");
						
						} else if (compraTemp==null) {
							
							System.out.println("La compra ha sido cancelada.");
						
						}
							
							repetirorden= instruccion.leerInstruccionSN(1);//1 - repetir
							
							if(repetirorden==true) {
								
								instruccionAuxiliar=true;
								instruccion.setEntidad("VENTA");

							} else
								
								instruccion.setAccion(null);//"reset" de instruccion
							
							break;
					}//else
						
				}
			
				} break; //FIN BLOQUE ACCION CREAR----------------------------------------------------------------
											
				case "LISTAR": // INICIO -------------------------------------------------------------------------

					/*Para añadir nuevas entidades:
					
					case "NOMBRE_ENTIDAD":
						
						instrucciones;
																	 
						break;
					*/
					
					switch (instruccion.getEntidad()) {
					case "CLIENTE":
						
						listaClientesTemp.listar();
						instruccion.setAccion(null);//"reset" de instruccion
						
						break;
						
					case "MUSICA":
						
						listaMusicaTemp.listar();
						instruccion.setAccion(null);//"reset" de instruccion
						
						break;
						
					case "VENTA":
						
						try {
							
							listaVentasTemp.abrirLeerArchivo();
							
						} catch (IOException e) {
							
							System.out.println("El archivo de ventas esta vacío.");
							
						} 
						
						instruccion.setAccion(null);//"reset" de instruccion
						
						break;
											
					} break;//FIN BLOQUE ACCION LISTAR------------------------------------------------------------
					
				case "ELIMINAR": // INICIO -----------------------------------------------------------------------
					
					/*Para añadir nuevas entidades:
					
					case "NOMBRE_ENTIDAD":
						
						instrucciones;
																	 
						break;
					*/
					
					switch (instruccion.getEntidad()) {
					
					case "CLIENTE":
						
						if (codigoConvertido!=null) { //si hay un codigo guardado...
							
							listaClientesTemp.eliminar(instruccion.getCodigo());
							
						} else if (codigoConvertido==null) { //si no hay un codigo guardado... 

							listaClientesTemp.eliminar(listaClientesTemp.leeCodigo());
														
						};
						
						instruccion.setAccion(null);//"reset" de instruccion
																	 
						break;
						
					case "MUSICA":
						
						if (codigoConvertido!=null) { //si hay un codigo guardado...
							
						listaMusicaTemp.eliminar(listaMusicaTemp.leeCodigo());
						
						} else if (codigoConvertido==null) { //si no hay un codigo guardado...

							listaMusicaTemp.eliminar(listaMusicaTemp.leeCodigo());
														
						};
						
						instruccion.setAccion(null);//"reset" de instruccion
						
						break;
						
					case "VENTA":
						
						if (codigoConvertido!=null) { //si hay un codigo guardado...
							
						listaVentasTemp.eliminar(listaVentasTemp.leeCodigo());
						
						} else if (codigoConvertido==null) { //si no hay un codigo guardado...

							listaVentasTemp.eliminar(listaVentasTemp.leeCodigo());
														
						};
						
						instruccion.setAccion(null);//"reset" de instruccion

						break;	
					
					} break;//FIN BLOQUE ACCION ELIMINAR----------------------------------------------------------
					
				}//FIN BLOQUE SWITCH_MAESTRO
		
		} catch (NullPointerException e) {
			
			//"RESET" del objeto instruccion
			instruccion.setAccion(null);
			instruccion.setEntidad(null);
			instruccion.setCodigo(null);
			System.out.println("(error al crear el objeto deseado)");
			
		}
			
			}//FIN BLOQUE ELSE IF(INSTRUCCION CORRECTA) 
		
		} while (programa==true);
	
	}
	
}