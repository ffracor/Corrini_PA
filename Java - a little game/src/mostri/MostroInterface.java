package mostri;

import oggetti.OggettoInterface;

public interface MostroInterface 
{
	//sferra un attacco al nemico ritornando il danno
	public int attacco();	
	
	//subisce un attacco dal nemico ritornando true se muore e false se è ancora vivo,
	//aggiornando i PV
	public boolean riceviAttacco(int danno);
	
	//ottiene il drop dal mostro
	public OggettoInterface getDrop() throws SenzaOggettoException;
	public int getExp();
	
	public String getNome();
	
}
