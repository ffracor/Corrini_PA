package stanze;

import mostri.MostroInterface;
import personaggi.PersonaggioInterface;

public interface StanzaInterface 
{
	public boolean Battaglia(PersonaggioInterface p);
	public MostroInterface creaMostro();
	public String getNome();
	public boolean bossAvibile();
	public boolean stanzaSuccessivaAvible();
	public StanzaInterface getStanzaPrecedente();
	public StanzaInterface getStanzaSuccessiva();
	public boolean stanzaPrecedenteAvible();
	public boolean bossFinaleAvible();
	public boolean isLastStanza();
}
