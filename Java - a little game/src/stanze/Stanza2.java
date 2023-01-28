package stanze;

import mostri.FactoryMostro;
import mostri.MostroInterface;

public class Stanza2 extends Stanza{
	@Override
	public MostroInterface creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}

}
