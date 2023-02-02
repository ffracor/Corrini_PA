package oggetti.armi;

import oggetti.OggettoInterface;

//un'arma è un oggetto ma deve avere anche il metodo getAttacco per aumentare l'attacco del 
//personaggio che la equipaggia
public interface ArmaInterface extends OggettoInterface
{
	public int getAttacco();
}
