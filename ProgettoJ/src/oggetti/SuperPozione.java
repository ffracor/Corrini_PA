package oggetti;

//simile a pozione ma è una superpozione
public class SuperPozione extends Cura
{
	public SuperPozione()
	{
		PV = 40;
		nome = "Superpozione";
		descrizione = "Cura 40 PV";
		costo = 25;
	}

	@Override
	public int getCosto() {
		return costo;
	}
}
