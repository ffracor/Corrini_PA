/*
 * MA.h
 *
 *  Created on: 21 gen 2023
 *      Author: FCFra
 */

#include "ARMA.h"

#ifndef MODELLI_MA_H_
#define MODELLI_MA_H_

class MA: private ARMA
{
	public:

	double getC();
	void stampaProcesso();

	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	void stimaParametri(double y[], int n);
	double previsioneAdUnPasso(double yt);
};

#endif /* MODELLI_MA_H_ */
