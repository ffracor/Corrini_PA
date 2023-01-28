package oggetti.inventario;

import java.util.List;
import oggetti.OggettoInterface;

public class Inventario 
{
	List<OggettoInterface> inventario;
	
	public OggettoInterface rimuovi(int i)
	{
		return inventario.remove(i);
	}
	
	public void inserisci(OggettoInterface o)
	{
		inventario.add(o);
	}
	
	public void ordinaInventario()
	{
		//decideremo come ordinarlo, ad esmepio prima le armi e poi alfabetico
	}
	
	
}
