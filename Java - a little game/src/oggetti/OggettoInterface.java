package oggetti;

import personaggi.PersonaggioInterface;

public interface OggettoInterface extends Comparable<OggettoInterface>
{
	public void Usa(PersonaggioInterface p);
	public String getNome();
	public String getDescrizione();
	public int getCosto();
	
}
