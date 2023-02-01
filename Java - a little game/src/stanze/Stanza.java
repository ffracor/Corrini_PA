package stanze;

import java.util.Scanner;

import mostri.MostroInterface;
import mostri.SenzaOggettoException;
import mostri.boss.GenioOscuro;
import oggetti.OggettoInterface;
import partita.Input;
import personaggi.PersonaggioInterface;

public abstract class Stanza implements StanzaInterface
{
	protected String nome;
	protected StanzaInterface successiva;
	protected StanzaInterface precedente;
	protected int countBattaglie;
	protected boolean bossSconfitto;
	
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

	@Override
	public boolean finalBattle(PersonaggioInterface p) {
		return battle(p, new GenioOscuro());
	}

	
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
	
	@Override
	public boolean Battaglia(PersonaggioInterface p)
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
				case 3: System.out.println("Sei fuggito!");
						return false;
				default: System.out.println("Comando errato");
			}
		}
	}

}
