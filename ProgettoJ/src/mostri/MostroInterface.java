package mostri;

import oggetti.OggettoInterface;
import personaggi.PersonaggioInterface;

public interface MostroInterface 
{
	//sferra un attacco al nemico ritornando il danno
	public int attacco();	
	
	//subisce un attacco dal nemico ritornando true se muore e false se è ancora vivo,
	//aggiornando i PV
	public boolean riceviAttacco(int danno);
	
	//ottiene il drop dal mostro l'esperienza il denaro e il nome
	public OggettoInterface getDrop(PersonaggioInterface p) throws SenzaOggettoException;
	public int getExp();
	public int getDenaro();
	public String getNome();
	
}
