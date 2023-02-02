package stanze;

import mostri.FactoryMostro;
import mostri.Mostro;
import mostri.boss.Rhapthorne;

public class Stanza1 extends Stanza{
	

	public Stanza1(StanzaInterface s)
	{
		nome = "Canale sotterraneo";
		successiva = s;
		precedente = null;
	}
	
	
	@Override
	public Mostro creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}

	@Override
	public Rhapthorne creaBoss() {
		return new Rhapthorne();
	}
}
