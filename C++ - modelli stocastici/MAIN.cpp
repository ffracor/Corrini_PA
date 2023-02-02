/*
 * MAIN.cpp
 *
 *  Created on: 4 gen 2023
 *      Author: FCFra
 */

#include <iostream>
#include <cstdlib>
#include <cstring>
#include "modelli\AR.h"
#include "modelli\MA.h"
#include "modelli\ARMAX.h"
#include "modelli\ARMA.h"
#include "modelli\X.h"
#include <memory>
#include <vector>
#include <random>
using namespace std;

template <typename T> shared_ptr<vector<double>> simulaModello(T modello, int n)
{
	cout<<endl<<"[ ";
	shared_ptr<vector<double>> simulazione(new vector<double>(n));
	(*simulazione)[0] = modello.calcolaMedia();
	double v[1];
	for(int i = 1; i < n; i++)
	{
		v[0] = (*simulazione)[i-1];
		(*simulazione)[i] = modello.simulaModello(v);
		cout<<(*simulazione)[i]<<" ";
	}
	cout<<"]";
	return simulazione;
}

template <typename S> shared_ptr<vector<double>> simulaModello(S modello, int n, unique_ptr<vector<double>> &ingresso)
{
	shared_ptr<vector<double>> simulazione(new vector<double>(n));
	(*simulazione)[0] = 0;
	double v[2];
	for(int i = 1; i < n; i++)
	{
		v[0] = (*simulazione)[i-1];
		v[1] = (*ingresso)[i-1];
		(*simulazione)[i] = modello.simulaModello(v);
	}

	return simulazione;
}

int main()
{
	int n = 5000;
	unique_ptr<vector<double>> y = std::make_unique<vector<double>>(n);
	AR crea(0.5, 1, 2);
	cout<<endl<<"Sistema vero AR";
	crea.stampaProcesso();
	cout<<endl<<"Simulazione del sistema";
	shared_ptr<vector<double>> sim = simulaModello(crea, n);
	cout<<endl<<endl;

	for(int i = 0; i < n; i++) (*y)[i] = (*sim)[i];

	cout<<endl<<"Stima dai dati usando un modello AR";
	AR ar;
	ar.stampaProcesso();
	ar.stimaParametri(y, n);
	ar.stampaProcesso();

	cout<<endl<<"Stima dai dati usando un modello ARMA";
	ARMA arma;
	arma.stampaProcesso();
	arma.stimaParametri(y, n);
	arma.stampaProcesso();

	cout<<endl<<"Stima dai dati usando un modello MA";
	MA ma;
	ma.stampaProcesso();
	ma.stimaParametri(y,n);
	ma.stampaProcesso();

	system("PAUSE");

	cout<<endl<<"Sistema ARMAX che usa come ingresso l'output del sistema precedente";
	ARMAX armax(0.3, 0.8, 0.2, 0, 1);
	armax.stampaProcesso();

	//utilizzo il vettore y precedente come ingresso per il modello successivo
	shared_ptr<vector<double>> simx = simulaModello(armax, n, y);
	unique_ptr<vector<double>> yx = std::make_unique<vector<double>>(n);// (new vector<double>(n));
	for(int i = 0; i < n; i++) (*yx)[i] = (*simx)[i];

	cout<<endl<<"Stima del sistema usando modello ARMAX";
	ARMAX armax2;
	armax2.stampaProcesso();
	armax2.stimaParametri(yx, y, n);
	armax2.stampaProcesso();


	cout<<endl<<"Stima del sistema usando un modello X";
	X x;
	x.stampaProcesso();
	x.stimaParametri(yx, y, n);
	x.stampaProcesso();

	return 0;
}
