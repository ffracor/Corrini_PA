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
#include "..\modelli\ARMAX.h"
#include <vector>
#include "..\modelli\AR.h"
#include "..\modelli\MA.h"

#include <memory>

//mette a disposizione le funzioni per ottimizzare il modello
//ogni modello ha la sua poiché per ogni modello devono essere stimati dei parametri diversi
//e siccome il gradient descent si basa sul gradiente (derivata) e queste sono dipendenti le une
//dai parametri delle altre deve essere definita una funzione per ogni modello con parametri differenti
class GradientDescent
{
	public:
	void ottimizza(ARMA* modello, std::unique_ptr<std::vector<double>> &dati, int n, int iterazioni, double alpha);
	void ottimizza(X* modello, std::unique_ptr<std::vector<double>> &dati, std::unique_ptr<std::vector<double>> &ingresso, int n, int iterazioni, double alpha);
	void ottimizza(ARMAX* modello, std::unique_ptr<std::vector<double>> &dati, std::unique_ptr<std::vector<double>> &ingresso, int n, int iterazioni, double alpha);
	void ottimizza(AR* modello, std::unique_ptr<std::vector<double>> &dati, int n, int iterazioni, double alpha);
	void ottimizza(MA* modello, std::unique_ptr<std::vector<double>> &dati, int n, int iterazioni, double alpha);
};


#endif /* OTTIMIZZAZIONE_GRADIENTDESCENT_H_ */
