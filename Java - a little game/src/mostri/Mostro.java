package mostri;

import oggetti.OggettoInterface;

public abstract class Mostro implements MostroInterface
{
	protected int PV;
	protected OggettoInterface drop = null;
	protected String nome;
	
	@Override
	public OggettoInterface getDrop() throws SenzaOggettoException
	{
		if(drop == null) throw new SenzaOggettoException();		
		return drop;		
	}
	
	@Override
	public boolean riceviAttacco(int danno) 
	{
		PV -= danno;
		if(PV >= 0) return false;
		return true;
	}
}
