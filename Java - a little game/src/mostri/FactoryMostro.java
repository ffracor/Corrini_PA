package mostri;

import stanze.StanzaInterface;
import stanze.Stanza1;
import stanze.Stanza2;
import stanze.Stanza3;

public class FactoryMostro 
{
	static FactoryMostro fm = null;
	private FactoryMostro(){}
	
	public static FactoryMostro getFactoryMostro()
	{
		if(fm == null)
			fm = new FactoryMostro();
		return fm;
	}
	
	//Pseudo Visitor Pattern (dispatch sulla stanza)
	public MostroInterface getMostro(Stanza1 s)
	{
		int N = (int) (Math.random()*3 - 0.001);
		
		switch(N)
		{
			case 0: return new Slime();
			case 1: return new Himarra();
			case 2: return new Tombarry();
		};
		
		return null;
	}
	
	public MostroInterface getMostro(Stanza2 s)
	{
		int N = (int) (Math.random()*3 - 0.001);
		
		switch(N)
		{
			case 0: return new Vampistrello();
			case 1: return new Gemron();
			case 2: return new Unioculum();
		};
		
		return null;
	}
	
	public MostroInterface getMostro(Stanza3 s)
	{
		int N = (int) (Math.random()*3 - 0.001);
		
		switch(N)
		{
			case 0: return new ReSlimeGrigio();
			case 1: return new VanguardMk2();
			case 2: return new Behemoth();
		};
		
		return null;
	}
}
