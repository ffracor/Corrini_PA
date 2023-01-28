/*
 * AR.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */
#include "AR.h"

double AR::getA()
{
	return ARMA::getA();
}

void AR::stampaProcesso(){}

double AR::calcolaMedia()
{
	return ARMA::calcolaMedia();
}
double AR::calcolaVarianza()
{
	return ARMA::calcolaVarianza();
}
double AR::calcolaAutoCovarianza(int tau)
{
	return ARMA::calcolaAutoCovarianza(tau);
}

void AR::stimaParametri(double y[], int n)
{
	ARMA::stimaParametri(y, n);
}
double AR::previsioneAdUnPasso(double yt)
{
	return ARMA::previsioneAdUnPasso(yt);
}

