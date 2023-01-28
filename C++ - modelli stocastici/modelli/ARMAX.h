/*
 * ARMAX.h
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#ifndef MODELLI_ARMAX_H_
#define MODELLI_ARMAX_H_

#include "ARMA.h"
#include "X.h"

class ARMAX: public ARMA, public X
{
	public:
	double predizioneAdUnPasso(double yt, double ut);

};

#endif /* MODELLI_ARMAX_H_ */
