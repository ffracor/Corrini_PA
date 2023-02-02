package oggetti;

//ridefinisce cura solo con il costruttore per inizializzare i campi
public class Pozione extends Cura
{
	public Pozione()
	{
		PV = 20;
		nome = "Pozione";
		descrizione = "Cura 20 PV";
		costo = 10;
	}

}
