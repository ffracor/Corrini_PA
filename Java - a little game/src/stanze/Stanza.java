package stanze;

import java.util.Scanner;

import mostri.FactoryMostro;
import mostri.MostroInterface;
import mostri.SenzaOggettoException;
import oggetti.OggettoInterface;
import personaggi.PersonaggioInterface;

public abstract class Stanza implements StanzaInterface
{
	private Scanner sc;
	
	public Stanza()
	{
		 Scanner sc = new Scanner(System.in);

	}
	
	@Override
	public boolean Battaglia(PersonaggioInterface p) {
		MostroInterface m = creaMostro();
		System.out.println("Inizia la battaglia contro " + m.getNome() + "!");
		
		while(true)
		{
			System.out.println("1-Attacca");
			System.out.println("2-Usa oggetto");
			System.out.println("3-Fuggi");
			int i = sc.nextInt();
		
			switch(i)
			{
				case 1: if(m.riceviAttacco(p.attacco()))
						{
							System.out.println(m.getNome() + " muore!");
							try
							{
								OggettoInterface o = m.getDrop();
								System.out.println("Ottieni " + o.getNome());
								p.ottieniOggetto(o);
							}
							catch(SenzaOggettoException so) {}

							if(p.aggiungiExp(m.getExp()))
								System.out.println("Sei arrivato al livello " + p.getLivello());
							return false;
						};
						if(p.riceviAttacco(m.attacco()))
						{
							System.out.println("Sei morto..");
							System.out.println();
							System.out.println("GAME OVER");
							return true;
						}
						break;
				case 2:
						p.stampaInventario();
						i = sc.nextInt();
						p.usaOggetto(i);
						
						if(p.riceviAttacco(m.attacco()))
						{
							System.out.println("Sei morto..");
							System.out.println();
							System.out.println("GAME OVER");
							return true;
						}
						break;
				case 3: System.out.println("Sei fuggito!");
						return false;
				default: System.out.println("Comando errato");
			}
		}
	}

}
