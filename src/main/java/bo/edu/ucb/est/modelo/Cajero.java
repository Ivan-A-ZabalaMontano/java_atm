/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est.modelo;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ecampohermoso
 */
public class Cajero{
	private Banco banco;
	private Cliente cliente;
	private List<Cuenta> cuentas;
	private Cuenta cuenta;
	
	private InicioSesion inicio;
	private Menu opciones;
	private Menu verCuentas;
	

	public Cajero(Banco banco)
	{
		this.banco=banco;
		System.out.println("Bienvenido al Banco "+banco.getNombre());
		iniciarSesion();
		
		
	}
	public void agregarOpciones()
	{
		opciones= new Menu();
		opciones.agregarOpcion("Ver Saldo");
		opciones.agregarOpcion("Retirar dinero");
		opciones.agregarOpcion("Depositar dinero");
		opciones.agregarOpcion("Salir");
		verCuentas= new Menu();
		for(int i=0;i<cuentas.size();i++)
		{
			verCuentas.agregarOpcion(cuentas.get(i).getTipo());
		}
		verCuentas.agregarOpcion("Atras");
	}
	public void iniciarSesion()
	{
		cliente=null;
		cuentas=null;
		cuenta=null;
		inicio= new InicioSesion(this.banco);
		cliente=inicio.iniciarSesion();
		cuentas=cliente.getCuentas();
		agregarOpciones();
		menuPrincipal();
	}
	public void menuPrincipal()
	{
		opciones.elegirOpcion();
		if(opciones.getEleccion()+1!=opciones.getOpciones().size())
		{
			menuCuentas();
			tipoTransferencia(opciones.getEleccion()+1);
		}
		else
		{
			iniciarSesion();
		}
	}
	public void menuCuentas()
	{
		verCuentas.elegirOpcion();
		if(verCuentas.getEleccion()+1!=verCuentas.getOpciones().size())
		{
			cuenta= cuentas.get(verCuentas.getEleccion());
		}
		else
		{
			menuPrincipal();
		}
	}
	public void tipoTransferencia(int tipo)
	{
		if(tipo==1)
		{
			System.out.println("Moneda: "+cuenta.getMoneda());
			System.out.println("Tipo de cuenta: "+cuenta.getTipo());
			System.out.println("Saldo disponible: "+cuenta.getSaldo());
		}
		else 
		{
			System.out.println("Saldo disponible: "+cuenta.getSaldo());
			Scanner read = new Scanner(System.in);
			System.out.println("Ingrese la cantidad: ");
			double cantidad= read.nextDouble();
			if(tipo==2)
			{
				if(cuenta.retirar(cantidad))
				{
					System.out.println("Saldo disponible: "+cuenta.getSaldo());
					System.out.println("Retiro exitoso");
				}
				else
				{
					System.out.println("No se pudo completar la transferencia");
				}
			}
			else
			{
				if(cuenta.depositar(cantidad))
				{
					System.out.println("Saldo disponible: "+cuenta.getSaldo());
					System.out.println("Deposito exitoso");
				}
				else
				{
					System.out.println("No se pudo completar la transferencia");
				}
			}
			//read.close();
		}
		menuPrincipal();
		
	}


	
}
