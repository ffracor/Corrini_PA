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

	//funzione principale che definisce il gioco
	public void game() 
	{
		//creazione delle stanze e concatenazione tra precedente e successiva
		StanzaInterface s = new Stanza3();
		s = new Stanza2(s);
		s.getStanzaSuccessiva().setPrecedente(s);
		s = new Stanza1(s);
		s.getStanzaSuccessiva().setPrecedente(s);
		//alla fine s è la prima stanza da cui inizia la partita
		
		int decisione;
		PersonaggioInterface p = null;
		//si chiede al giocatore di scegliere tra mago e guerriero finchè non inserisce 1 o 2
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
		
		//menu di gioco dove il giocatore può scegliere cosa fare
		while (true)
		{
			//stampa delle varie azioni del giocatore in base alle condizioni della partita
			//(Boss disponibile o meno, stanza successiva disponibile ecc)
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
			
			//input e switch della scelta del giocatore
			int i = Input.getInput().readInt();
			switch(i)
			{
				//i metodi delle battaglie ritornano true se il giocatore muore e false se 
				//vince la battaglia. vengono chiamati nell'if cosi se ritornano true
				//si fa ritornare la funzione game() e la partita termina
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
