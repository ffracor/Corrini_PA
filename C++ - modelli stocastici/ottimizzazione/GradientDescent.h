/*
 * GradientDescent.h
 *
 *  Created on: 24 gen 2023
 *      Author: FCFra
 */

#ifndef OTTIMIZZAZIONE_GRADIENTDESCENT_H_
#define OTTIMIZZAZIONE_GRADIENTDESCENT_H_

#include "..\modelli\ARMA.h"
#include "..\modelli\X.h"


class GradientDescent
{
	public:
	void ottimizza(ARMA* modello, double dati[], int n, int iterazioni, double alpha);
	void ottimizza(X* modello, double dati[], int n, int iterazioni, double alpha);
};


#endif /* OTTIMIZZAZIONE_GRADIENTDESCENT_H_ */
