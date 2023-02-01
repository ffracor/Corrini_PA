package stanze;

import mostri.FactoryMostro;
import mostri.MostroInterface;
import mostri.boss.Rhapthorne;
import mostri.boss.Seymour;

public class Stanza2 extends Stanza{
		
	@Override
	public MostroInterface creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}
	
	public Stanza2(StanzaInterface s)
	{
		nome = "Dedalo della spada";
		successiva = s;
		precedente = null;
	}
		
	@Override
	public Seymour creaBoss() {
		return new Seymour();
	}
}
