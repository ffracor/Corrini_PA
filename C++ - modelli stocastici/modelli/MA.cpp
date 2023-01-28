/*
 * MA.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */
#include "MA.h"

double MA::getC()
{
	return ARMA::getC();
}

void MA::stampaProcesso(){}

double MA::calcolaMedia()
{
	return ARMA::calcolaMedia();
}
double MA::calcolaVarianza()
{
	return ARMA::calcolaVarianza();
}
double MA::calcolaAutoCovarianza(int tau)
{
	return ARMA::calcolaAutoCovarianza(tau);
}

void MA::stimaParametri(double y[], int n)
{
	ARMA::stimaParametri(y, n);
}
double MA::previsioneAdUnPasso(double yt)
{
	return ARMA::previsioneAdUnPasso(yt);
}
