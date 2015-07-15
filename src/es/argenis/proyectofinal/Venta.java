package es.argenis.proyectofinal;

/*
 * CLASS VENTA: define atributos y metodos de cada objeto Venta
 * 
 */

public class Venta {
	
	static int numVenta=0;//codigo de autoincremento (cuando crea cada objeto)
	CompraCliente compratemp;//cada objeto CompraCliente se guarda en Cada Cliente
	Cliente clienteVentaActual;
	int codigoventa;	
	
	public CompraCliente getCompratemp() {
		return compratemp;
	}
	
	public void setCompratemp(CompraCliente compratemp) {
		this.compratemp = compratemp;
	}
	
	public int getCodigoventa() {
		return codigoventa;
	} 
	
	public void setCodigoventa(int codigoventa) {
		this.codigoventa = codigoventa;
	}	

	public Cliente getClienteVentaActual() {
		return clienteVentaActual;
	}

	public void setClienteVentaActual(Cliente clienteCompraActual) {
		this.clienteVentaActual = clienteCompraActual;
	}
	
	// Para definir atributos especificos a cada Objeto Venta
	// (toda venta se ha de asignar a un cliente; tambien, toda venta
	// se formaliza cuando el cliente confirma su compra [argumentos])
	
	public static Venta leerDatos (Cliente cliente, CompraCliente compratemp) {
			
			Venta venta= new Venta();
			
			//Asignamos el cliente a la venta...
			venta.setClienteVentaActual(cliente);
			System.out.println(venta.getClienteVentaActual()+":"); 
			
			if(compratemp!=null)
				
				venta.setCompratemp(compratemp);
			
				else return null;
			
			venta.setCodigoventa(numVenta);
			numVenta++;
			
			return venta;
			
		}			
	}