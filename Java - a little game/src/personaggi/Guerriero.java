package personaggi;

import oggetti.ArmaInterface;
import oggetti.OggettoInterface;

public class Guerriero extends Personaggio
{


	@Override
	public void riceviAttacco() {
		
	}

	@Override
	public void equipaggiaArma(ArmaInterface a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void usaOggetto(OggettoInterface o) {
		o.Usa(this);
	}

	@Override
	public int attacco() {
		// TODO Auto-generated method stub
		return 0;
	}

}
