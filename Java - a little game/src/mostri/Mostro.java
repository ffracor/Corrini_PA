package mostri;

import oggetti.OggettoInterface;
import personaggi.PersonaggioInterface;

public class Mostro implements MostroInterface
{
	protected int PV;
	DatiMostro dati;
	
	public Mostro(DatiMostro dati)
	{
		this.dati = dati;
		PV = dati.pv();
	}
	
	@Override
	public OggettoInterface getDrop(PersonaggioInterface p) throws SenzaOggettoException
	{
		if(dati.drop() == null) throw new SenzaOggettoException();		
		return dati.drop();		
	}
	
	@Override
	public boolean riceviAttacco(int danno) 
	{
		PV -= danno;
		if(PV >= 0) return false;
		return true;
	}

	@Override
	public int attacco() {
		return dati.attacco();
	}

	@Override
	public int getExp() {
		return dati.exp();
	}

	@Override
	public String getNome() {
		return dati.nome();
	}

	@Override
	public int getDenaro() {
		return dati.denaro();
	}
}
