package mostri.boss;

import mostri.SenzaOggettoException;
import oggetti.OggettoInterface;
import oggetti.armi.BraccialeStelle;
import oggetti.armi.Chronicle2;
import personaggi.Guerriero;
import personaggi.PersonaggioInterface;

public class Seymour implements BossInterface{

	int PV = 70;
	
	@Override
	public int attacco() {
		return 13;
	}

	@Override
	public boolean riceviAttacco(int danno) {
		PV -= danno;
		if(PV <= 0) return true;
		return false;
	}

	@Override
	public OggettoInterface getDrop(PersonaggioInterface p) throws SenzaOggettoException {
		if (p instanceof Guerriero) return new Chronicle2(); 
		return new BraccialeStelle();
	}

	@Override
	public int getExp() {
		return 100;
	}

	@Override
	public int getDenaro() {
		return 80;
	}

	@Override
	public String getNome() {
		return "Seymour";
	}

}
