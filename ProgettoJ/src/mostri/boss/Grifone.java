package mostri.boss;

import mostri.SenzaOggettoException;
import oggetti.OggettoInterface;
import personaggi.PersonaggioInterface;

//definisce il boss grifone (stanza3)
public class Grifone implements BossInterface{

	int PV = 100;
	@Override
	public int attacco() {
		return 21;
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
		return 200;
	}

	@Override
	public int getDenaro() {
		return 100;
	}

	@Override
	public String getNome() {
		return "Grifone";
	}

}
