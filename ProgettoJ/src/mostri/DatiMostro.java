package mostri;

import oggetti.OggettoInterface;

//uso del record per definire i dati di un mostro
public record DatiMostro(String nome, int exp, int pv, int attacco, int denaro, OggettoInterface drop) 
{
}
