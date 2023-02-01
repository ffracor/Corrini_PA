package oggetti;

import personaggi.PersonaggioInterface;

public interface OggettoInterface extends Comparable<OggettoInterface>
{
	public void usa(PersonaggioInterface p);
	public String getNome();
	public String getDescrizione();
	public int getCosto();
	
}
