package partita;

import java.io.IOException;
import java.util.Scanner;

import personaggi.Guerriero;
import personaggi.Mago;
import personaggi.PersonaggioInterface;
import stanze.Stanza1;
import stanze.Stanza2;
import stanze.Stanza3;
import stanze.StanzaInterface;

public class Partita 
{
	
	public Partita()
	{
	}

	public void game() 
	{
		StanzaInterface s = new Stanza3();
		s = new Stanza2(s);
		s.getStanzaSuccessiva().setPrecedente(s);
		s = new Stanza1(s);
		s.getStanzaSuccessiva().setPrecedente(s);
		
		int decisione;
		PersonaggioInterface p = null;

		do
		{
			System.out.println("Vuoi essere un Guerriero (1) o un Mago (2) ?");
			decisione = Input.getInput().readInt();
			switch(decisione)
			{
				case 1: p = new Guerriero(); break;
				case 2: p = new Mago(); break;
				default: System.out.println("inserisci numero valido");
			}
		}while(decisione <= 0 || decisione > 2);
		
		while (true)
		{
			System.out.println("Sei nel " + s.getNome());
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
			
			int i = Input.getInput().readInt();
			switch(i)
			{
				case 1: if (s.battaglia(p)) return; break;
				case 2: Negozio.getNegozio().menuNegozio(p); break;
				case 3: if(s.bossAvibile()) {if(s.bossBattle(p)) return;}
						else if(s.stanzaSuccessivaAvible()) s= s.getStanzaSuccessiva();
						break;
				case 4: if(s.stanzaPrecedenteAvible()) s = s.getStanzaPrecedente(); break;
				case 5: p.gestioneInventario(); break;
				case 6: p.equipaggiaArma(); break;
				case 12: if(s.isLastStanza() && s.bossFinaleAvible()) 
						{
							if(!s.finalBattle(p)) System.out.println("Complimenti! Hai completato il gioco!");
							return;
						}
						else return;
			};
		}
	}
}
