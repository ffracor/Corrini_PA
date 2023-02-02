package mostri.boss;

import mostri.SenzaOggettoException;
import oggetti.OggettoInterface;
import personaggi.PersonaggioInterface;

public class GenioOscuro implements BossInterface
{
	int PV = 200;
	@Override
	public int attacco() {
		return 0;
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
		return 0;
	}

	@Override
	public int getDenaro() {
		return 0;
	}

	@Override
	public String getNome() {
		return "Genio Oscuro";
	}

}
