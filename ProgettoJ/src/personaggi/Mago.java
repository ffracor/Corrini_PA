package personaggi;

import java.util.List;
import java.util.Scanner;

import oggetti.OggettoInterface;
import oggetti.armi.Bracciale;
import oggetti.armi.BraccialeBandito;
import oggetti.armi.Spada;
import partita.Input;

//definisce i metodi specifici del mago
public class Mago extends Personaggio
{
	private int i;

	public Mago()
	{
		//arma iniziale del mago
		arma = new BraccialeBandito();
		inventario.add(arma);
	}
	//metodo per cambiare equipaggiamento, seleziona dall'inventario con una lambda function
	//i bracciali che il mago può equipaggiare
	@Override
	public void equipaggiaArma() {
		i = 0;
		System.out.println("Quale spada vuoi equipaggiare?");
		List<OggettoInterface> armi = inventario.stream().filter(x -> (x instanceof Bracciale)).toList();
		armi.stream().forEach(x -> {System.out.println(i + " - " + x.getNome()); i++;});
		int scelta = Input.getInput().readInt();
		arma = (Bracciale)armi.get(scelta);
	}

}
