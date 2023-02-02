package mostri.boss;

import mostri.SenzaOggettoException;
import oggetti.OggettoInterface;
import personaggi.PersonaggioInterface;

//definisce il boss rhapthorne (stanza 1)
public class Rhapthorne implements BossInterface{

	int PV = 50;
	@Override
	public int attacco() {
		return 9;
	}

	@Override
	public boolean riceviAttacco(int danno) {
		PV -= danno;
		if(PV <= 0) return true;
		return false;
	}

	@Override
	public OggettoInterface getDrop(PersonaggioInterface p) throws SenzaOggettoException {
		throw new SenzaOggettoException();
	}

	@Override
	public int getExp() {
		return 65;
	}

	@Override
	public int getDenaro() {
		return 40;
	}

	@Override
	public String getNome() {
		return "Rhapthrone";
	}

}
