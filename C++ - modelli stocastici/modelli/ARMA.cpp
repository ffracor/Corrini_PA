/*
 * ARMA.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#include "..\ottimizzazione\GradientDescent.h"
#include "ARMA.h"
#include <cmath>

double ARMA::calcolaMedia()
{
	return (1+c)*wn_mean/(1-a);
}

double ARMA::calcolaVarianza()
{
	return wn_variance*((1 + pow(c, 2) + a*c)/(1 - pow(a, 2)));
}

double ARMA::calcolaAutoCovarianza(int tau)
{
	if(tau == 0) return calcolaVarianza();
	if(tau < 0) tau = -tau;
	return calcolaVarianza()*pow(a, tau) + wn_variance*c*pow(a, tau-1); //pow(0,0) = 1
}

double ARMA::previsioneAdUnPasso(double yt)
{
	y_hat = (c+a)*yt - c*y_hat;
	return y_hat;
}

void ARMA::stimaParametri(double y[], int n)
{
	GradientDescent gd;
	gd.ottimizza(this, y, n, 500, 0.1);
}

void ARMA::stampaProcesso()
{

}


