/*
 * ARMA.cpp
 *
 *  Created on: 28 gen 2023
 *      Author: FCFra
 */

#include "..\ottimizzazione\GradientDescent.h"
#include "ARMA.h"
#include <cmath>
#include <random>
#include <memory>
#include <vector>
#include <iostream>
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
	(*y_hat) = (c+a)*yt - c*(*y_hat);
	return (*y_hat);
}

void ARMA::stimaParametri(std::unique_ptr<std::vector<double>> &y, int n, int iterazioni, double alpha)
{
	GradientDescent gd;
	std::unique_ptr<std::vector<double>> z (new std::vector<double>(n));
	double media = detrend(y,z,n);
	gd.ottimizza(this, z, n, iterazioni, alpha);
	wn_mean = media*(1-a)/(1+c);
}

void ARMA::stampaProcesso()
{
	std::cout<<std::endl<<"y(t) = "<<a<<"*y(t-1) + e(t) + "<<c<<"*e(t-1)"
	<<std::endl<<"Media processo: "<<calcolaMedia()<<"\tMedia WN: "<<wn_mean
			 <<std::endl<<"Varianza processo: "<<calcolaVarianza()<<"\tVarianza WN: "<<wn_variance<<std::endl;

}

double ARMA::simulaModello(double values[])
{
	std::normal_distribution<double> distribution(wn_mean, sqrt(wn_variance));
	double wn = distribution(generator);
	double ris =  a*values[0] + c*(*last_wn) + wn;
	*last_wn = wn;
	return ris;
}

double ARMA::detrend(std::unique_ptr<std::vector<double>> &y, std::unique_ptr<std::vector<double>> &det, int n)
{
		double media = 0;
		for (std::vector<double>::iterator it = (*y).begin(); it != (*y).end(); it++) media += (*it);
		media = media/n;
		for (std::vector<double>::iterator it = (*y).begin(), jt = (*det).begin(); it != (*y).end(); it++, jt++)
			*jt = (*it) - media;

		return media;
}
