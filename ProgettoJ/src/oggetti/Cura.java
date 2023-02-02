package oggetti;

import personaggi.PersonaggioInterface;

//override del metodo usa specificando cosa fa una cura (aggiorna i PV)
public abstract class Cura extends Oggetto
{
	protected int PV;
	
	@Override
	public void usa(PersonaggioInterface p) {
		p.aggiornaPV(PV);
	}

	
}
