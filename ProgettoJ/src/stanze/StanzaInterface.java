package stanze;

import mostri.MostroInterface;
import mostri.boss.BossInterface;
import personaggi.PersonaggioInterface;

public interface StanzaInterface 
{
	//definisce i metodi che una stanza deve avere per essere tale
	public boolean battaglia(PersonaggioInterface p);
	public boolean bossBattle(PersonaggioInterface p);
	public MostroInterface creaMostro();
	public BossInterface creaBoss();
	public String getNome();
	public boolean bossAvibile();
	public boolean stanzaSuccessivaAvible();
	public StanzaInterface getStanzaPrecedente();
	public StanzaInterface getStanzaSuccessiva();
	public boolean stanzaPrecedenteAvible();
	public boolean bossFinaleAvible();
	public boolean isLastStanza();
	public boolean finalBattle(PersonaggioInterface p);
	public void setPrecedente(StanzaInterface s);
}
