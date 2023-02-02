package mostri;

import stanze.StanzaInterface;
import oggetti.Pozione;
import oggetti.SuperPozione;
import stanze.Stanza1;
import stanze.Stanza2;
import stanze.Stanza3;

//classe secondo il factory pattern che quando invocata restituisce un mostro casuale in 
//base alla stanza
public class FactoryMostro 
{
	//singleton pattern per avere una sola istanza
	static FactoryMostro fm = null;
	private FactoryMostro(){}
	
	public static FactoryMostro getFactoryMostro()
	{
		if(fm == null)
			fm = new FactoryMostro();
		return fm;
	}
	
	//in base alla stanza viene scelto il metodo adeguato che restituisce specifici mostri
	public Mostro getMostro(Stanza1 s)
	{
		int N = (int) (Math.random()*3 - 0.001);
		
		switch(N)
		{
			case 0: return new Mostro(new DatiMostro("Slime", 1, 5, 3, 5, new Pozione()));
			case 1: return new Mostro(new DatiMostro("Himarra", 2, 6, 4, 8, null));
			case 2: return new Mostro(new DatiMostro("Tombarry", 3, 8, 5, 7, new Pozione()));
		};
		
		return null;
	}
	
	public Mostro getMostro(Stanza2 s)
	{
		int N = (int) (Math.random()*3 - 0.001);
		
		switch(N)
		{
			case 0: return new Mostro(new DatiMostro("Vampistrello", 6, 10, 5, 12, null));
			case 1: return new Mostro(new DatiMostro("Gemron", 8, 11, 7, 12, new Pozione()));
			case 2: return new Mostro(new DatiMostro("Unioculum", 10, 14, 8, 12, new SuperPozione()));
		};
		
		return null;
	}
	
	public Mostro getMostro(Stanza3 s)
	{
		int N = (int) (Math.random()*3 - 0.001);
		
		switch(N)
		{
			case 0: return new Mostro(new DatiMostro("Re slime grigio", 40, 60, 5, 21, new SuperPozione()));
			case 1: return new Mostro(new DatiMostro("Vanguard mk2", 15, 20, 12, 17, new Pozione()));
			case 2: return new Mostro(new DatiMostro("Tombarry", 20, 25, 15, 23, new SuperPozione()));
		};
		
		return null;
	}
}
