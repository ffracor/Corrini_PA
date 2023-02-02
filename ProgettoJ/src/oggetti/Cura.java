package oggetti;

import personaggi.PersonaggioInterface;

public abstract class Cura extends Oggetto
{
	protected int PV;
	
	@Override
	public void usa(PersonaggioInterface p) {
		p.aggiornaPV(PV);
	}

	
}
