package oggetti.armi;

import oggetti.Oggetto;
import personaggi.PersonaggioInterface;

//tutte le spade riutilizzano questo codice
//essendo un'arma un oggetto decido di riutilizzare anche il codice di oggetto
public abstract class Spada extends Oggetto implements ArmaInterface
{
	protected int danno;
	
	@Override
	public void usa(PersonaggioInterface p) {
		System.out.println("Non succede niente..");
		
	}
	
	@Override
	public int getAttacco() {
		return danno;
	}
}
