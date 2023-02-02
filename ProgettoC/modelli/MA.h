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
	MA(double c, double wnm, double wnv): ARMA(0, c, wnm, wnv){}
	MA(): ARMA(0,0,0,1){}
	double getC();
	void stampaProcesso();
	void setC(double C) {c = C;}
	void setMedia(double mean) {wn_mean = mean;}
	void setVarianza(double var) {wn_variance = var;}

	double calcolaMedia();
	double calcolaVarianza();
	double calcolaAutoCovarianza(int tau);

	void stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni = 250, double alpha = 0.00001);
	double previsioneAdUnPasso(double yt);
	double simulaModello(double values[] = NULL);
};

#endif /* MODELLI_MA_H_ */
