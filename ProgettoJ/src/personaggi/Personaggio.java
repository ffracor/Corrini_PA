package personaggi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import oggetti.OggettoInterface;
import oggetti.armi.ArmaInterface;
import partita.Input;

//implementa il codice base del personaggio che sarà riutilizzato dalle varie classi
public abstract class Personaggio implements PersonaggioInterface
{
	//campi di un personaggio per gestire i livelli, vita, attacco, denaro, arma, inventario
	protected int PV;
	protected int PVMax;
	protected ArmaInterface arma;
	protected int livello;
	protected int expNextLivello;
	protected int exp;
	protected int attacco;
	protected int denaro;
	protected ArrayList<OggettoInterface> inventario;
	//necessario sia globale per la lambda function
	private int i;
	
	public int getPV()
	{
		return PV;
	}
	//costruttore che inizializza il personaggio
	public Personaggio()
	{
		attacco = 5;
		expNextLivello = 10;
		inventario = new ArrayList<>();
		PVMax = 30;
		denaro = 0;
		exp = 0;
		PV = PVMax;
		livello = 0;
	}
	
	@Override
	public void aggiornaPV(int delta) {
		PV += delta;
		if (PV > PVMax) PV = PVMax;
	}
	
	//permette di eseguire operazioni con l'inventario e gli oggetti
	@Override
	public void gestioneInventario() {
		
		//usa lambda function per stampare gli oggetti dell'inventario
		i = 0;
		System.out.println("Inventario: ");
		inventario.stream().forEach(x -> {System.out.println(i + " - " + x.getNome()); i++;});
		int scelta;

		//operazioni possibili
		do
		{
			System.out.println("Cosa vuoi fare?");
			System.out.println("1-Usare un oggetto");
			System.out.println("2-Ordinare l'inventario");
			System.out.println("3-Leggere la descrizione dell'oggetto"); 
			System.out.println("4-Chiudere l'inventario");
		
			scelta = Input.getInput().readInt();
			
			switch(scelta)
			{
				case 1:
						System.out.println("Seleziona oggetto");
						int o = Input.getInput().readInt();
						this.usaOggetto(o);
						break;
				case 2: 
						Collections.sort(inventario); //uso il metodo di collections e il compareTo di oggetto
						break;
				case 3: System.out.println("Seleziona oggetto");
						int o1 = Input.getInput().readInt();
						System.out.println("Descrizione: " + inventario.get(o1));
						break;
				case 4: break;
				default: System.out.println("inserire valore valido");
			}
		}while(scelta <= 0 || scelta > 4);
	}
	
	//overload
	@Override
	public void usaOggetto(OggettoInterface o) {
		o.usa(this);
	}

	@Override
	public int attacco() {
		return attacco + arma.getAttacco();
	}

	@Override
	public boolean riceviAttacco(int danno) {
		PV -= danno;
		if(PV <= 0) return true;
		return false;
	}

	//overload
	@Override
	public void usaOggetto(int i) {
		if(inventario.get(i) instanceof ArmaInterface) usaOggetto(inventario.get(i));
		else usaOggetto(inventario.remove(i));
	}

	@Override
	public void ottieniOggetto(OggettoInterface o) {
		inventario.add(o);	
	}

	//gestione dei livelli e dell'esperienza
	@Override
	public void aggiungiExp(int exp) {
		this.exp -= exp;
		while (this.exp <= 0)
		{
			this.exp = expNextLivello - Math.abs(this.exp);
			expNextLivello += 0.5*expNextLivello;
			livello ++;
			attacco += 2;
			PVMax += 5;
			System.out.println("Livello " + livello + " raggiunto!!");
		}
	}	
	
	public void aggiungiDenaro(int d)
	{
		denaro += d;
	}

	public boolean rimuoviDenaro(int d)
	{
		if ((denaro - d) < 0) return false;
		denaro -= d;
		return true;
	}
}
