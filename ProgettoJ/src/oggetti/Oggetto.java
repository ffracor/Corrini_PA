package oggetti;

import oggetti.armi.ArmaInterface;
import personaggi.PersonaggioInterface;

//definisce il codice generale degli oggetti che può essere riutilizzato da altre classi
//implementa compareTo per permettere l'ordinamento: gli oggetti generici vengono prima delle armi,
//per il resto si usa l'ordine alfabetico
public abstract class Oggetto implements OggettoInterface
{
	//campi di un oggetto, protected per essere visibili alle sottoclassi che ereditano il codice
	//e che li ridefiniscono
	protected String nome;
	protected String descrizione;
	protected int costo;
	
	@Override
	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public int getCosto()
	{
		return costo;
	}
	
	@Override 
	public void usa(PersonaggioInterface p)
	{
		System.out.println("Non puoi usare questo oggetto");
	}
	
	@Override
	public int compareTo(OggettoInterface o) {
		if(this instanceof ArmaInterface && !(o instanceof ArmaInterface)) return 1;
		if(o instanceof ArmaInterface && !(this instanceof ArmaInterface)) return -1;
		return this.getNome().compareTo(o.getNome());
	}

}
