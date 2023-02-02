/*
 * GradientDescent.cpp
 *
 *  Created on: 24 gen 2023
 *      Author: FCFra
 *      Ringraziamento speciale a Gabriele Marchesi alias Gabs alias Zuppa Salata per il .. nell'include
 */


#include "GradientDescent.h"
#include "..\modelli\ARMA.h"
#include "..\modelli\AR.h"
#include "..\modelli\MA.h"

#include <cmath>
#include <vector>
#include <memory>

void GradientDescent::ottimizza(ARMA* modello, std::unique_ptr<std::vector<double>> &dati, int n, int iterazioni, double alpha)
{
	if (iterazioni == 0) return;

	double errore = (*dati)[0];
	double derrore = 0;
	double dy = 0;

	double sommac = 0;
	double sommay = 0;

	double var = 0;

	for (std::vector<double>::iterator it = (*dati).begin(); it != ((*dati).end() -1); it++)
	{
		dy = -(*it) - modello->getC()*dy;
		derrore = -errore - modello->getC()*derrore;
		errore = (*(it+1)) - modello->previsioneAdUnPasso((double)(*it));

		sommac += errore*derrore;
		sommay += errore*dy;
		var += pow(errore, 2);
	}
	modello->setC(modello->getC() - (alpha*sommac));
	modello->setA(modello->getA() - (alpha*sommay));
	modello->setVarianza(var/(n-1));
	ottimizza(modello, dati, n, iterazioni-1, alpha);
}

void GradientDescent::ottimizza(AR* modello, std::unique_ptr<std::vector<double>> &dati, int n, int iterazioni, double alpha)
{
	if (iterazioni == 0) return;

	double errore = (*dati)[0];
	double dy = 0;

	double sommay = 0;

	double var = 0;

	for (std::vector<double>::iterator it = (*dati).begin(); it != ((*dati).end() -1); it++)
	{
		dy = -(*it);
		errore = (*(it+1)) - modello->previsioneAdUnPasso((*it));

		sommay += errore*dy;
		var += pow(errore, 2);
	}

	modello->setA(modello->getA() - (alpha*sommay));
	modello->setVarianza(var/(n-1));
	ottimizza(modello, dati, n, iterazioni-1, alpha);
}

void GradientDescent::ottimizza(MA* modello, std::unique_ptr<std::vector<double>> &dati, int n, int iterazioni, double alpha)
{
	if (iterazioni == 0) return;

	double errore = (*dati)[0];
	double derrore = 0;

	double sommac = 0;

	double var = 0;

	for (std::vector<double>::iterator it = (*dati).begin(); it != ((*dati).end() -1); it++)
	{
		derrore = -errore - modello->getC()*derrore;
		errore = (*(it+1)) - modello->previsioneAdUnPasso((double)(*it));

		sommac += errore*derrore;
		var += pow(errore, 2);
	}

	modello->setC(modello->getC() - (alpha*sommac));
	modello->setVarianza(var/(n-1));
	ottimizza(modello, dati, n, iterazioni-1, alpha);
}

void GradientDescent::ottimizza(ARMAX* modello, std::unique_ptr<std::vector<double>> &dati, std::unique_ptr<std::vector<double>> &ingresso, int n, int iterazioni, double alpha)
{
	if (iterazioni == 0) return;

	double errore = (*dati)[0];
	double derrore = 0;
	double dy = 0;
	double du = 0;

	double sommac = 0;
	double sommay = 0;
	double sommau = 0;

	double var = 0;

	for (std::vector<double>::iterator it = (*dati).begin(), jt = (*ingresso).begin(); it != ((*dati).end() -1); it++, jt++)
	{
		dy = -(*it) - modello->getC()*dy;
		du = -(*jt) - modello->getC()*du;
		derrore = -errore - modello->getC()*derrore;
		errore = (*(it+1)) - modello->previsioneAdUnPasso((double)(*it), (double)(*jt));

		sommac += errore*derrore;
		sommay += errore*dy;
		sommau += errore*du;
		var += pow(errore, 2);
	}

	modello->setC(modello->getC() - (alpha*sommac));
	modello->setA(modello->getA() - (alpha*sommay));
	modello->setB(modello->getB() - (alpha*sommau));
	modello->setVarianza(var/(n-1));
	ottimizza(modello, dati, ingresso, n, iterazioni-1, alpha);
}

void GradientDescent::ottimizza(X* modello, std::unique_ptr<std::vector<double>> &dati, std::unique_ptr<std::vector<double>> &ingresso, int n, int iterazioni, double alpha)
{
	if (iterazioni == 0) return;

	double errore = (*dati)[0] - (*ingresso)[0];
	double db = 0;

	double sommab = 0;

	for (std::vector<double>::iterator it = (*dati).begin(), jt = (*ingresso).begin(); it != ((*dati).end() -1); it++, jt++)
	{
		db = -(*jt);
		errore = (*(it+1)) - modello->previsioneAdUnPasso((*jt));

		sommab += errore*db;
	}

	modello->setB(modello->getB() - (alpha*sommab));
	ottimizza(modello, dati, ingresso, n, iterazioni-1, alpha);
}


