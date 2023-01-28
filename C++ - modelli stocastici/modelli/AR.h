/*
 * AR.h
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_AR_H_
#define MODELLI_AR_H_

#include "ARMA.h"

class AR: private ARMA
{
	public:

	double getA();
	void stampaProcesso();

	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	void stimaParametri(double y[], int n);
	double previsioneAdUnPasso(double yt);
};

#endif /* MODELLI_AR_H_ */
