package personaggi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import oggetti.OggettoInterface;
import oggetti.armi.ArmaInterface;
import partita.Input;

public abstract class Personaggio implements PersonaggioInterface
{
	protected int PV;
	protected int PVMax;
	protected ArmaInterface arma;
	protected int livello;
	protected int expNextLivello;
	protected int exp;
	protected int attacco;
	protected int denaro;
	
	protected ArrayList<OggettoInterface> inventario;
	
	private int i;
	
	public int getPV()
	{
		return PV;
	}
	
	public Personaggio()
	{
		attacco = 5;
		expNextLivello = 10;
		inventario = new ArrayList<>();
		PVMax = 30;
		denaro = 0;
		exp = 0;
		PV = PVMax;
	}
	
	@Override
	public void aggiornaPV(int delta) {
		PV += delta;
		if (PV > PVMax) PV = PVMax;
	}
	
	@Override
	public void gestioneInventario() {
		
		i = 0;
		System.out.println("Inventario: ");
		inventario.stream().forEach(x -> {System.out.println(i + " - " + x.getNome()); i++;});
		int scelta;

		do
		{
			System.out.println("Cosa vuoi fare?");
			System.out.println("1-Usare un oggetto");
			System.out.println("2-Ordinare l'inventario");
			System.out.println("3-Chiudere l'inventario");
		
			scelta = Input.getInput().readInt();
			
			switch(scelta)
			{
				case 1:
						System.out.println("Seleziona oggetto");
						int o = Input.getInput().readInt();
						this.usaOggetto(o);
						break;
				case 2: 
						Collections.sort(inventario);
						break;
				case 3: break;
				default: System.out.println("inserire valore valido");
			}
		}while(scelta <= 0 || scelta > 3);
	}
	
	@Override
	public void usaOggetto(OggettoInterface o) {
		o.Usa(this);
	}

	@Override
	public int attacco() {
		return attacco;
	}

	@Override
	public boolean riceviAttacco(int danno) {
		PV -= danno;
		if(PV <= 0) return true;
		return false;
	}

	@Override
	public void usaOggetto(int i) {
		if(inventario.get(i) instanceof ArmaInterface) usaOggetto(inventario.get(i));
		else usaOggetto(inventario.remove(i));
	}

	@Override
	public void ottieniOggetto(OggettoInterface o) {
		inventario.add(o);	
	}

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
