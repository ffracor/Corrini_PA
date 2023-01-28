package stanze;

import mostri.FactoryMostro;
import mostri.MostroInterface;

public class Stanza1 extends Stanza{

	@Override
	public MostroInterface creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}
}
