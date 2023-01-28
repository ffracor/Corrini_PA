package oggetti;

import personaggi.PersonaggioInterface;

public abstract class Cura extends Oggetto
{
	protected int PV;
	
	@Override
	public void Usa(PersonaggioInterface p) {
		p.aggiornaPV(PV);
	}

	
}
