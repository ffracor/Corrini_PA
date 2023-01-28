/*
 * GradientDescent.cpp
 *
 *  Created on: 24 gen 2023
 *      Author: FCFra
 *      Ringraziamento speciale a Gabriele Marchesi alias Gabs alias Zuppa Salata per il .. nell'include
 */


#include "GradientDescent.h"
#include "..\modelli\ARMA.h"
#include <cmath>

void GradientDescent::ottimizza(ARMA* modello, double dati[], int n, int iterazioni, double alpha)
{
	if (iterazioni == 0) return;

	double errore = dati[0];
	double derrore = 0;
	double dy = 0;

	double sommac = 0;
	double sommay = 0;

	double var = 0;

	for (int i = 1; i < n; i++)
	{
		dy = -dati[i-1] - modello->getC()*derrore;
		derrore = -errore - modello->getC()*derrore;
		errore = dati[i] - modello->previsioneAdUnPasso(dati[i-1]);

		sommac += errore*derrore;
		sommay += errore*dy;
		var += pow(errore, 2);
	}

	modello->setC(modello->getC() - (alpha*sommac));
	modello->setA(modello->getA() - (alpha*sommay));
	modello->setVarianza(var/(n-1));
	ottimizza(modello, dati, n, iterazioni-1, alpha);
}

//void ottimizza(ARMA, double dati[], int n, int iterazioni, double alpha)

