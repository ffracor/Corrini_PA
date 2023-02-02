package stanze;

import mostri.FactoryMostro;
import mostri.MostroInterface;
import mostri.boss.Grifone;
import mostri.boss.Rhapthorne;

public class Stanza3 extends Stanza{
	
	private static Stanza3 s = null;

	@Override
	public MostroInterface creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}
	
	public Stanza3()
	{
		nome = "Palazzo Fiordiluna";
		successiva = null;
		precedente = null;
	}
	

	@Override
	public Grifone creaBoss() {
		return new Grifone();
	}
}
