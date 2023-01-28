package oggetti;

public abstract class Oggetto implements OggettoInterface
{
	protected String nome;
	protected String descrizione;
	
	@Override
	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public String getNome() {
		return nome;
	}
}
