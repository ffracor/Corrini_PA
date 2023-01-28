package personaggi;

import oggetti.ArmaInterface;
import oggetti.OggettoInterface;

public interface PersonaggioInterface 
{
	public int attacco();
	public boolean riceviAttacco(int danno);
	public void equipaggiaArma(ArmaInterface a);
	public void usaOggetto(OggettoInterface o);
	public void usaOggetto(int i);
	public void aggiornaPV(int delta);
	public void stampaInventario();
	public void ottieniOggetto(OggettoInterface o);
	public boolean aggiungiExp(int exp);
	public int getLivello();
}
