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
	ARMAX(): ARMA(0,0,0,1), X(0){}
	ARMAX(double a, double b, double c, double wnm, double wnv): ARMA(a,c,wnm,wnv), X(b){}
	double previsioneAdUnPasso(double yt, double ut);
	void stimaParametri(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &u, int n, int iterazioni = 250, double = 0.00001);
	void stampaProcesso();
	double simulaModello(double values[]);
};

#endif /* MODELLI_ARMAX_H_ */
