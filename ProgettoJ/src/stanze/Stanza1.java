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
	
	//si ritorna un mostro specificando al factory la stanza (col this)
	@Override
	public Mostro creaMostro() 
	{
		return FactoryMostro.getFactoryMostro().getMostro(this);
	}

	//override del boss ritornato dalla stanza con covarianza del tipo
	//nell'interfaccia ritorna un MostroInterface
	@Override
	public Rhapthorne creaBoss() {
		return new Rhapthorne();
	}
}
