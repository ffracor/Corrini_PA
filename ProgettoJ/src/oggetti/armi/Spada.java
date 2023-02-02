package oggetti.armi;

import oggetti.Oggetto;
import personaggi.PersonaggioInterface;

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
