package oggetti.armi;

import oggetti.Oggetto;
import personaggi.PersonaggioInterface;

//arma del mago, il suo codice verrà riutilizzato dalle armi che ridefiniscono i campi dell'oggetto
//(da cui eredita la maggior parte del codice)
public abstract class Bracciale extends Oggetto implements ArmaInterface
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
