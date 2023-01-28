package partita;

import java.util.Scanner;

import personaggi.Guerriero;
import personaggi.PersonaggioInterface;
import stanze.Stanza1;
import stanze.StanzaInterface;

public class Partita 
{
	private Scanner sc;
	
	public Partita()
	{
		 Scanner sc = new Scanner(System.in);
	}

	public void game()
	{
		StanzaInterface s = new Stanza1();
		PersonaggioInterface p = new Guerriero();
		while (true)
		{
			System.out.println("Sei nella stanza n. " + s.getNome());
			System.out.println("Cosa vuoi fare?");
			System.out.println("1-Combatti contro un mostro");
			System.out.println("2-Apri il negozio");
			if(s.bossAvibile())
				System.out.println("3-Combatti boss");
			if(s.stanzaSuccessivaAvible())
				System.out.println("3-Vai alla stanza successiva");
			if(s.stanzaPrecedenteAvible())
				System.out.println("4-Vai alla stanza precedente");
			System.out.println("5-Visualizza l'inventario");
			System.out.println("6-Equipaggia un'arma");
			if(s.isLastStanza() && s.bossFinaleAvible())
				System.out.println("12-Combatti il boss finale");
			
			int i = sc.nextInt();
			switch(i)
			{
				case 1: if (s.Battaglia(p)) return; break;
				case 2: Negozio.getNegozio().menuNegozio(p); 
				case 3: break; //TODO boss battle or successiva
				case 4: if(s.stanzaPrecedenteAvible()) s = s.getStanzaPrecedente();
				case 12: if(s.isLastStanza() && s.bossFinaleAvible()); //TODO boss finale
			};
		}
	}
}
