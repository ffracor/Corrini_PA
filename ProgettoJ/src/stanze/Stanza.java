package stanze;

import java.util.Scanner;

import mostri.MostroInterface;
import mostri.SenzaOggettoException;
import mostri.boss.BossInterface;
import mostri.boss.GenioOscuro;
import oggetti.OggettoInterface;
import partita.Input;
import personaggi.PersonaggioInterface;

public abstract class Stanza implements StanzaInterface
{
	//campi di una stanza
	protected String nome;
	protected StanzaInterface successiva; //utilizzati per muoversi fra le stanze
	protected StanzaInterface precedente;
	protected int countBattaglie; //il boss è disponibile quando si ha vinto almeno 10 battaglie
	protected boolean bossSconfitto; //la stanza successiva è disponibile solo se è true
	
	public Stanza()
	{
		 countBattaglie = 0;
		 bossSconfitto = false;
	}
	
	@Override
	public void setPrecedente(StanzaInterface s)
	{
		precedente = s;
	}

	//avvia la battaglia finale con il genio oscuro
	@Override
	public boolean finalBattle(PersonaggioInterface p) {
		return battle(p, new GenioOscuro());
	}

	//per muoversi fra le stanze
	@Override
	public StanzaInterface getStanzaPrecedente()
	{
		return precedente;
	}
	@Override
	public StanzaInterface getStanzaSuccessiva()
	{
		return successiva;
	}
	
	//definisce se si può visitare la stanza successiva
	@Override
	public boolean stanzaSuccessivaAvible()
	{
		if(successiva == null) return false;
		if(!bossSconfitto) return false;
		return true;
	}
	
	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public boolean bossAvibile() {
		if(countBattaglie < 10 || bossSconfitto) return false;
		return true;
	}

	@Override
	public boolean bossFinaleAvible() {
		if(isLastStanza() && bossSconfitto) return true;
		return false;
	}

	@Override
	public boolean stanzaPrecedenteAvible()
	{
		if(precedente == null) return false;
		return true;
	}
	
	@Override public boolean isLastStanza()
	{
		if(successiva == null) return true;
		return false;
	}
	
	//battaglia
	@Override
	public boolean battaglia(PersonaggioInterface p)
	{
		countBattaglie++;
		return battle(p, creaMostro());
	}
	
	@Override public boolean bossBattle(PersonaggioInterface p)
	{
		if(battle(p, creaBoss())) return true;
		bossSconfitto = true;
		return false;
	}
	
	private boolean battle(PersonaggioInterface p, MostroInterface m) {
		System.out.println("Inizia la battaglia contro " + m.getNome() + "!");
		
		while(true)
		{
			System.out.println("Hai " + p.getPV() + " PV");
			System.out.println("1-Attacca");
			System.out.println("2-Usa oggetto");
			System.out.println("3-Fuggi");
			int i = Input.getInput().readInt();
		
			switch(i)
			{
				//si attacca. se il mostro muore ritorna true, si aggiornano le statistiche
				//del personaggio e si ritorna false (che indica che non si è morti)
				case 1: System.out.println("Attacchi il mostro!");
						if(m.riceviAttacco(p.attacco()))
						{
							System.out.println(m.getNome() + " muore!");
							try
							{
								OggettoInterface o = m.getDrop(p);
								System.out.println("Ottieni " + o.getNome());
								p.ottieniOggetto(o);
							}
							catch(SenzaOggettoException so) {}

							System.out.println("Ottieni " + m.getExp() + " di esperienza");
							System.out.println("Ottieni " + m.getDenaro() + " zehn");
							p.aggiungiExp(m.getExp());
							p.aggiungiDenaro(m.getDenaro());
							return false;
						};
						//il nemico attacca, se il mostro ti uccide si ritorna true e la partita finisce
						System.out.println("Il mostro ti colpisce!");
						if(p.riceviAttacco(m.attacco()))
						{
							System.out.println("Sei morto..");
							System.out.println();
							System.out.println("GAME OVER");
							return true;
						}
						break;
				case 2:
						//utilizzo dell'inventario. successivamente il mostro attacca
					 	System.out.println("Apri l'inventario..");
						p.gestioneInventario();
						
						System.out.println("Il mostro ti colpisce!");
						if(p.riceviAttacco(m.attacco()))
						{
							System.out.println("Sei morto..");
							System.out.println();
							System.out.println("GAME OVER");
							return true;
						}
						break;
						//gestione della fuga, la battaglia non viene contata e dal boss non si fugge
				case 3: if(m instanceof BossInterface) 
						{
							System.out.println("Non puoi fuggire dal boss!");
							break;
						}
						else
						{
							countBattaglie--;
							System.out.println("Sei fuggito!");
							return false;
						}
				default: System.out.println("Comando errato");
			}
		}
	}

}
