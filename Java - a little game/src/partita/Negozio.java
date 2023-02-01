package partita;

import java.util.Scanner;

import oggetti.OggettoInterface;
import oggetti.Pozione;
import oggetti.SuperPozione;
import oggetti.armi.BraccialePlatino;
import oggetti.armi.ReIsola;
import personaggi.PersonaggioInterface;

public class Negozio 
{
	private static Negozio n = null;
	
	private Negozio()
	{
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
		System.out.println("3 - Re dell'isola: 150 zehn");
		System.out.println("4 - Bracciale di platino: 150 zehn");
		System.out.println("0 - Esci dal negozio");
		
		int i = Input.getInput().readInt();
		OggettoInterface o;
		switch(i)
		{
			case 1: o = new Pozione();
					if(p.rimuoviDenaro(o.getCosto()))
					{
						System.out.println("Hai acquistato una pozione!");
						p.ottieniOggetto(o);
					}
					else System.out.println("Non hai abbastanza denaro");
					break;
			case 2:
					o = new SuperPozione();
					if(p.rimuoviDenaro(o.getCosto()))
					{
						System.out.println("Hai acquistato una Superpozione!");
						p.ottieniOggetto(o);
					}
					else System.out.println("Non hai abbastanza denaro");
				break;
			case 3:
					o = new ReIsola();
					if(p.rimuoviDenaro(o.getCosto()))
					{
						System.out.println("Hai acquistato la Re dell'Isola!");
						p.ottieniOggetto(o);
					}
					else System.out.println("Non hai abbastanza denaro");
					break;
			case 4:
					o = new BraccialePlatino();
					if(p.rimuoviDenaro(o.getCosto()))
					{
						System.out.println("Hai acquistato un Bracciale di Platino!");
						p.ottieniOggetto(o);
					}
					else System.out.println("Non hai abbastanza denaro");
					break;
			case 0: System.out.println("Grazie per aver visitato il negozio!"); return;
			default: System.out.println("Oggetto selezionato non valido");
		}
		
		menuNegozio(p);	
	}
}
