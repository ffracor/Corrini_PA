package partita;

import java.util.Scanner;

import personaggi.PersonaggioInterface;

public class Negozio 
{
	private Scanner sc;
	private static Negozio n = null;
	
	private Negozio()
	{
		Scanner sc = new Scanner(System.in);
	}
	
	public static Negozio getNegozio()
	{
		if (n == null) n = new Negozio();
		return n;
	}
	
	public void menuNegozio(PersonaggioInterface p)
	{
		System.out.println("1 - Pozione: 10 zehn");
		System.out.println("2 - Superpozione: 25 zehn");
		System.out.println("3 - Spada del cavaliere: 250 zehn");
		System.out.println("4 - Bacchetta del saggio: 250 zehn");
		System.out.println("0 - Esci dal negozio");
		
		int i = sc.nextInt();
		switch(i)
		{
			case 1: //TODO
			case 2: 
			case 0: System.out.println("Grazie per aver visitato il negozio!");
			default: System.out.println("Oggetto selezionato non valido");
		}
		
		menuNegozio(p);	
	}
}
