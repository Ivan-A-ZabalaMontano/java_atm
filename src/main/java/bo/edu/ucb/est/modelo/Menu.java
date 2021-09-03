package bo.edu.ucb.est.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Pantalla{
	private ArrayList<String> opciones;
	private Scanner read;
	private int eleccion;
	public Menu()
	{
		opciones=new ArrayList<String>();
		read= new Scanner(System.in);
	}
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		for(int i=0;i<opciones.size();i++)
		{
			System.out.println((i+1)+". "+opciones.get(i));
		}
	}
	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			System.out.println();
		}
	}
	public String getOpcion(int n)
	{
		return opciones.get(n);
	}
	@Override
	public void disponer() {
		// TODO Auto-generated method stub
		read.close();
		opciones.clear();
	}
	public ArrayList<String> getOpciones()
	{
		return opciones;
	}
	public void elegirOpcion()
	{
		try
		{
			do 
			{
				mostrar();
				eleccion=read.nextInt();
			}while(getEleccion()>opciones.size() || getEleccion()+1<=0);
		
		
		}catch(Exception e)
		{
			elegirOpcion();
		}
		limpiar();
		
	}
	public void agregarOpcion(String opcion)
	{
		opciones.add(opcion);
	}
	
	public int getEleccion()
	{
		return this.eleccion-1;
	}
}
