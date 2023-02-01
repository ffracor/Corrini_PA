package oggetti.armi;

import oggetti.Oggetto;
import personaggi.PersonaggioInterface;

public class Bracciale extends Oggetto implements ArmaInterface
{
	protected int danno;
	
	@Override
	public void Usa(PersonaggioInterface p) {
		System.out.println("Non succede niente..");
		
	}
	
	@Override
	public int getAttacco() {
		return danno;
	}
}
