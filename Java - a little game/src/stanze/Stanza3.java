package stanze;

import mostri.FactoryMostro;
import mostri.MostroInterface;

public class Stanza3 extends Stanza{
	@Override
	public MostroInterface creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}

}
