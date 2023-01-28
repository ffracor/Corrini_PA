/*
 * ARMA.h
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_ARMA_H_
#define MODELLI_ARMA_H_

#include "ProcessoStocastico.h"

class ARMA: public ProcessoStocastico
{
	protected:
	int a;
	int c;

	int y_hat;

	public:
	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	//stima del modello e previsione
	void stimaParametri(double y[], int n);
	double previsioneAdUnPasso(double yt);
	void stampaProcesso();

	double getA() {return a;}
	double getC() {return c;}
	void setC(double C) {c = C;}
	void setA(double A) {a = A;}
};

#endif /* MODELLI_ARMA_H_ */
