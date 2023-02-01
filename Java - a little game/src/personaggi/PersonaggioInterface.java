package personaggi;

import oggetti.OggettoInterface;
import oggetti.armi.ArmaInterface;

public interface PersonaggioInterface 
{
	public int attacco();
	public boolean riceviAttacco(int danno);
	public void equipaggiaArma();
	public void usaOggetto(OggettoInterface o);
	public void usaOggetto(int i);
	public void aggiornaPV(int delta);
	public void gestioneInventario();
	public void ottieniOggetto(OggettoInterface o);
	public void aggiungiExp(int exp);
	public void aggiungiDenaro(int d);
	public boolean rimuoviDenaro(int d);
	public int getPV();
}
