package mostri;

public class Slime extends Mostro
{
	public Slime()
	{
		PV = 8 + (int) Math.random()%4; //vita randomica tra 8 e 12
	}
	
	@Override
	public int attacco() {
		return 1;
	}
}
