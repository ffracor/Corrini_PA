/*
 * ARMAX.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#include "ARMAX.h"
#include <iostream>
#include "..\ottimizzazione\GradientDescent.h"

double ARMAX::previsioneAdUnPasso(double yt, double ut)
{
	(*y_hat) = ARMA::previsioneAdUnPasso(yt) + X::previsioneAdUnPasso(ut);
	return (*y_hat);
}

void ARMAX::stimaParametri(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &u, int n, int iterazioni, double alpha)
{
	GradientDescent gd;
	std::unique_ptr<std::vector<double>> z (new std::vector<double>(n));
	double media = detrend(y,z,n);
	gd.ottimizza(this, z, u, n, iterazioni, alpha);
	wn_mean = media*(1-a)/(1+c);
}
void ARMAX::stampaProcesso()
{
	std::cout<<std::endl<<"y(t) = "<<a<<"*y(t-1) + "<<c<<"*e(t-1) + e(t) + "<<b<<"*u(t-1)"
			<<std::endl<<"Media processo: "<<calcolaMedia()<<"\t\tMedia WN: "<<wn_mean
			<<std::endl<<"Varianza processo: "<<calcolaVarianza()<<"\tVarianza WN: "<<wn_variance<<std::endl;
}


double ARMAX::simulaModello(double values[])
{
	return ARMA::simulaModello(values) + b*values[1];
}
