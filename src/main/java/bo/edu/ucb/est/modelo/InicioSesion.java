package bo.edu.ucb.est.modelo;

import java.util.Scanner;

public class InicioSesion implements Pantalla{
	
	private Banco banco;
	private Cliente cliente;
	private Scanner read;
	
	private String cod;
	private String pin;
	public InicioSesion(Banco banco)
	{

		this.banco=banco;
		read=new Scanner(System.in);
		
	}
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println("Ingrese su codigo de cliente");
		cod=read.next();
		System.out.println("Ingrese su pin: ");
		pin=read.next();
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		for(int i=0;i<25;i++)
		{
			System.out.println();
		}
		
	}

	@Override
	public void disponer() {
		// TODO Auto-generated method stub
		read.close();	
	}
	
	public Cliente iniciarSesion()
	{
		do
		{
			mostrar();
			if(validarDatos(cod,pin))
			{
				limpiar();
				return cliente;
			}
				
		}while(true);
			
	}
	public boolean validarDatos(String cod,String pin)
	{
		this.cliente=banco.buscarClientePorCodigo(cod, pin);
		if(this.cliente!=null)
		{
			return true;
		}
		return false;
	}
}
