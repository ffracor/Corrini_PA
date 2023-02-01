package personaggi;

import java.util.List;
import java.util.Scanner;

import oggetti.armi.Spada;
import partita.Input;
import oggetti.OggettoInterface;
import oggetti.armi.ArmaInterface;
import oggetti.armi.LamaDelDeserto;

public class Guerriero extends Personaggio
{

	private int i;
	
	public Guerriero()
	{
		arma = new LamaDelDeserto();
		inventario.add(arma);
	}

	@Override
	public void equipaggiaArma() {
		i = 0;
		System.out.println("Quale spada vuoi equipaggiare?");
		List<OggettoInterface> armi = inventario.stream().filter(x -> (x instanceof Spada)).toList();
		armi.stream().forEach(x -> {System.out.println(i + " - " + x.getNome()); i++;});
		int scelta = Input.getInput().readInt();
		arma = (Spada)armi.get(scelta);
	}

	
}
