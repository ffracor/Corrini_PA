package personaggi;

import java.util.List;

import oggetti.ArmaInterface;
import oggetti.OggettoInterface;
import oggetti.inventario.Inventario;

public abstract class Personaggio implements PersonaggioInterface
{
	protected int PV;
	protected ArmaInterface arma;
	protected int livello;
	protected int expNextLivello;
	
	protected List<OggettoInterface> inventario;
	
	@Override
	public void aggiornaPV(int delta) {
		PV += delta;
	}
	
	//da vedere
	@Override
	public void stampaInventario() {
		int i = 0;
		for (OggettoInterface o : inventario) {
			System.out.println(i + ": " + o.getNome());
		}
	}
	
	
}
